package com.stepon.gymapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.View;

import com.stepon.gymapp.fragment.MainFragment;
import com.stepon.gymapp.model.ModelCategory;

import java.lang.ref.WeakReference;
import java.util.List;

public class MainPagerAdapter extends FragmentStatePagerAdapter{

    private List<ModelCategory> tModels;
    public MainPagerAdapter(FragmentManager fm, List<ModelCategory> tModels) {
        super(fm);
        this.tModels = tModels;
    }

    @Override
    public Fragment getItem(int position) {

        return MainFragment. newInstance(position + 1, tModels);
    }
    @Override
    public int getCount() {
        return tModels.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tModels.get(position).getName();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        if(object != null){
            return ((Fragment)object).getView() == view;
        }else{
            return false;
        }
    }
}
