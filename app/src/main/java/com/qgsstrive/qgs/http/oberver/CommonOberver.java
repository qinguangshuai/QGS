package com.qgsstrive.qgs.http.oberver;

import com.google.gson.Gson;
import com.qgsstrive.qgs.http.callback.HttpCallBack;
import com.qgsstrive.qgs.http.response.CommonResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CommonOberver<T> implements Observer<CommonResponse> {

    private HttpCallBack mHttpCallBack;  //声明回调接口对象

    Gson gson = new Gson();

    Class<?> dataType;   //声明Bean类对象

    /*
    有参构造
     */
    public CommonOberver(HttpCallBack mHttpCallBack) {
        this.mHttpCallBack = mHttpCallBack;
    }

    /*
    实现Observer后的重写方法
     */
    @Override
    public void onSubscribe(Disposable d) {
        boolean netStatus = true;
        if (netStatus) {
            mHttpCallBack.onRequest();
        } else {
            //"网络连接不给力"
     //       String NetError = BaseApplication.sContext.getString(R.string.commonOberver_error_net);
            mHttpCallBack.onFailer("网络连接不给力");
        }
    }


    /*
    请求成功方法
     */
    @Override
    public void onNext(CommonResponse commonResponse) {
       // String RequestCode = BaseApplication.sContext.getString(R.string.commonOberver_request_Code);
        if ("200".equals(commonResponse.ret)) {
            if (commonResponse.result != null) {
                T result = (T) gson.fromJson(gson.toJson(commonResponse), dataType);
                if (result != null) {
                    mHttpCallBack.onDataSuccess(result);
                } else {
                 //   String ConstructionError = BaseApplication.sContext.getString(R.string.commonOberver_error_construction);
                    mHttpCallBack.onFailer("网络异常");
                }
            } else {
                mHttpCallBack.onDataEmpty();
            }
        } else {
            mHttpCallBack.onFailer(commonResponse.msg);
        }
    }


    /*
    获取该对象的类
     */
    public <T> void getDataType(T t) {
        //将 该对象初始化
        dataType = t.getClass();
    }

    /*
    失败方法
     */
    @Override
    public void onError(Throwable e) {
        mHttpCallBack.onFailer(e.getMessage());
    }

    /*
    请求完成
     */
    @Override
    public void onComplete() {

    }

}
