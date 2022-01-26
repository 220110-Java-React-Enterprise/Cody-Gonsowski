package console;

import list.CustomArrayList;
import java.util.Scanner;

/**
 * There should only ever be one instance of this object.
 *   Handles the various menus presented to the user in the console.
 */
public class ViewManager {
    private static ViewManager viewRenderer;
    private boolean running;
    private final Scanner scanner;
    private View nextView;
    private CustomArrayList<View> viewList;


    /**
     * Default constructor sets up starting values & references.
     */
    private ViewManager() {
        running = true;
        scanner = new Scanner(System.in);
        viewList = new CustomArrayList<>();
    }


    /**
     * Get the view renderer if it exists, otherwise make a new one.
     * @return the singleton instance of ViewManager object
     */
    public static ViewManager getViewManager() {
        if (viewRenderer == null) {
            viewRenderer = new ViewManager();
        }

        return viewRenderer;
    }


    /**
     * Runs through registered views and queues up destination view if it exists.
     * @param destination the name of the next view to navigate to
     */
    public void navigate(String destination) {
        for (int i = 0; i < viewList.size(); i++) {
            View view = viewList.get(i);
            if(view.viewName.equals(destination)) {
                nextView = view;
            }
        }
    }


    /**
     * Add a new view to the list
     * @param view view to add to list
     */
    public void registerView(View view) {
        viewList.add(view);
    }


    /**
     * Calls the respective renderView() method of the next view.
     */
    public void render() {
        nextView.renderView();
    }


    /**
     * Returns the scanner object provided in the ViewManager class.
     * @return scanner connected to System.in
     */
    public Scanner getScanner() {
        return scanner;
    }


    /**
     * Sets the running flag to false.
     *   The program should exit smoothly after this is set.
     */
    public void exit() {
        running = false;
    }

    
    /**
     * See if the ViewManager is still running.
     * @return true  - the ViewManager is still running
     *         false - the ViewManager is no longer running.
     */
    public boolean isRunning() {
        return running;
    }

}
