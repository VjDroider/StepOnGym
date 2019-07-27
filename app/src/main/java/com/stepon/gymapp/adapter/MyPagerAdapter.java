package com.stepon.gymapp.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;





import com.stepon.gymapp.fragment.AboutUsFragment;
import com.stepon.gymapp.fragment.ChildFragment;
import com.stepon.gymapp.fragment.DietFragment;
import com.stepon.gymapp.fragment.FragmentHome;
import com.stepon.gymapp.fragment.FragmentMen;
import com.stepon.gymapp.fragment.GymFragment;
import com.stepon.gymapp.fragment.WeightFragment;
import com.stepon.gymapp.fragment.WomenFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {
    String data[] = {"Home", "Men", "Women", "Child", "Gym", "Diet", "Weight", "AboutUs"};

    private int pos;
    private String strCheck;

    public MyPagerAdapter(FragmentManager fm, int pos, String strCheck) {
        super(fm);
        this.pos = pos;
        this.strCheck = strCheck;
    }
    public MyPagerAdapter(FragmentManager fm, String strCheck) {
        super(fm);
        this.strCheck = strCheck;

    }

    @Override
    public Fragment getItem(int position) {

        if (!strCheck.equals("")){
            if (pos == 0) {
                return new FragmentHome();
            } if (pos == 1) {
                return new FragmentMen();
            } if (pos == 2) {
                return new WomenFragment();
            } if (pos == 3) {
                return new ChildFragment();
            } if (pos == 4) {
                return new GymFragment();
            }
        }
        else {

        if (position == 0) {
            return new FragmentHome();
        }

        if (position == 1) {
            return new FragmentMen();

        }
        if (position == 2) {

            return new WomenFragment();
        }
        if (position == 3) {

            return new ChildFragment();
        }

        if (position == 4) {

            return new GymFragment();
        }

        if (position == 5) {

            return new DietFragment();
        }


        if (position == 6) {

            return new WeightFragment();
        }


        if (position == 7) {

            return new AboutUsFragment();
        }
}
        return null;
    }

    @Override
    public int getCount() {
        return data.length;
    }


    @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
}
