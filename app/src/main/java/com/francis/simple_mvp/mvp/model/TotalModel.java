package com.francis.simple_mvp.mvp.model;

import android.util.Log;

import com.francis.simple_mvp.mvp.common.RetrofitNewInstance;
import com.francis.simple_mvp.mvp.common.URLCommon;
import com.francis.simple_mvp.mvp.presenter.MeiMeiDataChange;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by yuer on 2016/7/8.
 */
public class TotalModel implements MvpModel<TotalModelIn> {

    private TotalModelIn  mTotalModeIn;
    public void NetworkLoadData() {

        rx.Observable.zip(RetrofitNewInstance.getInstance(URLCommon.URL2).create(ZhuangbiService.class).getMeimei(100, 1).map(MeiMeiDataChange.getInstance()),
                RetrofitNewInstance.getInstance(URLCommon.URL).create(ZhuangbiService.class).getZhuagnbi("在下")
                , new Func2<List<ZhuangbiBean>, List<ZhuangbiBean>, List<ZhuangbiBean>>() {
                    @Override
                    public List<ZhuangbiBean> call(List<ZhuangbiBean> list, List<ZhuangbiBean> list2) {
                        List<ZhuangbiBean> zipList = new ArrayList<ZhuangbiBean>();
                        for (int i = 0; i < list.size() ||  i < list2.size(); i++) {
                            if(i < list.size()){
                                zipList.add(list.get(i));
                            }
                            if(i < list2.size()){
                                zipList.add(list2.get(i));
                            }

                        }
                        return zipList;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ZhuangbiBean>>() {
                    @Override
                    public void onCompleted() {
                            Log.e("哈哈 ","加载结束");
                        mTotalModeIn.onCompleted();
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.e("哈哈","加载失败"+e.toString());
                        mTotalModeIn.error();
                    }

                    @Override
                    public void onNext(List<ZhuangbiBean> list) {
                        Log.e("哈哈","加载中.....");
                        mTotalModeIn.Susessce(list);
                    }
                });





    }


    @Override
    public void LoadPresenter(TotalModelIn modelIn) {
        mTotalModeIn = modelIn;
    }
}
