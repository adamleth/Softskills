package com.grp12.softskilltools.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.User;
import com.squareup.haha.perflib.Main;

/**
 * Created by mathiaslarsen on 11/01/2017.
 */

public class SecondFragment extends Fragment implements View.OnClickListener {

    CheckBox administrativ,inverter,notifikationer;
    User user;
    Button gem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.viewpager_2, container, false);

        administrativ = (CheckBox) v.findViewById(R.id.checkbox_administrativ);
        inverter = (CheckBox) v.findViewById(R.id.checkbox_inverter);
        notifikationer = (CheckBox) v.findViewById(R.id.checkbox_notifikationer);
        user = MainMenu.getInstance().getUser();
        gem = (Button) v.findViewById(R.id.button21);
        gem.setOnClickListener(this);
        administrativ.setOnClickListener(this);
        inverter.setOnClickListener(this);
        notifikationer.setOnClickListener(this);

        checkAdministrativ();
        checkInverter();
        checkNotifikationer();


        return v;
    }








    /*************************************************************************************
     * This method checks for whether the administrative environment is activated or nah *
     *************************************************************************************/

    public void checkAdministrativ(){
        if (user.getAdministrativ() == false){
            administrativ.setChecked(true);
        }
        else if(user.getAdministrativ() == true){
            administrativ.setChecked(false);
        }
    }

    public void checkInverter(){
        if (user.getInverter() == true){
            inverter.setChecked(true);
        }
        else if(user.getInverter() == false){
            inverter.setChecked(false);
        }
    }

    /****************************************
     * This method checks for notifications *
     ****************************************/

    public void checkNotifikationer(){
        if (user.getNotifikationer() == true){
            notifikationer.setChecked(true);
        }
        else if(user.getNotifikationer() == false){
            notifikationer.setChecked(false);
        }
    }

    public static SecondFragment newInstance(User user) {

        SecondFragment f = new SecondFragment();
        Bundle b = new Bundle();

        f.setArguments(b);

        return f;
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button21:
                MainMenu.getInstance().updateUser1();
                break;
            case R.id.checkbox_administrativ:
                if (administrativ.isChecked() == true){
                    user.setAdministrativ(true);
                    MainMenu.getInstance().ChangeMenu(true);
                    MainMenu.getInstance().updateUser1();
                }
                if(administrativ.isChecked() == false){
                    user.setAdministrativ(false);
                    MainMenu.getInstance().ChangeMenu(false);
                    MainMenu.getInstance().updateUser1();
                }
                break;
        }


    }
}
