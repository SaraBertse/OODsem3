/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem3.integration;
import se.kth.sem3.model.SalesLogDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import se.kth.sem3.model.Sale.ItemData;

/**
 *
 * @author sarab
 */
public class PrinterHandler {
    
    public String printReceipt(SalesLogDTO salesLog){
        StringBuilder builder = new StringBuilder();
       
        LocalDateTime timeAndDate = salesLog.getTimeAndDateOfSale();
        builder.append("Time and date of sale: ");
        appendLine(builder, timeAndDate.toString());
        endSection(builder);

        builder.append("Store name: ");
        appendLine(builder, salesLog.getStoreName());
        builder.append("Store address: ");
        appendLine(builder, salesLog.getStoreAddress());
        
        for (ItemData item : (ArrayList<ItemData>)salesLog.getItems()){
            builder.append(item);
            endSection(builder);
        }
        builder.append("Total price of sale: ");
        appendLine(builder, salesLog.getTotalPrice().toString());
        
        builder.append("Total VAT of sale: ");
        appendLine(builder, salesLog.getTotalVAT().toString()); 
        builder.append("Amount paid: ");
        appendLine(builder, salesLog.getAmountPaid().toString());
        builder.append("Change back: ");
        appendLine(builder, salesLog.getChange().toString());
        endSection(builder);
        
        return builder.toString();
    }
        
     private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
}
        
   
