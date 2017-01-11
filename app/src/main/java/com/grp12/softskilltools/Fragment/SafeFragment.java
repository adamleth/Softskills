package com.grp12.softskilltools.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.AbstractItem;
import com.grp12.softskilltools.Util.PopUp;
import com.grp12.softskilltools.Util.TestProgressAdaptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathiaslarsen on 14/11/2016.
 */

public class SafeFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    public List<AbstractItem> tests;
    public GridView grid;
    Button vejledning, hjælp;
    TextView ingenProfiler,hjælp2;
    protected static SafeFragment sSafeFragment;
    public AbstractItem tempItem;
    public int position;
    View myView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_active_tests, container, false);
        grid = (GridView) myView.findViewById(R.id.GridView);
        hjælp = (Button) myView.findViewById(R.id.button53);
        hjælp2 = (TextView) myView.findViewById(R.id.textView20);
        vejledning = (Button) myView.findViewById(R.id.button6);
        vejledning.setOnClickListener(this);
        ingenProfiler = (TextView) myView.findViewById(R.id.textView8);
        initialize();
        grid.setAdapter(new TestProgressAdaptor(getContext(),tests));
        grid.setOnItemClickListener(this);

        sSafeFragment = this;
        return myView;

    }

    public void initialize() {
        tests = new ArrayList<>();
        tests = MainMenu.getInstance().getUser().retrieveSafeObjects();
        if (tests.isEmpty()==true){
            hjælp.setVisibility(View.VISIBLE);
            ingenProfiler.setVisibility(View.VISIBLE);
            hjælp.setOnClickListener(this);
            hjælp2.setVisibility(View.VISIBLE);
        }
    }
    public void dataChanged(){
       //Her skal viewet refreshes efter der er blevet hentet data.
    }

    public void startTest(AbstractItem item, int position){
        this.position = position;
        switch (item.getTestType()) {
            case DISC:
                DISCFragment nextFrag= new DISCFragment();
                this.getFragmentManager().beginTransaction()
                        .replace(R.id.article_fragment, nextFrag,null)
                        .addToBackStack(null)
                        .commit();
                        MainMenu.getInstance().mToolbar.setTitle("DISC PROFIL");
                break;
            case BELBIN:
                BELBINFragment belbinFrag= new BELBINFragment();
                this.getFragmentManager().beginTransaction()
                        .replace(R.id.article_fragment, belbinFrag,null)
                        .addToBackStack(null)
                        .commit();
                        MainMenu.getInstance().mToolbar.setTitle("BELBIN PROFIL");
                break;
            case THREESIXTY:
                break;
        }
    }
    public AbstractItem getTempItem(){return tempItem;}
    public static SafeFragment getInstance() {
        return sSafeFragment;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(position);
        tempItem = tests.get(position);
        startTest(tempItem, position);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button53:
                StoreFragment nextFrag= new StoreFragment();
                this.getFragmentManager().beginTransaction()
                        .replace(R.id.article_fragment, nextFrag,null)
                        .addToBackStack(null)
                        .commit();
                MainMenu.getInstance().mToolbar.setTitle("Butik");
                break;
            case R.id.button6:
                startActivity(new Intent(this.getContext(), PopUp.class));
                break;
        }
    }
}
