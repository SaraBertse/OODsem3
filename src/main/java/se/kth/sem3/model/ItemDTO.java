
package se.kth.sem3.model;

/**
 * Represents an item in the store.
 */
public class ItemDTO {
    private String description;
    private Amount price;
    private Amount taxRate;
    
    /**
     * Creates a new instance.
     * 
     * @param description This is the description of the item.
     * @param price This is the price of the item.
     * @param taxRate This is the tax rate of the item. An integer represents
     * the percentage, so the value 6 means the tax rate is 6%.
     */
    public ItemDTO(String description, Amount price, Amount taxRate){
        
        this.description = description;
        this.price = price;
        this.taxRate = taxRate;
    }
    
    
    /**
     * Compares two ItemDTO objects. 
     * @param otherObj The object used to compare with.
     * @return Returns <code>false</code> if the objects are found not equal,
     * and <code>true</code> if they are found equal.
     */
    public boolean equals(Object otherObj) {
        
        if (otherObj == null) {
            
            return false;
        }
        
        if (getClass() != otherObj.getClass()) {
            
            return false;
        }
        
        ItemDTO other = (ItemDTO) otherObj;
        if (description != other.description) {
            
            return false;
        }
        return true;
    }
        
    /**
     * Gets the description of an item.
     * @return the description.
     */
    public String getDescription(){
       
        return description;
    }
    
    /**
     * Gets the price of an item (before tax).
     * 
     * @return the price. 
     */
    public Amount getPrice(){
        
        return price;
    }
    
    /**
     * Gets the items tax rate.
     * 
     * @return the tax rate. 
     */
    public Amount getTaxRate(){
        
        return taxRate;
    }
    
    /**
     * Represents the ItemDTO object with words. Prints description, price and tax rate.
     * @return Returns a formatted string with description, price and tax rate.
     */
    public String toString(){
        
        return "description: " + description + " , price: " + price 
                + ", taxRate: " + taxRate; 
    }
}
