package com.blog.melo.buzzerbeater.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blog.melo.buzzerbeater.R;
import com.blog.melo.buzzerbeater.adapter.MainTabAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ${melo} on 2016/11/29.
 */

public class SearchFragment extends BaseFragment {

    private static final String TAG = "SearchFragment";
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.vp_fragment_search)
    ViewPager mViewPager;
    private Unbinder bind;

    private List<Fragment> fragmentList;

    public static SearchFragment newInstance(String title) {
        SearchFragment f = new SearchFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        Log.e(TAG, "onCreateView");
        bind = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onCreateView");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView");
        bind.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "hidden:" + hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(TAG, "isVisibleToUser:" + isVisibleToUser);
    }

}
