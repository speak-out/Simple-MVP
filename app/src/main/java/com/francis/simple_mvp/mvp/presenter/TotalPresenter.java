package com.francis.simple_mvp.mvp.presenter;

import com.francis.simple_mvp.mvp.model.TotalModel;
import com.francis.simple_mvp.mvp.model.TotalModelIn;
import com.francis.simple_mvp.mvp.model.ZhuangbiBean;
import com.francis.simple_mvp.mvp.view.TotalView;

import java.util.List;

/**
 * Created by yuer on 2016/7/8.
 */
public class TotalPresenter implements MvpPresenter<TotalView>,TotalModelIn {

    private TotalView mTotalView;
    private TotalModel mTotalModel;
    public TotalPresenter(){
        mTotalModel = new TotalModel();
        mTotalModel.LoadPresenter(this);
    }

    public void LoadData(){
        mTotalModel.NetworkLoadData();
    }
    @Override
    public void attachView(TotalView view) {
        mTotalView = view;
    }

    @Override
    public void detachView(boolean retainInstance) {

    }
    @Override
    public void Susessce(List<ZhuangbiBean> list) {
        mTotalView.refresh();
        mTotalView.loadData(list);
    }

    @Override
    public void error() {
        mTotalView.hidefresh();
    }

    @Override
    public void onCompleted() {
        mTotalView.hidefresh();
    }
}
