
package se.kth.sem3.controller;
import java.util.ArrayList;
import java.util.List;
import se.kth.sem3.integration.ExternalAccountingDBHandler;
import se.kth.sem3.model.PurchaseInfoDTO;
import se.kth.sem3.model.Sale;
import se.kth.sem3.model.ItemDTO;
import se.kth.sem3.integration.ExternalInventoryDBHandler;
import se.kth.sem3.integration.HandlerCreator;
import se.kth.sem3.model.Amount;
import se.kth.sem3.model.CashRegister;
import se.kth.sem3.integration.PrinterHandler;

/**
 * The controller class passes calls from the view to the model or integration.
 */
public class Controller {
    private HandlerCreator handler;
    private ExternalInventoryDBHandler extInv;
    private ExternalAccountingDBHandler extAcc;
    private CashRegister cashreg;
    private Sale sale;
    private List<Integer> enteredIDs = new ArrayList<>();
    PrinterHandler printerHandler = new PrinterHandler();
    
    /**
     * Creates a new sale
     */
    public void startSale(){
        this.sale = new Sale();
    }
    //Need this for now, because otherwise sale.updatePurchaseItem doesn't work...
    //Sale sale = new Sale();
   
    
    /**
     * Creates a new instance.
     * 
     * @param handler A HandlerCreator is needed to get the external inventory
     * database handler that the controller uses.
     * @param cashreg A cash register is needed for later calculations.
     */
    public Controller(HandlerCreator handler, CashRegister cashreg){
        this.handler = handler;  
        this.extInv = handler.getExtInvDBHandler();
        this.extAcc = handler.getExtAccDBHandler();
        this.cashreg = cashreg;
    }
    
    
    
    /**
     * Inputs the item ID and quantity, and outputs purchase info in the form
     * of description, price and running total.
     * 
     * @param itemID The item ID of the item.
     * @param quantity How many of the item is being purchased.
     * 
     * @return Returns item description, item price and running total. 
     */  
     public PurchaseInfoDTO enterItem(int itemID, int quantity){

        ItemDTO item = extInv.retrieveItemInfo(itemID);
        
                       
        enteredIDs.add(new Integer(itemID));
        PurchaseInfoDTO purchaseInfo = sale.updatePurchaseInfo(item, quantity);  
       
        return purchaseInfo;
    }
    
    
    /**
     * Ends the sale and returns the total price for the sale.
     * 
     * @param purchaseInfo Part of this contains the total price.
     * @return Returns the total price.
     */
    public Amount endSale(PurchaseInfoDTO purchaseInfo){
        
        Amount totalPrice = purchaseInfo.getRunningTotal();
        
        return totalPrice;
    }
    
    /**
     * Takes the amount that was paid and returns the change.
     * 
     * @param payment How much the customer paid.
     * @param totalPrice The total price of the sale.
     * @return Returns how much change belongs to the customer.
    */
    public Amount enterAmountPaid(Amount payment, Amount totalPrice){
       
        Amount change = cashreg.addPayment(payment, totalPrice);
        
        sale.updateAmountPaid(payment);
        return change;
    }
    
    /**
     * Displays the receipt on the View.
     * 
     * @return Returns the formatted receipt with all relevant info. 
     */
    public String getReceiptString(){
        System.out.println("test Controller 1");
        String receipt = printerHandler.printReceipt(sale.getSalesLogDTO());
        System.out.println("Test controlle r2");
        return receipt;
    }
    
    /**
     * Updates the external inventory system and the external accounting system.
     */
    public void updateExternalSystems(){
        extInv.updateInventory(sale.getSalesLogDTO());
        extAcc.updateAccounting(sale.getSalesLogDTO());
    }
}
