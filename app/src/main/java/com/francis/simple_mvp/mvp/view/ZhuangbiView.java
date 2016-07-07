package com.francis.simple_mvp.mvp.view;

import com.francis.simple_mvp.mvp.model.ZhuangbiBean;

import java.util.List;

/**
 * Created by yuer on 2016/7/7.
 */
public interface ZhuangbiView extends MvpView {
    //刷新结束
    void hideRefresh();
    //开始刷新
    void startRefresh();
    //设置数据
    void setData(List<ZhuangbiBean> list);
    //还有的再补
}
