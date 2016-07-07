package com.francis.simple_mvp.mvp.common;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yuer on 2016/7/7.
 */
public class RetrofitNewInstance {
    private static Retrofit mRetrofit;
    private static Converter.Factory gonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private static OkHttpClient mOkHttpClient = new OkHttpClient();
    public static Retrofit getInstance(String Url){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Url)
                    .client(mOkHttpClient)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .addConverterFactory(gonConverterFactory)
                    .build();
            return mRetrofit;
    }

}
