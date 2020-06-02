package se.kth.sem3.view;

import se.kth.sem3.controller.Controller;
import se.kth.sem3.model.PurchaseInfoDTO;
import se.kth.sem3.model.Amount;

/**
 * Currently the placeholder class for the user interface. Also has a hardcoded
 * sample execution.
 */
public class View {

    public Controller contr; //Should be private but is public for now!
    public Amount payment;

    /**
     * Creates a new instance.
     *
     * @param contr The controller that is used for all operations.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * This is the hardcoded sample execution.
     */
    public void sampleExecution() {

        contr.startSale();
        PurchaseInfoDTO purchaseInfo1 = contr.enterItem(111, 2);
        PurchaseInfoDTO purchaseInfo2 = contr.enterItem(112, 1);
        PurchaseInfoDTO purchaseInfo3 = contr.enterItem(114, 2);
        PurchaseInfoDTO purchaseInfo4 = contr.enterItem(111, 1);
        PurchaseInfoDTO purchaseInfo5 = contr.enterItem(112, 1);

        System.out.println(purchaseInfo1);
        System.out.println(purchaseInfo2);
        System.out.println(purchaseInfo3);
        System.out.println(purchaseInfo4);
        System.out.println(purchaseInfo5);

        Amount totalPrice = contr.endSale(purchaseInfo5);

        System.out.println("The total price is " + totalPrice);

        Amount change = contr.enterAmountPaid(new Amount(200), totalPrice);

        System.out.println("The change is " + change);
        System.out.println();

        String receipt = contr.getReceiptString();
        System.out.println(receipt);
        contr.updateExternalSystems();
    }
}
