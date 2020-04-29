
package se.kth.sem3.model;

/**
 * Represents an amount of money.
 */
public class Amount {
    private double amount;
    
    /**
     * Creates a new instance with the value 0.
     */
    public Amount(){
        this(0);
    }
    
    /**
     * Creates a new instance.
     * 
     * @param amount Specifies how much the amount is. 
     */
    public Amount(double amount){
        this.amount = amount;
    }
    
    /**
     * Checks if two <code>Amount</code>s represent the same value, in which 
     * case they are considered equal.
     * 
     * @param The <code>Amount</code> to compare with this amount.
     * 
     * @return Returns <code>true</code> if the amount passed to the method 
     * has the same value as this amount. Returns <code>false</code> if the two
     * amounts contain different values.
     */
    public boolean equals(Object other){
        if (other == null || !(other instanceof Amount)){
                return false;
        }
        Amount otherAmount = (Amount) other;
        return amount == otherAmount.amount;
    }
    
    /**
     * Adds a new <code>Amount</code> to the existing <code>Amount</code>.
     * 
     * @param other the <code>Amount</code> to add. 
     * @return The result of the two <code>Amount</code>s added.
     */
    public Amount plus(Amount other) {
        return new Amount(amount + other.amount);
    }
    
    /**
     * Subtracts a new <code>Amount</code> from the current <code>Amount</code>.
     * 
     * @param other the <code>Amount</code> to subtract.
     * @return The result of the existing <code>Amount</code> minus the new <code>Amount</code>. 
     */
    public Amount minus(Amount other) {
        return new Amount(amount - other.amount);
    }
    
    /**
     * Multiplies the current <code>Amount</code> times another <code>Amount</code>.
     * 
     * @param other The <code>Amount</code> with which to multiply.
     * @return The results of the two <code>Amount</code>s multiplied.
     */
    public Amount multiplied(Amount other){
        return new Amount(amount * other.amount);
    }
        
    public double getAmount(){
    
    return amount;
}
    
    public String toString(){
        
        return String.valueOf(amount);
    }
}
