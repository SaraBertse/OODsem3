/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem3.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sarab
 */
public class CashRegisterTest {
    Sale sale = new Sale();
    public CashRegisterTest() {
    }

    @Test
    public void testAddPayment() {
        Amount payment = new Amount(100);
        Amount totalPrice = new Amount(50);
        CashRegister instance = new CashRegister(sale);
        Amount expResult = new Amount(50.0);
        Amount result = instance.addPayment(payment, totalPrice);
        assertEquals(expResult, result, "the calculated change is wrong");
    }
    
     @Test
    public void testAddPaymentNegative() {
        Amount payment = new Amount(-100);
        Amount totalPrice = new Amount(50);
        CashRegister instance = new CashRegister(sale);
        Amount expResult = new Amount(-150.0);
        Amount result = instance.addPayment(payment, totalPrice);
        assertEquals(expResult, result, "the calculated change is wrong when the"
                + "payment is negative");
    }
    
         @Test
    public void testAddPaymentZero() {
        Amount payment = new Amount(0);
        Amount totalPrice = new Amount(50);
        CashRegister instance = new CashRegister(sale);
        Amount expResult = new Amount(-50.0);
        Amount result = instance.addPayment(payment, totalPrice);
        assertEquals(expResult, result, "the calculated change is wrong when"
                + "the payment is 0");
    }
}
