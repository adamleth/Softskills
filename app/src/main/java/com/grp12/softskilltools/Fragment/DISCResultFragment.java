package com.grp12.softskilltools.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.grp12.softskilltools.Entities.AbstractItem;
import com.grp12.softskilltools.Entities.DISC;
import com.grp12.softskilltools.Entities.User;

import org.eazegraph.lib.communication.IOnItemFocusChangedListener;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.charts.PieChart;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by mathiaslarsen on 27/11/2016.
 */

public class DISCResultFragment extends Fragment {

    private PieChart mPieChart;
    DISC temp;
    Bundle bundle;
    TextView textDom;
    TextView textInf;
    TextView textSta;
    TextView textCom;



    public DISCResultFragment() {

    }

    /**********************************************************
     * This method initializes whatever that is on the screen *
     **********************************************************/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_disc_result, container, false);
        mPieChart = (PieChart) view.findViewById(R.id.piechart);
        textDom = (TextView) view.findViewById(R.id.domText);
        textInf = (TextView) view.findViewById(R.id.infText);
        textSta = (TextView) view.findViewById(R.id.staText);
        textCom = (TextView) view.findViewById(R.id.comText);
        bundle = getArguments();
        this.temp = (DISC) bundle.getSerializable("Item");
        loadData(temp.getDom(), temp.getInf(), temp.getSta(), temp.getCom());
        //Testresultater skap parses direkte fra listresultfragment, via en putextra funktion. På denne måde sendes data direkte til dette framgent, og loader med det samme.
        return view;
    }

    /******************************
     * This method loads the data *
     ******************************/

    private void loadData(int dom, int inf, int sta, int com) {
        int perDom = (int) (0.55 * dom);
        int perInf = (int) (0.55 * inf);
        int perSta = (int) (0.55 * sta);
        int perCom = (int) (0.55 * com);

        mPieChart.addPieSlice(new PieModel("Dominant", perDom, Color.parseColor("#e94848")));
        mPieChart.addPieSlice(new PieModel("Influential", perInf, Color.parseColor("#ed7c21")));
        mPieChart.addPieSlice(new PieModel("Stable", perSta, Color.parseColor("#67c34f")));
        mPieChart.addPieSlice(new PieModel("Compliant", perCom, Color.parseColor("#5384b7")));

        mPieChart.setOnItemFocusChangedListener(new IOnItemFocusChangedListener() {

            @Override
            public void onItemFocusChanged(int _Position) {
//                Log.d("PieChart", "Position: " + _Position);
            }
        });

        textDom.setText(dom + " (" + perDom + "%)");
        textInf.setText(inf + " (" + perInf + "%)");
        textSta.setText(sta + " (" + perSta + "%)");
        textCom.setText(com + " (" + perCom + "%)");

    }

 }

