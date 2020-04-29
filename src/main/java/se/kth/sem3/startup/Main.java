
package se.kth.sem3.startup;
import se.kth.sem3.integration.HandlerCreator;
import se.kth.sem3.model.PurchaseInfoDTO;
import se.kth.sem3.controller.Controller;
import se.kth.sem3.view.View;
import se.kth.sem3.model.CashRegister;
import se.kth.sem3.model.Sale;
import se.kth.sem3.model.SalesLogDTO;

/**
 * This starts up the entire program.
 */
public class Main {
    
    /**
     * The main method, which controls the flow of the program.
     * @param args Leave as is with no changes.
     */
    public static void main(String args[]){
        
        HandlerCreator handle = new HandlerCreator();
        Sale sale = new Sale();
        CashRegister cashreg = new CashRegister(sale);
      
        Controller contr = new Controller(handle, cashreg);
        new View(contr).sampleExecution();
    }
    
}
