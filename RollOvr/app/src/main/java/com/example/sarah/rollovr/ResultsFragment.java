package com.example.sarah.rollovr;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Channing on 11/24/2014.
 */
public class ResultsFragment extends Fragment {

    //This is a handle so that we can call methods on our service
    private ScheduleClient scheduleClient;

    //Calendar Variables
    private String month="";
    private String day="";
    private String year="";




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_results, container, false);




        scheduleClient = new ScheduleClient(getActivity());
        scheduleClient.doBindService();
        Button confirm = (Button)v.findViewById(R.id.finish_button);

        View.OnClickListener confirmListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch(view.getId()){
                    case(R.id.finish_button):
                        estimateDays();
                        Calendar c = Properties.getEstimatedDate();

                        //Set time to midnight
                        c.set(Calendar.HOUR_OF_DAY, 0);
                        c.set(Calendar.MINUTE, 0);
                        c.set(Calendar.SECOND, 0);

                        //Ask our service to set an alarm for that date,
                        // this activity talks to the client that talks to the service

                        scheduleClient.setAlarmForNotification(c);

                        int year =  c.get(Calendar.YEAR);
                        int month = c.get(Calendar.MONTH);
                        int day = c.get(Calendar.DAY_OF_MONTH);

                        Toast.makeText(getActivity(),"" + day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();

                        Fragment fr = new Complete();
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.fragResults,fr);
                        fragmentTransaction.commit();


                        break;


                }

            }
        };

        confirm.setOnClickListener(confirmListener);



        return v;
    }

    @Override
    public void onStop() {
        // When our activity is stopped ensure we also stop the connection to the service
        // this stops us leaking our activity into the system *bad*
        if(scheduleClient != null)
            scheduleClient.doUnbindService();
        super.onStop();
    }

    public void estimateDays(){
        Integer days = Estimate.estimateDays(Properties.getRollType(),Properties.getPackageAmt(),Properties.getHouseHold());

        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        Calendar calendar = new GregorianCalendar(gregorianCalendar.get(GregorianCalendar.YEAR),
                gregorianCalendar.get(GregorianCalendar.MONTH),gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH));

        calendar.add(Calendar.DAY_OF_MONTH,days);

        Properties.setEstimatedDate(calendar);


    }



}
