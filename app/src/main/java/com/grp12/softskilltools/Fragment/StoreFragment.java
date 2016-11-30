package com.grp12.softskilltools.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.AbstractItem;
import com.grp12.softskilltools.Entities.BELBIN;
import com.grp12.softskilltools.Entities.DISC;
import com.grp12.softskilltools.Entities.THREESIXTY;
import com.grp12.softskilltools.Entities.User;
import com.grp12.softskilltools.Util.StoreAdaptor;
import com.grp12.softskilltools.resources.ItemDefinition;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by mathiaslarsen on 16/11/2016.
 */

public class StoreFragment extends Fragment{

    public StoreFragment(){

    }

    private AbstractItem[] items;
    private final int Store_items = 3;
    View myView;
    public ListView lv;
    private static StoreFragment sStoreFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_store, container, false);
        initialize();
        ArrayList<AbstractItem> products = getProducts();
        lv = (ListView) myView.findViewById(R.id.list);
        lv.setAdapter(new StoreAdaptor(getContext(), products));
        sStoreFragment = this;
        return myView;
    }


    public void addToBasket(AbstractItem item, int qty, User user){
        user.addToSafe(item, qty);
        Toast.makeText(getContext(), "Du ejer nu "+item.getProductName(), Toast.LENGTH_SHORT).show();
    }
    public User getUser(){
        return MainMenu.getInstance().getUser();
    }

    public void initialize() {
        items = new AbstractItem[Store_items];

        for (int i = 0; i < Store_items; i++) {
            switch (ItemDefinition.testType[i]) {

                case DISC:
                    items[i] = new DISC(ItemDefinition.TESTPrice_DATA[i],false,ItemDefinition.TESTName_DATA[i],ItemDefinition.TESTDescription_DATA[i]);
                    break;

                case BELBIN:
                    items[i] = new BELBIN(ItemDefinition.TESTPrice_DATA[i],false, ItemDefinition.TESTName_DATA[i],ItemDefinition.TESTDescription_DATA[i]);
                    break;

                case THREESIXTY:
                    items[i] = new THREESIXTY(ItemDefinition.TESTPrice_DATA[i],false, ItemDefinition.TESTName_DATA[i],ItemDefinition.TESTDescription_DATA[i]);
                    break;
            }
        }
    }

    public static StoreFragment getInstance() {
        return sStoreFragment;
    }
    public ArrayList<AbstractItem> getProducts(){

        ArrayList<AbstractItem> products = new ArrayList<>(Arrays.asList(items));
        return products;
    }

}
