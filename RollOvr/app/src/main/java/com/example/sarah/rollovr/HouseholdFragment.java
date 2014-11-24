package com.example.sarah.rollovr;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class HouseholdFragment extends Fragment implements AdapterView.OnItemSelectedListener {


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



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //Next Page button
    public void nextPage(View view){

        //Move to Results Page
        ResultsFragmentStack();
    }

    public void ResultsFragmentStack(){
        getFragmentManager().beginTransaction()
                .replace(R.id.maincontainer, new ResultsFragment())
                .commit();
    }

}
