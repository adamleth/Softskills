package com.grp12.softskilltools.Util;

/**
 * Created by mathiaslarsen on 04/01/2017.
 */

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Entities.Child;
import com.grp12.softskilltools.Entities.Group;

public class ExpandListAdaptor extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Group> groups;


    public ExpandListAdaptor(Context context, ArrayList<Group> groups) {
        this.context = context;
        this.groups = groups;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<Child> chList = groups.get(groupPosition)
                .getChildren();
        return chList.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        Child child = (Child) getChild(groupPosition,
                childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_layout, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.child);
        tv.setText(child.getQuestion().toString());

        return convertView;

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<Child> chList = groups.get(groupPosition)
                .getChildren();

        return chList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        Group group = (Group) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.parent_layout, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.parent);
        tv.setText(group.getCategory());
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}


