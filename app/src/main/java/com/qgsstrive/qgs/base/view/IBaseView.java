package com.qgsstrive.qgs.base.view;

public interface IBaseView<T> {//参数是Bean类
    void onDataSuccess(T data);
    void onDataFailter(String msg);
}
