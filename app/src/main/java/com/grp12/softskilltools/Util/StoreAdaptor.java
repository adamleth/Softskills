package com.grp12.softskilltools.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Entities.AbstractItem;
import com.grp12.softskilltools.Entities.User;
import com.grp12.softskilltools.Fragment.StoreFragment;

import java.util.ArrayList;

/**
 * Created by mathiaslarsen on 22/11/2016.
 */

public class StoreAdaptor extends BaseAdapter implements View.OnClickListener {

    private static ArrayList<AbstractItem> products;
    private LayoutInflater mInflater;
    private AbstractItem item;


    public StoreAdaptor(Context mStoreFragment, ArrayList<AbstractItem> products){
        this.products = products;
        mInflater = LayoutInflater.from(mStoreFragment);

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
            convertView = mInflater.inflate(R.layout.store_adaptor, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textView15);
            holder.description = (TextView) convertView.findViewById(R.id.textView16);
            holder.price = (TextView) convertView.findViewById(R.id.textView17);
            holder.add = (ImageButton) convertView.findViewById(R.id.button25);
            holder.add.setOnClickListener(this);


            convertView.setTag(convertView.getId(),position);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(products.get(position).getProductName());
        holder.description.setText(products.get(position).getDescription());
        holder.price.setText(products.get(position).getPrice()+",-");

        return convertView;
    }

    @Override
    public void onClick(View v) {
        View parent = (View)v.getParent();
        AbstractItem item = products.get(StoreFragment.getInstance().lv.getPositionForView(parent));
        User user = StoreFragment.getInstance().getUser();
        StoreFragment.getInstance().addToBasket(item,1,user);

    }


    static class ViewHolder{
        TextView name, description, price;
        ImageButton add;
    }
}

