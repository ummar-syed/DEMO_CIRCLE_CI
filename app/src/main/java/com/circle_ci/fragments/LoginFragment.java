package com.circle_ci.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.circle_ci.R;

public class LoginFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText userId_EditText = view.findViewById(R.id.userId_EditText);
        final EditText password_EditText = view.findViewById(R.id.password_EditText);

        Button submit_Button = view.findViewById(R.id.submit_Button);

        submit_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userId_EditText.getText().toString().length() > 0 && password_EditText.getText().toString().length() > 0)
                {
                    getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment())
                            .addToBackStack(HomeFragment.class.getSimpleName())
                            .commit();
                }
                else
                Toast.makeText(getActivity(),"Enter both UserId and Password",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
