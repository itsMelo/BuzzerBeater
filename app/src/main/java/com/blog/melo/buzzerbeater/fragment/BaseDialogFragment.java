package com.blog.melo.buzzerbeater.fragment;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;

/**
 * Created by melo on 2016/12/20.
 * 封装的 DialogFragment 为与 Activity 通信提供接口 OnDialogInteraction
 */

public class BaseDialogFragment extends DialogFragment {

    public interface OnDialogInteraction extends DialogInterface.OnClickListener {

        void onConfirm(DialogInterface dialog, int which);

        void onCancel(DialogInterface dialog, int which);

    }

}
