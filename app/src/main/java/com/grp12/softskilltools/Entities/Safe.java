package com.grp12.softskilltools.Entities;



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


    public Safe(){
        unusedItems = new ArrayList<>();
        usedItems = new ArrayList<>();
    }

    private void Initialize(User user){
        this.owner = user;
        unusedItems = new ArrayList<>();
        usedItems = new ArrayList<>();

        /**********************************
         * The logic of this class begins *
         **********************************/
    }

    boolean addToSafe(AbstractItem item, int qty){

        /********************************************************
         * This method takes an object and saves it in the safe *
         ********************************************************/

         int value = unusedItems.size();

        for (int i = 0; i < qty; i++) {
            unusedItems.add(item);
        }

        return unusedItems.size() != value;
    }
    boolean addToResults(AbstractItem item){

        /**********************************************
         * This method filters out the answered tests *
         **********************************************/

        int value = usedItems.size();
            usedItems.add(item);
            removeItemFromSafe(item);

        return usedItems.size() != value;
    }
    List<AbstractItem> getSafe(){
        return unusedItems;
    }

    List<AbstractItem> getResults(){
        return usedItems;
    }


    public boolean isEmpty(){
        return unusedItems.isEmpty();
    }

        /*********************************************************
        * The method checks if the safe is empty for unused items*
        **********************************************************/

    private boolean removeItemFromSafe(AbstractItem item){

        /********************************************
         * This method removes a item from the safe *
         ********************************************/

        int value = unusedItems.size();
        unusedItems.remove(item);
        return unusedItems.size() != value;
    }
}
