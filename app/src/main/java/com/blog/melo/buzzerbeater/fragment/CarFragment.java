package com.blog.melo.buzzerbeater.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blog.melo.buzzerbeater.R;

import static android.support.v7.widget.StaggeredGridLayoutManager.TAG;

/**
 * Created by ${melo} on 2016/11/29.
 */

public class CarFragment extends BaseFragment {

    private static final String TAG = "CarFragment";

    public static CarFragment newInstance(String title) {
        CarFragment f = new CarFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car, container, false);
        return view;
    }

}
