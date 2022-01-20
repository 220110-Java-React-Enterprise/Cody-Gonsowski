package console;

public class ConsoleMain {
    public static void main(String[] args) {
        // make/get the view manager
        ViewManager viewManager = ViewManager.getViewManager();

        // register views to view manager
        viewManager.registerView(new MainMenu());
        viewManager.registerView(new SubMenu());

        // navigate to main menu for the first menu
        viewManager.navigate("MainMenu");

        // call the next render method
        while(viewManager.isRunning()) {
            viewManager.render();
        }

    }
}
