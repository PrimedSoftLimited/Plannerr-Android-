package com.example.plannerr;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CreateGoals extends Fragment {

    View view;

    public CreateGoals() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_create_goals, container, false);
        Bundle tokenArgument = getArguments();
        String token = tokenArgument.getString("token");
        return view;
    }

}
