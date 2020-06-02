package se.kth.sem3.integration;

/**
 * This class is responsible for instantiating the external database handlers
 * ExternalInventoryDBHandler, ExternalAccountingDBHandler and the Printer
 */
public class HandlerCreator {

    ExternalInventoryDBHandler extInv = new ExternalInventoryDBHandler();
    ExternalAccountingDBHandler extAcc = new ExternalAccountingDBHandler();

    /**
     * Gets the external inventory database handler.
     *
     * @return the external inventory database handler.
     */
    public ExternalInventoryDBHandler getExtInvDBHandler() {

        return extInv;
    }

    /**
     * Gets the external accounting database handler.
     *
     * @return the external accounting database handler.
     */
    public ExternalAccountingDBHandler getExtAccDBHandler() {

        return extAcc;
    }
}
