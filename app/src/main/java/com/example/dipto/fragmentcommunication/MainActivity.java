package com.example.dipto.fragmentcommunication;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadiogroupFragment.ClickListener {

    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.main_layout)
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        RadiogroupFragment radiogroupFragment = new RadiogroupFragment();
        radiogroupFragment.onAttach(getApplicationContext());
        FragmentTransaction radio_ft = getSupportFragmentManager().beginTransaction();
        radio_ft.replace(R.id.container, radiogroupFragment, "Pizza Fragment");
        radio_ft.commit();
    }

    @Override
    public void dataPassingToActivity(String color) {
        if(color.equals("WHITE")){
            Log.d("++++MSG++++", "GOT IT 1!!") ;
        }
        else if(color.equals("RED")){
            Log.d("++++MSG++++", "GOT IT 2!!") ;
        }
        else if(color.equals("YELLOW")){
            Log.d("++++MSG++++", "GOT IT 3!!") ;
        }
    }
}
