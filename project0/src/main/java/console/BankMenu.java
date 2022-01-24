package console;

public class BankMenu extends View {
    public BankMenu() {
        viewName = "BankMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("============= BANKING =============\n" +
                           "c - Create a new banking account\n" +
                           "l - List associated accounts\n" +
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
                    break;
                
                case 'l':
                    viewManager.navigate("BankListMenu");
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
