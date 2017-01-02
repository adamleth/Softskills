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
import com.grp12.softskilltools.Entities.AbstractItem;
import com.grp12.softskilltools.Entities.DISC;

import java.util.ArrayList;
import java.util.List;

import static com.galgespil.stvhendeop.menuapp.R.id.pieChart;

/**
 * Created by mathiaslarsen on 27/11/2016.
 */

public class DISCResultFragment extends Fragment {

    PieChart result;
    DISC temp;
    Bundle bundle;
    View myView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_disc_result, container, false);
        result = (PieChart) myView.findViewById(pieChart);
        bundle = getArguments();
        this.temp =(DISC) bundle.getSerializable("Item");
        data(temp.getDom(),temp.getInf(),temp.getSta(),temp.getCom());
        //Testresultater skap parses direkte fra listresultfragment, via en putextra funktion. På denne måde sendes data direkte til dette framgent, og loader med det samme.
        return myView;
    }

    public void data(float f1, float f2, float f3, float f4) {





        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(f1, "Dom"));
        entries.add(new PieEntry(f2, "Inf"));
        entries.add(new PieEntry(f3, "Sta"));
        entries.add(new PieEntry(f4, "Com"));


        PieDataSet set = new PieDataSet(entries, "DISC profil resultat");
        PieData data = new PieData(set);
        result.setData(data);
        result.invalidate();

    }
}
