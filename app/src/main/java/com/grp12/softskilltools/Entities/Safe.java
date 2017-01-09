package com.grp12.softskilltools.Entities;



import com.grp12.softskilltools.Activities.MainMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathiaslarsen on 18/11/2016.
 */

public class Safe {

    public List<BELBIN> unusedBelbinItems = new ArrayList<>();
    public List<BELBIN> usedBelbinItems = new ArrayList<>();

    public List<DISC> unusedDiscItems = new ArrayList<>();
    public List<DISC> usedDiscItems = new ArrayList<>();




    private List<AbstractItem> unusedItems = new ArrayList<>();
    private List<AbstractItem> usedItems = new ArrayList<>();


    /** Nødvendigt med konsteruktør uden parametre for at objektet kan instantieres fra JSON */
    public Safe() {
    }

    /**********************************
     * The logic of this class begins *
     **********************************/


    /********************************************************
     * This method takes an object and saves it in the safe *
     ********************************************************/

    void addToSafe(AbstractItem item, int qty) {

        switch (item.getTestType()){
            case DISC:
                unusedDiscItems.add((DISC)item);
                break;
            case BELBIN:
                unusedBelbinItems.add((BELBIN)item);
                break;

            case THREESIXTY:
        }
    }


    /**********************************************
     * This method filters out the answered tests *
     **********************************************/

    void addToResults(AbstractItem item) {


        switch (item.getTestType()){
            case DISC:
                usedDiscItems.add((DISC)item);
                break;

            case BELBIN:
                usedBelbinItems.add((BELBIN)item);
                break;

            case THREESIXTY:
                break;
        }

    }

    public void updateUnusedItem(AbstractItem item){
        int number  = 0;
        for(int i = 0; i < unusedItems.size(); i++){
            if(item == unusedItems.get(i))
                number = i;
            unusedItems.set(number,item);
        }

    }
    /********************************************
     * This method gets an unused item from the safe *
     ********************************************/

    public List<AbstractItem> læsUnusedItems() {
        ArrayList<AbstractItem> res = new ArrayList<AbstractItem>();
        res.addAll(unusedBelbinItems);
        res.addAll(unusedDiscItems);
        return res;
    }





    public void sætUnusedItems(List<AbstractItem> Unused){
       for (int i = 0; i < Unused.size();i++){
            switch (Unused.get(i).getTestType()){
                case DISC:
                    DISC disc = (DISC)Unused.get(i);
                    this.unusedItems.add(disc);
                    break;

                case BELBIN:
                    BELBIN belbin = (BELBIN)Unused.get(i);
                    this.unusedItems.add(belbin);
                    break;

                case THREESIXTY:
                    THREESIXTY threesixty = (THREESIXTY)Unused.get(i);
                    this.unusedItems.add(threesixty);

                    break;
            }
       }

    }


    public void sætUsedItems(List<AbstractItem> used){
        for (int i = 0; i < used.size();i++){
            switch (used.get(i).getTestType()){
                case DISC:
                    DISC disc = (DISC)used.get(i);
                    this.usedDiscItems.add(disc);
                    break;

                case BELBIN:
                    BELBIN belbin = (BELBIN)used.get(i);
                    this.usedBelbinItems.add(belbin);
                    break;

                case THREESIXTY:
                    THREESIXTY threesixty = (THREESIXTY)used.get(i);
                    this.unusedItems.add(threesixty);

                    break;
            }
        }
    }


    /********************************************
     * This method gets the results from a test *
     ********************************************/

    public ArrayList<AbstractItem> getUsedItems() {
        ArrayList<AbstractItem> res = new ArrayList<>();
        res.addAll(usedDiscItems);
        res.addAll(usedBelbinItems);
        return res;
    }



    public int getSafeSize(){
        return læsUnusedItems().size();
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
