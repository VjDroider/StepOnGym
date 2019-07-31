package com.stepon.gymapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.stepon.gymapp.fragment.MainFragment;
import com.stepon.gymapp.model.ModelCategory;

import java.util.List;

public class MainPagerAdapter extends FragmentStatePagerAdapter{

    private List<ModelCategory> tModels;

    public MainPagerAdapter(FragmentManager fm, List<ModelCategory> tModels) {
        super(fm);
        this.tModels = tModels;
    }

    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(position + 1, tModels);
    }

    @Override
    public int getCount() {
        return tModels.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tModels.get(position).getName();
    }
}
