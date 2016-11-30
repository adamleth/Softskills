package com.grp12.softskilltools.Entities;



/**
 * Created by mathiaslarsen on 18/11/2016.
 */

public abstract class AbstractItem {
    public double cost;
    public enum testType{DISC,BELBIN,THREESIXTY};
    public boolean isUsed;
    protected testType type;
    protected User owner;
    private String productName, description;

    public AbstractItem(double cost, boolean isUsed, String productName, String description){
        this.cost = cost;
        this.isUsed = isUsed;
        this.owner = null;
        this.productName = productName;
        this.description = description;

    }
    public testType getTestType(){
        return type;
    }
    public void setTestType(testType type) {this.type = type;}
    public User getOwner(){
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public void setName(String name) { this.productName = name;}
    public void setCost(int cost) { this.cost = cost;}
    public String getProductName(){ return productName;}
    public String getDescription(){ return description;}
    public String getPrice() {return Double.toString(cost);}
    public int getCompletion(){ return 1;}

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
