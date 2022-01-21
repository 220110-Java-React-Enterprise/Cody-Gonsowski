import account.UserAccount;
import console.MainMenu;
import console.LoginMenu;
import console.ViewManager;

public class Main {
    public static void main(String[] args) {
        // make/get the view manager
        ViewManager viewManager = ViewManager.getViewManager();

        // make an account to pass around
        UserAccount user = new UserAccount();

        // register views to view manager
        viewManager.registerView(new MainMenu(user));
        viewManager.registerView(new LoginMenu(user));

        // navigate to main menu for the first menu
        viewManager.navigate("MainMenu");

        // call the next render method
        while(viewManager.isRunning()) {
            viewManager.render();
        }

    }
}
