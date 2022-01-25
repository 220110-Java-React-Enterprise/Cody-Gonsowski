package console;

import java.text.NumberFormat;
import java.util.Locale;

public class BankWithdrawalMenu extends View {
    public BankWithdrawalMenu() {
        viewName = "BankWithdrawalMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        System.out.println("\n=========== WITHDRAWAL ============");  // not balanced

        

        System.out.println("===================================");
    }
}
