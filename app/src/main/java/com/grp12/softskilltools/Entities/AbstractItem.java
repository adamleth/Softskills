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
    public testType getTestType(){

        /***********************************************
         * This method checks for the type of the test *
         ***********************************************/

        return type;
    }
    public void setTestType(testType type) {

        /*****************************************
         * This method sets the type of the test *
         *****************************************/

        this.type = type;}


    public User getOwner(){

        /******************************
         * This method gets the owner *
         ******************************/

        return owner;
    }
    public void setOwner(User owner) {

        /****************************************
         * This method sets the owner of a test *
         ****************************************/

        this.owner = owner;
    }
    public void setName(String name) {

        /******************************************
         * This method sets the name of the owner *
         ******************************************/

        this.productName = name;}

    public void setCost(int cost) {

        /****************************************
         * This method sets the price of a test *
         ****************************************/

        this.cost = cost;}

    public String getProductName(){

        /***************************************
         * This method gets the name of a test *
         ***************************************/

        return productName;}

    public String getDescription(){

        /**********************************************
         * This method gets the description of a test *
         **********************************************/

        return description;}

    public String getPrice() {

        /****************************************
         * This method gets the price of a test *
         ****************************************/

        return Double.toString(cost);}

    public int getCompletion(){

        /*******************************************************************
         * This method gets the information regarding completion of a test *
         *******************************************************************/

        return 1;}


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
