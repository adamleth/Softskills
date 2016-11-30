package com.grp12.softskilltools.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class SafeFragment extends Fragment implements AdapterView.OnItemClickListener {

    private List<AbstractItem> tests;
    public GridView grid;
    private static SafeFragment sSafeFragment;
    View myView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_active_tests, container, false);
        grid = (GridView) myView.findViewById(R.id.GridView);
        initialize();
        grid.setAdapter(new TestProgressAdaptor(getContext(),tests));
        grid.setOnItemClickListener(this);
        sSafeFragment = this;
        return myView;

    }

    public void initialize() {
        tests = new ArrayList<>();
        tests = MainMenu.getInstance().getUser().getSafe();
    }

    public void startTest(AbstractItem test){
        switch (test.getTestType()) {
            case DISC:
                break;
            case BELBIN:
                break;
            case THREESIXTY:
                break;
        }
    }

    public static SafeFragment getInstance() {
        return sSafeFragment;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AbstractItem item = tests.get(position);
        System.out.println(position);
    }
}
