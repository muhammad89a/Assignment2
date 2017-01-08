package com.example.mohammed.assignment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment2 extends Fragment {
    private Button btn;
    private Button btn3;
    Fragment3 fragment3 = new Fragment3();

    FragmentManager fm;
    FragmentTransaction ft;
    View view ;
    LayoutInflater layoutInflater;
    ViewGroup content;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        layoutInflater=inflater;
        content=container;


        btn = (Button) v.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                view = layoutInflater.inflate(R.layout.fragment_main, content, false);

                btn3 = (Button) view.findViewById(R.id.btn3);
                btn3.setVisibility(View.VISIBLE);
                btn3.setText("replace");
                btn3.setBackgroundColor(155);

                fm = getActivity().getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.contentFragment, fragment3);
                ft.addToBackStack(null);
                ft.commit();

                Toast.makeText(getActivity(),"button btn pressed!", Toast.LENGTH_LONG).show();


            }
        });

        return v;
    }


}
