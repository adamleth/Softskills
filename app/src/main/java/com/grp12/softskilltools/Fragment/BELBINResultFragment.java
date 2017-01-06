package com.grp12.softskilltools.Fragment;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.galgespil.stvhendeop.menuapp.R;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.grp12.softskilltools.Entities.BELBIN;
import com.github.mikephil.charting.data.RadarData;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathias R. Larsen on 03-01-2017.
 */

public class BELBINResultFragment extends Fragment {

    BELBIN temp;
    RadarChart spider;
    List<RadarEntry> rawData;
    Bundle bundle;


    public BELBINResultFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_belbin_result, container, false);
        spider = (RadarChart) view.findViewById(R.id.spiderweb);
        rawData= new ArrayList<>();
        bundle = getArguments();
        this.temp = (BELBIN) bundle.getSerializable("Item");
        loadData(temp.getPL(),temp.getRI(),temp.getCO(),temp.getSH(),temp.getME(),temp.getTW(),temp.getIMP(),temp.getCF(),temp.getSP(),temp.getDROP());
        initialize();



        return view;
    }

    public void initialize () {



        RadarDataSet dataset_comp1 = new RadarDataSet(rawData, "Company1");
        dataset_comp1.setColor(Color.parseColor("#e94848"));





        ArrayList<String> labels = new ArrayList<String>();
        labels.add("PL");
        labels.add("RI");
        labels.add("CO");
        labels.add("SH");
        labels.add("ME");
        labels.add("TW");
        labels.add("IMP");
        labels.add("CF");
        labels.add("SP");
        labels.add("DROP");

        ArrayList<IRadarDataSet> dataSets = new ArrayList<IRadarDataSet>();
        dataSets.add(dataset_comp1);
        RadarData data = new RadarData(dataSets);

        spider.setData(data);





    }

    private void loadData(int PL, int RI, int CO, int SH, int ME, int TW, int IMP, int CF, int SP, int DROP) {
        rawData.add(new RadarEntry(PL,0));
        rawData.add(new RadarEntry(RI,1));
        rawData.add(new RadarEntry(CO,2));
        rawData.add(new RadarEntry(SH,3));
        rawData.add(new RadarEntry(ME,4));
        rawData.add(new RadarEntry(TW,5));
        rawData.add(new RadarEntry(IMP,6));
        rawData.add(new RadarEntry(CF,7));
        rawData.add(new RadarEntry(SP,8));
        rawData.add(new RadarEntry(DROP,9));

    }


}



