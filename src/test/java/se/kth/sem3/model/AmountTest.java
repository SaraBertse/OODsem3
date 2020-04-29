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
public class AmountTest {
    private Amount amtNoArgConstr;
    private Amount amtWithAmt5;
    
    public AmountTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {

    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        amtNoArgConstr = new Amount();
        amtWithAmt5 = new Amount(5);
    }
    
    @AfterEach
    public void tearDown() {
    }

    //WRite test to Also see that the equals thing is working!
    
    
    @Test //DONE WRITTEN
    public void testPlus() {
        int amountOfOperand1 = 5;
        int amountOfOperand2 = 3;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.plus(operand2);
        assertEquals(expResult, result, "Wrong addition result");
    }
    //Can test +[-amt], can test +0.

    @Disabled
    public void testMinus() {
        System.out.println("minus");
        Amount other = null;
        Amount instance = null;
        Amount expResult = null;
        Amount result = instance.minus(other);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Disabled
    public void testMultiplied() {
        System.out.println("multiplied");
        Amount other = null;
        Amount instance = null;
        Amount expResult = null;
        Amount result = instance.multiplied(other);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToStringPositiveAmount() {
        int representedAmount = 5;
        Amount amount = new Amount(representedAmount);
        String expResult = Integer.toString(representedAmount);
        String result = amount.toString();
        assertEquals(expResult, result, "Wrong string returned by toString");
    }
}
