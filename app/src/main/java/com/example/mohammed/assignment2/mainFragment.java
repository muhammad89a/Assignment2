package com.example.mohammed.assignment2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class mainFragment extends Fragment {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private boolean btn1_pressed;
    private boolean btn2_pressed;

    Fragment1 fragment1 = new Fragment1();
    Fragment2 fragment2 = new Fragment2();

    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        btn1 = (Button) v.findViewById(R.id.btn1);
        btn2 = (Button) v.findViewById(R.id.btn2);
        btn3 = (Button) v.findViewById(R.id.btn3);
        btn4 = (Button) v.findViewById(R.id.btn4);

        btn1_pressed=false;
        btn2_pressed=false;


        fm = getActivity().getSupportFragmentManager();
        ft= fm.beginTransaction();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getActivity().getSupportFragmentManager();
                ft= fm.beginTransaction();
                ft.addToBackStack(null);

                if(btn1_pressed==false)
                {
                    btn1_pressed=true;
                    ft.add(R.id.contentFragment, fragment1);
                    btn1.setText("Remove frag1");
                    ft.commit();
                }
                else {
                    btn1_pressed=false;
                    btn1.setText("Add frag1");
                    ft.remove(fragment1);
                    ft.commit();
                    Toast.makeText(getActivity(),"button 1 Pressed",Toast.LENGTH_LONG).show();
               }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getActivity().getSupportFragmentManager();
                ft= fm.beginTransaction();
                ft.addToBackStack(null);

                if((btn2_pressed==false))
                {
                    btn2_pressed=true;
                    ft.add(R.id.contentFragment,fragment2);
                    btn2.setText("Remove frag2");
                    ft.commit();
                }
                else {
                    btn2_pressed=false;
                    btn2.setText("Add frag2");
                    ft.remove(fragment2);
                    ft.addToBackStack(null);
                    ft.commit();
                    Toast.makeText(getActivity(),"button 2 pressed!",Toast.LENGTH_LONG).show();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getActivity().getSupportFragmentManager();
                ft= fm.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.contentFragment,fragment1);
                btn1_pressed=true;
                ft.commit();


            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fm = getActivity().getSupportFragmentManager();
                ft= fm.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.container,new secondmain());
                ft.commit();


            }
        });

        return v;


    }


}
