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
    
    @BeforeEach
    public void setUp() {
        amtNoArgConstr = new Amount();
        amtWithAmt5 = new Amount(5);
    }
    
    @AfterEach
    public void tearDown() {
    }

    //WRite test to Also see that the equals thing is working!
    
    @Test 
    public void testPlus() {
        double amountOfOperand1 = 5.0;
        double amountOfOperand2 = 3.0;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.plus(operand2);
        assertEquals(expResult, result, "Wrong addition result");
    }
   @Test
    public void testPlusWithZero(){
        double amountOfOperand1 = 5.0;
        double amountOfOperand2 = 0.0;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.plus(operand2);
        assertEquals(expResult, result, "Wrong addition with zero result");
    }
    @Test
    public void testPlusWithNegative(){
        double amountOfOperand1 = 5.0;
        double amountOfOperand2 = -3.0;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.plus(operand2);
        assertEquals(expResult, result, "Wrong addition with negative result");
    }

    @Test
    public void testMinus() {
        double amountOfOperand1 = 5.0;
        double amountOfOperand2 = 3.0;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 - amountOfOperand2);
        Amount result = operand1.minus(operand2);
        assertEquals(expResult, result, "Wrong subtraction result");
    }
        
    @Test
    public void testMinusWithZero() {
        double amountOfOperand1 = 5.0;
        double amountOfOperand2 = 0.0;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 - amountOfOperand2);
        Amount result = operand1.minus(operand2);
        assertEquals(expResult, result, "Wrong subtraction result");
    }
    
    @Test
    public void testMinusWithNegative() {
        double amountOfOperand1 = 5.0;
        double amountOfOperand2 = -3.0;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 - amountOfOperand2);
        Amount result = operand1.minus(operand2);
        assertEquals(expResult, result, "Wrong subtraction result");
    }

    @Test
    public void testMultiplied() {
        double amountOfOperand1 = 5.0;
        double amountOfOperand2 = 3.0;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 * amountOfOperand2);
        Amount result = operand1.multiplied(operand2);
        assertEquals(expResult, result, "Wrong multiplication result");
    }
    
    @Test
    public void testMultipliedWithZero() {
        double amountOfOperand1 = 5.0;
        double amountOfOperand2 = 0.0;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 * amountOfOperand2);
        Amount result = operand1.multiplied(operand2);
        assertEquals(expResult, result, "Wrong multiplication result");
        }
    
     @Test
    public void testMultipliedWithNegative() {
        double amountOfOperand1 = 5.0;
        double amountOfOperand2 = -3.0;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 * amountOfOperand2);
        Amount result = operand1.multiplied(operand2);
        assertEquals(expResult, result, "Wrong multiplication result");
        }

    @Test
    public void testToString() {
        double representedAmount = 5.0;
        Amount amount = new Amount(representedAmount);
        String expResult = Double.toString(representedAmount);
        String result = amount.toString();
        assertEquals(expResult, result, "Wrong string returned by toString");
    }
}
