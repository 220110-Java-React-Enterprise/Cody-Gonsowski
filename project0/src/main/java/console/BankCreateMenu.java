package console;

import account.BankAccount;
import account.UserAccount;
import account.repos.BankAccountRepo;

public class BankCreateMenu extends View {
    public BankCreateMenu(BankAccountRepo bankRepo, UserAccount currentUser) {
        viewName = "BankCreateMenu";
        viewManager = ViewManager.getViewManager();
        this.bankRepo = bankRepo;
        this.currentUser = currentUser;
    }

    @Override
    public void renderView() {
        BankAccount bank = new BankAccount();

        // following general format, though process is automated
        System.out.println("=========== NEW ACCOUNT ===========");

        // inform user account is being created
        System.out.println("Creating new bank account for active user...");
        bank.setCustomerId(currentUser.getId());

        // initial account balance of $0
        System.out.println("Initiating account balance of $0...");
        bank.setBalance(0.0);

        // create account in database
        bankRepo.create(bank);
        System.out.println("Account created successfully!");

        System.out.println("===================================");

        // navigate back to main bank menu
        viewManager.navigate("BankMenu");
    }
}
