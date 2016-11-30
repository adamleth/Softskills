package com.grp12.softskilltools.Entities;

import java.util.List;

/**
 * Created by mathiaslarsen on 18/11/2016.
 */

public class User {

    public String name;
    public String surName;
    public String email;
    public String phone;
    private Safe safe;


    public User(String name,String surName,String email, String phone){
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phone = phone;
        this.safe = new Safe(this);
    }

    public void setName(String newName, String newSurName){
        this.name= newName;
        this.surName = newSurName;
    }
    public String getName(){
        return name;
    }
    public String getSurName(){
        return surName;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPhone(String newPhone){
        this.phone = newPhone;
    }
    public String getPhone(){
        return this.phone;
    }
    public List<AbstractItem> getSafe(){ return safe.getItems();}
    public void addToSafe(AbstractItem item, int qty){
        safe.addToSafe(item,qty);
    }

}
