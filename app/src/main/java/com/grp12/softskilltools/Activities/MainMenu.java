package com.grp12.softskilltools.Activities;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.AsyncTask;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
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
import android.widget.Toast;

import com.cleveroad.slidingtutorial.Direction;
import com.cleveroad.slidingtutorial.IndicatorOptions;
import com.cleveroad.slidingtutorial.PageOptions;
import com.cleveroad.slidingtutorial.TransformItem;
import com.cleveroad.slidingtutorial.TutorialFragment;
import com.cleveroad.slidingtutorial.TutorialOptions;
import com.cleveroad.slidingtutorial.TutorialPageOptionsProvider;
import com.galgespil.stvhendeop.menuapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.grp12.softskilltools.Entities.User;
import com.grp12.softskilltools.Fragment.SafeFragment;
import com.grp12.softskilltools.Fragment.InviteFragment;
import com.grp12.softskilltools.Fragment.RemindFragment;
import com.grp12.softskilltools.Fragment.ResultListFragment;
import com.grp12.softskilltools.Fragment.StoreFragment;
import com.grp12.softskilltools.Fragment.PrefFragment;

import java.util.HashMap;
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
    public DatabaseReference mRootDataRef = FirebaseDatabase.getInstance().getReference();
    public DatabaseReference mConditionDataRef;
    private static final int TOTAL_PAGES = 4;
    private static final int ACTUAL_PAGES_COUNT = 4;
    public int[] mPagesColors;
    TextView nav_user;
    TextView nav_email;
    public MenuItem titel1, titel2;
    public Menu menu;
    public boolean ButtonPressed;
    public String email;




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sMainMenu = this;
        this.user = null;
        this.ButtonPressed = false;

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    System.out.println("BrugerUID " + user.getUid());

                } else {
                    // User is signed out

                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };


        Intent PromptIntent = getIntent();
        email = PromptIntent.getStringExtra("UserEmail");
        createUser(email, info.get("Name"), info.get("lastName"), info.get("phone"));



        DatabaseReference mConditionRef = mRootDataRef.child("Brugere").child(email.replaceAll("[\\.:;&@]", "_"));
        mConditionRef.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User newUser = dataSnapshot.getValue(User.class);

                Log.d("Data", "val=" + newUser);

                user = newUser;

                if (newUser.getFirstRun() == false) {
                    initialize(2);
                    System.out.println("Indeni " + newUser.getName());
                    nav_user.setText(newUser.getName() + " " + newUser.getSurName());
                    nav_email.setText(newUser.getEmail());
                    if (savedInstanceState != null)
                    SafeFragment.getInstance().Update();
                    else {
                        databaseCall(newUser.getEmail());
                    }

                }
                else if(newUser.getFirstRun() == true){
                    initialize(1);
                    System.out.println("Indeni " + newUser.getName());

                }



            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    /*********************************************
     * This method gets a user from the database *
     *********************************************/

    public void databaseCall(String email){
        DatabaseReference mConditionRef = mRootDataRef.child("Brugere").child(email.replaceAll("[\\.:;&@]", "_"));
        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User newUser = dataSnapshot.getValue(User.class);

                Log.d("Data", "val=" + newUser);
                user = newUser;

                if (newUser.getFirstRun() == false) {
                    System.out.println("Indeni " + newUser.getName());
                    nav_user.setText(newUser.getName() + " " + newUser.getSurName());
                    nav_email.setText(newUser.getEmail());
                    if(ButtonPressed != true) {
                        SafeFragment.getInstance().Update();
                    }
                    loadMenu(user.getAdministrativ());

                }

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /******************************************************************
     * This method initializes the menu which works as the controller *
     ******************************************************************/

    public void initialize(int i) {


        fragmentManager = getSupportFragmentManager();
        if (i == 1) {

            mPagesColors = new int[]{
                    ContextCompat.getColor(this, R.color.colorPrimary),
                    ContextCompat.getColor(this, R.color.colorPrimary),
                    ContextCompat.getColor(this, R.color.colorPrimary),
                    ContextCompat.getColor(this, R.color.colorPrimary),
                    ContextCompat.getColor(this, R.color.colorPrimary),
                    ContextCompat.getColor(this, R.color.colorPrimary),

            };
            Intent PromptIntent = getIntent();

            createUser(email, info.get("Name"), info.get("lastName"), info.get("phone"));
            databaseCall(user.getEmail());


            replaceTutorialFragment();

        } else if (i == 2) {

            NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
            View hView = navigationView.getHeaderView(0);
            nav_user = (TextView) hView.findViewById(R.id.NavHeaderName);
            nav_email = (TextView) hView.findViewById(R.id.NavHeaderEmail);
            Intent PromptIntent = getIntent();
            createUser(email, info.get("Name"), info.get("lastName"), info.get("phone"));






            databaseCall(user.getEmail());
            mToolbar = (Toolbar) findViewById(R.id.nav_action);
            setSupportActionBar(mToolbar);

            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
            mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

            mDrawerLayout.addDrawerListener(mToggle);
            mToggle.syncState();

            navView = (NavigationView) findViewById(R.id.navigation);



            navView.setNavigationItemSelectedListener(this);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            fragmentManager.beginTransaction()
                    .replace(R.id.article_fragment
                            , new SafeFragment())
                    .commit();
            mToolbar.setTitle("Dine profiler");



        }
    }

    /*****************************************************************************************
     * This method loads the menu depending on whether you are a normal user or a consultant *
     *****************************************************************************************/

    public void loadMenu(Boolean administrativ) {
        menu = navView.getMenu();
        titel1 = menu.findItem(R.id.grp1);
        titel2 = menu.findItem(R.id.gruppe2);
        if (administrativ == false) {
            ChangeMenu(false);
            SpannableString s1 = new SpannableString(titel1.getTitle());
            s1.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance), 0, s1.length(), 0);
            titel1.setTitle(s1);
        } else if (administrativ == true) {
            ChangeMenu(true);
            SpannableString s1 = new SpannableString(titel1.getTitle());
            SpannableString s2 = new SpannableString(titel2.getTitle());
            s1.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance), 0, s1.length(), 0);
            s2.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance), 0, s2.length(), 0);
            titel1.setTitle(s1);
            titel2.setTitle(s2);
        }
    }

    public void runUpdate(){
        new updateUser().execute();
    }



    /********************************************
     * This method updates the user information *
     ********************************************/

    public class updateUser extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {

            try{
                String nøgle = getUser().getEmail().replaceAll("[\\.:;&@]","_");
                Log.d("xxxx", nøgle);
                mConditionDataRef = mRootDataRef.child("Brugere").child(nøgle);
                Log.d("xxxx", mConditionDataRef.toString());
                Log.d("xxxx", ""+getUser());
                mConditionDataRef.setValue(getUser());
                return "Brugeren blev opdateret korrekt";
            }
            catch (Exception e){
                e.printStackTrace();
                return "Der skete en fejl" + e;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (!user.getFirstRun()) {
                SafeFragment.getInstance().Update();
            }
        }


    }




    /*****************************************************************
     * This method updates the user information without an AsyncTask *
     *****************************************************************/

    public void updateUser1(){
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

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    /********************************
     * This method creates the user *
     ********************************/

    public void createUser(String email, String name, String lastName, String phone){
        this.user = new User(name,lastName,email,phone );
    }


    /****************************************************
     * This method returns an instance of the main menu *
     ****************************************************/

    public static MainMenu getInstance() {
        return sMainMenu;
    }
    public User getUser(){
        return user;
    }


    /********************************************
     * This method handles onClick for the menu *
     ********************************************/

    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();



        switch (id){
            case R.id.navigation_remind:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new RemindFragment())
                        .commit();
                mToolbar.setTitle("Opfølgning");
                break;
            case R.id.navigation_test:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new SafeFragment())
                        .commit();
                mToolbar.setTitle("Dine profiler");
                break;
            case R.id.navigation_results:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new ResultListFragment())
                        .commit();
                mToolbar.setTitle("Resultater");
                break;

            case R.id.navigation_invite:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new InviteFragment())
                        .commit();
                mToolbar.setTitle("Inviter");
                break;

            case R.id.navigation_settings:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                fragmentManager.beginTransaction()
                        .replace(R.id.article_fragment
                                , new PrefFragment())
                        .commit();
                mToolbar.setTitle(" ");
                break;

            case R.id.navigation_store:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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


    /*******************************************************************
     * This method shows the tutorial IF the user is a firstTimeRunner *
     *******************************************************************/

    public void replaceTutorialFragment() {
        final IndicatorOptions indicatorOptions = IndicatorOptions.newBuilder(this)
                .build();
        final TutorialOptions tutorialOptions = TutorialFragment.newTutorialOptionsBuilder(this)
                .setUseAutoRemoveTutorialFragment(true)
                .setUseInfiniteScroll(true)
                .setPagesColors(mPagesColors)
                .setPagesCount(TOTAL_PAGES)
                .setIndicatorOptions(indicatorOptions)
                .setTutorialPageProvider(new TutorialPagesProvider())
                .setOnSkipClickListener(new OnSkipClickListener(this))
                .build();

        final TutorialFragment tutorialFragment = TutorialFragment.newInstance(tutorialOptions);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.article_fragment, tutorialFragment)
                .commit();
    }

    public void setScreenRotaionLock(int i){
        switch (i){
            case 1:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
            case 2:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                break;
        }
    }


    /************************************************************
     * This method creates the different pages for the tutorial *
     ************************************************************/

    private static final class TutorialPagesProvider implements TutorialPageOptionsProvider {

        @NonNull
        @Override
        public PageOptions provide(int position) {
            @LayoutRes int pageLayoutResId;
            TransformItem[] tutorialItems;
            position %= ACTUAL_PAGES_COUNT;
            switch (position) {
                case 0: {
                    pageLayoutResId = R.layout.fragment_page_first;
                    tutorialItems = new TransformItem[]{
                            TransformItem.create(R.id.ivFirstImage, Direction.LEFT_TO_RIGHT, 0.20f),
                            TransformItem.create(R.id.ivSecondImage, Direction.RIGHT_TO_LEFT, 0.06f),
                            TransformItem.create(R.id.ivThirdImage, Direction.LEFT_TO_RIGHT, 0.08f),
                            TransformItem.create(R.id.ivFourthImage, Direction.RIGHT_TO_LEFT, 0.1f),
                            TransformItem.create(R.id.ivFifthImage, Direction.RIGHT_TO_LEFT, 0.03f),
                            TransformItem.create(R.id.ivSixthImage, Direction.RIGHT_TO_LEFT, 0.09f),
                            TransformItem.create(R.id.ivSeventhImage, Direction.RIGHT_TO_LEFT, 0.14f),
                            TransformItem.create(R.id.ivEighthImage, Direction.RIGHT_TO_LEFT, 0.07f)
                    };
                    break;
                }
                case 2: {
                    pageLayoutResId = R.layout.fragment_page_third;
                    tutorialItems = new TransformItem[]{
                            TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.20f),
                            TransformItem.create(R.id.ivSecondImage, Direction.LEFT_TO_RIGHT, 0.06f),
                            TransformItem.create(R.id.ivThirdImage, Direction.RIGHT_TO_LEFT, 0.08f),
                            TransformItem.create(R.id.ivFifthImage, Direction.LEFT_TO_RIGHT, 0.03f),
                            TransformItem.create(R.id.ivSixthImage, Direction.LEFT_TO_RIGHT, 0.09f),
                            TransformItem.create(R.id.ivSeventhImage, Direction.LEFT_TO_RIGHT, 0.14f)
                    };
                    break;
                }
                case 1: {
                    pageLayoutResId = R.layout.fragment_page_second;
                    tutorialItems = new TransformItem[]{
                            TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f),
                            TransformItem.create(R.id.ivSecondImage, Direction.LEFT_TO_RIGHT, 0.06f),
                            TransformItem.create(R.id.ivThirdImage, Direction.RIGHT_TO_LEFT, 0.08f),
                            TransformItem.create(R.id.ivFourthImage, Direction.LEFT_TO_RIGHT, 0.1f),
                            TransformItem.create(R.id.ivFifthImage, Direction.LEFT_TO_RIGHT, 0.03f),
                            TransformItem.create(R.id.ivSixthImage, Direction.LEFT_TO_RIGHT, 0.09f),
                            TransformItem.create(R.id.ivSeventhImage, Direction.LEFT_TO_RIGHT, 0.14f),
                            TransformItem.create(R.id.ivEighthImage, Direction.LEFT_TO_RIGHT, 0.07f)
                    };
                    break;
                }
                case 3: {
                    pageLayoutResId = R.layout.fragment_page_fourth;
                    tutorialItems = new TransformItem[]{
                            TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f),
                            TransformItem.create(R.id.ivThirdImage, Direction.RIGHT_TO_LEFT, 0.08f),
                            TransformItem.create(R.id.ivFourthImage, Direction.LEFT_TO_RIGHT, 0.1f),
                            TransformItem.create(R.id.ivEighthImage, Direction.LEFT_TO_RIGHT, 0.07f)
                    };
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unknown position: " + position);
                }
            }

            return PageOptions.create(pageLayoutResId, position, tutorialItems);
        }
    }



    /*******************************************************
     * This method handles the skip button in the tutorial *
     *******************************************************/

    private final class OnSkipClickListener implements View.OnClickListener {

        @NonNull
        private final Context mContext;

        OnSkipClickListener(@NonNull Context context) {
            mContext = context.getApplicationContext();
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, "Skip button clicked", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            user.setFirstRun(false);
            ButtonPressed = true;
            updateUser1();
            initialize(2);

        }
    }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){

            if (mToggle.onOptionsItemSelected(item)) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }


    /********************************************************************************************************
     * This method handles the change in the menu if a user wants to turn on the administrative environment *
     ********************************************************************************************************/

    public void ChangeMenu(Boolean administrativ){
        if (administrativ == true) {
            navView.getMenu().setGroupVisible(R.id.grp2, administrativ);
            SpannableString s2 = new SpannableString(titel2.getTitle());
            s2.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance), 0, s2.length(), 0);
            titel2.setTitle(s2);
        }
        else {
            navView.getMenu().setGroupVisible(R.id.grp2, administrativ);
        }
    }




    /*********************************************
     * This method handles the sign out function *
     *********************************************/

    private void signOut() {
        mAuth.signOut();
        Intent i = new Intent(MainMenu.this,MainActivity.class);
        startActivity(i);

    }

}



