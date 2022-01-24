package console;

public abstract class View {
    String viewName;
    protected ViewManager viewManager;

    public String getViewName() {
        return viewName;
    }

    public abstract void renderView();
}
