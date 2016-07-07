package com.francis.simple_mvp.mvp.presenter;

import android.util.Log;
import android.view.View;

import com.francis.simple_mvp.mvp.common.RetrofitNewInstance;
import com.francis.simple_mvp.mvp.common.URLCommon;
import com.francis.simple_mvp.mvp.model.MeiMeiBean;
import com.francis.simple_mvp.mvp.model.MeiMeiResutBean;
import com.francis.simple_mvp.mvp.model.ZhuangbiBean;
import com.francis.simple_mvp.mvp.model.ZhuangbiService;
import com.francis.simple_mvp.mvp.view.MeiMeiView;
import com.francis.simple_mvp.mvp.view.MvpView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yuer on 2016/7/7.
 */
public class MeiMeiPresenter implements MvpPresenter<MeiMeiView> {
    private MeiMeiView meiMeiView;
    @Override
    public void attachView(MeiMeiView view) {
        this.meiMeiView = view;
    }

    @Override
    public void detachView(boolean retainInstance) {

    }

    public void LoadData(int pageNum,int page)
    {
        if(meiMeiView == null){
        return;
        }
        meiMeiView.startRefresh();

        RetrofitNewInstance.getInstance(URLCommon.URL2).create(ZhuangbiService.class)
                .getMeimei(pageNum,page)
                .map(MeiMeiDataChange.getInstance())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ZhuangbiBean>>() {
                    @Override
                    public void onCompleted() {
                        Log.e("longjain","加载完成了");
                        meiMeiView.hideRefresh();
                    }

                    @Override
                    public void onError(Throwable e) {
                        meiMeiView.hideRefresh();
                        Log.e("longjain","加载失败了"+e.toString());
                    }

                    @Override
                    public void onNext(List<ZhuangbiBean> zhuangbiBeen) {
                        meiMeiView.LoadData(zhuangbiBeen);
                        Log.e("longjain","加载中");
                    }
                });




    }

}
