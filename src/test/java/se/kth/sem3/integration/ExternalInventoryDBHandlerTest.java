/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import se.kth.sem3.model.Amount;
import se.kth.sem3.model.ItemDTO;

/**
 *
 * @author sarab
 */
public class ExternalInventoryDBHandlerTest {

    ExternalInventoryDBHandler instance;

    @BeforeEach
    public void setUp() {
        instance = new ExternalInventoryDBHandler();
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testRetrieveItemInfo() {
        int ItemID = 111;
        ItemDTO expResult = new ItemDTO("Milk, VAT 12%", new Amount(12), new Amount(12));
        ItemDTO result = instance.retrieveItemInfo(ItemID);
        assertEquals(expResult, result, "Item not retrieved correctly");
    }

    @Test
    public void testRetrieveItemInfoDifferentIdentifier() {
        int ItemID = 114;
        ItemDTO expResult = new ItemDTO("Milk, VAT 12%", new Amount(12), new Amount(12));
        ItemDTO result = instance.retrieveItemInfo(ItemID);
        assertFalse(expResult.equals(result), "The first item was retrieved"
                + "when it shouldn't have been");
    }

    @Test
    public void testRetrieveItemInfoNullObject() {
        int ItemID = 116;
        ItemDTO expResult = null;
        ItemDTO result = instance.retrieveItemInfo(ItemID);
        assertEquals(expResult, result, "Object not null when it should be");
    }
}
