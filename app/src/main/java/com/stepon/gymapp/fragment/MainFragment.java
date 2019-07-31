package com.stepon.gymapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.activity.DetailActivity;
import com.stepon.gymapp.model.ModelCategory;
import com.stepon.gymapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private int sectionNumber;
    private List<ModelCategory> tModels;

    @BindView(R.id.tvFragTitle)
    protected TextView tvFragTitle;
    @BindView(R.id.tvWeekOne)
    protected TextView tvWeekOne;
    @BindView(R.id.tvWeekTwo)
    protected TextView tvWeekTwo;
    @BindView(R.id.tvWeekThree)
    protected TextView tvWeekThree;
    @BindView(R.id.tvWeekFour)
    protected TextView tvWeekFour;
    @BindView(R.id.tvWeekFive)
    protected TextView tvWeekFive;
    @BindView(R.id.tvWeekSix)
    protected TextView tvWeekSix;
    @BindView(R.id.tvWeekSeven)
    protected TextView tvWeekSeven;
    @BindView(R.id.tvWeekEight)
    protected TextView tvWeekEight;
    @BindView(R.id.tvWeekNine)
    protected TextView tvWeekNine;
    @BindView(R.id.tvWeekTen)
    protected TextView tvWeekTen;
    @BindView(R.id.tvWeekEleven)
    protected TextView tvWeekEleven;
    @BindView(R.id.tvWeekTwelve)
    protected TextView tvWeekTwelve;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sectionNumber = getArguments() != null ? getArguments().getInt(ARG_SECTION_NUMBER) : 1;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_main, container, false);
        ButterKnife.bind(this, view);
        tvFragTitle.setText(tModels.get(sectionNumber-1).getName());
        return  view;
    }

    public static MainFragment newInstance(int sectionNumber, List<ModelCategory> tModels) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        fragment.tModels = tModels;
        return fragment;
    }

    @OnClick(R.id.tvWeekOne)
    public void tvWeekOneClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
    @OnClick(R.id.tvWeekTwo)
    public void tvWeekTwoClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
    @OnClick(R.id.tvWeekThree)
    public void tvWeekThreeClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
    @OnClick(R.id.tvWeekFour)
    public void tvWeekFourClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
    @OnClick(R.id.tvWeekFive)
    public void tvWeekFiveClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
    @OnClick(R.id.tvWeekSix)
    public void tvWeekSixClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
    @OnClick(R.id.tvWeekSeven)
    public void tvWeekSevenClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
    @OnClick(R.id.tvWeekEight)
    public void tvWeekEightClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
    @OnClick(R.id.tvWeekNine)
    public void tvWeekNineClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
    @OnClick(R.id.tvWeekTen)
    public void tvWeekTenClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
    @OnClick(R.id.tvWeekEleven)
    public void tvWeekElevenClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
    @OnClick(R.id.tvWeekTwelve)
    public void tvWeekTwelveClicked(View view){
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
}
