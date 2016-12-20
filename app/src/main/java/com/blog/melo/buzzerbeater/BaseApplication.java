package com.blog.melo.buzzerbeater;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.blog.melo.buzzerbeater.utils.ToastUtils;

/**
 * Created by melo on 2016/12/9.
 */

public class BaseApplication extends Application {

    private static String sCacheDir;
    public static Context sAppContext;

    // TODO: 16/12/1 这里的夜间模式 UI 有些没有适配好 暂时放弃夜间模式
    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sAppContext = getApplicationContext();

        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
            sCacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            sCacheDir = getApplicationContext().getCacheDir().toString();
        }

        ToastUtils.init(true);
    }

    private boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static String getAppCacheDir() {
        return sCacheDir;
    }
}
