/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem3.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sarab
 */
public class HandlerCreatorTest {
        HandlerCreator instance = new HandlerCreator();
        ExternalInventoryDBHandler extInv;
        ExternalAccountingDBHandler extAcc;

    @Test
    public void testGetExtInvDBHandler() {
        this.extInv = instance.getExtInvDBHandler();
        assertTrue((extInv != null), "ExternalInventoryDBHandler wasn't"
                + " retrieved correctly");
        
    }
    
        @Test
    public void testGetExtAccDBHandler() {
        this.extAcc = instance.getExtAccDBHandler();
        assertTrue((extAcc != null), "ExternalAccountingDBHandler wasn't"
                + " retrieved correctly");
    }
}

