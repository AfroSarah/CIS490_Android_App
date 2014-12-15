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
import android.widget.ImageButton;
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
        View v = inflater.inflate(R.layout.fragment_household, container, false);

        ImageButton onePly = (ImageButton)v.findViewById(R.id.imageButton_onePly);
        ImageButton twoPly = (ImageButton)v.findViewById(R.id.imageButton_twoPly);
        ImageButton threePly = (ImageButton)v.findViewById(R.id.imageButton_threePly);

        View.OnClickListener typeListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch(view.getId()){
                    case(R.id.imageButton_onePly):
                        if(Properties.getHouseHold() != null)
                        Properties.setRollType(1);
                        ResultsFragmentStack(view);
                        break;
                    case(R.id.imageButton_twoPly):
                        if(Properties.getHouseHold() != null)
                        Properties.setPackageAmt(2);
                        ResultsFragmentStack(view);
                        break;
                    case(R.id.imageButton_threePly):
                        if(Properties.getHouseHold() != null)
                        Properties.setPackageAmt(3);
                        ResultsFragmentStack(view);
                        break;
                }

            }
        };

        onePly.setOnClickListener(typeListener);
        twoPly.setOnClickListener(typeListener);
        threePly.setOnClickListener(typeListener);


        return v;
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


    //Replaces Fragment with HouseholdFragment
    public void ResultsFragmentStack(View view){
        if(view != null) {
            Fragment fr = new ResultsFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.maincontainer, fr);
            fragmentTransaction.commit();
        }

    }

}
