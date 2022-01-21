package console;

import account.UserAccount;

public abstract class View {
    String viewName;
    protected ViewManager viewManager;
    protected UserAccount user;

    public String getViewName() {
        return viewName;
    }

    public abstract void renderView();
}
