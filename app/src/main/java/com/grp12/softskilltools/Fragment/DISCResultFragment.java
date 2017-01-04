package com.grp12.softskilltools.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.galgespil.stvhendeop.menuapp.R;

import com.grp12.softskilltools.Entities.AbstractItem;
import com.grp12.softskilltools.Entities.DISC;

import org.eazegraph.lib.communication.IOnItemFocusChangedListener;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.charts.PieChart;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by mathiaslarsen on 27/11/2016.
 */

public class DISCResultFragment extends Fragment {

    private PieChart mPieChart;
    DISC temp;
    Bundle bundle;

    public DISCResultFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_disc_result, container, false);
        mPieChart = (PieChart) view.findViewById(R.id.piechart);

        bundle = getArguments();
        this.temp =(DISC) bundle.getSerializable("Item");
        loadData(temp.getDom(),temp.getInf(),temp.getSta(),temp.getCom());
        //Testresultater skap parses direkte fra listresultfragment, via en putextra funktion. På denne måde sendes data direkte til dette framgent, og loader med det samme.
        return view;
    }


    private void loadData(int dom, int inf, int sta, int com) {
        int perDom = (int) (0.55*dom);
        int perInf = (int) (0.55*inf);
        int perSta = (int) (0.55*sta);
        int perCom = (int) (0.55*com);
        System.out.println(dom + " " + inf + " " + sta + " " + com);
        System.out.println(perDom + " " + perInf + " " + perSta + " " + perCom);
        mPieChart.addPieSlice(new PieModel("Dominant", perDom, Color.parseColor("#FE6DA8")));
        mPieChart.addPieSlice(new PieModel("Influencial", perInf, Color.parseColor("#56B7F1")));
        mPieChart.addPieSlice(new PieModel("Stabile", perSta, Color.parseColor("#CDA67F")));
        mPieChart.addPieSlice(new PieModel("Compliant", perCom, Color.parseColor("#FED70E")));

        mPieChart.setOnItemFocusChangedListener(new IOnItemFocusChangedListener() {
            @Override
            public void onItemFocusChanged(int _Position) {
//                Log.d("PieChart", "Position: " + _Position);
            }
        });
    }
}
