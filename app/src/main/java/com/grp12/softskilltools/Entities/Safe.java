package com.grp12.softskilltools.Entities;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathiaslarsen on 18/11/2016.
 */

public class Safe {

    public List<AbstractItem> abstractItems;
    private AbstractItem item;
    private User owner;

    public Safe(User owner){
        Initialize(owner);
    }


    public void Initialize(User user){
        this.owner = user;
        abstractItems = new ArrayList<>();

    }

    public boolean addToSafe(AbstractItem item, int qty){
         int value = abstractItems.size();

        for (int i = 0; i < qty; i++) {
            abstractItems.add(item);
        }

        if (abstractItems.size()==value){
            return false;

        }
        return true;
    }
    public List<AbstractItem> getItems(){
        return abstractItems;
    }
    public boolean isEmpty(){
        if (abstractItems.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean removeItemFromSafe(AbstractItem item){
        int value = abstractItems.size();
               abstractItems.remove(item);
        if (abstractItems.size()==value){
            return false;
        }
        return true;
    }
}
