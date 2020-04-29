/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.sem3.model.SalesLogDTO;

/**
 *
 * @author sarab
 */
public class PrinterHandlerTest {
    
    public PrinterHandlerTest() {
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

    @Test
    public void testPrintReceipt() {
        System.out.println("printReceipt");
        SalesLogDTO salesLog = null;
        PrinterHandler instance = new PrinterHandler();
        String expResult = "";
        String result = instance.printReceipt(salesLog);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
