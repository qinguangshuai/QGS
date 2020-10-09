package com.qgsstrive.qgs.http.service;

import com.qgsstrive.qgs.http.response.CommonResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface CommonService {

    @GET
    Observable<CommonResponse> doGet(@Url String url, @QueryMap Map<String, Object> params);

    @POST
    @FormUrlEncoded
    Observable<CommonResponse> doPost(@Url String url, @FieldMap Map<String, Object> params);

    @PUT
    @FormUrlEncoded
    Observable<CommonResponse> doPut(@Url String url, @FieldMap Map<String, Object> params);

    @DELETE
    Observable<CommonResponse> doDelete(@Url String url, @QueryMap Map<String, Object> params);

}
