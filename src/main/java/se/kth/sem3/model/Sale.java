
package se.kth.sem3.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an ongoing sale.
 */
public class Sale {
    private Amount totalPrice;
    Amount payment;
    Amount totalVAT; 
    Amount runningTotal = new Amount(0);
    Amount calculateTotalVAT = new Amount(0);
    LocalDateTime timeAndDateOfSale = LocalDateTime.now();
    public List<ItemData> items = new ArrayList<>();
    
    /**
     * Updates the purchase info with description, price and running total.
     * 
     * @param item This object contains the description, price and tax rate. 
     * @param quantity This is how many of the given item is purchased.
     * 
     * @return Returns purchase information with item description, item price 
     * and running total.
     */
    public PurchaseInfoDTO updatePurchaseInfo(ItemDTO item, int quantity){
    
        String description = item.getDescription();
        Amount price = item.getPrice();
        double calculatePriceWithVAT = (item.getPrice().getAmount()) + 
        (item.getPrice().getAmount()*(item.getTaxRate().getAmount())/100);
        Amount priceWithVAT = new Amount(calculatePriceWithVAT);
        Amount priceMultiplied = priceWithVAT.multiplied(new Amount(quantity));
       
        
        runningTotal = updateRunningTotal(runningTotal, priceMultiplied);
        calculateTotalVAT = calculateTotalVAT.plus(new Amount
        (item.getPrice().getAmount()*(item.getTaxRate().getAmount())/100));
        this.totalVAT = calculateTotalVAT;
        
        PurchaseInfoDTO purchaseInfo = new PurchaseInfoDTO(description, price, runningTotal);
    
        //This could be in the threat of Long Method and a bit unclear, could go into it's own thing.
       //items.add(new ItemData(item.getDescription(), quantity, price));
        
        boolean checkIfDuplicate = false;
        int i = 0;
        for (ItemData cycledItems : items){
           String comparedDescription = cycledItems.getDescription();
           i++;
           if (comparedDescription.equals(item.getDescription())){
               ItemData toReplace = items.get(i-1);
               toReplace.setQuantity(toReplace.getQuantity() + 1);
               items.set(i-1, toReplace);
               checkIfDuplicate = true;
           }        
        }
        
        if (checkIfDuplicate == false){
            items.add(new ItemData(item.getDescription(), quantity, price));
        }
        
        return purchaseInfo;
    }
        
   
    /**
     * Calculates the updated running total after each item.
     * 
     * @param runningTotal
     * @param price
     * 
     * @return The updated running total. 
     */
    private Amount updateRunningTotal(Amount runningTotal, Amount price){
       
        Amount updatedRunningTotal = runningTotal.plus(price);
        
        this.totalPrice = updatedRunningTotal;
        return updatedRunningTotal;
    }
   
    /**
     * Calculates the change that belongs to the customer.
     * 
     * @param payment This is how much the customer paid.
     * @param totalPrice This is the total price of the sale.
     * @return Returns how much change the customer should get.
     */
    public Amount calculateChange(Amount payment, Amount totalPrice){
        
        Amount change = payment.minus(totalPrice); 
       
        System.out.println("Running total: " + totalPrice);
        
        return change;
    }
    
    /**
     * Transfers the value of the amount the customer paid to the Sale.
     * 
     * @param paidAmount 
     */
    public void updateAmountPaid(Amount paidAmount){
        this.payment = paidAmount;
    }
    
    
    /**
     * This class represents item data, with description, quantity and price.
     */
    public class ItemData{
        public String description;
        public int quantity;
        public Amount price;
        
        /**
         * Creates an instance of ItemData.
         * 
         * @param description The item's description.
         * @param quantity The quantity of that type of item.
         * @param price The price for the item.
         */
        public ItemData(String description, int quantity, Amount price){
            this.description = description;
            this.quantity = quantity;
            this.price = price;
        }
        
        /**
         * Get the item description.
         * 
         * @return the item description.
         */
        public String getDescription(){
        
            return description;
    }
        /**
         * Get the quantity of the same item.
         * 
         * @return the quantity of the same item. 
         */
        public int getQuantity(){
            
            return quantity;
        }
        
        /**
         * Set the quantity of a certain item.
         * 
         * @param quantity the quantity of an item. 
         */
        public void setQuantity(int quantity){
            this.quantity = quantity;
        }
        
        /**
         * Displays printed description, quantity and price of an item.
         * 
         * @return The formatted string with item description, quantity and price. 
         */
        public String toString(){
            
            return "Item: " + description + "    Quantity: " + quantity + "    Price each:" + price;
        }
    }
  
    /**
     * Creates a new sales log (DTO).
     * 
     * @return the sales log (DTO).
     */
    public SalesLogDTO getSalesLogDTO(){
    
    SalesLogDTO salesLog = new SalesLogDTO(timeAndDateOfSale, "BestShop", "Shopway 12", 
    items, totalPrice, totalVAT, payment, (payment.minus(totalPrice)));
    
    return salesLog;
    }
}