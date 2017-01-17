package com.grp12.softskilltools.Util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;


/**
 * Created by Ejer on 16-01-2017.
 */

/*******************************************************************
 * This class handles all of the pop-ups on the BELBIN-result page *
 *******************************************************************/

public class BELBIN_popup extends Activity implements View.OnClickListener {

    TextView belbinPopTitle, belbinPopText;
    Button belbinPopOK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_popup);
        belbinPopTitle = (TextView) findViewById(R.id.popTitle);
        belbinPopText = (TextView) findViewById(R.id.popText);
        belbinPopOK = (Button) findViewById(R.id.popOK);
        belbinPopOK.setOnClickListener(this);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        Intent PromptIntent = getIntent();
        final int antal = PromptIntent.getIntExtra("antal",1);
        final String tempBrødtekst = PromptIntent.getStringExtra("brødtekst");
        final String tempOverskrift = PromptIntent.getStringExtra("overskrift");
        setBelbinTekst(tempBrødtekst, tempOverskrift);
        System.out.println(antal);
        getWindow().setLayout((int) (width * .9), (int) (height * .4));
    }

    public void setBelbinTekst(String overskrift, String brødtekst) {
        belbinPopText.setText(brødtekst);
        belbinPopTitle.setText(overskrift);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == belbinPopOK.getId()) {
            finish();
        }
    }
}

