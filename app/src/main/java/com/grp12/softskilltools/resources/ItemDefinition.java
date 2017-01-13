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
            "BELBIN",
            "ThreeSixty"
    };

    public static final String [] TESTDescription_DATA = {

            "Dette værktøj anvender vi til at identificere kommunikationsstile, adfærd og motivationsfaktorer hos individer, – og hos teams bruger vi det til at fremhæve ligheder og forskelle indenfor teamet. Målet for vores indsatser er at få endnu mere værdi ud af både ligheder og forskelle, både i forhold til teamet og til omgivelserne, og DiSC™ Person Profil er uhyre effektivt til at igangsætte en sådan proces.",
            "Denne type profil bestemmer, ud fra en række spørgsmål, hvilken rolle du bedst vil udfylde i et team bestående af forskellige personligheder.",
            "Denne test er ikke tilgængelig på nuværende tidspunkt."
    };

    public static final double [] TESTPrice_DATA = {

        29.95,49.95,79.95

        };


    public static final AbstractItem.testType[] testType  = {

        AbstractItem.testType.DISC,
        AbstractItem.testType.BELBIN,
        AbstractItem.testType.THREESIXTY

        };


        }
