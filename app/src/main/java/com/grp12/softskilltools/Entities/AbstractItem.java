package com.grp12.softskilltools.Entities;


import java.io.Serializable;

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

    public AbstractItem(double cost, boolean isUsed, String productName, String description, testType type){
        this.cost = cost;
        this.isUsed = isUsed;
        this.owner = null;
        this.productName = productName;
        this.description = description;
        this.type = type;

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
