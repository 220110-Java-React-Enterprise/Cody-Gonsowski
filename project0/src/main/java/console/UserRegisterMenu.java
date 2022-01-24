package console;

import account.UserAccount;
import account.repos.UserAccountRepo;

public class UserRegisterMenu extends View {
    public UserRegisterMenu(UserAccountRepo userRepo) {
        viewName = "UserRegisterMenu";
        viewManager = ViewManager.getViewManager();
        this.userRepo = userRepo;
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
            System.out.printf("First Name: ");
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
            System.out.printf("Last Name: ");
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
            System.out.printf("Email: ");
            input = viewManager.getScanner().nextLine();

            // attempt to set email
            isValid = user.setEmail(input);

            // if invalid email, try again
            if (!isValid) {
                System.out.println("Invalid email! Please try again.");
            }
        } while (!isValid);

        // PASSWORD
        do {
            // user input
            System.out.printf("Password: ");
            input = viewManager.getScanner().nextLine();

            // attempt to set password
            isValid = user.setPassword(input);

            // if password email, try again
            if (!isValid) {
                System.out.println("Invalid password! Please try again.");
            }
        } while (!isValid);

        System.out.println("===================================");

        userRepo.create(user);

        System.out.println("Registration complete!");

        viewManager.navigate("WelcomeMenu");
    }
}
