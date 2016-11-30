package com.grp12.softskilltools.Fragment;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v7.widget.Toolbar;

import com.galgespil.stvhendeop.menuapp.R;


/**
 * Created by mathiaslarsen on 07/11/2016.
 */
public class PrefFragment extends PreferenceActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();




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

    }
