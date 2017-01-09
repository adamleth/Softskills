package com.grp12.softskilltools.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Entities.AbstractItem;


import java.util.List;

/**
 * Created by mathiaslarsen on 05/12/2016.
 */

public class ResultListAdaptor extends BaseAdapter{
    private static List<AbstractItem> results;
    private LayoutInflater mInflater;

    public ResultListAdaptor(Context ResultFragment, List<AbstractItem> results){
        this.results = results;
        mInflater = LayoutInflater.from(ResultFragment);
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return results.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return results.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.resultlist_adaptor, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.type = (TextView) convertView.findViewById(R.id.code);
            holder.created = (TextView) convertView.findViewById(R.id.continent);
            holder.expire = (TextView) convertView.findViewById(R.id.region);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
            holder.type.setText(results.get(position).getProductName());
            holder.name.setText(results.get(position).getOwner());
            holder.created.setText(results.get(position).getFinishedDate());
            holder.expire.setText(results.get(position).getExpirationDate());




        return convertView;
    }

    static class ViewHolder{
        TextView name, type, created,expire;

    }
}

