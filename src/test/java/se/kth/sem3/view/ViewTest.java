
package se.kth.sem3.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.sem3.controller.Controller;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import se.kth.sem3.integration.HandlerCreator;
import se.kth.sem3.model.CashRegister;
import se.kth.sem3.model.Sale;

public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    
    @BeforeEach
    public void setUp() {
        HandlerCreator handle = new HandlerCreator();
        Sale sale = new Sale();
        CashRegister cashreg = new CashRegister(sale);
        Controller contr = new Controller(handle, cashreg);
        instanceToTest = new View(contr);
        
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
        
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testSampleExecution() {
        instanceToTest.sampleExecution();
        String printout = printoutBuffer.toString();
        String expectedOutput = "price";
        assertTrue(printout.contains(expectedOutput), "UI did not start correctly.");
    }
}

/*public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    
    public ViewTest() {
    }
   
    
    @BeforeEach
    public void setUp() {
        Controller contr = new Controller();
        instanceToTest = new View(contr);
        
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
        
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testSampleExecution() {
        instanceToTest.sampleExecution();
        String printout = printoutBuffer.toString();
        String expectedOutput = "blah";
        assertTrue(printout.contains(expectedOutput), "SampleExecution prints wrong thing.");
    }
    
}
*/