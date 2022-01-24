import console.WelcomeMenu;
import utils.DataStore;
import console.UserRegisterMenu;
import console.BankCreateMenu;
import console.BankMenu;
import console.UserLoginMenu;
import console.ViewManager;

public class Main {
    public static void main(String[] args) {
        // load new objects for data sharing
        DataStore.initializeDataStore();

        // make/get the view manager
        ViewManager viewManager = ViewManager.getViewManager();

        // register views to view manager
        viewManager.registerView(new WelcomeMenu());
        viewManager.registerView(new UserRegisterMenu());
        viewManager.registerView(new UserLoginMenu());
        viewManager.registerView(new BankMenu());
        viewManager.registerView(new BankCreateMenu());

        // navigate to main menu for the first menu
        viewManager.navigate("WelcomeMenu");

        // call the next render method
        while(viewManager.isRunning()) {
            viewManager.render();
        }

    }
}
