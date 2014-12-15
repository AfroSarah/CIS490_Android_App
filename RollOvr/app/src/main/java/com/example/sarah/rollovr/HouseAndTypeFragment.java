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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class HouseAndTypeFragment extends Fragment{

    private Spinner spinner;
    private Button nextPageBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Spinner spinner = (Spinner) getView().findViewById(R.id.household_spinner);
        List<String> residents = new ArrayList<String>();
        residents.add("1");
        residents.add("2");
        residents.add("3");
        residents.add("4");
        residents.add("5");
        residents.add("6");
        residents.add("7");
        residents.add("8");
        residents.add("9");
        residents.add("10");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, residents);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        //Spinner item selection listener
        addListenerOnSpinnerItemSelection();

        //Button click listener
        addListenerOnButton();

    }

    //Add spinner data
    public void addListenerOnSpinnerItemSelection(){
        spinner.setOnItemSelectedListener(new OnItemSelectedListener());
    }

    //get the selected dropdown list value
    public void addListenerOnButton(){
        spinner = (Spinner) getView().findViewById(R.id.household_spinner);
        //Button
        nextPageBtn = (Button) getView().findViewById(R.id.household_button);

        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),""+String.valueOf(spinner.getSelectedItem()),
                        Toast.LENGTH_LONG).show();
                Properties.setHouseHold(Integer.valueOf((Integer) spinner.getSelectedItem()));
            }
        });
        //Button click listener

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
                        if(Properties.getHouseHold() == 1){
                            Toast.makeText(getActivity(), "One Ply Roll",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case(R.id.imageButton_twoPly):
                        if(Properties.getHouseHold() != null)
                        Properties.setRollType(2);
                        if(Properties.getRollType() == 2){
                            Toast.makeText(getActivity(), "Two Ply Roll", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case(R.id.imageButton_threePly):
                        if(Properties.getHouseHold() != null)
                        Properties.setRollType(3);
                        if(Properties.getRollType() == 3){
                            Toast.makeText(getActivity(), "Three Ply Roll", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }

            }
        };

        onePly.setOnClickListener(typeListener);
        twoPly.setOnClickListener(typeListener);
        threePly.setOnClickListener(typeListener);


        return v;
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
