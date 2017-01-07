package com.grp12.softskilltools.Entities;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mathiaslarsen on 18/11/2016.
 */

public abstract class AbstractItem implements Serializable {
    public double cost;
    public enum testType{DISC,BELBIN,THREESIXTY};
    public boolean isUsed;
    protected testType type;
    protected User owner;
    private String productName, description;
    private String finishedDate, expirationDate;

    public AbstractItem(double cost, boolean isUsed, String productName, String description, testType type){
        this.cost = cost;
        this.isUsed = isUsed;
        this.owner = null;
        this.productName = productName;
        this.description = description;
        this.type = type;
        this.finishedDate = "00/00/0000";
        this.expirationDate = "00/00/0000";

    }


    /***********************************************
     * This method checks for the type of the test *
     ***********************************************/

    public testType getTestType(){

        return type;
    }

    /*****************************************
     * This method sets the type of the test *
     *****************************************/

    public void setTestType(testType type) {

        this.type = type;}

    /******************************
     * This method gets the owner *
     ******************************/

    public User getOwner(){

        return owner;
    }

    /****************************************
     * This method sets the owner of a test *
     ****************************************/

    public void setOwner(User owner) {

        this.owner = owner;
    }

    /******************************************
     * This method sets the name of the owner *
     ******************************************/

    public void setName(String name) {

        this.productName = name;
    }

    public void setFinishedDate(String date){
        this.finishedDate = date;
    }
    public void setExpirationDate(String date){
        this.expirationDate = date;
    }
    public void resolveFinishedDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.finishedDate = dateFormat.format(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 60);
        this.expirationDate = dateFormat.format(c.getTime());
    }

    /****************************************
     * This method sets the price of a test *
     ****************************************/

    public void setCost(int cost) {

        this.cost = cost;
    }

    /***************************************
     * This method gets the name of a test *
     ***************************************/

    public String getProductName() {

        return productName;
    }

    /**********************************************
     * This method gets the description of a test *
     **********************************************/

    public String getDescription(){

        return description;
    }

    /****************************************
     * This method gets the price of a test *
     ****************************************/

    public String getPrice() {

        return Double.toString(cost);
    }

    /*******************************************************************
     * This method gets the information regarding completion of a test *
     *******************************************************************/

    public int getCompletion(){

        return 1;

    }

    public String getFinishedDate(){

        return finishedDate;
            }
    public String getExpirationDate(){

        return expirationDate;
    }


    @Override
    public String toString(){
        switch(type){
            case DISC:
                return "testType=DISC";
            case BELBIN:
                return "testType=BELBIN";
            case THREESIXTY:
                return "testType=THREESIXTY";
            default:
                return "";
        }
    }

}
