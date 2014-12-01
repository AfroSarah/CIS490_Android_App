package com.example.sarah.rollovr;

/**
 * Created by Channing on 12/1/2014.
 */



public class Estimate {

    //Sheets per Person per Day
    public final int ONE_PLY_PERSON = 80;
    public final int TWO_PLY_PERSON = 70;
    public final int THREE_PLY_PERSON = 60;

    //Sheets per Roll of Type
    public final int ONE_PLY_SHEETS = 1000;
    public final int TWO_PLY_SHEETS = 500;
    public final int THREE_PLY_SHEETS = 300;

    //Rolls per Packages Available
    public final int SMALL_PACKAGE = 12;
    public final int MEDIUM_PACKAGE = 24;
    public final int LARGE_PACKAGE = 48;


    //Roll Type and Package Size Identifier in Boolean Operations
    public final int ONE_ROLL_TYPE = 1;
    public final int TWO_ROLL_TYPE = 2;
    public final int THREE_ROLL_TYPE = 3;
    public final String PACKAGE_SMALL = "small";
    public final String PACKAGE_MEDIUM = "medium";
    public final String PACKAGE_LARGE = "large";


    //Variables for Estimation

    //Sheets per Roll of Type
    public Integer r;

    //Sheets per Person
    public Integer x;

    //Package amount
    public Integer y;

    //Number of People
    public Integer z;

    //Days until Restock
    public int days;

    public Integer estimateDays(Integer rollType, String packageAmt, Integer houseHold) {

        //Boolean operation of Roll Type Input
        if(rollType == ONE_ROLL_TYPE){
            x = ONE_PLY_PERSON;
            r = ONE_PLY_SHEETS;
        }
        else if(rollType == TWO_ROLL_TYPE){
            x = TWO_PLY_PERSON;
            r = TWO_PLY_SHEETS;
        }
        else if(rollType == THREE_ROLL_TYPE){
            x = THREE_PLY_PERSON;
            r = THREE_PLY_SHEETS;
        }


        //Boolean operation of Package Amount Input
        if(packageAmt == PACKAGE_SMALL){
            y = SMALL_PACKAGE;
        }
        else if(packageAmt == PACKAGE_MEDIUM){
            y = MEDIUM_PACKAGE;
        }
        else if(packageAmt == PACKAGE_LARGE){
            y = LARGE_PACKAGE;
        }

        //Set Amount of People in household
        z = houseHold;


        //Calculate
        days = y*r/x*z;

        return days;
    }

}
