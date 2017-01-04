package com.grp12.softskilltools.Fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ExpandableListView;

import com.grp12.softskilltools.Entities.BELBIN;

/**
 * Created by Mathias R. Larsen on 03-01-2017.
 */

public class BELBINFragment extends Fragment implements View.OnClickListener {



        BELBIN test;
        ExpandableListView exView;
        boolean finished = false;

    public BELBINFragment(){

        test = (BELBIN)SafeFragment.getInstance().getTempItem();

    }







    @Override
    public void onClick(View v) {

    }
}

