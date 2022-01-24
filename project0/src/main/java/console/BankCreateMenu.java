package console;

import account.BankAccount;
import utils.DataStore;

public class BankCreateMenu extends View {
    public BankCreateMenu() {
        viewName = "BankCreateMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        BankAccount bank = new BankAccount();

        // following general format, though process is automated
        System.out.println("=========== NEW ACCOUNT ===========");

        // inform user account is being created empty
        System.out.println("Creating new empty bank account...");
        bank.setBalance(0.0);
        DataStore.getBankRepo().create(bank);

        // update current bank account
        DataStore.setBank(
            DataStore.getBankRepo().accountsOfCustomer(
                DataStore.getUser().getId()
                ).get(0));

        // link account to active user
        System.out.println("Linking new bank account to active user...");
        DataStore.getBankRepo().linkAccount(DataStore.getUser().getId(), DataStore.getBank().getId());

        // create account
        System.out.println("Account created successfully!");

        System.out.println("===================================");

        // navigate back to main bank menu
        viewManager.navigate("BankMenu");
    }
}
