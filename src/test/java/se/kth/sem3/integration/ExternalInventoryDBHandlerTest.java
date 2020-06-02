/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem3.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.sem3.model.Amount;
import se.kth.sem3.model.ItemDTO;
import se.kth.sem3.model.SalesLogDTO;

/**
 *
 * @author sarab
 */
public class ExternalInventoryDBHandlerTest {
    
    public ExternalInventoryDBHandlerTest() {
    }

    @Test
    public void testRetrieveItemInfo() {
        int ItemID = 111;
        ExternalInventoryDBHandler instance = new ExternalInventoryDBHandler();
        ItemDTO expResult = new ItemDTO("Milk, VAT 12%", new Amount(12), new Amount(12));
        ItemDTO result = instance.retrieveItemInfo(ItemID);
        assertEquals(expResult, result, "Item not retrieved correctly");
    }
       
    @Test
    public void testRetrieveItemInfoDifferentIdentifier() {
        int ItemID = 114;
        ExternalInventoryDBHandler instance = new ExternalInventoryDBHandler();
        ItemDTO expResult = new ItemDTO("Milk, VAT 12%", new Amount(12), new Amount(12));
        ItemDTO result = instance.retrieveItemInfo(ItemID);
        assertFalse(expResult.equals(result), "The first item was retrieved"
                + "when it shouldn't have been");
    }
    
        @Test
    public void testRetrieveItemInfoNullObject() {
        int ItemID = 116;
        ExternalInventoryDBHandler instance = new ExternalInventoryDBHandler();
        ItemDTO expResult = null;
        ItemDTO result = instance.retrieveItemInfo(ItemID);
        assertEquals(expResult, result, "Object not null when it should be");
    }
}
