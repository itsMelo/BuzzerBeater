package com.blog.melo.buzzerbeater.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blog.melo.buzzerbeater.R;
import com.blog.melo.buzzerbeater.listener.PermissionsResultListener;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by melo on 2016/11/29.
 */

public class SettingFragment extends BaseFragment {

    private static final String TAG = "SettingFragment";
    private static final int PER_REQUEST_CODE = 2;
    private Unbinder bind;

    public static SettingFragment newInstance(String title) {
        SettingFragment f = new SettingFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        bind = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.bt_request_permission)
    public void onClick() {
        performRequestPermissions(getString(R.string.permission_desc), new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION}
                , PER_REQUEST_CODE, new PermissionsResultListener() {
                    @Override
                    public void onPermissionGranted() {
                        Toast.makeText(getActivity(), "已申请权限", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onPermissionDenied() {
                        Toast.makeText(getActivity(), "拒绝申请权限", Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
