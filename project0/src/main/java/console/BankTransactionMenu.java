package console;

import java.text.NumberFormat;
import java.util.Locale;

import utils.DataStore;

public class BankTransactionMenu extends View {
    public BankTransactionMenu() {
        viewName = "BankTransactionMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        System.out.printf("\n=========== TRANSACTION ===========\n" +
                          "Account %d contains %s\n" +
                          "d - Make a deposit\n" +
                          "w - Make a withdrawal\n" +
                          "q - Quit\n" +
                          "===================================\n",
                          DataStore.getBank().getId(),
                          currencyFormatter.format(DataStore.getBank().getBalance()));
        System.out.print("Enter choice: ");

        // get input from user
        String input = viewManager.getScanner().nextLine();

        // navigate to a menu based on user choice
        boolean isChoice = false;
        do {
            switch (input.toCharArray()[0]) {
                case 'd':
                    viewManager.navigate("BankDepositMenu");
                    isChoice = true;
                    break;
                
                case 'w':
                    viewManager.navigate("BankWithdrawalMenu");
                    isChoice = true;
                    break;
                
                case 'q':
                    viewManager.quit();
                    isChoice = true;
                    break;
                
                default:
                    break;
            }
        } while (!isChoice);
    }
}
