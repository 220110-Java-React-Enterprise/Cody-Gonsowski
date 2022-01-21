package console;

import account.UserAccount;

public class MainMenu extends View {
    public MainMenu(UserAccount user) {
        viewName = "MainMenu";
        viewManager = ViewManager.getViewManager();
        this.user = user;
    }

    @Override
    public void renderView() {
        // prompt user
        System.out.println("============ MAIN MENU ============\n" +
                           "l - Login to an existing account\n" +
                           "r - Register a new account\n" + 
                           "===================================");
        System.out.print("Enter choice: ");

        // get input from user
        String input = viewManager.getScanner().nextLine();

        // perform validation for input?

        // store this for use later across different contexts
        user.setEmail("test@test.com");

        // navigate to next menu
        viewManager.navigate("LoginMenu");

    }
}
