package com.example.mohammed.assignment2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private mainFragment main_fragment;


    FragmentManager fm;
    FragmentTransaction ft;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_fragment = new mainFragment();

        fm =getSupportFragmentManager();
        ft= fm.beginTransaction();
        ft.add(R.id.container,main_fragment);
        ft.commit();
    }
}
