package console;

import account.UserAccount;

public class LoginMenu extends View {
    public LoginMenu(UserAccount currentUser) {
        viewName = "LoginMenu";
        viewManager = ViewManager.getViewManager();
        this.currentUser = currentUser;
    }

    @Override
    public void renderView() {
        System.out.println("============== LOGIN ==============");
        System.out.printf("Email: %s", currentUser.getEmail());
        System.out.println("===================================");

        viewManager.quit();
    }
}
