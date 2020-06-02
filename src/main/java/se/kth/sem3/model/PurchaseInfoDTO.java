
package se.kth.sem3.model;

/**
 * Represents the information of a purchase, with item description, item price 
 * and running total.
 */
public class PurchaseInfoDTO {
    private String description;
    private Amount price;
    private Amount runningTotal;
    
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
    
    /**
     * Get the item description.
     * 
     * @return the description. 
     */
    public String getDescription(){
        
        return description;
    }
    
    /**
     * Get the price of the item.
     * 
     * @return the price. 
     */
    public Amount getPrice(){
        
        return price;
    }
    
    /**
     * Get the running total for the sale.
     * 
     * @return the running total.
     */
    public Amount getRunningTotal(){
    
        return runningTotal;
    }
    
    /**
     * Displays description, price and running total as a string.
     * 
     * @return the string displaying description, price and running total. 
     */
    public String toString(){
        
        return "Description: " + description + " Price: " + price + " Running Total " + runningTotal;
    }
    
           public boolean equals(Object other){
        if (other == null || !(other instanceof PurchaseInfoDTO)){
                return false;
        }
        PurchaseInfoDTO purchaseInfoEquals = (PurchaseInfoDTO) other;
        if (!purchaseInfoEquals.getDescription().equals(this.getDescription())){
            return false;
        }
        if (!purchaseInfoEquals.getPrice().equals(this.getPrice()))
            return false;
        if (!purchaseInfoEquals.getRunningTotal().equals(this.getRunningTotal()))
            return false;  
        return true;
    }
}
