package com.grp12.softskilltools.Entities;

/**
 * Created by mathiaslarsen on 18/11/2016.
 */

public class THREESIXTY extends AbstractItem {

    private String name;

    public THREESIXTY(){

    }

    /********
     * Hygge*
     ********/

    public THREESIXTY(double cost, boolean isUsed, String productName, String description, testType type) {
        super(cost, isUsed, productName, description, type);
        this.name = name;
    }
}
