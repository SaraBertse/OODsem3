
package se.kth.sem3.model;

/**
 * Represents the information of a purchase, with item description, item price 
 * and running total.
 */
public class PurchaseInfoDTO {
    
    String description;
    Amount price;
    Amount runningTotal;
    
    /**
     * Creates a new instance with purchase info.
     * 
     * @param description This is the item description.
     * @param price This is the item price.
     * @param runningTotal This is the running total, meaning the price of all 
     * so far purchased items added together.
     */
    public PurchaseInfoDTO(String description, Amount price, Amount runningTotal){
    
        this.description = description;
        this.price = price;
        this.runningTotal = runningTotal;
    }
    
    public String getDescription(){
        
        return description;
    }
    
    public Amount getPrice(){
        
        return price;
    }
    
    public Amount getRunningTotal(){
    
        return runningTotal;
    }
    
    public String toString(){
        
        return "Description: " + description + " Price: " + price + " Running Total " + runningTotal;
    }
    
}
