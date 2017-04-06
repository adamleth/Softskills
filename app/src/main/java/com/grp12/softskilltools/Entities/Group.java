package com.grp12.softskilltools.Entities;

import java.util.ArrayList;

/**
 * Created by Mathias R. Larsen on 06-04-2017.
 */

public class Group {
    String name;
    ArrayList<User> members = new ArrayList<User>();
    int size;

    public Group(String name, ArrayList<User> members, int size){
        this.name = name;
        this.members = members;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
