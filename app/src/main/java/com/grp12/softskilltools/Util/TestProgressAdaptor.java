package com.grp12.softskilltools.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.github.lzyzsd.circleprogress.DonutProgress;
import com.grp12.softskilltools.Entities.AbstractItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathiaslarsen on 22/11/2016.
 */

public class TestProgressAdaptor extends BaseAdapter {

    private static List<AbstractItem> products;
    private LayoutInflater mInflater;

    public TestProgressAdaptor(Context ProgressFragment, List<AbstractItem> products){
        this.products = products;
        mInflater = LayoutInflater.from(ProgressFragment);
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return products.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return products.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.active_tests_adaptor, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textView19);
            holder.progress = (DonutProgress) convertView.findViewById(R.id.Donut);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(products.get(position).getProductName());
        holder.progress.setProgress(products.get(position).getCompletion());


        return convertView;
    }

    static class ViewHolder{
        TextView name;
        DonutProgress progress;
    }
}
