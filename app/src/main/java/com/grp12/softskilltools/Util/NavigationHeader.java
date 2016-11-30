package com.grp12.softskilltools.Util;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;

/**
 * Created by mathiaslarsen on 15/11/2016.
 */

public class NavigationHeader extends AppCompatActivity implements View.OnClickListener {

    private ImageView user;
    private TextView userName,userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_header1);
        user = (ImageView)findViewById(R.id.imageView2);
        userName = (TextView)findViewById(R.id.NavHeaderName);
        userEmail = (TextView)findViewById(R.id.NavHeaderEmail);
    }


    @Override
    public void onClick(View v) {
        if (v == user){

        }


    }
}
