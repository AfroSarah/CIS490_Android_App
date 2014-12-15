package com.example.sarah.rollovr;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class HouseAndTypeFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Spinner spinner = (Spinner) getView().findViewById(R.id.household_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.household_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_household, container, false);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

      adapterView.getItemAtPosition(i);
      Properties.setHouseHold(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //Image Buttons
    public void typeOne(View view){
        if(Properties.getHouseHold() != null) {
            ResultsFragmentStack(view);
        }
    }

    public void typeTwo(View view){
        if(Properties.getHouseHold() != null) {
            ResultsFragmentStack(view);
        }
    }

    public void typeThree(View view){
        if(Properties.getHouseHold() != null) {
            ResultsFragmentStack(view);
        }
    }



    //Roll Type and Package Size Identifier in Boolean Operations
    final int ONE_ROLL_TYPE = 1;
    final int TWO_ROLL_TYPE = 2;
    final int THREE_ROLL_TYPE = 3;

    public void ResultsFragmentStack(View view){
        Fragment fr= null;

/*
        switch(view.getId()) {
            case R.id.oneType:
                Properties.setRollType(ONE_ROLL_TYPE);
                fr = new ResultsFragment();
                break;
            case R.id.twoType:
                Properties.setRollType(TWO_ROLL_TYPE);
                fr = new ResultsFragment();
                break;
            case R.id.threeType:
                Properties.setRollType(THREE_ROLL_TYPE);
                fr = new ResultsFragment();
        }
*/

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.maincontainer,fr);
        fragmentTransaction.commit();
    }

}
