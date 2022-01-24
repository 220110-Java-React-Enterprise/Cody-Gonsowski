package console;

public class BankTransactionMenu extends View {
    public BankTransactionMenu() {
        viewName = "BankTransactionMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        //TODO print current balance of active account to user
        System.out.println("\n=========== TRANSACTION ===========\n" +
                           "d - Make a deposit\n" +
                           "w - Make a withdrawal\n" +
                           "q - Quit\n" +
                           "===================================");
        System.out.print("Enter choice: ");

        // get input from user
        String input = viewManager.getScanner().nextLine();

        // navigate to a menu based on user choice
        boolean isChoice = false;
        do {
            switch (input.toCharArray()[0]) {
                case 'd':
                    viewManager.navigate("BankDepositMenu");
                    //TODO implement BankDepositMenu
                    isChoice = true;
                    break;
                
                case 'w':
                    viewManager.navigate("BankWithdrawalMenu");
                    //TODO implement BankWithdrawalMenu
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
