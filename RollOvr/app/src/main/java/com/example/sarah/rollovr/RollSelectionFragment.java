package com.example.sarah.rollovr;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


public class RollSelectionFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_roll_selection, container, false);
    }


    //Changing RadioButtons to ImageButtons
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.onePly:
                if (checked)
                    // single ply input for algorithm
                    HouseHoldFragmentStack();
                    break;
            case R.id.twoPly:
                if (checked)
                    // double ply input for algorithm
                    HouseHoldFragmentStack();
                    break;
            case R.id.threePly:
                if (checked)
                    // triple ply input for algorithm
                    HouseHoldFragmentStack();
                    break;
        }
    }

    //Replaces Fragment with HouseholdFragment
    public void HouseHoldFragmentStack(){
        getFragmentManager().beginTransaction()
                .replace(R.id.maincontainer, new HouseholdFragment())
                .commit();
    }

}
