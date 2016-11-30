package com.grp12.softskilltools.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.galgespil.stvhendeop.menuapp.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import static com.galgespil.stvhendeop.menuapp.R.id.pieChart;

/**
 * Created by mathiaslarsen on 27/11/2016.
 */

public class DISCResultFragment extends Fragment {

    PieChart result;
    View myView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_disc_result, container, false);
        result = (PieChart) myView.findViewById(pieChart);
        data();
        return myView;
    }

    public void data() {





        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(18.5f, "Dom"));
        entries.add(new PieEntry(26.7f, "Inf"));
        entries.add(new PieEntry(24.0f, "Sta"));
        entries.add(new PieEntry(30.8f, "Com"));


        PieDataSet set = new PieDataSet(entries, "DISC profil resultat");
        PieData data = new PieData(set);
        result.setData(data);
        result.invalidate();

    }
}
