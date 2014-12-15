package com.example.sarah.rollovr;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

        //Roll Type and Package Size Identifier in Boolean Operations
        final int ONE_ROLL_TYPE = 1;
        final int TWO_ROLL_TYPE = 2;
        final int THREE_ROLL_TYPE = 3;
        final String PACKAGE_SMALL = "small";
        final String PACKAGE_MEDIUM = "medium";
        final String PACKAGE_LARGE = "large";


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.onePly:
                if (checked)
                    Properties.setRollType(ONE_ROLL_TYPE);
                    HouseHoldFragmentStack(view);
                    break;
            case R.id.twoPly:
                if (checked)
                    Properties.setRollType(TWO_ROLL_TYPE);
                    HouseHoldFragmentStack(view);
                    break;
            case R.id.threePly:
                if (checked)
                    Properties.setRollType(THREE_ROLL_TYPE);
                    HouseHoldFragmentStack(view);
                    break;
        }
    }

    //Replaces Fragment with HouseholdFragment
    public void HouseHoldFragmentStack(View view){
        if(view != null) {
            Fragment fr = new HouseAndTypeFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.maincontainer, fr);
            fragmentTransaction.commit();
        }

    }
}
