package com.qgsstrive.qgs.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    private static Retrofit mRetrofit;
    private static RetrofitUtil mRetrofitUtil;

    private RetrofitUtil() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://web.trtgjtcm.com/api/")
                //.client(HttpUtil.getInstance())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtil getInstance() {
        if (mRetrofitUtil==null) {
            mRetrofitUtil = new RetrofitUtil();
        }
        return mRetrofitUtil;
    }
    public <T>T createApi(Class<T> tClass){
        return mRetrofit.create(tClass);
    }
}
