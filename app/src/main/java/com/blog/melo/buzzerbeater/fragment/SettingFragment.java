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
import com.blog.melo.buzzerbeater.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by melo on 2016/11/29.
 */

public class SettingFragment extends BaseFragment {

    private static final String TAG = "SettingFragment";
    private static final int PER_REQUEST_CODE = 2;

    public static SettingFragment newInstance(String title) {
        SettingFragment f = new SettingFragment();
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

    }

    @Override
    protected void initView() {

    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_setting;
    }

    @OnClick(R.id.bt_request_permission)
    public void onClick() {
        performRequestPermissions(getString(R.string.permission_desc), new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION}
                , PER_REQUEST_CODE, new PermissionsResultListener() {
                    @Override
                    public void onPermissionGranted() {
                        ToastUtils.showShortToast("已申请权限");
                    }

                    @Override
                    public void onPermissionDenied() {
                        ToastUtils.showShortToast("已拒绝权限");
                    }
                });
    }
}
