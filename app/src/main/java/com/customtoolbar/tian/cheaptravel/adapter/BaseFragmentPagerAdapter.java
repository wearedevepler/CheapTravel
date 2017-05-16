package com.customtoolbar.tian.cheaptravel.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tian on 2017/5/16.
 */

public class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;



    public BaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        if (fragments == null) {
            mFragments = new ArrayList<>();
        } else {
            mFragments = fragments;
        }

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return mTitle.get(position);
//    }

}
