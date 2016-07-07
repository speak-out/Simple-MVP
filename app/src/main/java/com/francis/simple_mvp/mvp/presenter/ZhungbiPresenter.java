package com.francis.simple_mvp.mvp.presenter;


import android.util.Log;

import com.francis.simple_mvp.mvp.common.RetrofitNewInstance;
import com.francis.simple_mvp.mvp.common.URLCommon;
import com.francis.simple_mvp.mvp.model.ZhuangbiBean;
import com.francis.simple_mvp.mvp.model.ZhuangbiService;
import com.francis.simple_mvp.mvp.view.ZhuangbiView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yuer on 2016/7/7.
 */
public class ZhungbiPresenter implements MvpPresenter<ZhuangbiView> {
    private ZhuangbiView view;
    public void LoadData(){
        if(view==null){
            return ;
        }
        view.startRefresh();
        RetrofitNewInstance.getInstance(URLCommon.URL).create(ZhuangbiService.class)
                .getZhuagnbi("在下")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ZhuangbiBean>>() {
            @Override
            public void onCompleted() {
                Log.e("加载，，","完成");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("加载，，","失败"+e.toString());
            }

            @Override
            public void onNext(List<ZhuangbiBean> zhuangbiBeen) {
                view.setData(zhuangbiBeen);
                view.hideRefresh();
            }
        });


    }

    @Override
    public void attachView(ZhuangbiView view) {
        this.view = view;
    }

    @Override
    public void detachView(boolean retainInstance) {

    }
}
