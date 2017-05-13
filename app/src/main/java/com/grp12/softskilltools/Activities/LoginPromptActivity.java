package com.grp12.softskilltools.Activities;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
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
import com.grp12.softskilltools.SOAP.IWsdl2CodeEvents;
import com.grp12.softskilltools.SOAP.ServermanagerService;
import com.grp12.softskilltools.Util.NetworkChangeReciever;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


/**
 * Created by mathiaslarsen on 23/11/2016.
 */

public class LoginPromptActivity extends AppCompatActivity implements View.OnClickListener, IWsdl2CodeEvents {


    EditText email;
    EditText kodeord;
    TextView warning;
    Button login;
    Button forgot;
    NetworkChangeReciever reciever;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "EmailPassword";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_prompt);
        reciever = new NetworkChangeReciever();
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
                    System.out.println("BrugerUID " + user.getUid());

                    Intent i = new Intent(LoginPromptActivity.this, MainMenu.class);
                    i.putExtra("UserEmail", user.getEmail());


                    startActivity(i);
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        if (checkInternetConnection() == false) {
            login.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            login.setClickable(false);
            login.setText("Vi kunne ikke logge dig ind. Tjek din internetforbindelse");
            forgot.setVisibility(View.GONE);
            Toast.makeText(this, "Netværk ikke tilgængeligt", Toast.LENGTH_LONG).show();
            // ...
        }
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
    public void Login(final String email, final String password){
        System.out.println("Start på login");
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                callWeb(email,password);
                System.out.println("WSDL er kaldt");
                Intent i = new Intent(LoginPromptActivity.this, MainMenu.class);
                i.putExtra("UserEmail", email);
                return null;
            }
        }.execute();
        Toast toast = Toast.makeText(this,"Login forsøges",Toast.LENGTH_LONG);
        toast.show();





    }

    public void callWeb(String arg1, String arg2){
        ServermanagerService service = new ServermanagerService();
        service.setUrl("http://ubuntu4.javabog.dk:9959/softskills?WSDL");
        service.login(arg1,arg2);
    }

    public void udskrivFejl(String fejl){
        warning.setText(fejl);
        warning.setVisibility(View.VISIBLE);
    }
    public boolean checkInternetConnection(){

        return reciever.checkInternet(this);
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
                Login(email.getText().toString(), kodeord.getText().toString());
                //logInd(email.getText().toString(), kodeord.getText().toString());
                warning.setVisibility(View.GONE);
            }
        }
        else if (v == forgot){
            Toast toast = Toast.makeText(this,"Denne funktion er ikke implementeret",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    public void Wsdl2CodeStartedRequest() {
        Log.e("Wsdl2Code", "Wsdl2CodeStartedRequest");

    }
    @Override
    public void Wsdl2CodeFinished(String methodName, Object Data) {
        Log.e("Wsdl2Code", "Wsdl2CodeFinished");
        Log.e("Wsdl2Code",methodName);

    }
    @Override
    public void Wsdl2CodeFinishedWithException(Exception ex) {
        Log.e("Wsdl2Code", "Wsdl2CodeFinishedWithException");

    }
    @Override
    public void Wsdl2CodeEndedRequest() {
        Log.e("Wsdl2Code", "Wsdl2CodeEndedRequest");
    }
}
