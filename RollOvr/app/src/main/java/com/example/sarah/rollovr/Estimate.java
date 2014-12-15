package com.example.sarah.rollovr;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Channing on 12/1/2014.
 */



public class Estimate {

    //Sheets per Person per Day
    public static final int ONE_PLY_PERSON = 80;
    public static final int TWO_PLY_PERSON = 70;
    public static final int THREE_PLY_PERSON = 60;

    //Sheets per Roll of Type
    public static final int ONE_PLY_SHEETS = 1000;
    public static final int TWO_PLY_SHEETS = 500;
    public static final int THREE_PLY_SHEETS = 300;

    //Rolls per Packages Available
    public static final int SMALL_PACKAGE = 12;
    public static final int MEDIUM_PACKAGE = 24;
    public static final int LARGE_PACKAGE = 48;


    //Roll Type and Package Size Identifier in Boolean Operations
    public static final int ONE_ROLL_TYPE = 1;
    public static final int TWO_ROLL_TYPE = 2;
    public static final int THREE_ROLL_TYPE = 3;


    //Variables for Estimation

    //Sheets per Roll of Type
    public static Integer r;

    //Sheets per Person
    public static Integer x;

    //Package amount
    public static Integer y;

    //Number of People
    public static Integer z;

    //Days until Restock
    public static int days;

    public static Integer estimateDays(Integer rollType, Integer packageAmt, Integer houseHold) {

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
        if(packageAmt == SMALL_PACKAGE){
            y = SMALL_PACKAGE;
        }
        else if(packageAmt == MEDIUM_PACKAGE){
            y = MEDIUM_PACKAGE;
        }
        else if(packageAmt == LARGE_PACKAGE){
            y = LARGE_PACKAGE;
        }

        //Set Amount of People in household
        z = houseHold;


        //Calculate
        days = y*r/x*z;



        return days;
    }

}
