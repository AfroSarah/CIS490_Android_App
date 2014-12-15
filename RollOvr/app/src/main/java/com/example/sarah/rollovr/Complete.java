package com.example.sarah.rollovr;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Channing on 12/14/2014.
 */
public class Complete extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_complete, container, false);


        Button returnHome = (Button)v.findViewById(R.id.returnHome);


        View.OnClickListener completeListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case (R.id.returnHome):
                        Fragment fr = new HomeScreenFragment();
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.maincontainer,fr);
                        fragmentTransaction.commit();

                        break;
                }
            }
        };

        returnHome.setOnClickListener(completeListener);



        return v;
    }






}
