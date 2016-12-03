package com.grp12.softskilltools.Entities;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathiaslarsen on 18/11/2016.
 */

public class Safe {

    public List<AbstractItem> unusedItems;
    public List<AbstractItem> usedItems;
    private AbstractItem item;
    private User owner;

    public Safe(User owner){
        Initialize(owner);
    }


    public void Initialize(User user){
        this.owner = user;
        unusedItems = new ArrayList<>();

    }

    public boolean addToSafe(AbstractItem item, int qty){
         int value = unusedItems.size();

        for (int i = 0; i < qty; i++) {
            unusedItems.add(item);
        }

        if (unusedItems.size()==value){
            return false;

        }
        return true;
    }
    public boolean addToResults(AbstractItem item){
        int value = usedItems.size();
            usedItems.add(item);
        if (usedItems.size()==value){
            return false;

        }
        return true;
    }
    public List<AbstractItem> getSafe(){
        return unusedItems;
    }
    public List<AbstractItem> getResults(){
        return usedItems;
    }
    public boolean isEmpty(){
        if (unusedItems.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean removeItemFromSafe(AbstractItem item){
        int value = unusedItems.size();
        unusedItems.remove(item);
        if (unusedItems.size()==value){
            return false;
        }
        return true;
    }
}
