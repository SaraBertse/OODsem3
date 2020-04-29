
package se.kth.sem3.model;

/**
 * Represents an item in the store.
 */
public class ItemDTO {
    String description;
    Amount price;
    Amount taxRate;
    
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
    
    public String getDescription(){
       
        return description;
    }
    
    public Amount getPrice(){
        
        return price;
    }
    
    public Amount getTaxRate(){
        
        return taxRate;
    }
}
