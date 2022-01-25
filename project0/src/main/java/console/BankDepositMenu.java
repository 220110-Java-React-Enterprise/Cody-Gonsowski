package console;

import java.text.NumberFormat;
import java.util.Locale;

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
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        
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

            if (isDouble) {
                isValid = true;
            }
        } while(!isValid);

        System.out.println("===================================");
    }
}
