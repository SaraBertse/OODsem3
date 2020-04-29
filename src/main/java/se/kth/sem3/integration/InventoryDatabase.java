/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem3.integration;
import java.util.ArrayList;
import java.util.List;
import se.kth.sem3.model.ItemDTO;
import se.kth.sem3.model.Amount;
/**
 *
 * @author sarab
 */
public class InventoryDatabase {
    
    ItemDTO item1 = new ItemDTO("milk", new Amount(12), new Amount(12));
    ItemDTO item2 = new ItemDTO("bread", new Amount(20), new Amount(12));
    ItemDTO item3 = new ItemDTO("snickers", new Amount(15), new Amount(25));
    ItemDTO item4 = new ItemDTO("tomato", new Amount(2), new Amount(6));
 
}
