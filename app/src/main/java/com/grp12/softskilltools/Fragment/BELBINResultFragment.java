package com.grp12.softskilltools.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.galgespil.stvhendeop.menuapp.R;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarDataSet;
import com.grp12.softskilltools.Entities.BELBIN;

import java.util.ArrayList;

/**
 * Created by Mathias R. Larsen on 03-01-2017.
 */

public class BELBINResultFragment extends Fragment {

    BELBIN temp;
    RadarChart spider;
    ArrayList<Entry> data;
    Bundle bundle;


    public BELBINResultFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_belbin_result, container, false);
        spider = (RadarChart) view.findViewById(R.id.spiderweb);
        data = new List<Entry>();
        bundle = getArguments();
        this.temp = (BELBIN) bundle.getSerializable("Item");
        loadData(temp.getPL(),temp.getRI(),temp.getCO(),temp.getSH(),temp.getME(),temp.getTW(),temp.getIMP(),temp.getCF(),temp.getSP(),temp.getDROP());
        return view;
    }

    public void initialize () {
        RadarDataSet datasetPL = new RadarDataSet(data,"Dine data");
    }

    private void loadData(int PL, int RI, int CO, int SH, int ME, int TW, int IMP, int CF, int SP, int DROP) {
        data.add(new Entry(PL,0));
        data.add(new Entry(RI,1));
        data.add(new Entry(CO,2));
        data.add(new Entry(SH,3));
        data.add(new Entry(ME,4));
        data.add(new Entry(TW,5));
        data.add(new Entry(IMP,6));
        data.add(new Entry(CF,7));
        data.add(new Entry(SP,8));
        data.add(new Entry(DROP,9));

    }


}



