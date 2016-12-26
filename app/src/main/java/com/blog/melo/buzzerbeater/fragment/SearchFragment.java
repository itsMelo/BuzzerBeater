package com.blog.melo.buzzerbeater.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blog.melo.buzzerbeater.R;
import com.blog.melo.buzzerbeater.adapter.MainTabAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by melo on 2016/11/29.
 */

public class SearchFragment extends BaseFragment {

    private static final String TAG = "SearchFragment";
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.vp_fragment_search)
    ViewPager mViewPager;

    private List<Fragment> fragmentList;

    public static SearchFragment newInstance(String title) {
        SearchFragment f = new SearchFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }


    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_search;
    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        fragmentList = new ArrayList<>();

        ScienceFragment science = ScienceFragment.newInstance("Science");
        GameFragment game = GameFragment.newInstance("Game");
        EquipmentFragment equipment = EquipmentFragment.newInstance("Equipment");
        BusinessFragment business = BusinessFragment.newInstance("Business");
        ThinkingFragment thinking = ThinkingFragment.newInstance("Thinking");

        fragmentList.add(science);
        fragmentList.add(game);
        fragmentList.add(equipment);
        fragmentList.add(business);
        fragmentList.add(thinking);

        MainTabAdapter adapter = new MainTabAdapter(getActivity().getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(5);
        mTabLayout.setupWithViewPager(mViewPager);

    }



}
