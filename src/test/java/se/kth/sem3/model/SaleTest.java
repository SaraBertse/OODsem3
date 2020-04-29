/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author sarab
 */
public class SaleTest {
    
    public SaleTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Disabled
    public void testUpdatePurchaseInfo() {
        System.out.println("updatePurchaseInfo");
        ItemDTO item = null;
        int quantity = 0;
        Sale instance = new Sale();
        PurchaseInfoDTO expResult = null;
        PurchaseInfoDTO result = instance.updatePurchaseInfo(item, quantity);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculateChange() {
        System.out.println("calculateChange");
        Amount payment = new Amount(500);
        Amount totalPrice = new Amount(250);
        Sale instance = new Sale();
        Amount expResult = new Amount(250);
        Amount result = instance.calculateChange(payment, totalPrice);
        assertEquals(expResult, result, "Wrong calculate change result.");
    }

    @Disabled
    public void testGetSalesLogDTO() {
        System.out.println("getSalesLogDTO");
        Sale instance = new Sale();
        SalesLogDTO expResult = null;
        SalesLogDTO result = instance.getSalesLogDTO();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
