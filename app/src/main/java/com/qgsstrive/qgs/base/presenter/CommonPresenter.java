package com.qgsstrive.qgs.base.presenter;

import com.qgsstrive.qgs.base.view.IBaseView;
import com.qgsstrive.qgs.http.callback.HttpCallBack;
import com.qgsstrive.qgs.http.model.CommonModel;

import java.util.Map;

public class CommonPresenter<T> extends BasePresenter<IBaseView<T>, CommonModel> {

    public CommonPresenter(IBaseView<T> mIView) {
        super(mIView);
    }

    public <E> void doGet(String url, Map<String, Object> params, E t) {

        getModel().doGet(url, params, new HttpCallBack() {

            @Override
            public void onRequest() {
            }

            @Override
            public void onDataSuccess(Object data) {
                T result = (T) data;
                getIView().onDataSuccess(result);
            }

            @Override
            public void onFailer(String msg) {
                getIView().onDataFailter(msg);
            }

            @Override
            public void onDataEmpty() {

            }
        }, t);

    }

    public <E> void doPost(String url, Map<String, Object> params, E t) {
        getModel().doPost(url, params, new HttpCallBack() {
            @Override
            public void onRequest() {
            }

            @Override
            public void onDataSuccess(Object data) {
                T result = (T) data;
                getIView().onDataSuccess(result);
            }

            @Override
            public void onFailer(String msg) {
                getIView().onDataFailter(msg);
            }

            @Override
            public void onDataEmpty() {

            }
        }, t);

    }

    public <E> void doPut(String url, Map<String, Object> params, E t) {
        getModel().doPost(url, params, new HttpCallBack() {
            @Override
            public void onRequest() {
            }

            @Override
            public void onDataSuccess(Object data) {
                T result = (T) data;
                getIView().onDataSuccess(result);
            }

            @Override
            public void onFailer(String msg) {
                getIView().onDataFailter(msg);
            }

            @Override
            public void onDataEmpty() {

            }
        }, t);

    }

    public <E> void doDelete(String url, Map<String, Object> params, E t) {
        getModel().doPost(url, params, new HttpCallBack() {
            @Override
            public void onRequest() {
            }

            @Override
            public void onDataSuccess(Object data) {
                T result = (T) data;
                getIView().onDataSuccess(result);
            }

            @Override
            public void onFailer(String msg) {
                getIView().onDataFailter(msg);
            }

            @Override
            public void onDataEmpty() {

            }
        }, t);

    }

    @Override
    protected CommonModel initModel() {
        return new CommonModel();
    }
}
