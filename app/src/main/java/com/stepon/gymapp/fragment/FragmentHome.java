package com.stepon.gymapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stepon.gymapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {


    private FragmentManager tFragmentManager;


    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        tFragmentManager = getFragmentManager();
        return view;


    }

//        @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.tvFragHomeMen:
//
//                break;
//        case R.id.tvFragHomeWomen:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new FragmentMen()).addToBackStack(null).commit();
//                break;
//        case R.id.tvFragHomeChild:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new FragmentMen()).addToBackStack(null).commit();
//                break;
//        case R.id.tvFragHomeWeight:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new FragmentMen()).addToBackStack(null).commit();
//                break;
//        case R.id.tvFragHomeDiet:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new FragmentMen()).addToBackStack(null).commit();
//                break;
//        case R.id.tvFragHomeGym:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new FragmentMen()).addToBackStack(null).commit();
//                break;
//        case R.id.tvFragHomeAboutUs:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new FragmentMen()).addToBackStack(null).commit();
//                break;
//
//        }
//    }
    @OnClick(R.id.tvFragHomeMen)
    public void tvFragMenClicked(View view){
        tFragmentManager.beginTransaction().replace(R.id.container_main, new FragmentMen()).addToBackStack(null).commit();
    }
  @OnClick(R.id.tvFragHomeWomen)
    public void tvFragHomeWomenClicked(View view){
        tFragmentManager.beginTransaction().replace(R.id.container_main, new WomenFragment()).addToBackStack(null).commit();
    }
  @OnClick(R.id.tvFragHomeChild)
    public void tvFragHomeChildClicked(View view){
        tFragmentManager.beginTransaction().replace(R.id.container_main, new ChildFragment()).addToBackStack(null).commit();
    }
  @OnClick(R.id.tvFragHomeWeight)
    public void tvFragHomeWeightClicked(View view){
        tFragmentManager.beginTransaction().replace(R.id.container_main, new WeightFragment()).addToBackStack(null).commit();
    }
  @OnClick(R.id.tvFragHomeDiet)
    public void tvFragHomeDietClicked(View view){
        tFragmentManager.beginTransaction().replace(R.id.container_main, new DietFragment()).addToBackStack(null).commit();
    }
  @OnClick(R.id.tvFragHomeGym)
    public void tvFragHomeGymClicked(View view){
        tFragmentManager.beginTransaction().replace(R.id.container_main, new GymFragment()).addToBackStack(null).commit();
    }
  @OnClick(R.id.tvFragHomeAboutUs)
    public void tvFragHomeAboutUsClicked(View view){
        tFragmentManager.beginTransaction().replace(R.id.container_main, new AboutUsFragment()).addToBackStack(null).commit();
    }

}
