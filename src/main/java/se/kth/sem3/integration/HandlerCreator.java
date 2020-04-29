package se.kth.sem3.integration;

/**
 * This class is responsible for instantiating the external database handlers 
 * ExternalInventoryDBHandler, ExternalAccountingDBHandler and the Printer
 */
public class HandlerCreator {
    ExternalInventoryDBHandler extInv = new ExternalInventoryDBHandler();
    
 
    public ExternalInventoryDBHandler getExtInvDBHandler(){
        
        return extInv;
    }
}
