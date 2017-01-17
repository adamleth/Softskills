package com.grp12.softskilltools.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;


import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.DISC;
import com.grp12.softskilltools.Util.DISC_popup;
import com.grp12.softskilltools.Util.PopUp;


import org.eazegraph.lib.communication.IOnItemFocusChangedListener;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.charts.PieChart;

import java.text.DecimalFormat;


//heh

/**
 * Created by mathiaslarsen on 27/11/2016.
 */

public class DISCResultFragment extends Fragment implements View.OnClickListener {

    private PieChart mPieChart;
    DISC temp;
    Bundle bundle;
    TextView textDom, textInf, textSta, textCom,
            popDom, popInf, popSta, popCom;
    public DecimalFormat df;
    public int antal;


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
        popDom = (TextView) view.findViewById(R.id.popDom);
        popInf = (TextView) view.findViewById(R.id.popInf);
        popSta = (TextView) view.findViewById(R.id.popSta);
        popCom = (TextView) view.findViewById(R.id.popCom);
        popDom.setOnClickListener(this);
        popInf.setOnClickListener(this);
        popSta.setOnClickListener(this);
        popCom.setOnClickListener(this);
        bundle = getArguments();
        this.temp = (DISC) bundle.getSerializable("Item");
        df = new DecimalFormat("#.0");
        loadData(temp.getDom(), temp.getInf(), temp.getSta(), temp.getCom());
        //Testresultater skap parses direkte fra listresultfragment, via en putextra funktion. På denne måde sendes data direkte til dette framgent, og loader med det samme.
        return view;
    }

    /******************************
     * This method loads the data *
     ******************************/

    private void loadData(int dom, int inf, int sta, int com) {
        double perDom = Double.valueOf(100)*dom/Double.valueOf(180);
        double perInf = Double.valueOf(100)*inf/Double.valueOf(180);
        double perSta = Double.valueOf(100)*sta/Double.valueOf(180);
        double perCom = Double.valueOf(100)*com/Double.valueOf(180);

        mPieChart.addPieSlice(new PieModel("Dominant", Math.round(perDom), Color.parseColor("#e94848")));
        mPieChart.addPieSlice(new PieModel("Influential", Math.round(perInf), Color.parseColor("#ed7c21")));
        mPieChart.addPieSlice(new PieModel("Stable", Math.round(perSta), Color.parseColor("#67c34f")));
        mPieChart.addPieSlice(new PieModel("Compliant", Math.round(perCom), Color.parseColor("#5384b7")));

        mPieChart.setOnItemFocusChangedListener(new IOnItemFocusChangedListener() {

            @Override
            public void onItemFocusChanged(int _Position) {
//                Log.d("PieChart", "Position: " + _Position);
            }
        });

        textDom.setText(dom + " (" + df.format(perDom) + "%)");
        textInf.setText(inf + " (" + df.format(perInf) + "%)");
        textSta.setText(sta + " (" + df.format(perSta) + "%)");
        textCom.setText(com + " (" + df.format(perCom) + "%)");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.popDom:
                Intent i = new Intent(this.getContext(), DISC_popup.class);
                i.putExtra("antal",antal);
                i.putExtra("overskrift",getResources().getString(R.string.dominantOverskrift));
                i.putExtra("brødtekst",getResources().getString(R.string.dominantBrødtekst));
                startActivity(i);
                break;
            case R.id.popInf:
                i = new Intent(this.getContext(), DISC_popup.class);
                i.putExtra("antal",antal);
                i.putExtra("overskrift",getResources().getString(R.string.influentialOverskrift));
                i.putExtra("brødtekst",getResources().getString(R.string.influentialBrødtekst));
                startActivity(i);
                break;
            case R.id.popSta:
                i = new Intent(this.getContext(), DISC_popup.class);
                i.putExtra("antal",antal);
                i.putExtra("overskrift",getResources().getString(R.string.stableOverskrift));
                i.putExtra("brødtekst",getResources().getString(R.string.stableBrødtekst));
                startActivity(i);
                break;
            case R.id.popCom:
                i = new Intent(this.getContext(), DISC_popup.class);
                i.putExtra("antal",antal);
                i.putExtra("overskrift",getResources().getString(R.string.compliantOverskrift));
                i.putExtra("brødtekst",getResources().getString(R.string.compliantBrødtekst));
                startActivity(i);
                break;
        }
    }

}

