package console;

import java.text.NumberFormat;
import java.util.Locale;

import account.BankAccount;
import list.CustomArrayList;
import utils.DataStore;

public class BankListMenu extends View {
    public BankListMenu() {
        viewName = "BankListMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        // following general format, though process is automated
        System.out.println("========== BANK ACCOUNTS ==========");

        // list to go through
        CustomArrayList<BankAccount> list = DataStore.getBankRepo().accountsOfCustomer(DataStore.getUser().getId());

        // objects used per iteration
        BankAccount currentAccount;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

        // loop through each account associated with the currently logged in customer
        for (int i = 0; i < list.size(); i++) {
            currentAccount = list.get(i);

            // print id of account
            System.out.printf("Account: %d\n", currentAccount.getId());

            // format balance like: $1234.56
            System.out.printf("  Balance: %s\n", currencyFormatter.format(currentAccount.getBalance()));
        }

        System.out.println("===================================");

        // navigate back to main bank menu
        viewManager.navigate("BankMenu");
    }
}
