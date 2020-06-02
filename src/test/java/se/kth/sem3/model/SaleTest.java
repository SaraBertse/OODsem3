package se.kth.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import se.kth.sem3.integration.ExternalInventoryDBHandler;
import se.kth.sem3.model.Sale.ItemData;

public class SaleTest {

    Amount runningTotal = new Amount(0);
    Amount totalPrice;
    Amount payment;
    Sale instance;

    @BeforeEach
    public void setUp() {
        instance = new Sale();
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testUpdatePurchaseInfoCreatesPurchaseInfoDTO() {
        ItemDTO item = new ItemDTO("milk", new Amount(12.0), new Amount(12.0));
        int quantity = 1;
        PurchaseInfoDTO expResult = new PurchaseInfoDTO("milk", new Amount(12.0),
                new Amount(13.44));
        PurchaseInfoDTO result = instance.updatePurchaseInfo(item, quantity);
        assertEquals(expResult, result, "PurchaseInfoDTO is not created correctly");
    }

    @Test
    public void testUpdatePurchaseInfoCorrectRunningTotal() {
        ItemDTO item = new ItemDTO("milk", new Amount(12.0), new Amount(12.0));
        int quantity = 1;
        PurchaseInfoDTO expResult = new PurchaseInfoDTO("milk", new Amount(12.0),
                new Amount(26.88));
        PurchaseInfoDTO result = instance.updatePurchaseInfo(item, quantity);
        result = instance.updatePurchaseInfo(item, quantity);
        assertEquals(expResult, result, "PurchaseInfoDTO doesn't calculate"
                + "the running total correctly");
    }

    @Test
    public void testUpdatePurchaseInfoRunningTotalMultipleQuantities() {
        ItemDTO item = new ItemDTO("milk", new Amount(12.0), new Amount(12.0));
        int quantity = 2;
        PurchaseInfoDTO expResult = new PurchaseInfoDTO("milk", new Amount(12.0),
                new Amount(26.88));
        PurchaseInfoDTO result = instance.updatePurchaseInfo(item, quantity);
        assertEquals(expResult, result, "PurchaseInfoDTO doesn't calculate"
                + "the running total correctly with multiple quantities");
    }

    @Test
    public void testCalculateChange() {
        Amount payment = new Amount(500);
        Amount totalPrice = new Amount(250);
        Amount expResult = new Amount(250);
        Amount result = instance.calculateChange(payment, totalPrice);
        assertEquals(expResult, result, "Wrong calculate change result.");
    }

    @Test
    public void testCalculateChangeNegativePayment() {
        Amount payment = new Amount(-500);
        Amount totalPrice = new Amount(250);
        Amount expResult = new Amount(-750);
        Amount result = instance.calculateChange(payment, totalPrice);
        assertEquals(expResult, result, "Wrong calculate change result"
                + " when the payment is negative.");
    }

    @Test
    public void testCalculateChangeNegativePrice() {
        Amount payment = new Amount(500);
        Amount totalPrice = new Amount(-250);
        Amount expResult = new Amount(750);
        Amount result = instance.calculateChange(payment, totalPrice);
        assertEquals(expResult, result, "Wrong calculate change result"
                + " when the payment is negative.");
    }

    @Test
    public void testUpdateAmountPaid() {
        Amount paidAmount = new Amount(500);
        Amount expResult = paidAmount;
        instance.updateAmountPaid(paidAmount);
        payment = instance.getPayment();
        Amount result = payment;
        assertEquals(expResult, result, "Payment isn't registering/updating correctly");
    }

    @Test
    public void testUpdateAmountPaidNegativePayment() {
        Amount paidAmount = new Amount(-500);
        Amount expResult = paidAmount;
        instance.updateAmountPaid(paidAmount);
        payment = instance.getPayment();
        Amount result = payment;
        assertEquals(expResult, result, "Payment isn't registering/updating correctly"
                + " when the amount is negative");
    }

    @Test
    public void testUpdateAmountPaidZero() {
        Amount paidAmount = new Amount(0);
        Amount expResult = paidAmount;
        instance.updateAmountPaid(paidAmount);
        payment = instance.getPayment();
        Amount result = payment;
        assertEquals(expResult, result, "Payment isn't registering/updating correctly"
                + " when the amount is negative");
    }

    @Test
    public void testItemDataToString() {
        ItemDTO item = new ItemDTO("milk", new Amount(12.0), new Amount(12.0));
        Sale.ItemData itemData = instance.new ItemData(item.getDescription(), 1, item.getPrice());
        String expResult = "Item: " + item.getDescription() + "    Quantity: " + 1 + "    Price each: " + 12.0;
        String result = itemData.toString();
        assertEquals(expResult, result, "Wrong string returned by ItemData.toString");
    }

    @Test
    public void testItemDataToStringEmptyString() {
        ItemDTO item = new ItemDTO(" ", new Amount(12.0), new Amount(12.0));
        Sale.ItemData itemData = instance.new ItemData(item.getDescription(), 1, item.getPrice());
        String expResult = "Item: " + item.getDescription() + "    Quantity: " + 1 + "    Price each: " + 12.0;
        String result = itemData.toString();
        assertEquals(expResult, result, "Wrong string returned by ItemData.toString"
                + " with empty String");
    }

    @Test
    public void testItemDataToStringNullString() {
        ItemDTO item = new ItemDTO(null, new Amount(12.0), new Amount(12.0));
        Sale.ItemData itemData = instance.new ItemData(item.getDescription(), 1, item.getPrice());
        String expResult = "Item: " + item.getDescription() + "    Quantity: " + 1 + "    Price each: " + 12.0;
        String result = itemData.toString();
        assertEquals(expResult, result, "Wrong string returned by ItemData.toString"
                + " with empty String");
    }
}
