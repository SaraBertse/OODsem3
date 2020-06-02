package se.kth.sem3.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an ongoing sale.
 */
public class Sale {

    private Amount totalPrice;
    private Amount payment;
    private Amount totalVAT;
    private Amount runningTotal = new Amount(0);
    private Amount calculateTotalVAT = new Amount(0);
    private LocalDateTime timeAndDateOfSale = LocalDateTime.now();
    private List<ItemData> items = new ArrayList<>();

    /**
     * Updates the purchase info with description, price and running total.
     *
     * @param item This object contains the description, price and tax rate.
     * @param quantity This is how many of the given item is purchased.
     *
     * @return Returns purchase information with item description, item price
     * and running total.
     */
    public PurchaseInfoDTO updatePurchaseInfo(ItemDTO item, int quantity) {

        String description = item.getDescription();
        Amount price = item.getPrice();
        Amount priceWithVAT = new Amount(calculatePriceWithVAT(item, quantity));
        Amount priceMultiplied = priceWithVAT.multiplied(new Amount(quantity));

        runningTotal = updateRunningTotal(runningTotal, priceMultiplied);
        calculateTotalVAT(item, quantity);

        PurchaseInfoDTO purchaseInfo = new PurchaseInfoDTO(description, price, runningTotal);

        addAndCheckForDuplicates(item, quantity);

        return purchaseInfo;
    }

    /**
     * Calculates the price with VAT.
     *
     * @param item the current item it's being calculated for.
     * @param quantity How many of the item are being purchased.
     *
     * @return The price with VAT.
     */
    private double calculatePriceWithVAT(ItemDTO item, int quantity) {
        double calculatePriceWithVat = (item.getPrice().getAmount())
                + (item.getPrice().getAmount() * (item.getTaxRate().getAmount()) / 100);

        return calculatePriceWithVat;
    }

    /**
     * Calculates the total VAT for the sale.
     *
     * @param item The item is needed to calculate the VAT from the tax rate and
     * price.
     * @param quantity The quantity of the item.
     */
    private void calculateTotalVAT(ItemDTO item, int quantity) {
        calculateTotalVAT = calculateTotalVAT.plus(new Amount((item.getPrice().getAmount() * quantity) * (item.getTaxRate().getAmount()) / 100));
        this.totalVAT = calculateTotalVAT;
    }

    /**
     * Add the items to a list, for the sales log to send to the receipt, and
     * checks if any of the items are duplicates. If they are duplicates, the
     * items are added together and the quantity is increased.
     *
     * @param item The item being added.
     * @param quantity The quantity of the item.
     */
    private void addAndCheckForDuplicates(ItemDTO item, int quantity) {
        boolean checkIfDuplicate = false;
        int i = 0;
        for (ItemData cycledItems : items) {
            String comparedDescription = cycledItems.getDescription();
            i++;
            if (comparedDescription.equals(item.getDescription())) {
                ItemData toReplace = items.get(i - 1);
                toReplace.setQuantity(toReplace.getQuantity() + 1);
                items.set(i - 1, toReplace);
                checkIfDuplicate = true;
            }
        }

        if (checkIfDuplicate == false) {
            items.add(new ItemData(item.getDescription(), quantity, item.getPrice()));
        }
    }

    /**
     * Calculates the updated running total after each item.
     *
     * @param runningTotal
     * @param price
     *
     * @return The updated running total.
     */
    private Amount updateRunningTotal(Amount runningTotal, Amount price) {

        Amount updatedRunningTotal = runningTotal.plus(price);

        this.totalPrice = updatedRunningTotal;
        return updatedRunningTotal;
    }

    /**
     * Calculates the change that belongs to the customer.
     *
     * @param payment This is how much the customer paid.
     * @param totalPrice This is the total price of the sale.
     * @return Returns how much change the customer should get.
     */
    public Amount calculateChange(Amount payment, Amount totalPrice) {

        Amount change = payment.minus(totalPrice);

        return change;
    }

    /**
     * Transfers the value of the amount the customer paid to the Sale.
     *
     * @param paidAmount
     */
    public void updateAmountPaid(Amount paidAmount) {
        this.payment = paidAmount;
    }

    /**
     * Retrieves the payment that's made by the customer.
     *
     * @return the value of the payment the customer made.
     */
    public Amount getPayment() {
        return payment;
    }

    /**
     * This class represents item data, with description, quantity and price.
     */
    public class ItemData {

        public String description;
        public int quantity;
        public Amount price;

        /**
         * Creates an instance of ItemData.
         *
         * @param description The item's description.
         * @param quantity The quantity of that type of item.
         * @param price The price for the item.
         */
        public ItemData(String description, int quantity, Amount price) {
            this.description = description;
            this.quantity = quantity;
            this.price = price;
        }

        /**
         * Get the item description.
         *
         * @return the item description.
         */
        public String getDescription() {

            return description;
        }

        /**
         * Get the quantity of the same item.
         *
         * @return the quantity of the same item.
         */
        public int getQuantity() {

            return quantity;
        }

        /**
         * Set the quantity of a certain item.
         *
         * @param quantity the quantity of an item.
         */
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        /**
         * Displays printed description, quantity and price of an item.
         *
         * @return The formatted string with item description, quantity and
         * price.
         */
        public String toString() {

            return "Item: " + description + "    Quantity: " + quantity + "    Price each: " + price;
        }
    }

    /**
     * Creates a new sales log (DTO).
     *
     * @return the sales log (DTO).
     */
    public SalesLogDTO getSalesLogDTO() {

        SalesLogDTO salesLog = new SalesLogDTO(timeAndDateOfSale, "BestShop", "Shopway 12",
                items, totalPrice, totalVAT, payment, (payment.minus(totalPrice)));

        return salesLog;
    }
}
