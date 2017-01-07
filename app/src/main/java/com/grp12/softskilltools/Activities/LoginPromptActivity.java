package com.grp12.softskilltools.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.galgespil.stvhendeop.menuapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by mathiaslarsen on 23/11/2016.
 */

public class LoginPromptActivity extends AppCompatActivity implements View.OnClickListener {


    EditText email;
    EditText kodeord;
    TextView warning;
    Button login;
    Button forgot;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "EmailPassword";

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
        warning = (TextView) findViewById(R.id.textView11);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    System.out.println("BrugerUID "+user.getUid());

                    Intent i = new Intent(LoginPromptActivity.this, MainMenu.class);
                    i.putExtra("UserEmail",user.getEmail());


                    startActivity(i);
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        // ...
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

    public void logInd(final String email, String kodeord) {
        mAuth.signInWithEmailAndPassword(email, kodeord)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());


                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            udskrivFejl(task.getException().getMessage().toString());

                        }

                        // ...
                    }
                });

    }
    public void udskrivFejl(String fejl){
        warning.setText(fejl);
        warning.setVisibility(View.VISIBLE);
    }
    @Override
    public void onClick(View v) {
        if (v == login) {
            if (email.getText().length()==0){
                warning.setText("Du skal skrive en email, før du kan logge ind");
                warning.setVisibility(View.VISIBLE);
            }
            else if (kodeord.getText().length()==0){
                warning.setText("Du skal skrive et kodeord, før du kan logge ind");
                warning.setVisibility(View.VISIBLE);
            }
            else {
                logInd(email.getText().toString(), kodeord.getText().toString());
                warning.setVisibility(View.GONE);
            }
        }
        else if (v == forgot){
            Toast toast = Toast.makeText(this,"Denne funktion er ikke implementeret",Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
