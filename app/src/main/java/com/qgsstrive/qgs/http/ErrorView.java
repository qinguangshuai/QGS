package com.qgsstrive.qgs.http;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qgsstrive.qgs.R;

import org.greenrobot.eventbus.Subscribe;

public class ErrorView extends LinearLayout {

    private View view;
    private TextView image;

    public ErrorView(Context context) {
        this(context, null);
    }

    public ErrorView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        EventBusUtil.register(this);
        initView(context);
    }

    @Subscribe
    public void isNetWork(NetWorkChangeEvent event) {
        boolean aTrue = event.isConnected;
        //有网络
        if (aTrue) {

            view.setVisibility(View.GONE);

        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

    private void initView(final Context context){
        view = LayoutInflater.from(context).inflate(R.layout.layout_error,this);
        image = view.findViewById(R.id.errImage);
        image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                context.startActivity(intent);
            }
        });
    }

    public void unRegister(){
        EventBusUtil.unregister(this);
    }
}
