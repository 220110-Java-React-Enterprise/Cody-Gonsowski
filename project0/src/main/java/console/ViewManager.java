package console;

import list.CustomArrayList;
import java.util.Scanner;

/**
 * Singleton design pattern:
 *   There should only ever be one instance of this object.
 *   Do this by making the constructor private, and having a public method which invokes
 *     constructor if needed. We abstract the user away from instantiation.
 */
public class ViewManager {
    private static ViewManager viewRenderer;
    private boolean running;
    private final Scanner scanner;
    private View nextView;

    private CustomArrayList<View> viewList;


    // default constructor to set up starting values & references
    private ViewManager() {
        running = true;
        scanner = new Scanner(System.in);
        viewList = new CustomArrayList<>();
    }


    // get the view renderer if it exists, otherwise make a new one
    public static ViewManager getViewManager() {
        if (viewRenderer == null) {
            viewRenderer = new ViewManager();
        }

        return viewRenderer;
    }


    // handoff destination -> runs through registered views -> queues up next view
    public void navigate(String destination) {
        for (int i = 0; i < viewList.size(); i++) {
            View view = viewList.get(i);
            if(view.viewName.equals(destination)) {
                nextView = view;
            }
        }
    }


    public void registerView(View view) {
        viewList.add(view);
    }


    public void render() {
        nextView.renderView();
    }


    public Scanner getScanner() {
        return scanner;
    }


    public void quit() {
        running = false;
    }

    
    public boolean isRunning() {
        return running;
    }

}
