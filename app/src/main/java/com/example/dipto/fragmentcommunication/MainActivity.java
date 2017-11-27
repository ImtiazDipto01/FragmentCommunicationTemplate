package com.example.dipto.fragmentcommunication;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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
        FragmentTransaction radio_ft = getSupportFragmentManager().beginTransaction();
        radio_ft.replace(R.id.container, radiogroupFragment, "Pizza Fragment");
        radio_ft.commit();
    }
}
