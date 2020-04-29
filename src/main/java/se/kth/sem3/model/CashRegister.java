
package se.kth.sem3.model;
import se.kth.sem3.controller.Controller;
import se.kth.sem3.model.PurchaseInfoDTO;

/**
 * Represents the cash register.
 */
public class CashRegister {
    private Sale sale;    
    
    public CashRegister(){
    }
    
    public CashRegister(Sale sale){
        this.sale = sale;
    }
    
    public Amount addPayment(Amount payment, Amount totalPrice){
        
        Amount change = sale.calculateChange(payment, totalPrice);
        
        return change;
    }
    
}
