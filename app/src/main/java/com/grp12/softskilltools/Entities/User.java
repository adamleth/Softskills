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
    public Safe safe;



    public User(){

    }

    public User(String name,String surName,String email, String phone){
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phone = phone;
        this.safe = new Safe(this);

    }

    /***************************************
     * This method sets the name of a user *
     ***************************************/

    public void setName(String newName, String newSurName) {

        this.name= newName;
        this.surName = newSurName;
    }

    /***************************************
     * This method gets the name of a user *
     ***************************************/

    public String getName() {

        return name;
    }

    /******************************************
     * This method gets the surname of a user *
     ******************************************/

    public String getSurName() {

        return surName;
    }

    /****************************************
     * This method sets the email of a user *
     ****************************************/

    public void setEmail(String newEmail) {

        this.email = newEmail;
    }

    /****************************************
     * This method gets the email of a user *
     ****************************************/

    public String getEmail(){

        return this.email;
    }

    /**********************************************
     * This method sets the phone number of a user *
     **********************************************/

    public void setPhone(String newPhone){

        this.phone = newPhone;
    }

    /**********************************************
     * This method gets the phone number of a user *
     **********************************************/

    public String getPhone(){

        return this.phone;
    }

    /*********************************
     * This method gets and the safe *
     *********************************/

    public List<AbstractItem> retrieveSafeObjects() {

        return safe.getSafe();
    }

    /*****************************
     * This method gets the safe *
     *****************************/

    public Safe getSafe() {

        return safe;
    }

    /*****************************
     * This method sets the safe *
     *****************************/

    public void setSafe(Safe safe){

        this.safe = safe;
    }

    /******************************************
     * This method gets the results of a user *
     ******************************************/

    public List<AbstractItem> getResults() {

        return safe.getResults();
    }

    /*********************************************
     * This method adds bought tests to the safe *
     *********************************************/

    public void addToSafe(AbstractItem item, int qty){

        safe.addToSafe(item,qty);
    }

    /***********************************
     * This method adds to the results *
     ***********************************/

    public void addToResults(AbstractItem item) {

        safe.addToResults(item);
    }

}
