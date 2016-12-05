package com.blog.melo.buzzerbeater.common;

import android.os.Handler;

import com.blog.melo.buzzerbeater.listener.HandlerContainer;

import java.lang.ref.WeakReference;

/**
 * Created by melo on 2016/12/3.
 */

public class SafeHandler<T extends HandlerContainer> extends Handler {
    protected WeakReference<T> mRef;

    public SafeHandler(WeakReference<T> ref) {
        mRef = ref;
    }

    public SafeHandler(T obj) {
        mRef = new WeakReference<>(obj);
    }

    public T getContainer() {
        return mRef.get();
    }

    @Override
    public void handleMessage(android.os.Message msg) {
        super.handleMessage(msg);
        HandlerContainer container = getContainer();
        if (container != null) {
            container.handleMessage(msg);
        }
    }
}
