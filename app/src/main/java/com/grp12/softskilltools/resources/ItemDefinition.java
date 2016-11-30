package com.grp12.softskilltools.resources;

import com.grp12.softskilltools.Entities.AbstractItem;

/**
 * Created by mathiaslarsen on 21/11/2016.
 */

public class ItemDefinition {

    public final static int [] TESTNo_DATA = {
            1,2,3
    };
    public static final String [] TESTName_DATA = {
            "DISC",
            "Belbin",
            "ThreeSixty"
};
    public static final String [] TESTDescription_DATA = {
            "DISC test beskrivelse. Kan en beskrivelse være kort? NEEIGH!",
            "BELBIN test beskrivelse. Lad os bare give hver beskrivelse 60 tegn. ",
            "360-graders test beskrivelse, som er meget lang og irriterende"

    };
public static final double [] TESTPrice_DATA = {
        29.95,49.95,79.95
        };


public static final AbstractItem.testType testType[]  = {
        AbstractItem.testType.DISC,
        AbstractItem.testType.BELBIN,
        AbstractItem.testType.THREESIXTY
        };


        }
