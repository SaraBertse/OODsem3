package se.kth.sem3.model;

/**
 * Represents the cash register.
 */
public class CashRegister {

    private Sale sale;

    /**
     * Creates a new instance of the cash register with a sale object.
     *
     * @param sale This is the sale object.
     */
    public CashRegister(Sale sale) {
        this.sale = sale;
    }

    /**
     * Calculates the change that belongs to the customer.
     *
     * @param payment What the customer paid.
     * @param totalPrice The total price of the sale.
     * @return The change the customer should get.
     */
    public Amount addPayment(Amount payment, Amount totalPrice) {

        Amount change = sale.calculateChange(payment, totalPrice);

        return change;
    }

}
