package com.circle_ci.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.circle_ci.R;
import com.crashlytics.android.Crashlytics;
import com.google.firebase.analytics.FirebaseAnalytics;

public class HomeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        rootView.findViewById(R.id.btnEvent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Bundle params = new Bundle();
                    params.putString("Button", "Clicked");
                    FirebaseAnalytics.getInstance(getActivity()).logEvent("action", params);

                    Crashlytics.log("button_click");

                    String s1=null;
                    s1.length();



                }
                catch (Exception e)
                {
                    Crashlytics.logException(e);
                }
                String s=null;
                s.length();


            }
        });

        Crashlytics.log("after click");

        return rootView;
    }

}
