package com.grp12.softskilltools.Fragment;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.preference.PreferenceManager;
import android.view.View;

import com.galgespil.stvhendeop.menuapp.R;


/**
 * Created by mathiaslarsen on 07/11/2016.
 */
public class PrefFragment extends FragmentActivity implements View.OnClickListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);


    }


    @Override
    public void onClick(View v) {

    }

    //public void setVisiblity () {

    //}
}

