package console;

import utils.DataStore;
import utils.InvalidAmountException;

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

            // check to see if input is a valid amount
            try {
                inputAmount = Double.parseDouble(input);
                isDouble = true;
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number! Please try again.");
                isDouble = false;
            }

            // perform transaction
            try {
                // local
                DataStore.getBank().deposit(inputAmount);
    
                // carry over local change to database
                DataStore.getBankRepo().update(DataStore.getBank());

                // indicate positive transaction amount
                //   this is checked by deposit(), but should loop here
                isValid = true;
    
            } catch (InvalidAmountException e) {
                System.out.println(e.getMessage());
                isValid = false;
            }

        } while(!isDouble || !isValid);

        System.out.println("===================================");

        // navigate back to transactions menu
        viewManager.navigate("BankTransactionMenu");
    }
}
