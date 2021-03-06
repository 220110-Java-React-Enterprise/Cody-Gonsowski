package console;

import utils.DataStore;

/**
 * Menu that allows the user to login to an existing UserAccount.
 *   Chains forward to BankMenu upon completion.
 *   Chains back to WelcomeMenu upon failure.
 */
public class UserLoginMenu extends View {
    public UserLoginMenu() {
        viewName = "UserLoginMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        String email, password = "";
        
        System.out.println("\n============== LOGIN ==============");

        // input email
        System.out.print("Email: ");
        email = viewManager.getScanner().nextLine();

        // input password
        System.out.print("Password: ");
        password = viewManager.getScanner().nextLine();

        // LOGIN SUCCESSFUL
        if (DataStore.getUserRepo().doesPasswordMatch(email, password)) {
            // update current user based on email
            DataStore.setUser(DataStore.getUserRepo().retrieveUserInfo(email));

            // print confirmation of login to user
            System.out.printf("Login successful!\nWelcome, %s %s!\n",
                DataStore.getUser().getFirstName(),
                DataStore.getUser().getLastName());
            System.out.println("===================================");

            // redirect to banking menu
            viewManager.navigate("BankMenu");
        }
        // LOGIN FAILED
        else {
            System.out.println("Login failed! Please register a new account or try again.");
            System.out.println("===================================");
    
            viewManager.navigate("WelcomeMenu");
        }
    }
}
