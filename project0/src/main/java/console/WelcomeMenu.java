package console;

public class WelcomeMenu extends View {
    public WelcomeMenu() {
        viewName = "WelcomeMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        // prompt user
        System.out.println("============= WELCOME =============\n" +
                           "l - Login to an existing account\n" +
                           "r - Register a new account\n" +
                           "q - Quit\n" +
                           "===================================");
        System.out.print("Enter choice: ");

        // get input from user
        String input = viewManager.getScanner().nextLine();

        // navigate to a menu based on user choice
        boolean isChoice = false;
        do {
            switch(input.toCharArray()[0]) {
                case 'l':
                    viewManager.navigate("LoginMenu");
                    isChoice = true;
                    break;
                case 'r':
                    viewManager.navigate("RegisterMenu");
                    isChoice = true;
                    break;
                case 'q':
                    viewManager.quit();
                    isChoice = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (!isChoice);
    }
}
