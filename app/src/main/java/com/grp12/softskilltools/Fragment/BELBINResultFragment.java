package com.grp12.softskilltools.Fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.galgespil.stvhendeop.menuapp.R;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.grp12.softskilltools.Entities.BELBIN;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathias R. Larsen on 03-01-2017.
 */

public class BELBINResultFragment extends Fragment {

    BELBIN temp;
    RadarChart spider;
    List<RadarEntry> data;
    Bundle bundle;


    public BELBINResultFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_belbin_result, container, false);
        spider = (RadarChart) view.findViewById(R.id.spiderweb);
        data = new ArrayList<>();
        bundle = getArguments();
        this.temp = (BELBIN) bundle.getSerializable("Item");
        loadData(temp.getPL(),temp.getRI(),temp.getCO(),temp.getSH(),temp.getME(),temp.getTW(),temp.getIMP(),temp.getCF(),temp.getSP(),temp.getDROP());
        return view;
    }

    public void initialize () {
        RadarDataSet dataset = new RadarDataSet(data,"Dine data");
        dataset.setColor(Color.parseColor("#e94848"));
    }

    private void loadData(int PL, int RI, int CO, int SH, int ME, int TW, int IMP, int CF, int SP, int DROP) {
        data.add(new RadarEntry(PL,0));
        data.add(new RadarEntry(RI,1));
        data.add(new RadarEntry(CO,2));
        data.add(new RadarEntry(SH,3));
        data.add(new RadarEntry(ME,4));
        data.add(new RadarEntry(TW,5));
        data.add(new RadarEntry(IMP,6));
        data.add(new RadarEntry(CF,7));
        data.add(new RadarEntry(SP,8));
        data.add(new RadarEntry(DROP,9));

    }


}



