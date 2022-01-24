package console;

import account.UserAccount;
import utils.DataStore;

public class UserRegisterMenu extends View {
    public UserRegisterMenu() {
        viewName = "UserRegisterMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        String input = "";
        boolean isValid = false;
        UserAccount user = new UserAccount();

        System.out.println("=========== NEW ACCOUNT ===========");

        // FIRST NAME
        do {
            // user input
            System.out.print("First Name: ");
            input = viewManager.getScanner().nextLine();

            // attempt to set first name
            isValid = user.setFirstName(input);

            // if invalid first name, try again
            if (!isValid) {
                System.out.println("Invalid first name! Please try again.");
            }
        } while (!isValid);

        // LAST NAME
        do {
            // user input
            System.out.print("Last Name: ");
            input = viewManager.getScanner().nextLine();

            // attempt to set last name
            isValid = user.setLastName(input);

            // if invalid last name, try again
            if (!isValid) {
                System.out.println("Invalid last name! Please try again.");
            }
        } while (!isValid);

        // EMAIL
        do {
            // user input
            System.out.print("Email: ");
            input = viewManager.getScanner().nextLine();

            // attempt to set email
            isValid = user.setEmail(input);

            // if invalid email, try again
            if (!isValid) {
                System.out.println("Invalid email! Please try again.");
            }

            if (DataStore.getUserRepo().doesEmailExist(input)) {
                System.out.println("That email already exists! Please try again.");
            }
        } while (!isValid);

        // PASSWORD
        do {
            // user input
            System.out.print("Password: ");
            input = viewManager.getScanner().nextLine();

            // attempt to set password
            isValid = user.setPassword(input);

            // if password email, try again
            if (!isValid) {
                System.out.println("Invalid password! Please try again.");
            }
        } while (!isValid);

        System.out.println("===================================");

        DataStore.getUserRepo().create(user);

        System.out.println("Registration complete!");

        viewManager.navigate("WelcomeMenu");
    }
}
