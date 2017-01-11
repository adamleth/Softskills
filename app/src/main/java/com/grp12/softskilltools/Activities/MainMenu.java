package com.grp12.softskilltools.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.galgespil.stvhendeop.menuapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.grp12.softskilltools.Entities.User;
import com.grp12.softskilltools.Fragment.SafeFragment;
import com.grp12.softskilltools.Fragment.InviteFragment;
import com.grp12.softskilltools.Fragment.RemindFragment;
import com.grp12.softskilltools.Fragment.ResultListFragment;
import com.grp12.softskilltools.Fragment.StoreFragment;
import com.grp12.softskilltools.Fragment.PrefFragment;

import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.IllegalFormatFlagsException;
import java.util.IllegalFormatWidthException;
import java.util.Map;

/**
 * Created by mathiaslarsen on 13/11/2016.
 */

public class MainMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    public Toolbar mToolbar;
    private NavigationView navView;
    private FragmentManager fragmentManager;
    private ImageView Iuser;
    private FirebaseAuth mAuth;
    private User user;
    Map <String, String> info = new HashMap<>();
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "EmailPassword";
    private static MainMenu sMainMenu;
    DatabaseReference mRootDataRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionDataRef;
    private Boolean refreshed;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sMainMenu = this;
        this.user = null;
        this.refreshed = false;

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    System.out.println("BrugerUID "+user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        View hView =  navigationView.getHeaderView(0);
        final TextView nav_user = (TextView)hView.findViewById(R.id.NavHeaderName);
        final TextView nav_email = (TextView)hView.findViewById(R.id.NavHeaderEmail);
        Intent PromptIntent = getIntent();
        final String email = PromptIntent.getStringExtra("UserEmail");
        createUser(email,info.get("Name"),info.get("lastName"),info.get("phone"));
        DatabaseReference mConditionRef = mRootDataRef.child("Brugere").child(email.replaceAll("[\\.:;&@]","_"));
        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User newUser = dataSnapshot.getValue(User.class);

                Log.d("Data",  "val="+newUser);

                user = newUser;
                System.out.println("Indeni "+user.getName());
                nav_user.setText(newUser.getName()+" "+ newUser.getSurName());
                nav_email.setText(newUser.getEmail());
                SafeFragment.getInstance().dataChanged();




            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        navView = (NavigationView) findViewById(R.id.navigation);
        Menu menu = navView.getMenu();
        MenuItem titel1 = menu.findItem(R.id.grp1);
        MenuItem titel2 = menu.findItem(R.id.grp2);
        SpannableString s1 = new SpannableString(titel1.getTitle());
        SpannableString s2 = new SpannableString(titel2.getTitle());
        s1.setSpan(new TextAppearanceSpan(this,R.style.TextAppearance),0,s1.length(),0);
        s2.setSpan(new TextAppearanceSpan(this,R.style.TextAppearance),0,s2.length(),0);
        titel1.setTitle(s1);
        titel2.setTitle(s2);
        navView.setNavigationItemSelectedListener(this);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.article_fragment
                            , new SafeFragment())
                    .commit();
            mToolbar.setTitle("Aktive tests");
         }

    mAuth = FirebaseAuth.getInstance();



}

    private void refreshView() {
        fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.article_fragment
                            , new SafeFragment())
                    .commit();
            mToolbar.setTitle("Aktive tests");
       this.refreshed = true;
        }


    public void updateUser(){
        String nøgle = getUser().getEmail().replaceAll("[\\.:;&@]","_");
        Log.d("xxxx", nøgle);
        mConditionDataRef = mRootDataRef.child("Brugere").child(nøgle);
        Log.d("xxxx", mConditionDataRef.toString());
        Log.d("xxxx", ""+getUser());
        mConditionDataRef.setValue(getUser());

    }


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

    public void createUser(String email, String name, String lastName, String phone){
        this.user = new User(name,lastName,email,phone );
    }

    public static MainMenu getInstance() {
        return sMainMenu;
    }
    public User getUser(){
        return user;
    }



    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();



        switch (id){
            case R.id.navigation_remind:
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new RemindFragment())
                        .commit();
                mToolbar.setTitle("Opfølgning");
                break;
            case R.id.navigation_test:
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new SafeFragment())
                        .commit();
                mToolbar.setTitle("Dine profiler");
                break;
            case R.id.navigation_results:
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new ResultListFragment())
                        .commit();
                mToolbar.setTitle("Resultater");
                break;

            case R.id.navigation_invite:
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new InviteFragment())
                        .commit();
                mToolbar.setTitle("Inviter");
                break;

            case R.id.navigation_settings:
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new PrefFragment())
                        .commit();
                mToolbar.setTitle(" ");
                break;

            case R.id.navigation_store:
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new StoreFragment())
                        .commit();
                mToolbar.setTitle("Butik");
                break;

            case R.id.navigation_logout:
                signOut();
                break;




        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public static class MyPreferenceFragment extends PreferenceFragment
    {

        private Toolbar mToolbar;
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);


            addPreferencesFromResource(R.xml.preferences);

        }
    }



        @Override
        public boolean onOptionsItemSelected (MenuItem item){

            if (mToggle.onOptionsItemSelected(item)) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }



    private void signOut() {
        mAuth.signOut();
        Intent i = new Intent(MainMenu.this,MainActivity.class);
        startActivity(i);

    }

}



