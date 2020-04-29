
package se.kth.sem3.controller;
import java.util.ArrayList;
import java.util.List;
import se.kth.sem3.model.PurchaseInfoDTO;
import se.kth.sem3.model.Sale;
import se.kth.sem3.model.ItemDTO;
import se.kth.sem3.integration.ExternalInventoryDBHandler;
import se.kth.sem3.integration.HandlerCreator;
import se.kth.sem3.model.Amount;
import se.kth.sem3.model.CashRegister;
import se.kth.sem3.integration.PrinterHandler;
import se.kth.sem3.model.SalesLogDTO;

/**
 * The controller class passes calls from the view to the model or integration.
 */
public class Controller {
    private HandlerCreator handler;
    private ExternalInventoryDBHandler extInv;
    private CashRegister cashreg;
    
     public List<Integer> enteredIDs = new ArrayList<>();
    
    /**
     * Creates a new sale
     */
    public void startSale(){
        Sale sale = new Sale();
    }
    //Need this for now, because otherwise sale.updatePurchaseItem doesn't work...
    Sale sale = new Sale();
    
    public Controller(){
        
    }
    
    /**
     * Creates a new instance.
     * 
     * @param handler A HandlerCreator is needed to get the external inventory
     * database handler that the controller uses.
     */
    public Controller(HandlerCreator handler, CashRegister cashreg){
        this.handler = handler;  
        this.extInv = handler.getExtInvDBHandler();
        this.cashreg = cashreg;
    }
    
    PrinterHandler printerHandler = new PrinterHandler();
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
        int i = 0; //Counts iterations. Maybe needs to be lowered, I dunno.
        ItemDTO item = extInv.retrieveItemInfo(itemID);
        for (int items : enteredIDs){
            if (itemID == items){
                enteredIDs.get(i); //Gets the latest object
            }
            else{
                                
            enteredIDs.add(new Integer(itemID));
            PurchaseInfoDTO purchaseInfo = sale.updatePurchaseInfo(item, quantity);
                //So I basically want it to check if the item number has been entered.
                //If it has, it increases the quantity of that by 1.
                //Maybe that's the problem, how can you increase the quantity 
                //From before... From the previous item.
                
                //So I need to see how to access that quantity, where it's stored.
                //And see if I can mess with a value that's already there.
               
            }
           
        }
       
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
    
    public Amount enterAmountPaid(Amount payment, Amount totalPrice){
       
        Amount change = cashreg.addPayment(payment, totalPrice);
        
        sale.updateAmountPaid(payment);
        return change;
    }
    
    public String getReceiptString(){
        String receipt = printerHandler.printReceipt(sale.getSalesLogDTO());
    
        return receipt;
    }
}
