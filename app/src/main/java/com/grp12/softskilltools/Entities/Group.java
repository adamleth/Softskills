package com.grp12.softskilltools.Entities;

import java.util.ArrayList;

/**
 * Created by mathiaslarsen on 04/01/2017.
 */

public class Group {

        private String Name;
        private ArrayList<Child> Items;

        public String getCategory() {
            return Name;
        }

        public void setCategory(String name) {
            this.Name = name;
        }

        public ArrayList<Child> getChildren() {
            return Items;
        }

        public void setChildren(ArrayList<Child> Items) {
            this.Items = Items;
        }

    }

