package com.example.sarah.rollovr;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Channing on 12/15/2014.
 */
public class OnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> adapterView, View view, int pos,
                                long id){

        Toast.makeText(adapterView.getContext(),
                "Current Household: \n" + adapterView.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0){

    }

}
