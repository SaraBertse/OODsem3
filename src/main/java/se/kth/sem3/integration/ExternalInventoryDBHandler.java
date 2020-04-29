/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem3.integration;
import java.util.ArrayList;
import java.util.List;
import se.kth.sem3.model.ItemDTO;
import se.kth.sem3.integration.InventoryDatabase;
import se.kth.sem3.model.Amount;
/**
 *
 * @author sarab
 */
public class ExternalInventoryDBHandler {
    
    
    //Maybe best handled with switches, so like 111, 112, 113, for different items.
    //And then it returns the one that matches.
    //private List<ItemDTO> items = new ArrayList<>();
    
    //It's static because it doesn't change, the items shall be immutable.
    //Private because there's no need for it to be public?
    //ItemDTO because it might as well get the entire DTO. Even if it doesn't,
    //That doesn't matter in our scenario, whatever type of info it is, it can 
    //be merged into a DTO later. But to make it easier, we say it's in the same format.
   
    public ItemDTO retrieveItemInfo(int ItemID){
        
        ItemDTO itemDTO = fetchItem(ItemID);
        
        return itemDTO;
    }
    
    
    
         ItemDTO returnedItem;
    
    ItemDTO item1 = new ItemDTO("milk", new Amount(12), new Amount(12));
    ItemDTO item2 = new ItemDTO("bread", new Amount(20), new Amount(12));
    ItemDTO item3 = new ItemDTO("snickers", new Amount(15), new Amount(25));
    ItemDTO item4 = new ItemDTO("tomato", new Amount(2), new Amount(6));
    
    
    private ItemDTO fetchItem(int itemID){
        
        //This itemID should be sent on from the View, through the controller
        //and the DBHandler
        switch(itemID) {
            case 111: returnedItem = item1;
                break;
            case 112: returnedItem = item2;
                break;
            case 113: returnedItem = item3;
                break;
            case 114: returnedItem = item4;
                break;
        }
        
        return returnedItem;
     
     }
    
}

   
