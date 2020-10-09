package com.qgsstrive.qgs.http;

import org.greenrobot.eventbus.EventBus;

/**
 * EventBus 工具类
 */
public class EventBusUtil {

    public EventBusUtil() {
    }

    /*取消订阅*/
    public static void unregister(Object subscriber) {
        if (EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().unregister(subscriber);//取消注册
        }
    }

    /*订阅事件*/
    public static void register(Object subscriber) {
        if (!EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().register(subscriber);//开始订阅
        }

    }

    /*发送事件*/
    public static void post(Object event) {//开始发送
        EventBus.getDefault().post(event);
    }

}
