package com.grp12.softskilltools.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.galgespil.stvhendeop.menuapp.R;

/**
 * Created by mathiaslarsen on 23/11/2016.
 */

public class LoginPromptActivity extends AppCompatActivity implements View.OnClickListener {


    EditText email;
    EditText kodeord;
    Button login;
    Button forgot;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_prompt);

        email = (EditText) findViewById(R.id.loginemail);
        kodeord = (EditText) findViewById(R.id.loginkode);
        login = (Button) findViewById(R.id.loginknap);
        forgot = (Button) findViewById(R.id.glemtkode);
        login.setOnClickListener(this);
        forgot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == login) {
            Intent i = new Intent(LoginPromptActivity.this, MainMenu.class);
            i.putExtra("UserEmail",email.getText().toString());
            startActivity(i);
        }
    }
}
