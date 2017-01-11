package com.grp12.softskilltools.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Activities.LoginPromptActivity;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.AbstractItem;
import com.grp12.softskilltools.Util.AnimationUtil;
import com.grp12.softskilltools.Util.PopUp;
import com.grp12.softskilltools.Util.TestProgressAdaptor;

import java.util.ArrayList;
import java.util.List;

import io.codetail.animation.ViewAnimationUtils;

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
    public int antal;
    public LinearLayout root;
    View myView;
    Boolean animated;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_active_tests, container, false);
        tests = new ArrayList<>();
        root = (LinearLayout) myView.findViewById(R.id.rodSafe);
        grid = (GridView) myView.findViewById(R.id.GridView);
        hjælp = (Button) myView.findViewById(R.id.button53);
        hjælp2 = (TextView) myView.findViewById(R.id.textView20);
        vejledning = (Button) myView.findViewById(R.id.button6);
        vejledning.setOnClickListener(this);
        ingenProfiler = (TextView) myView.findViewById(R.id.textView8);
        grid.setAdapter(new TestProgressAdaptor(getContext(),tests));
        grid.setOnItemClickListener(this);
        sSafeFragment = this;
        return myView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animated = false;
    }

    public void initialize() {

        tests = MainMenu.getInstance().getUser().retrieveSafeObjects();
        if (tests.isEmpty() == true) {
            hjælp.setVisibility(View.VISIBLE);
            ingenProfiler.setVisibility(View.VISIBLE);
            hjælp.setOnClickListener(this);
            hjælp2.setVisibility(View.VISIBLE);
            antal = 2;
        } else if (tests.isEmpty() == false) {
            antal = 1;
            hjælp.setVisibility(View.GONE);
            ingenProfiler.setVisibility(View.GONE);
            hjælp2.setVisibility(View.GONE);
            grid.setVisibility(View.VISIBLE);
        }
    }

    public void updateView(){
        tests = MainMenu.getInstance().getUser().retrieveSafeObjects();
        AnimationUtil.popInGone(hjælp,300);
        AnimationUtil.popInGone(ingenProfiler,300);
        AnimationUtil.popInGone(hjælp2,300);

        root.postDelayed(new Runnable() {
            @Override
            public void run() {
                hjælp.setVisibility(View.GONE);
                ingenProfiler.setVisibility(View.GONE);
                hjælp2.setVisibility(View.GONE);
            }
        }, 350);
        AnimationUtil.showMe(grid,500);
    }


    @Override
    public void onResume() {
        super.onResume();
        initialize();
        grid.setAdapter(new TestProgressAdaptor(getContext(),tests));
        grid.setOnItemClickListener(this);

        System.out.println("onResume blev kaldt" + tests.size());

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
                //startActivity(new Intent(this.getContext(), PopUp.class));
                Intent i = new Intent(this.getContext(), PopUp.class);
                i.putExtra("antal",antal);
                i.putExtra("overskrift",getResources().getString(R.string.introduktionOverskrift));
                i.putExtra("brødtekst",getResources().getString(R.string.introduktionBrødtekst));
                startActivity(i);
                break;
        }
    }
}
