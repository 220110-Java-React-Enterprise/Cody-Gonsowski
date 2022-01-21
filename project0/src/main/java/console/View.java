package console;

import account.repos.UserAccountRepo;
import account.BankAccount;
import account.UserAccount;
import account.repos.BankAccountRepo;

public abstract class View {
    String viewName;
    protected ViewManager viewManager;
    protected UserAccountRepo userRepo;
    protected BankAccountRepo bankRepo;
    protected UserAccount currentUser;
    protected BankAccount currentBank;

    public String getViewName() {
        return viewName;
    }

    public abstract void renderView();
}
