package console;

import account.BankAccount;
import list.CustomArrayList;
import utils.DataStore;

public class BankSelectMenu extends View {
    public BankSelectMenu() {
        viewName = "BankSelectMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        String input = "";
        Integer inputId = 0;
        boolean isInteger = false;
        boolean isLinked = false;
        CustomArrayList<BankAccount> bankList = new CustomArrayList<>();

        System.out.println("======== ACCOUNT SELECTION ========");

        do {
            // get input from user
            System.out.print("Enter an account ID associated with your current user: ");
            input = viewManager.getScanner().nextLine();

            // check to see if input is a valid integer
            try {
                inputId = Integer.parseInt(input);
                isInteger = true;
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number! Please try again.");
                isInteger = false;
            }

            if (isInteger) {
                // list of accounts associated with customer
                bankList = DataStore.getBankRepo().accountsOfCustomer(DataStore.getUser().getId());
    
                // check to see if input id is tied to the current user
                for (int i = 0; i < bankList.size(); i++) {
                    if (inputId == bankList.get(i).getId()) {
                        isLinked = true;
                    }
                }
            }

        } while (!isLinked);

        // update current account to select account
        DataStore.setBank(DataStore.getBankRepo().read(inputId));

        System.out.println("===================================");

        // navigate back to transactions menu
        viewManager.navigate("BankTransactionMenu");
    }
}
