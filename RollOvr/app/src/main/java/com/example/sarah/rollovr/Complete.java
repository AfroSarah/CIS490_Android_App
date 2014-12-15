package com.example.sarah.rollovr;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Channing on 12/14/2014.
 */
public class Complete extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(savedInstanceState == null){
            getFragmentManager().beginTransaction()
                    .add(R.id.maincontainer, new PlaceholderFragment())
                    .commit();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_complete, container, false);
    }

    public void returnHome(View view){
        ReturnHome(view);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_complete, container, false);
            return rootView;
        }


    }




    //Replaces Fragment with Number of Rolls Fragment
    public void ReturnHome(View view){
        Fragment fr = null;
        switch (view.getId()){
            case R.id.returnHome:
            fr = new HomeScreenFragment();
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.maincontainer,fr);
        fragmentTransaction.commit();
    }
}
