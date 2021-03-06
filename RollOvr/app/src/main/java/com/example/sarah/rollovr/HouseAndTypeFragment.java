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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_household, container, false);




        List<Integer> residents = new ArrayList<Integer>();
        residents.add(1);
        residents.add(2);
        residents.add(3);
        residents.add(4);
        residents.add(5);
        residents.add(6);
        residents.add(7);
        residents.add(8);
        residents.add(9);
        residents.add(10);


        Spinner spinner = (Spinner) v.findViewById(R.id.household_spinner);

        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_spinner_item, residents);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        //Spinner on item selection listener
        spinner.setOnItemSelectedListener(new OnItemSelectedListener());

        spinner = (Spinner) v.findViewById(R.id.household_spinner);
        //Button
        nextPageBtn = (Button) v.findViewById(R.id.household_button);

        final Spinner finalSpinner = spinner;
        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Properties.setHouseHold(Integer.valueOf((Integer) finalSpinner.getSelectedItem()));

                Fragment mFragment = new ResultsFragment();
                FragmentManager fM = getFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                fT.replace(R.id.maincontainer, mFragment).commit();


            }
        });




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
                        if(Properties.getRollType() == 1){
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




}
