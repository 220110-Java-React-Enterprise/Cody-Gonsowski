package console;

import utils.DataStore;
import utils.InvalidAmountException;

/**
 * Menu that handles deposit transactions with the user.
 *   Chains back to BankTransactionMenu upon completion.
 */
public class BankDepositMenu extends View {
    public BankDepositMenu() {
        viewName = "BankDepositMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        String input = "";
        Double inputAmount = 0.0;
        boolean isDouble = false;
        boolean isValid = false;
        
        System.out.println("\n============= DEPOSIT =============");

        do {
            // get input from user
            System.out.print("Enter an amount to deposit: ");
            input = viewManager.getScanner().nextLine();

            // check to see if input is a valid number
            try {
                inputAmount = Double.parseDouble(input);
                isDouble = true;
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number! Please try again.");
                isDouble = false;
            }

            // perform transaction
            if (isDouble) {
                try {
                    // persist change
                    DataStore.getBankRepo().deposit(inputAmount, DataStore.getBank().getId());

                    // update local account to match database
                    DataStore.setBank(
                        DataStore.getBankRepo().read(
                            DataStore.getBank().getId()));

                    // valid transaction has occurred
                    isValid = true;
        
                } catch (InvalidAmountException e) {
                    System.out.println(e.getMessage());
                    isValid = false;
                }
            }

        } while(!isDouble || !isValid);

        System.out.println("===================================");

        // navigate back to transactions menu
        viewManager.navigate("BankTransactionMenu");
    }
}
