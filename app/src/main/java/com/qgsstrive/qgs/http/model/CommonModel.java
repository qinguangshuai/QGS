package com.qgsstrive.qgs.http.model;

import com.qgsstrive.qgs.http.RetrofitUtil;
import com.qgsstrive.qgs.http.callback.HttpCallBack;
import com.qgsstrive.qgs.http.oberver.CommonOberver;
import com.qgsstrive.qgs.http.response.CommonResponse;
import com.qgsstrive.qgs.http.service.CommonService;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CommonModel {

    private CommonService mCommonService;

    /*
    get方法

    参数1:路径

    参数2:参数 键值对 形式 如:page=1
            key值:page
          value值:1

    参数3:回调CallBack基类

    参数4:Bean类

     */
    public <T> void doGet(String url, Map<String, Object> params, HttpCallBack httpCallBack, T t) {
        mCommonService = RetrofitUtil.getInstance().createApi(CommonService.class);
        CommonOberver commonOberver = new CommonOberver(httpCallBack);
        commonOberver.getDataType(t);
        Observable<CommonResponse> commonResponseObservable = mCommonService.doGet(url, params);
        commonResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(commonOberver);
    }


    public <T> void doPost(String url, Map<String, Object> params, HttpCallBack httpCallBack, T t) {
        mCommonService = RetrofitUtil.getInstance().createApi(CommonService.class);
        CommonOberver commonOberver = new CommonOberver(httpCallBack);
        commonOberver.getDataType(t);
        Observable<CommonResponse> commonResponseObservable = mCommonService.doPost(url, params);
        commonResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(commonOberver);
    }

    public <T> void doPut(String url, Map<String, Object> params, HttpCallBack httpCallBack, T t) {
        mCommonService = RetrofitUtil.getInstance().createApi(CommonService.class);
        CommonOberver commonOberver = new CommonOberver(httpCallBack);
        commonOberver.getDataType(t);
        Observable<CommonResponse> commonResponseObservable = mCommonService.doPut(url, params);
        commonResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(commonOberver);
    }

    public <T> void dpDelete(String url, Map<String, Object> params, HttpCallBack httpCallBack, T t) {
        mCommonService = RetrofitUtil.getInstance().createApi(CommonService.class);
        CommonOberver commonOberver = new CommonOberver(httpCallBack);
        commonOberver.getDataType(t);
        Observable<CommonResponse> commonResponseObservable = mCommonService.doDelete(url, params);
        commonResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(commonOberver);
    }


    public void onDstory() {

    }
}
