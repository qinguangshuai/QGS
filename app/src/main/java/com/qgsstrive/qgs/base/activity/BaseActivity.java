package com.qgsstrive.qgs.base.activity;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.qgsstrive.qgs.R;
import com.qgsstrive.qgs.base.presenter.BasePresenter;
import com.qgsstrive.qgs.http.AppManager;
import com.qgsstrive.qgs.http.ErrorView;
import com.qgsstrive.qgs.http.NetStateBroadReciver;
import com.qgsstrive.qgs.http.StatusView;

import java.util.Timer;
import java.util.TimerTask;


/*
 *  baseactivity
 * */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private T mBasePresenter;
    private StatusView mStatusView;
    private ErrorView mErrorView;
    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (initLayoutId() != 0) {
            //设置全局显示
            mErrorView = new ErrorView(this);
            ((ViewGroup) getWindow().getDecorView()).addView(mErrorView);
            initVariable();
            setContentView(initLayoutId());
            setStatusBarColor(R.color.colorPrimary);
            AppManager.getAppManager().addActivity(this);
            initView();
            initListener();
            initData();
            setBreoadcast();
        } else {
            finish();
        }
    }

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();

    public abstract int initLayoutId();

    //初始化变量
    public abstract void initVariable();

    public abstract T initPresenter();

    //设置沉浸式状态栏
    public void setStatusBarColor(int color) {
       // StatusBarUtil.calculateStatusColor(color);
    }

    @Override
    public void setContentView(View view) {
        initStatuView(view);
        super.setContentView(mStatusView);
    }

    @Override
    public void setContentView(int layoutResID) {
        View inflate = View.inflate(this, layoutResID, null);
        mStatusView = initStatuView(inflate);
        super.setContentView(mStatusView);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mStatusView = initStatuView(view);
        super.setContentView(mStatusView, params);
    }

    private StatusView initStatuView(View content) {
        StatusView.Builder builder = new StatusView.Builder(this);
        mStatusView = builder.contentView(content)
                .emptyId(R.layout.layout_empity2)
                .erroryId(R.layout.layout_error)
                .loadingId(R.layout.layout_loading)
                .build();
        return mStatusView;
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        mBasePresenter = initPresenter();
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mBasePresenter != null) {
            mBasePresenter.onDestory();
        }
    }

    public T getPresenter() {
        return mBasePresenter;
    }

    public void showEmptyLayout() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mErrorView.unRegister();
        if (mReceiver != null) {
            unregisterReceiver(mReceiver);
        }
    }

    //显示内容
    public void showContent() {
        mStatusView.showContent();
    }

    //加载数据
    public void showloading() {
        mStatusView.showLoading();
    }
    //显示空白布局
    public void showEmpty(){
        mStatusView.showEmpty();

    }

    /**
     * 设置网络监听
     */
    private void setBreoadcast() {
        mReceiver = new NetStateBroadReciver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mReceiver, filter);
    }

    /*float x1, x2;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = event.getX();
            if (x2 - x1 > 100) {
                finish();
            }
        }
        return super.onTouchEvent(event);
    }*/

    // 是否退出程序
    private static Boolean isExit = false;
    // 定时触发器
    private static Timer tExit = null;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isExit == false) {
                isExit = true;
                if (tExit != null) {
                    tExit.cancel(); // 将原任务从队列中移除
                }
                // 重新实例一个定时器
                tExit = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                };
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                // 延时两秒触发task任务
                tExit.schedule(task, 2000);
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
