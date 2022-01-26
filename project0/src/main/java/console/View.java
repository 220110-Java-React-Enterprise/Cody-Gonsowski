package console;

public abstract class View {
    protected String viewName;
    protected ViewManager viewManager;

    
    /**
     * Retrieve the view name of the view.
     * @return view name
     */
    public String getViewName() {
        return viewName;
    }


    /**
     * Abstract method to be implemented by anything extending View.
     *   This is called by the ViewManager's render() method to display to console
     *   and perform any respective logic.
     */
    public abstract void renderView();
}
