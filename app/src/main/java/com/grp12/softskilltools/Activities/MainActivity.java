package com.grp12.softskilltools.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.galgespil.stvhendeop.menuapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.grp12.softskilltools.Util.AnimationUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button login, register;
    ImageView logo;
    TextView welcome;
    TextView weCanHelp;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "EmailPassword";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_login);

        welcome = (TextView) findViewById(R.id.textView10);
        weCanHelp = (TextView) findViewById(R.id.textView20);
        login = (Button) findViewById(R.id.button3);
        register = (Button) findViewById(R.id.button2);
        logo = (ImageView) findViewById(R.id.imageView4);


        login.setOnClickListener(this);
        register.setOnClickListener(this);


        AnimationUtil.popOut(logo,700);
        AnimationUtil.popOut(welcome,400);
        AnimationUtil.popOut(weCanHelp, 400);
        AnimationUtil.enterLeft(login,300);
        AnimationUtil.enterRight(register,300);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    System.out.println("BrugerUID "+user.getUid());

                    Intent i = new Intent(MainActivity.this, MainMenu.class);
                    i.putExtra("UserEmail",user.getEmail());


                    startActivity(i);
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    // [START on_start_add_listener]
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    // [END on_start_add_listener]

    // [START on_stop_remove_listener]
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }





    @Override
    public void onClick(View v) {

        if (v == login){
            Intent i = new Intent(MainActivity.this, LoginPromptActivity.class);

            startActivity(i);
        }
        else if (v == register){
            //Intent i = new Intent(MainActivity.this,RegisterActivity.class);
            //startActivity(i);
            Toast toast = Toast.makeText(this,"Deaktiveret - Ikke understøttet af javabog.",Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
