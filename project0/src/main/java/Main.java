import account.BankAccount;
import account.UserAccount;
import account.repos.BankAccountRepo;
import account.repos.UserAccountRepo;
import console.WelcomeMenu;
import console.UserRegisterMenu;
import console.BankCreateMenu;
import console.BankMenu;
import console.UserLoginMenu;
import console.ViewManager;

public class Main {
    public static void main(String[] args) {
        // make/get the view manager
        ViewManager viewManager = ViewManager.getViewManager();

        // make account repos to pass around
        UserAccountRepo userRepo = new UserAccountRepo();
        BankAccountRepo bankRepo = new BankAccountRepo();
        UserAccount currentUser = new UserAccount();
        BankAccount currentBank = new BankAccount();

        // register views to view manager
        viewManager.registerView(new WelcomeMenu());
        viewManager.registerView(new UserRegisterMenu(userRepo));
        viewManager.registerView(new UserLoginMenu(currentUser));
        viewManager.registerView(new BankMenu());
        viewManager.registerView(new BankCreateMenu(bankRepo));

        // navigate to main menu for the first menu
        viewManager.navigate("WelcomeMenu");

        // call the next render method
        while(viewManager.isRunning()) {
            viewManager.render();
        }

    }
}
