package console;

public class BankMenu extends View {
    public BankMenu() {
        viewName = "BankMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("\n============= BANKING =============\n" +
                           "c - Create a new banking account\n" +
                           "l - List accounts\n" +
                           "s - Select an account\n" +
                           "q - Quit to previous major menu\n" +
                           "e - Exit\n" +
                           "===================================");
        System.out.print("Enter choice: ");

        // get input from user
        String input = viewManager.getScanner().nextLine();

        // navigate to a menu based on user choice
        boolean isChoice = false;
        do {
            switch (input.toCharArray()[0]) {
                case 'c':
                    viewManager.navigate("BankCreateMenu");
                    isChoice = true;
                    break;
                
                case 'l':
                    viewManager.navigate("BankListMenu");
                    isChoice = true;
                    break;
                
                case 's':
                    viewManager.navigate("BankSelectMenu");
                    isChoice = true;
                    break;
                
                case 'q':
                    viewManager.navigate("WelcomeMenu");
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
