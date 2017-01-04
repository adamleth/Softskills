package com.grp12.softskilltools.Util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.grp12.softskilltools.Entities.Question;

import java.util.ArrayList;

/**
 * Created by IbnMichael on 04/01/17.
 */

public class Belbin_adaptor {


    public class Belbin_adaptor extends BaseAdapter {

        private static ArrayList<Question> questions;
        private LayoutInflater mInflater;

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }


    }

    static class ViewHolder{
        TextView questions;
    }


}
