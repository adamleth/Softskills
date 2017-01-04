package com.grp12.softskilltools.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.galgespil.stvhendeop.menuapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.grp12.softskilltools.Entities.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mathiaslarsen on 13/11/2016.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText forNavn;
    private EditText efterNavn;
    private EditText email;
    private EditText kodeord;
    private EditText telefon;
    Button knap;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "EmailPassword";
    private FirebaseUser mUser;
    DatabaseReference mRootDataRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionDataRef = mRootDataRef.child("users");
    Map<String, String> userData = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_register);


        email = (EditText) findViewById(R.id.editText3);
        kodeord = (EditText) findViewById(R.id.editText4);
        forNavn = (EditText) findViewById(R.id.editText2);
        efterNavn = (EditText) findViewById(R.id.editText);
        telefon = (EditText) findViewById(R.id.editText6);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        knap = (Button) findViewById(R.id.button);
        knap.setOnClickListener(this);

    }

    private void createAccount(String eMail, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }

        mAuth.createUserWithEmailAndPassword(eMail, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        User user = new User(forNavn.getText().toString(),efterNavn.getText().toString(),email.getText().toString(),telefon.getText().toString());
                        System.out.println(user.getName());
                        mConditionDataRef = mRootDataRef.child("Brugere").child(email.getText().toString().replace('.',';'));
                        mConditionDataRef.setValue(user);
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        knap.setText("Konto oprettet!");

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Fejl",
                                    Toast.LENGTH_SHORT).show();
                            knap.setText("Der skete en fejl");


                        }


                    }
                });
    }


    private boolean validateForm() {
        boolean valid = true;

        String email1 = email.getText().toString();
        if (TextUtils.isEmpty(email1)) {
            email.setError("Required.");
            valid = false;
        } else {
            email.setError(null);
        }

        String password = kodeord.getText().toString();
        if (TextUtils.isEmpty(password)) {
            kodeord.setError("Required.");
            valid = false;
        } else {
            kodeord.setError(null);
        }

        return valid;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.button) {
            createAccount(email.getText().toString(), kodeord.getText().toString());
        }

    }
}


