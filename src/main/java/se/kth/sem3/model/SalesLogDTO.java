
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

LocalDateTime timeAndDateOfSale;
String storeName;
String storeAddress;
List items; //Name of each item //Quantity of each item //Price for each item
Amount totalPrice;
Amount totalVAT; //Nothing is calculating this or any other taxes
Amount amountPaid;
Amount change;
   
//Issues:    
    //Name of each item
    //Quantity of each item
    //Price for each item
    //VAT for the sale
    
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
    
    public LocalDateTime getTimeAndDateOfSale(){
    
        return timeAndDateOfSale;
    }
    
    public String getStoreName(){
        
        return storeName;
    }
    
     public String getStoreAddress(){
        
        return storeAddress;
    }
     
     public List getItems(){
         
         return items;
    }
     
    public Amount getTotalPrice(){
         
        return totalPrice;
    }
     
    public Amount getTotalVAT(){
         
        return totalVAT;
    }
      
    public Amount getAmountPaid(){
         
        return amountPaid;
    }
       
    public Amount getChange(){
         
        return change;
    }
    
}

