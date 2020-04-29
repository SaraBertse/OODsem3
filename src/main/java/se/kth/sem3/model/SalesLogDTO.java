
package se.kth.sem3.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The sales log keeps information for the receipt and the external systems.
 * It stores: Date of sale, time of sale, store name, store address, 
 * name of each item, quantity of each item, price for each item,
 * total price of sale, VAT for the sale, amount paid and change.
 */
public class SalesLogDTO {
    private LocalDateTime timeAndDateOfSale;
    private String storeName;
    private String storeAddress;
    private List items; 
    private Amount totalPrice;
    private Amount totalVAT; 
    private Amount amountPaid;
    private Amount change;
   

    /**
     * Creates a new instance of the sales log.
     * 
     * @param timeAndDateOfSale The time and date of the sale.
     * @param storeName The name of the store.
     * @param storeAddress The address of the store.
     * @param items The items purchased in the sale.
     * @param totalPrice The total price of the sale.
     * @param totalVAT The total VAT (tax) of the sale.
     * @param amountPaid The amount the customer paid.
     * @param change The change the customer gets back.
     */
    public SalesLogDTO(LocalDateTime timeAndDateOfSale, String storeName, 
            String storeAddress, List items, Amount totalPrice, Amount totalVAT,
            Amount amountPaid, Amount change){
        
        this.timeAndDateOfSale = timeAndDateOfSale;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.items = items;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.amountPaid = amountPaid;
        this.change = change;
    }
    
    /**
     * Get the time and date.
     * 
     * @return the time and date. 
     */
    public LocalDateTime getTimeAndDateOfSale(){
    
        return timeAndDateOfSale;
    }
    
    /**
     * Get the store name.
     * 
     * @return the store name.
     */
    public String getStoreName(){
        
        return storeName;
    }
    
    /**
     * Get the store address.
     * 
     * @return the store address.
     */
     public String getStoreAddress(){
        
        return storeAddress;
    }
     
     /**
      * Get the list of items purchased.
      * 
      * @return the list of items purchased. 
      */
     public List getItems(){
         
         return items;
    }
     
     /**
      * Get the total price of the sale.
      * 
      * @return the total price of the sale. 
      */
    public Amount getTotalPrice(){
         
        return totalPrice;
    }
     
    /**
     * Get the total VAT (taxes) of the sale.
     * 
     * @return the total VAT. 
     */
    public Amount getTotalVAT(){
         
        return totalVAT;
    }
      
    /**
     * Get the amount the customer paid.
     * 
     * @return the amount paid.
     */
    public Amount getAmountPaid(){
         
        return amountPaid;
    }
       
    /**
     * Get the change the customer receives back.
     * 
     * @return the change. 
      */
    public Amount getChange(){
         
        return change;
    }
    
}

