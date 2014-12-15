package com.example.sarah.rollovr;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class PackageSelectionFragment extends Fragment {



    public PackageSelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final View v = inflater.inflate(R.layout.fragment_package_selection, container, false);


        ImageButton smallPckBtn = (ImageButton)v.findViewById(R.id.imageButton_TP12);
        ImageButton mediumPckBtn = (ImageButton)v.findViewById(R.id.imageButton_TP24);
        ImageButton largePckBtn = (ImageButton)v.findViewById(R.id.imageButton_TP48);

        Button nextPage = (Button)v.findViewById(R.id.nextPage);


        View.OnClickListener packageListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch(view.getId()){
                    case(R.id.imageButton_TP12):
                        Properties.setPackageAmt(12);
                     //  HouseHoldFragmentStack(view);
                        if(Properties.getPackageAmt() == 12)
                        {
                            Toast.makeText(getActivity(),"12",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case(R.id.imageButton_TP24):
                        Properties.setPackageAmt(24);

                        if(Properties.getPackageAmt() == 24){
                            Toast.makeText(getActivity(), "24 Rolls", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case(R.id.imageButton_TP48):
                        Properties.setPackageAmt(48);

                        if(Properties.getPackageAmt() == 48){
                            Toast.makeText(getActivity(), "48 Rolls", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case(R.id.nextPage):
                        Fragment mFragment = new HouseAndTypeFragment();
                        FragmentManager fM = getFragmentManager();
                        FragmentTransaction fT = fM.beginTransaction();
                        fT.replace(R.id.fragPackage, mFragment).commit();
                        break;

                }

            }
        };

        smallPckBtn.setOnClickListener(packageListener);
        mediumPckBtn.setOnClickListener(packageListener);
        largePckBtn.setOnClickListener(packageListener);
        nextPage.setOnClickListener(packageListener);



        return v;


    }



    //Replaces current fragment with the Package Selection Fragment
    public void HouseHoldFragmentStack(View view){
        Fragment fr= null;
        if (view == getView().findViewById(R.id.nextPage)) {
            fr = new HouseAndTypeFragment();
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.maincontainer,fr);
        fragmentTransaction.commit();
    }


}
