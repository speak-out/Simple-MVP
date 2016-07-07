package com.francis.simple_mvp.mvp.model;

import java.util.List;


import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yuer on 2016/7/7.
 */
public interface ZhuangbiService {
    @GET("/search")
    Observable<List<ZhuangbiBean>> getZhuagnbi(@Query("q") String value);

    //http://gank.io/api/data/福利/10/1
    @GET("data/福利/{pagenum}/{page}")
    Observable<MeiMeiResutBean> getMeimei(@Path("pagenum") int pageNum, @Path("page") int page);

}
