package se.kth.sem3.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemDTOTest {

    @Test
    public void testEquals() {
        String description = "tomato";
        Amount price = new Amount(2.0);
        Amount taxRate = new Amount(6.0);
        ItemDTO instance = new ItemDTO(description, price, taxRate);
        ItemDTO equalInstance = new ItemDTO(description, price, taxRate);
        boolean expResult = true;
        boolean result = instance.equals(equalInstance);
        assertEquals(expResult, result, "ItemDTO instances with the same state are not equal.");
    }

    @Test
    public void testNotEqualsDescription() {
        String description = "tomato";
        Amount price = new Amount(2.0);
        Amount taxRate = new Amount(6.0);
        ItemDTO instance = new ItemDTO("cucumber", price, taxRate);
        ItemDTO equalInstance = new ItemDTO(description, price, taxRate);
        boolean expResult = false;
        boolean result = instance.equals(equalInstance);
        assertEquals(expResult, result, "ItemDTO instances with different names are equal.");
    }

    @Test
    public void testToString() {
        String description = "tomato";
        Amount price = new Amount(2.0);
        Amount taxRate = new Amount(6.0);
        ItemDTO instance = new ItemDTO(description, price, taxRate);
        String expResult = "description: " + description + " , price: " + price + ", taxRate: " + taxRate;
        String result = instance.toString();
        assertEquals(expResult, result, "Wrong string returned by toString");
    }

    @Test
    public void testToStringNullParameters() {
        String description = null;
        Amount price = null;
        Amount taxRate = null;
        ItemDTO instance = new ItemDTO(description, price, taxRate);
        String expResult = "description: " + description + " , price: " + price + ", taxRate: " + taxRate;
        String result = instance.toString();
        assertEquals(expResult, result, "Wrong string returned by toString with null parameters");
    }

    @Test
    public void testToStringEmptyString() {
        String description = "";
        Amount price = new Amount(2.0);
        Amount taxRate = new Amount(6.0);
        ItemDTO instance = new ItemDTO(description, price, taxRate);
        String expResult = "description: " + description + " , price: " + price + ", taxRate: " + taxRate;
        String result = instance.toString();
        assertEquals(expResult, result, "Wrong string returned by toString with empty String");
    }
}
