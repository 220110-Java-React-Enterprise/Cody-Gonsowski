package com.revature.project0.Console;

import java.util.LinkedList;
import java.util.List;
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

    // TODO when adapting to P0, replace this with your custom list structure
    private List<View> viewList;


    // default constructor to set up starting values & references
    private ViewManager() {
        running = true;
        scanner = new Scanner(System.in);
        // TODO when adapting to P0, replace this with your custom list structure
        viewList = new LinkedList<>();
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
        for(View view : viewList) {
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
