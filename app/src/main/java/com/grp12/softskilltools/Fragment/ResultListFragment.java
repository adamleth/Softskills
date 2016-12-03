package com.grp12.softskilltools.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.AbstractItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathiaslarsen on 14/11/2016.
 */

public class ResultListFragment extends Fragment{

    private ListView results;
    private List<AbstractItem> testResults;
    View myView;
    public ResultListFragment(){
        initialize();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_resultlist, container, false);

        results = (ListView) myView.findViewById(R.id.Results);
        return myView;
    }

    public void initialize(){
        testResults = MainMenu.getInstance().getUser().getResults();

    }


}
