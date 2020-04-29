
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
    
    public List<ItemData> items = new ArrayList<>();
   
    
  
    Amount runningTotal = new Amount(0);
    Amount calculateTotalVAT = new Amount(0);
    LocalDateTime timeAndDateOfSale = LocalDateTime.now();
    
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
   
    public Amount calculateChange(Amount payment, Amount totalPrice){
        
        Amount change = payment.minus(totalPrice); 
       
        System.out.println("Running total: " + totalPrice);
        
        return change;
    }
    
    public void updateAmountPaid(Amount paidAmount){
        this.payment = paidAmount;
    }
    
    
    //Is for the SaleLog, to be able to enter the desc, quantity and price in the receipt
    public class ItemData{
        public String description;
        public int quantity;
        public Amount price;
        
        public ItemData(String description, int quantity, Amount price){
            this.description = description;
            this.quantity = quantity;
            this.price = price;
        }
        
        public String getDescription(){
        
            return description;
    }
        
        public int getQuantity(){
            
            return quantity;
        }
        
        public void setQuantity(int quantity){
            this.quantity = quantity;
        }
        
        public String toString(){
            
            return "Item: " + description + "    Quantity: " + quantity + "    Price each:" + price;
        }
    }
  
    public SalesLogDTO getSalesLogDTO(){
    
    SalesLogDTO salesLog = new SalesLogDTO(timeAndDateOfSale, "BestShop", "Shopway 12", 
    items, totalPrice, totalVAT, payment, (payment.minus(totalPrice)));
    
    return salesLog;
    }
}
