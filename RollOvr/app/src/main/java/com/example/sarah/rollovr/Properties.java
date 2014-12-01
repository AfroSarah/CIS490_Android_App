package com.example.sarah.rollovr;

import android.content.Intent;

/**
 * Created by Channing on 12/1/2014.
 */
public class Properties {

    private static int _rollType;
    private int _packageAmt;
    private int _houseHold;



    public Integer getRollType(){
        return _rollType;
    }

    public static void setRollType(Integer rollType){
        _rollType = rollType;
    }

    public Integer getPackageAmt(){
        return _packageAmt;
    }

    public void setPackageAmt(Integer packageAmt){
        _packageAmt = packageAmt;
    }

    public Integer getHouseHold(){
        return _houseHold;
    }

    public void setHouseHold(Integer houseHold){
        _houseHold = houseHold;
    }



}
