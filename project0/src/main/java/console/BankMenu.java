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
                           "l - List associated accounts\n" +
                           "s - Select an associated account\n" +
                           "q - Quit\n" +
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
                    viewManager.quit();
                    isChoice = true;
                    break;
                
                default:
                    break;
            }
        } while (!isChoice);
    }
}
