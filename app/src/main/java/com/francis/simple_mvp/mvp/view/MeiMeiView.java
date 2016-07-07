package com.francis.simple_mvp.mvp.view;

import com.francis.simple_mvp.mvp.model.ZhuangbiBean;

import java.util.List;

/**
 * Created by yuer on 2016/7/7.
 */
public interface MeiMeiView extends MvpView {

    void  hideRefresh();
    void  startRefresh();
    void  LoadData(List<ZhuangbiBean> list);
}
