package com.grp12.softskilltools.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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

import java.util.ArrayList;

/**
 * Created by Mathias R. Larsen on 07-01-2017.
 */

public class BELBINResultFragment extends Fragment {

    private RadarChart mChart;
    BELBIN temp;
    Bundle bundle;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_belbin_result, container, false);
        bundle = getArguments();
        this.temp = (BELBIN) bundle.getSerializable("Item");
        TextView tv = (TextView) view.findViewById(R.id.BelbinResultText);
        tv.setTextColor(Color.WHITE);
        tv.setBackgroundColor(Color.rgb(60, 65, 82));
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

            private String[] mActivities = new String[]{"PL", "RI", "CO", "SH", "ME","TW","IMP","CF","SP","DROP"};

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
        entries1.add(new RadarEntry((float)DROP+30));



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
    }
}