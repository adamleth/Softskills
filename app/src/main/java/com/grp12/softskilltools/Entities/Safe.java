package com.grp12.softskilltools.Entities;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathiaslarsen on 18/11/2016.
 */

class Safe {

    private List<AbstractItem> unusedItems;
    private List<AbstractItem> usedItems;
    private AbstractItem item;
    private User owner;

    Safe(User owner){
        Initialize(owner);
    }


    private void Initialize(User user){
        this.owner = user;
        unusedItems = new ArrayList<>();
        usedItems = new ArrayList<>();

    }

    boolean addToSafe(AbstractItem item, int qty){
         int value = unusedItems.size();

        for (int i = 0; i < qty; i++) {
            unusedItems.add(item);
        }

        return unusedItems.size() != value;
    }
    boolean addToResults(AbstractItem item){
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

    private boolean removeItemFromSafe(AbstractItem item){
        int value = unusedItems.size();
        unusedItems.remove(item);
        return unusedItems.size() != value;
    }
}
