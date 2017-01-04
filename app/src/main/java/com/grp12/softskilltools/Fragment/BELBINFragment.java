package com.grp12.softskilltools.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ScrollView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Entities.BELBIN;
import com.grp12.softskilltools.Entities.Question;

/**
 * Created by Mathias R. Larsen on 03-01-2017.
 */

public class BELBINFragment extends Fragment implements View.OnClickListener {



        BELBIN test;
        ScrollView exView;
        boolean finished = false;
        Question currentQuestion1,currentQuestion2,currentQuestion3,
                currentQuestion4,currentQuestion5,currentQuestion6,
                currentQuestion7,currentQuestion8,currentQuestion9,currentQuestion10;
        int q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;
        View myView;

    public BELBINFragment(){
        q1 = q2 = q3 = q4 = q5 = q6 = q7 = q8 = q9 = q10 = 0;
        test = (BELBIN)SafeFragment.getInstance().getTempItem();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_belbin_test, container, false);
        exView = (ScrollView) myView.findViewById(R.id.);



        return myView;
    }







    @Override
    public void onClick(View v) {

    }
}

