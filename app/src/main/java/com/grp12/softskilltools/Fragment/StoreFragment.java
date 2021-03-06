package com.grp12.softskilltools.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.galgespil.stvhendeop.menuapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.AbstractItem;
import com.grp12.softskilltools.Entities.BELBIN;
import com.grp12.softskilltools.Entities.DISC;
import com.grp12.softskilltools.Entities.Safe;
import com.grp12.softskilltools.Entities.THREESIXTY;
import com.grp12.softskilltools.Entities.User;
import com.grp12.softskilltools.Util.AnimationUtil;
import com.grp12.softskilltools.Util.PopUp;
import com.grp12.softskilltools.Util.StoreAdaptor;
import com.grp12.softskilltools.Util.Store_popup;
import com.grp12.softskilltools.resources.ItemDefinition;
import com.squareup.haha.perflib.Main;

import java.util.ArrayList;
import java.util.Arrays;

import static com.grp12.softskilltools.Fragment.SafeFragment.sSafeFragment;


/**
 * Created by mathiaslarsen on 16/11/2016.
 */

public class StoreFragment extends Fragment implements View.OnClickListener {

    DatabaseReference mRootDataRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionDataRef;
    AbstractItem tempItem;

    public StoreFragment() {

    }

    private AbstractItem[] items;
    private final int Store_items = 3;
    View myView;
    public ListView lv;
    public Button ACTION;
    private static StoreFragment sStoreFragment;
    @Override

    /***************************************************
     * This method initializes all the screen elements *
     ***************************************************/

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_store, container, false);
        initialize();
        ArrayList<AbstractItem> products = getProducts();
        lv = (ListView) myView.findViewById(R.id.list);
        lv.setAdapter(new StoreAdaptor(getContext(), products));
        sStoreFragment = this;
        ACTION = (Button) myView.findViewById(R.id.button26);
        ACTION.setOnClickListener(this);

        if (sSafeFragment.tests.isEmpty()==false){
            ACTION.setVisibility(View.VISIBLE);
        }
        return myView;
    }



    /*************************************************
     * This method adds a bought test to the profile *
     *************************************************/

    public void addToBasket(AbstractItem item, int qty, User user) {
        item.setOwner(user.getFullName());
        user.addToSafe(item, qty);
        MainMenu.getInstance().runUpdate();
        Toast.makeText(getContext(), "Du ejer nu "+item.getProductName(), Toast.LENGTH_SHORT).show();
        if (user.getSafe().getSafeSize()==1){
            AnimationUtil.popOut(ACTION,300);

        }

    }





    /*****************************
     * This method gets the user *
     *****************************/

    public User getUser() {

        return MainMenu.getInstance().getUser();

    }
    public void setTempItem(AbstractItem item){
        this.tempItem = item;
    }
    public AbstractItem getTempItem(){
        return tempItem;
    }

    /**********************************************
     * This method begins the logic of this class *
     **********************************************/

    public void initialize() {

        items = new AbstractItem[Store_items];

        for (int i = 0; i < Store_items; i++) {
            switch (ItemDefinition.testType[i]) {

                case DISC:
                    items[i] = new DISC(ItemDefinition.TESTPrice_DATA[i],false,ItemDefinition.TESTName_DATA[i],ItemDefinition.TESTDescription_DATA[i], ItemDefinition.testType[i]);
                    break;

                case BELBIN:
                    items[i] = new BELBIN(ItemDefinition.TESTPrice_DATA[i],false, ItemDefinition.TESTName_DATA[i],ItemDefinition.TESTDescription_DATA[i],ItemDefinition.testType[i]);
                    break;

                case THREESIXTY:
                    items[i] = new THREESIXTY(ItemDefinition.TESTPrice_DATA[i],false, ItemDefinition.TESTName_DATA[i],ItemDefinition.TESTDescription_DATA[i],ItemDefinition.testType[i]);
                    break;
            }
        }


    }

    /***************************************************
     * This method makes a reference to another object *
     ***************************************************/

    public static StoreFragment getInstance() {

        return sStoreFragment;
    }

    /*********************************
     * This method gets the products *
     *********************************/

    public ArrayList<AbstractItem> getProducts() {

        ArrayList<AbstractItem> products = new ArrayList<>(Arrays.asList(items));
        return products;
    }

    /*****************************
     * This method gets the Disc *
     *****************************/

    public DISC getDisc(){

        return (DISC)items[0];
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button26){
            SafeFragment nextFrag= new SafeFragment();
            this.getFragmentManager().beginTransaction()
                    .replace(R.id.article_fragment, nextFrag,null)
                    .addToBackStack(null)
                    .commit();
            MainMenu.getInstance().mToolbar.setTitle("Dine Profiler");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /**********************************************************************
     * This method makes sure the pop up actually pops up when clicked on *
     **********************************************************************/

    public void openPopUp(AbstractItem item) {
        Intent i = new Intent(this.getContext(), PopUp.class);
        i.putExtra("brødtekst",item.getDescription());
        i.putExtra("overskrift",item.getProductName());
        startActivity(i);
    }

    /*******************************************************************************
     * This method makes sure the pop up for acceptance of a deal actually pops up *
     *******************************************************************************/

    public void openAcceptPopUp(){
        Intent i = new Intent(this.getContext(),Store_popup.class);
        startActivity(i);
    }
}
