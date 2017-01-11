package com.grp12.softskilltools.Util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.galgespil.stvhendeop.menuapp.R;

/**
 * Created by Mathias R. Larsen on 07-01-2017.
 */

public class PopUp extends Activity implements View.OnClickListener {

    public Button knap;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        Intent PromptIntent = getIntent();
        final int antal = PromptIntent.getIntExtra("antal",1);
        System.out.println(antal);

        if (antal == 2){
            getWindow().setLayout((int) (width * .9), (int) (height * .55));
            System.out.println("Højden bør være .55");
        }
        else if (antal == 1) {
            getWindow().setLayout((int) (width * .9), (int) (height * .7));
            System.out.println("Højden bør være .7");
        }
        knap = (Button) findViewById(R.id.button21);
        knap.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == knap.getId()){
            finish();
        }
    }
}
