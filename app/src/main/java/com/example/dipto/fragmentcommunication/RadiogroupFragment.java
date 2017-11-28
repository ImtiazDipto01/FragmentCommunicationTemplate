package com.example.dipto.fragmentcommunication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Dipto on 11/27/2017.
 */

public class RadiogroupFragment extends Fragment {

    @BindView(R.id.white_button)
    RadioButton whiteButton;
    @BindView(R.id.red_button)
    RadioButton redButton;
    @BindView(R.id.yellow_button)
    RadioButton yellowButton;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    Unbinder unbinder;

    ClickListener clickListener ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity){
            activity = (Activity) context;
            clickListener  = (ClickListener) activity;
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radio_button, container, false);
        unbinder = ButterKnife.bind(this, view);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.white_button:
                        clickListener.dataPassingToActivity("WHITE");
                        break;
                    case R.id.red_button:
                        clickListener.dataPassingToActivity("RED");
                        break;
                    case R.id.yellow_button:
                        clickListener.dataPassingToActivity("YELLOW");
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface ClickListener{
        public void dataPassingToActivity(String color);
    }
}
