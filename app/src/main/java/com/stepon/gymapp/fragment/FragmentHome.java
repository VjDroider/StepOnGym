package com.stepon.gymapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.stepon.gymapp.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {


    private FragmentManager tFragmentManager;
    private Context tContext;
    public FragmentHome() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        tFragmentManager = getFragmentManager();
        tContext = getContext();
        return view;


    }


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
