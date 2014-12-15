package com.example.sarah.rollovr;

import android.content.Intent;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Channing on 12/1/2014.
 */
public class Properties {

    private static int _rollType;
    private static int _packageAmt;
    private static int _houseHold;

    private static Calendar _estimatedDate;





    public static Integer getRollType(){
        return _rollType;
    }

    public static void setRollType(Integer rollType){
        _rollType = rollType;
    }

    public static Integer getPackageAmt(){
        return _packageAmt;
    }

    public static void setPackageAmt(Integer packageAmt){
        _packageAmt = packageAmt;
    }

    public static Integer getHouseHold(){
        return _houseHold;
    }

    public static void setHouseHold(Integer houseHold){
        _houseHold = houseHold;
    }

    public static Calendar getEstimatedDate() {return _estimatedDate;}

    public static void setEstimatedDate(Calendar estimatedDate) {_estimatedDate = estimatedDate;}



}
