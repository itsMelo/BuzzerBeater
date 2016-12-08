package com.blog.melo.buzzerbeater.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blog.melo.buzzerbeater.R;

/**
 * Created by melo on 2016/11/30.
 */

public class BusinessFragment extends BaseFragment {

    private static final String TAG = "BusinessFragment";

    public static BusinessFragment newInstance(String title) {
        BusinessFragment f = new BusinessFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        isViewCreated = true;
    }

    @Override
    protected void initView() {

    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_business;
    }

    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        if (isViewCreated) {

        }
    }
}
