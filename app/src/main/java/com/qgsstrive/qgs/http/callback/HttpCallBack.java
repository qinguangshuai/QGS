package com.qgsstrive.qgs.http.callback;

public interface HttpCallBack<T>{ //参数是Bean类

    String METHOD_SUCCESS = "onDataSuccess";

    void onRequest();

    void onDataSuccess(T data);

    void onFailer(String msg);

    void onDataEmpty();

}
