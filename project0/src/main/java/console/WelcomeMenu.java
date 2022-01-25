package console;

public class WelcomeMenu extends View {
    public WelcomeMenu() {
        viewName = "WelcomeMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        // prompt user
        System.out.println("\n============= WELCOME =============\n" +
                           "l - Login to an existing account\n" +
                           "r - Register a new account\n" +
                           "e - Exit\n" +
                           "===================================");
        System.out.print("Enter choice: ");

        // get input from user
        String input = viewManager.getScanner().nextLine();

        // navigate to a menu based on user choice
        boolean isChoice = false;
        do {
            switch(input.toCharArray()[0]) {
                case 'l':
                    viewManager.navigate("UserLoginMenu");
                    isChoice = true;
                    break;

                case 'r':
                    viewManager.navigate("UserRegisterMenu");
                    isChoice = true;
                    break;

                case 'e':
                    viewManager.exit();
                    isChoice = true;
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (!isChoice);
    }
}
