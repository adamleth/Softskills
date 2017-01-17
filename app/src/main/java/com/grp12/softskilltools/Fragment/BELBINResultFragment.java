package com.grp12.softskilltools.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.grp12.softskilltools.Entities.BELBIN;
import com.grp12.softskilltools.Entities.RadarMarkerView;
import com.grp12.softskilltools.Util.BELBIN_popup;
import com.grp12.softskilltools.Util.DISC_popup;

import java.util.ArrayList;

/**
 * Created by Mathias R. Larsen on 07-01-2017.
 */

public class BELBINResultFragment extends Fragment implements View.OnClickListener {

    private RadarChart mChart;
    BELBIN temp;
    Bundle bundle;
    TextView resIde, resKon, resKoo, resOps, resAna,
            resFor, resOrg, resAfs, resSpe,
            popIde, popKon, popKoo, popOps, popAna,
            popFor, popOrg, popAfs, popSpe;
    public int antal;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_belbin_result, container, false);
        bundle = getArguments();
        this.temp = (BELBIN) bundle.getSerializable("Item");
        mChart = (RadarChart) view.findViewById(R.id.spiderweb);
        mChart.setBackgroundColor(Color.rgb(60, 65, 82));
        mChart.getDescription().setEnabled(false);
        mChart.setWebLineWidth(1f);
        mChart.setWebColor(Color.WHITE);
        mChart.setWebLineWidthInner(1f);
        mChart.setWebColorInner(Color.WHITE);
        mChart.setWebAlpha(100);
        MarkerView mv = new RadarMarkerView(view.getContext(), R.layout.radar_markerview);
        mv.setChartView(mChart);
        mChart.setMarker(mv);
        resIde = (TextView) view.findViewById(R.id.resIde);
        resKon = (TextView) view.findViewById(R.id.resKon);
        resKoo = (TextView) view.findViewById(R.id.resKoo);
        resOps = (TextView) view.findViewById(R.id.resOps);
        resAna = (TextView) view.findViewById(R.id.resAna);
        resFor = (TextView) view.findViewById(R.id.resFor);
        resOrg = (TextView) view.findViewById(R.id.resOrg);
        resAfs = (TextView) view.findViewById(R.id.resAfs);
        resSpe = (TextView) view.findViewById(R.id.resSpe);
        popIde = (TextView) view.findViewById(R.id.popIde);
        popKon = (TextView) view.findViewById(R.id.popKon);
        popKoo = (TextView) view.findViewById(R.id.popKoo);
        popOps = (TextView) view.findViewById(R.id.popOps);
        popAna = (TextView) view.findViewById(R.id.popAna);
        popFor = (TextView) view.findViewById(R.id.popFor);
        popOrg = (TextView) view.findViewById(R.id.popOrg);
        popAfs = (TextView) view.findViewById(R.id.popAfs);
        popSpe = (TextView) view.findViewById(R.id.popSpe);
        popIde.setOnClickListener(this);
        popKon.setOnClickListener(this);
        popKoo.setOnClickListener(this);
        popOps.setOnClickListener(this);
        popAna.setOnClickListener(this);
        popFor.setOnClickListener(this);
        popOrg.setOnClickListener(this);
        popAfs.setOnClickListener(this);
        popSpe.setOnClickListener(this);

        setData(temp.getPL(),temp.getRI(),temp.getCO(),temp.getSH(),temp.getME(),temp.getTW(),temp.getIMP(),temp.getCF(),temp.getSP(),temp.getDROP());


        mChart.animateXY(
                1400, 1400,
                Easing.EasingOption.EaseInOutQuad,
                Easing.EasingOption.EaseInOutQuad);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setTextSize(9f);
        xAxis.setYOffset(0f);
        xAxis.setXOffset(0f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private String[] mActivities = new String[]{"Idémand", "Kontaktskaber", "Koordinator", "Opstarter", "Analytiker","Formidler","Organisator","Afslutter","Specialist"};

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mActivities[(int) value % mActivities.length];
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });
        xAxis.setTextColor(Color.WHITE);

        YAxis yAxis = mChart.getYAxis();
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(9f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(80f);
        yAxis.setDrawLabels(false);

        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setTextColor(Color.WHITE);
        ArrayList<IRadarDataSet> sets = (ArrayList<IRadarDataSet>) mChart.getData()
                .getDataSets();
        for (IRadarDataSet set : sets) {
            set.setDrawFilled(false);
        }
        mChart.invalidate();
        return  view;
    }

    /********************************************
     * This method reads the data of the result *
     ********************************************/

    public void setData(int PL, int RI, int CO, int SH, int ME, int TW, int IMP, int CF, int SP, int DROP) {


        ArrayList<RadarEntry> entries1 = new ArrayList<RadarEntry>();


        entries1.add(new RadarEntry((float)PL+30));
        entries1.add(new RadarEntry((float)RI+30));
        entries1.add(new RadarEntry((float)CO+30));
        entries1.add(new RadarEntry((float)SH+30));
        entries1.add(new RadarEntry((float)ME+30));
        entries1.add(new RadarEntry((float)TW+30));
        entries1.add(new RadarEntry((float)IMP+30));
        entries1.add(new RadarEntry((float)CF+30));
        entries1.add(new RadarEntry((float)SP+30));


        RadarDataSet set1 = new RadarDataSet(entries1, "Dit resultat");
        set1.setColor(Color.parseColor("#e94848"));
        set1.setFillColor(Color.rgb(103, 110, 129));
        set1.setDrawFilled(true);
        set1.setFillAlpha(180);
        set1.setLineWidth(2f);
        set1.setDrawHighlightCircleEnabled(true);
        set1.setDrawHighlightIndicators(false);



        ArrayList<IRadarDataSet> sets = new ArrayList<IRadarDataSet>();
        sets.add(set1);

        RadarData data = new RadarData(sets);
        data.setValueTextSize(12);
        data.setDrawValues(true);
        data.setValueTextColor(Color.WHITE);

        mChart.setData(data);
        mChart.invalidate();

        resIde.setText(String.valueOf(PL));
        resKon.setText(String.valueOf(RI));
        resKoo.setText(String.valueOf(CO));
        resOps.setText(String.valueOf(SH));
        resAna.setText(String.valueOf(ME));
        resFor.setText(String.valueOf(TW));
        resOrg.setText(String.valueOf(IMP));
        resAfs.setText(String.valueOf(CF));
        resSpe.setText(String.valueOf(SP));

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.popIde:
                Intent i = new Intent(this.getContext(), BELBIN_popup.class);
                i.putExtra("antal", antal);
                i.putExtra("overskrift", getResources().getString(R.string.idemandOverskrift));
                i.putExtra("brødtekst", getResources().getString(R.string.idemandBrødtekst));
                startActivity(i);
                break;
            case R.id.popKon:
                i = new Intent(this.getContext(), BELBIN_popup.class);
                i.putExtra("antal", antal);
                i.putExtra("overskrift", getResources().getString(R.string.kontaktskaberOverskrift));
                i.putExtra("brødtekst", getResources().getString(R.string.kontaktskaberBrødtekst));
                startActivity(i);
                break;
            case R.id.popKoo:
                i = new Intent(this.getContext(), BELBIN_popup.class);
                i.putExtra("antal", antal);
                i.putExtra("overskrift", getResources().getString(R.string.koordinatorOverskrift));
                i.putExtra("brødtekst", getResources().getString(R.string.koordinatorBrødtekst));
                startActivity(i);
                break;
            case R.id.popOps:
                i = new Intent(this.getContext(), BELBIN_popup.class);
                i.putExtra("antal", antal);
                i.putExtra("overskrift", getResources().getString(R.string.opstarterOverskrift));
                i.putExtra("brødtekst", getResources().getString(R.string.opstarterBrødtekst));
                startActivity(i);
                break;
            case R.id.popAna:
                i = new Intent(this.getContext(), BELBIN_popup.class);
                i.putExtra("antal", antal);
                i.putExtra("overskrift", getResources().getString(R.string.analytikerOverskrift));
                i.putExtra("brødtekst", getResources().getString(R.string.analytikerBrødtekst));
                startActivity(i);
                break;
            case R.id.popFor:
                i = new Intent(this.getContext(), BELBIN_popup.class);
                i.putExtra("antal", antal);
                i.putExtra("overskrift", getResources().getString(R.string.formidlerOverskrift));
                i.putExtra("brødtekst", getResources().getString(R.string.formidlerBrødtekst));
                startActivity(i);
                break;
            case R.id.popOrg:
                i = new Intent(this.getContext(), BELBIN_popup.class);
                i.putExtra("antal", antal);
                i.putExtra("overskrift", getResources().getString(R.string.organisatorOverskrift));
                i.putExtra("brødtekst", getResources().getString(R.string.organisatorBrødtekst));
                startActivity(i);
                break;
            case R.id.popAfs:
                i = new Intent(this.getContext(), BELBIN_popup.class);
                i.putExtra("antal", antal);
                i.putExtra("overskrift", getResources().getString(R.string.afslutterOverskrift));
                i.putExtra("brødtekst", getResources().getString(R.string.afslutterBrødtekst));
                startActivity(i);
                break;
            case R.id.popSpe:
                i = new Intent(this.getContext(), BELBIN_popup.class);
                i.putExtra("antal", antal);
                i.putExtra("overskrift", getResources().getString(R.string.specialistOverskrift));
                i.putExtra("brødtekst", getResources().getString(R.string.specialistBrødtekst));
                startActivity(i);
                break;
        }
    }

}