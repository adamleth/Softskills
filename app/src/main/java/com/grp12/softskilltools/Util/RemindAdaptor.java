package com.grp12.softskilltools.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Entities.AbstractItem;
import com.grp12.softskilltools.Entities.User;

import java.util.ArrayList;

/**
 * Created by mathiaslarsen on 13/11/2016.
 */

public class RemindAdaptor extends BaseAdapter {

    private static ArrayList<User> users;
    private LayoutInflater mInflater;

    RemindAdaptor(Context RemindFragment, ArrayList<User> users){
        this.users = users;
        mInflater = LayoutInflater.from(RemindFragment);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return users.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return users.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.remind_adaptor, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.firstLine);
            holder.email = (TextView) convertView.findViewById(R.id.secondLine);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(users.get(position).getName());
        holder.email.setText(users.get(position).getEmail());

        return convertView;
    }

    static class ViewHolder{
        TextView name, email;
    }
}

