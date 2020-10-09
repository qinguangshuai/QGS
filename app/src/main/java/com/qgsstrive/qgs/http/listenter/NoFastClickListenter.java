package com.qgsstrive.qgs.http.listenter;

import android.view.View;

import java.util.Calendar;

/**
 *页面功能-1： 【 阻止按钮快速点击 】 ✔
 */
public abstract class NoFastClickListenter implements View.OnClickListener {

    private long lastClickTime = 0;   //最后一次点击事件的时间

    public final int MIN_CLICK_DELAY_TIME = 1500; //单位毫秒

    public abstract void onNoDoubleClick(View view);    //创建一个抽象方法 用来再次回调事件

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();  //该方法获取到从格林事件1970年1月1日凌晨00:00 至今的毫秒数
        if (currentTime - lastClickTime >= MIN_CLICK_DELAY_TIME) {   //两者相减  得数小于1500 则代表 你没有连点
            lastClickTime = currentTime;       //将这次的 点击时的 时间记录下来
            onNoDoubleClick(v);         //如果符合这个要求 则利用  接口回调 将事件 重新 抛给 该方法处理
        }
    }




}
