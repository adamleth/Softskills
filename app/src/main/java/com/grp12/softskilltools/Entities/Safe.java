package com.grp12.softskilltools.Entities;



import com.grp12.softskilltools.Activities.MainMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathiaslarsen on 18/11/2016.
 */

public class Safe {

    private List<AbstractItem> unusedItems;
    private List<AbstractItem> usedItems;
    private AbstractItem item;
    private User owner;

    Safe(User owner){
        Initialize(owner);
    }


    public Safe() {

        unusedItems = new ArrayList<>();
        usedItems = new ArrayList<>();
    }

    /**********************************
     * The logic of this class begins *
     **********************************/

    private void Initialize(User user) {
        this.owner = user;
        unusedItems = new ArrayList<>();
        usedItems = new ArrayList<>();

    }

    /********************************************************
     * This method takes an object and saves it in the safe *
     ********************************************************/

    boolean addToSafe(AbstractItem item, int qty) {

        int value = unusedItems.size();

        for (int i = 0; i < qty; i++) {
            unusedItems.add(item);
        }
        return unusedItems.size() != value;
    }

    /**********************************************
     * This method filters out the answered tests *
     **********************************************/

    boolean addToResults(AbstractItem item) {

        int value = usedItems.size();
            usedItems.add(item);
            removeItemFromSafe(item);



        return usedItems.size() != value;
    }

    /********************************************
     * This method gets an unused item from the safe *
     ********************************************/

    List<AbstractItem> getSafe() {
        return unusedItems;
    }

    /********************************************
     * This method gets the results from a test *
     ********************************************/

    List<AbstractItem> getResults() {

        return usedItems;
    }

    /*********************************************************
     * The method checks if the safe is empty for unused items*
     **********************************************************/

    public boolean isEmpty() {

        return unusedItems.isEmpty();
    }
    public int getSafeSize(){
        return unusedItems.size();
    }

    /********************************************
     * This method removes a item from the safe *
     ********************************************/

    private boolean removeItemFromSafe(AbstractItem item){

        int value = unusedItems.size();
        unusedItems.remove(item);
        return unusedItems.size() != value;
    }
}
