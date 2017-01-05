package com.grp12.softskilltools.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Util.AnimationUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button login, register;
    ImageView logo;
    TextView welcome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_login);

        welcome = (TextView) findViewById(R.id.textView10);
        login = (Button) findViewById(R.id.button3);
        register = (Button) findViewById(R.id.button2);
        logo = (ImageView) findViewById(R.id.imageView4);


        login.setOnClickListener(this);
        register.setOnClickListener(this);


        AnimationUtil.popOut(logo,700);
        AnimationUtil.popOut(welcome,400);
        AnimationUtil.enterLeft(login,300);
        AnimationUtil.enterRight(register,300);
    }








    @Override
    public void onClick(View v) {

        if (v == login){
            Intent i = new Intent(MainActivity.this, LoginPromptActivity.class);

            startActivity(i);
        }
        else if (v == register){
            Intent i = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(i);
        }
    }
}
