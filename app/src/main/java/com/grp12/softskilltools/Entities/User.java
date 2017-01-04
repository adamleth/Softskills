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

        /***************************************
         * This method sets the name of a user *
         ***************************************/

        this.name= newName;
        this.surName = newSurName;
    }
    public String getName(){

        /***************************************
         * This method gets the name of a user *
         ***************************************/

        return name;
    }
    public String getSurName(){

        /******************************************
         * This method gets the surname of a user *
         ******************************************/

        return surName;
    }
    public void setEmail(String newEmail){

        /****************************************
         * This method sets the email of a user *
         ****************************************/

        this.email = newEmail;
    }
    public String getEmail(){

        /****************************************
         * This method gets the email of a user *
         ****************************************/

        return this.email;
    }
    public void setPhone(String newPhone){

        /**********************************************
         * This method sets the phonenumber of a user *
         **********************************************/

        this.phone = newPhone;
    }
    public String getPhone(){

        /**********************************************
         * This method gets the phonenumber of a user *
         **********************************************/

        return this.phone;
    }
    public List<AbstractItem> getSafe() {

        /*********************************
         * This method gets and the safe *
         *********************************/

        return safe.getSafe();}


    public List<AbstractItem> getResults(){

        /******************************************
         * This method gets the results of a user *
         ******************************************/

        return safe.getResults();}


    public void addToSafe(AbstractItem item, int qty){

        /*********************************************
         * This method adds bought tests to the safe *
         *********************************************/


        safe.addToSafe(item,qty);
    }
    public void addToResults(AbstractItem item) {

        /***********************************
         * This method adds to the results *
         ***********************************/

        safe.addToResults(item);}

}
