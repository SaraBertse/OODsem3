
package se.kth.sem3.integration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import se.kth.sem3.controller.Controller;
import se.kth.sem3.model.Amount;
import se.kth.sem3.model.CashRegister;
import se.kth.sem3.model.PurchaseInfoDTO;
import se.kth.sem3.model.Sale;
import se.kth.sem3.model.SalesLogDTO;


public class PrinterHandlerTest {
    Sale sale = new Sale();
    private PrinterHandler instance;
    Controller contr;
    private Amount runningTotal = new Amount(0);
    ExternalInventoryDBHandler extInv = new ExternalInventoryDBHandler();
    ExternalAccountingDBHandler extAcc = new ExternalAccountingDBHandler();
    HandlerCreator handle = new HandlerCreator();
    CashRegister cashreg = new CashRegister(sale);
    private Amount payment;
    private Amount totalVAT; 
    private Amount calculateTotalVAT = new Amount(0);
    private LocalDateTime timeAndDateOfSale = LocalDateTime.now();
    private List<Sale.ItemData> items = new ArrayList<>();

    
    @BeforeEach
    public void setUp() {
        HandlerCreator handle = new HandlerCreator();
        Sale sale = new Sale();
        CashRegister cashreg = new CashRegister(sale);
        contr = new Controller(handle, cashreg);
        instance = new PrinterHandler();
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testPrintReceipt() {
        contr.startSale();
        PurchaseInfoDTO purchaseInfo1 = contr.enterItem(111, 2);
        PurchaseInfoDTO purchaseInfo2 = contr.enterItem(112, 2);
        Amount totalPrice = contr.endSale(purchaseInfo2);
        Amount change = contr.enterAmountPaid(new Amount(200), totalPrice);
        SalesLogDTO salesLog = new SalesLogDTO(timeAndDateOfSale, "BestShop", "Shopway 12", 
        items, new Amount(300), new Amount(300), new Amount(300), new Amount(300));
        String result = instance.printReceipt(salesLog);
        String expResult = "Time and date of sale: " + salesLog.getTimeAndDateOfSale()
                + "\nStore name: " + salesLog.getStoreName() + "\nStore address: "
                + salesLog.getStoreAddress() + "\nTotal price of sale: "
                + salesLog.getTotalPrice() + "\nTotal VAT of sale: "
                + salesLog.getTotalVAT() + "\nAmount paid: " + salesLog.getAmountPaid()
                + "\nChange back: " + salesLog.getChange();
        assertTrue(result.contains(expResult), "Receipt printout is wrong");
        assertTrue(result.contains(Integer.toString(timeAndDateOfSale.getYear())), "Wrong year on receipt.");
        assertTrue(result.contains(Integer.toString(timeAndDateOfSale.getMonthValue())), "Wrong month on receipt.");
        assertTrue(result.contains(Integer.toString(timeAndDateOfSale.getDayOfMonth())), "Wrong day on receipt.");
        assertTrue(result.contains(Integer.toString(timeAndDateOfSale.getHour())), "Wrong hour on receipt.");
        assertTrue(result.contains(Integer.toString(timeAndDateOfSale.getMinute())), "Wrong minute on receipt.");
    }
}
