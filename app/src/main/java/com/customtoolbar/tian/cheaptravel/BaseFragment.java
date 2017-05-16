package com.customtoolbar.tian.cheaptravel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.customtoolbar.tian.cheaptravel.R;

import butterknife.ButterKnife;

/**
 * Created by tian on 2017/5/16.
 */

public abstract class BaseFragment extends Fragment{
    protected View layout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (layout == null) {
            layout = inflater.inflate(getLayoutId(),container,false);
        }
        ButterKnife.bind(this,layout);
        this.initView();
        return layout;
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected View findViewById(int id){
        return layout.findViewById(id);
    }
}
