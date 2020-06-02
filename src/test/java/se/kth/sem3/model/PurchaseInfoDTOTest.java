/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author sarab
 */
public class PurchaseInfoDTOTest {
    PurchaseInfoDTO infoDTOForTesting;
    
    public PurchaseInfoDTOTest() {
    }
    
    @BeforeEach
    public void SetUp(){
        PurchaseInfoDTO infoDTOForTesting = new PurchaseInfoDTO ("milk", new Amount(12.0), new Amount(12.0));
    }
    
    @AfterEach
    public void TearDown(){
        infoDTOForTesting = null;
    }

    @Test
    public void testToString() {
        String description = "milk";
        Amount price = new Amount(12.0);
        Amount runningTotal = new Amount(12.0);
        PurchaseInfoDTO purchaseInfo = new PurchaseInfoDTO(description, price, runningTotal);
        String expResult = "Description: " + purchaseInfo.getDescription() + 
                " Price: " + purchaseInfo.getPrice() +
                " Running Total " + purchaseInfo.getRunningTotal();
        String result = purchaseInfo.toString();
        assertEquals(expResult, result, "Wrong string returned by toString");
    }
    
        @Test
    public void testToStringEmptyString() {
        String description = "";
        Amount price = new Amount(12.0);
        Amount runningTotal = new Amount(12.0);
        PurchaseInfoDTO purchaseInfo = new PurchaseInfoDTO(description, price, runningTotal);
        String expResult = "Description: " + purchaseInfo.getDescription() + 
                " Price: " + purchaseInfo.getPrice() +
                " Running Total " + purchaseInfo.getRunningTotal();
        String result = purchaseInfo.toString();
        assertEquals(expResult, result, "Wrong string returned by toString when the String"
                + " is empty");
    }
    
            @Test
    public void testToStringEmptyStringNullParam() {
        String description = null;
        Amount price = null;
        Amount runningTotal = null;
        PurchaseInfoDTO purchaseInfo = new PurchaseInfoDTO(description, price, runningTotal);
        String expResult = "Description: " + purchaseInfo.getDescription() + 
                " Price: " + purchaseInfo.getPrice() +
                " Running Total " + purchaseInfo.getRunningTotal();
        String result = purchaseInfo.toString();
        assertEquals(expResult, result, "Wrong string returned by toString when the"
                + " parameters are null");
    }

    @Test
    public void testEquals() {
        String description = "milk";
        Amount price = new Amount(12.0);
        Amount runningTotal = new Amount(12.0);
        PurchaseInfoDTO expResult = new PurchaseInfoDTO ("milk", new Amount(12.0), new Amount(12.0));
        PurchaseInfoDTO result = new PurchaseInfoDTO(description, price, runningTotal);
        assertEquals(expResult, result, "Objects that should be equal are not.");
    }
    
        @Test
    public void testEqualsWhenNot() {
        String description = "juice";
        Amount price = new Amount(12.0);
        Amount runningTotal = new Amount(12.0);
        PurchaseInfoDTO expResult = new PurchaseInfoDTO ("milk", new Amount(12.0), new Amount(12.0));
        PurchaseInfoDTO result = new PurchaseInfoDTO(description, price, runningTotal);
        boolean test = expResult.equals(result);
        assertTrue(test == false, "Objects are equal when they shouldn't be.");
    }
    //COULD TEST FOR NOT EQUAL TO NULL ALSO!
}
