
package se.kth.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

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
}
