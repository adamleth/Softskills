package com.grp12.softskilltools.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.galgespil.stvhendeop.menuapp.R;

/**
 * Created by mathiaslarsen on 11/01/2017.
 */

public class FirstFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.viewpager_1, container, false);
        EditText name = (EditText)v.findViewById(R.id.EditName);
        EditText surName = (EditText)v.findViewById(R.id.EditSurName);
        EditText email = (EditText)v.findViewById(R.id.EditEmail);
        EditText password = (EditText)v.findViewById(R.id.EditPassword);
        EditText birth = (EditText)v.findViewById(R.id.EditBirth);
        EditText phone = (EditText)v.findViewById(R.id.EditPhone);
        name.setText(getArguments().getString("name"));
        surName.setText(getArguments().getString("surName"));
        email.setText(getArguments().getString("email"));
        phone.setText(getArguments().getString("phone"));


        return v;
    }

    public static FirstFragment newInstance(String name, String surName, String email, String phone) {

        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putString("surName", surName);
        b.putString("email", email);
        b.putString("phone", phone);

        f.setArguments(b);

        return f;
    }
}