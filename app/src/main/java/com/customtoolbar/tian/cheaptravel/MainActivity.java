package com.customtoolbar.tian.cheaptravel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentController;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.customtoolbar.tian.cheaptravel.adapter.BaseFragmentPagerAdapter;
import com.customtoolbar.tian.cheaptravel.ui.community.CommunityFragment;
import com.customtoolbar.tian.cheaptravel.ui.destination.DestinationFragment;
import com.customtoolbar.tian.cheaptravel.ui.homeage.HomeageFragment;
import com.customtoolbar.tian.cheaptravel.ui.shopping.ShoppingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private List<Fragment> mFragments ;
    private String[] mTabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @BindView(R.id.main_hotel_tablayout)
    TabLayout mMainHotelTablayout;
    @BindView(R.id.main_hotel_user_info)
    ImageView mMainHotelUserInfo;
    @BindView(R.id.main_hotel_linear)
    LinearLayout mMainHotelLinear;
    @BindView(R.id.main_viewpager)
    ViewPager mMainViewpager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mMainHotelTablayout.setTabMode(TabLayout.MODE_FIXED);
        mTabs = getResources().getStringArray(R.array.hotel_tabs);
        for (int i = 0; i < mTabs.length; i++) {
            mMainHotelTablayout.addTab(mMainHotelTablayout.newTab().setText(mTabs[i]));
        }

        mFragments = getFragments();
        mMainViewpager.setAdapter(new BaseFragmentPagerAdapter(getSupportFragmentManager(),
                mFragments));

        mMainHotelTablayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(mMainViewpager));
        mMainViewpager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(mMainHotelTablayout));
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeageFragment());
        fragments.add(new DestinationFragment());
        fragments.add(new ShoppingFragment());
        fragments.add(new CommunityFragment());
        return fragments;
    }


}
