package com.grp12.softskilltools.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.AbstractItem;
import com.grp12.softskilltools.Entities.Safe;
import com.grp12.softskilltools.Util.TestProgressAdaptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathiaslarsen on 14/11/2016.
 */

public class SafeFragment extends Fragment {

    private List<AbstractItem> tests;
    private GridView grid;
    View myView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_active_tests, container, false);
        grid = (GridView) myView.findViewById(R.id.GridView);
        initialize();
        grid.setAdapter(new TestProgressAdaptor(getContext(),tests));
        return myView;


    }

    public void initialize() {
        tests = new ArrayList<>();
        tests = MainMenu.getInstance().getUser().getSafe();
    }

    public void update(){

    }



}
