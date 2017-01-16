package com.grp12.softskilltools.Util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.AbstractItem;
import com.squareup.haha.perflib.Main;

import org.w3c.dom.Text;

/**
 * Created by mathiaslarsen on 16/01/2017.
 */

public class Store_popup extends Activity implements View.OnClickListener {

    Button accept, decline, plus, minus;
    TextView text, quantity;
    AbstractItem produkt;
    public int antal;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_popup);
        antal = 1;
        accept = (Button) findViewById(R.id.store_accept);
        decline = (Button) findViewById(R.id.store_decline);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        accept.setOnClickListener(this);
        decline.setOnClickListener(this);
        text = (TextView) findViewById(R.id.store_popup_text);
        quantity = (TextView) findViewById(R.id.store_quantity);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        Intent PromptIntent = getIntent();
        produkt = (AbstractItem)PromptIntent.getSerializableExtra("objekt");
        getWindow().setLayout((int) (width * .9), (int) (height * .60));
        text.setText("Ønsker du at købe " + produkt.getProductName() + "?");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == decline.getId()){
            finish();
        }
        if (v.getId() == accept.getId()){
            MainMenu.getInstance().getUser().addToSafe(produkt,antal);
        }
        if (v.getId() == plus.getId()){
            if (antal <= 10) {
                antal = antal + 1;
            }
        }
        if (v.getId() == minus.getId()){
            if (antal >= 1){
               antal = antal -1;
            }

        }
    }
}
