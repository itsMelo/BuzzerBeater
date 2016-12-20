package com.blog.melo.buzzerbeater.utils;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by melo on 2016/11/24.
 */

public class ViewUtils {


    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }


}
