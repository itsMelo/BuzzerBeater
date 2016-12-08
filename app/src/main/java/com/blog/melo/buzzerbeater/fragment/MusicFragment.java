package com.blog.melo.buzzerbeater.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blog.melo.buzzerbeater.R;

/**
 * Created by melo on 2016/11/29.
 */

public class MusicFragment extends BaseFragment {

    private static final String TAG = "MusicFragment";

    public static MusicFragment newInstance(String title) {
        MusicFragment f = new MusicFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_music;
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
}
