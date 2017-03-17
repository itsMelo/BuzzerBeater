package com.blog.melo.buzzerbeater.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import com.blog.melo.buzzerbeater.R;
import com.blog.melo.buzzerbeater.utils.ToastUtils;

import butterknife.OnClick;

/**
 * Created by melo on 2016/11/30.
 */

public class GameFragment extends BaseFragment {

    @OnClick(R.id.bt_dialog)
    public void onClick() {
        CommonDialog.newInstance("提示", "这里填 Message", "继续", "取消", false, new BaseDialogFragment.OnDialogInteraction() {
            @Override
            public void onConfirm(DialogInterface dialog, int which) {
                ToastUtils.showShortToast("onConfirm");
            }

            @Override
            public void onCancel(DialogInterface dialog, int which) {
                ToastUtils.showShortToast("onCancel");
            }

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show(getActivity().getSupportFragmentManager(), TAG);
    }

    private static final String TAG = "GameFragment";

    public static GameFragment newInstance(String title) {
        GameFragment f = new GameFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_game;
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
    protected void lazyLoadData() {
        super.lazyLoadData();
        if (isViewCreated) {
            Log.e(TAG, "lazyLoadData...");
        }
    }
}
