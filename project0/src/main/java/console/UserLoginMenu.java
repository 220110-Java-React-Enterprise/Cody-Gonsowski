package console;

import account.UserAccount;

public class UserLoginMenu extends View {
    public UserLoginMenu(UserAccount currentUser) {
        viewName = "UserLoginMenu";
        viewManager = ViewManager.getViewManager();
        this.currentUser = currentUser;
    }

    @Override
    public void renderView() {
        System.out.println("============== LOGIN ==============");
        System.out.printf("Email: %s", currentUser.getEmail());
        //TODO finish login
        System.out.println("===================================");

        viewManager.quit();
    }
}
