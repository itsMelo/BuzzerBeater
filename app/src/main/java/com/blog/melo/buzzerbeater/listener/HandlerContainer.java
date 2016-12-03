package com.blog.melo.buzzerbeater.listener;


import android.os.Message;

/**
 * 表示Handler所在的容器(类), 通常是Activity或Fragment.
 */
public interface HandlerContainer {
    void handleMessage(Message msg);
}
