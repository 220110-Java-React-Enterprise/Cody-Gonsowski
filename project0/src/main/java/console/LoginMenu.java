package console;

import account.UserAccount;

public class LoginMenu extends View {
    public LoginMenu(UserAccount user) {
        viewName = "LoginMenu";
        viewManager = ViewManager.getViewManager();
        this.user = user;
    }

    @Override
    public void renderView() {
        System.out.println("============== LOGIN ==============");
        System.out.printf("Email: %s", user.getEmail());
        System.out.println("===================================");

        viewManager.quit();
    }
}
