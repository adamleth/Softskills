package com.grp12.softskilltools.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.grp12.softskilltools.Entities.DISC;
import com.grp12.softskilltools.Entities.User;
import com.grp12.softskilltools.Fragment.DISCFragment;
import com.grp12.softskilltools.Fragment.DISCResultFragment;
import com.grp12.softskilltools.Fragment.SafeFragment;
import com.grp12.softskilltools.Fragment.InviteFragment;
import com.grp12.softskilltools.Fragment.RemindFragment;
import com.grp12.softskilltools.Fragment.ResultListFragment;
import com.grp12.softskilltools.Fragment.StoreFragment;
import com.grp12.softskilltools.Fragment.PrefFragment;

/**
 * Created by mathiaslarsen on 13/11/2016.
 */

public class MainMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    private NavigationView navView;
    private FragmentManager fragmentManager;
    private ImageView Iuser;
    private FirebaseAuth mAuth;
    private User user;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "EmailPassword";
    private static MainMenu sMainMenu;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sMainMenu = this;
        this.user = null;

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        View hView =  navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.NavHeaderName);
        TextView nav_email = (TextView)hView.findViewById(R.id.NavHeaderEmail);
        Intent PromptIntent = getIntent();
        String email = PromptIntent.getStringExtra("UserEmail");
        createUser(email);
        nav_user.setText("Testbruger");
        nav_email.setText(user.getEmail());


        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        navView = (NavigationView) findViewById(R.id.navigation);
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



    mAuthListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                // User is signed in
                Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
            } else {
                // User is signed out
                Log.d(TAG, "onAuthStateChanged:signed_out");
            }
        }
    };

}
    public void createUser(String email){
        this.user = new User("Test","Bruger",email,"Phone" );
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
                mToolbar.setTitle("Udfyld profil");
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
                Intent i = new Intent(this, PrefFragment.class);
                startActivity(i);
                break;
            case R.id.navigation_store:
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new StoreFragment())
                        .commit();
                mToolbar.setTitle("Butik");

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

    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}



