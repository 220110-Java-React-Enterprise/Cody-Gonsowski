package console;

import utils.DataStore;

public class UserLoginMenu extends View {
    public UserLoginMenu() {
        viewName = "UserLoginMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("============== LOGIN ==============");
        System.out.printf("Email: %s", DataStore.getUser().getEmail());
        //TODO finish login
        System.out.println("===================================");

        viewManager.quit();
    }
}
