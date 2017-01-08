package com.example.mohammed.assignment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class secondmain extends Fragment {

    private Button back2three;
    private FragmentManager fm;
    FragmentTransaction ft;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_secondmain, container, false);
        back2three = (Button) v.findViewById(R.id.back2three) ;
        back2three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fm = getActivity().getSupportFragmentManager();
                ft= fm.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.container,new mainFragment());
                ft.commit();


            }
        });

        return v;

    }
}
