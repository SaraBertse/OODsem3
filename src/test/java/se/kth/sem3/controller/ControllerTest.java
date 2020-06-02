/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem3.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import se.kth.sem3.integration.ExternalAccountingDBHandler;
import se.kth.sem3.integration.ExternalInventoryDBHandler;
import se.kth.sem3.integration.HandlerCreator;
import se.kth.sem3.model.Amount;
import se.kth.sem3.model.CashRegister;
import se.kth.sem3.model.PurchaseInfoDTO;
import se.kth.sem3.model.Sale;

public class ControllerTest {

    Sale sale = new Sale();
    HandlerCreator handle = new HandlerCreator();
    CashRegister cashreg = new CashRegister(sale);
    Controller instance;

    @BeforeEach
    public void setUp() {
        instance = new Controller(handle, cashreg);
        instance.startSale();
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testStartSaleNotNull() {
        instance.startSale();
        assertTrue((sale != null), "Creation of sale failed");

    }

    @Test
    public void testEnterItem() {
        int itemID = 111;
        int quantity = 1;
        PurchaseInfoDTO expResult = new PurchaseInfoDTO("Milk, VAT 12%", new Amount(12), new Amount(13.44));
        PurchaseInfoDTO result = instance.enterItem(itemID, quantity);
        assertEquals(expResult, result, "Item not retrieved correctly");
    }

    @Test
    public void testEnterItemMultipleQuantities() {
        int itemID = 111;
        int quantity = 2;
        PurchaseInfoDTO expResult = new PurchaseInfoDTO("Milk, VAT 12%", new Amount(12), new Amount(26.88));
        PurchaseInfoDTO result = instance.enterItem(itemID, quantity);
        assertEquals(expResult, result, "Quantity more than one not entering correctly");
    }

    @Test
    public void testEnterItemWithZeroQuantity() {
        int itemID = 111;
        int quantity = 0;
        PurchaseInfoDTO expResult = new PurchaseInfoDTO("Milk, VAT 12%", new Amount(12), new Amount(0));
        PurchaseInfoDTO result = instance.enterItem(itemID, quantity);
        assertEquals(expResult, result, "Zero quantity not being entered correctly");

    }

    @Test
    public void endSale() {
        PurchaseInfoDTO info = instance.enterItem(111, 2);
        Amount expResult = new Amount(26.88);
        Amount result = instance.endSale(info);
        assertEquals(expResult, result, "The final price is not correct.");
    }

    @Test
    public void endSaleMultipleItems() {
        PurchaseInfoDTO info1 = instance.enterItem(111, 2);
        PurchaseInfoDTO info2 = instance.enterItem(112, 1);
        Amount expResult = new Amount(49.28);
        Amount result = instance.endSale(info2);
        assertEquals(expResult, result, "The final price is not correct when"
                + "multiple items are being bought.");
    }

    @Test
    public void enterAmountPaid() {
        Amount payment = new Amount(100.0);
        Amount totalPrice = new Amount(50.0);
        Amount expResult = new Amount(50.0);
        Amount result = instance.enterAmountPaid(payment, totalPrice);
        assertEquals(expResult, result, "The calculated change is incorrect");
    }

    @Test
    public void enterAmountPaidNegativeValues() {
        Amount payment = new Amount(-100.0);
        Amount totalPrice = new Amount(50.0);
        Amount expResult = new Amount(-150.0);
        Amount result = instance.enterAmountPaid(payment, totalPrice);
        assertEquals(expResult, result, "The calculated change is incorrect"
                + "when the amount paid is negative");
    }

    @Test
    public void enterAmountPaidWithZero() {
        Amount payment = new Amount(0.0);
        Amount totalPrice = new Amount(50.0);
        Amount expResult = new Amount(-50.0);
        Amount result = instance.enterAmountPaid(payment, totalPrice);
        assertEquals(expResult, result, "The calculated change is incorrect"
                + "when the amount paid is 0");
    }

    @Test
    public void getReceiptString() {
        PurchaseInfoDTO purchaseInfo1 = instance.enterItem(111, 2);
        PurchaseInfoDTO purchaseInfo2 = instance.enterItem(112, 2);
        Amount totalPrice = instance.endSale(purchaseInfo2);
        Amount change = instance.enterAmountPaid(new Amount(200), totalPrice);
        String result = instance.getReceiptString();
        String expectedOutput = "price";
        assertTrue(result.contains(expectedOutput), "The receipt didn't print"
                + " as expected");
    }
}
