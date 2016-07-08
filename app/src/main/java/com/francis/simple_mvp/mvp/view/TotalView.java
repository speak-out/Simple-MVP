package com.francis.simple_mvp.mvp.view;

import com.francis.simple_mvp.mvp.model.ZhuangbiBean;

import java.util.List;

/**
 * Created by yuer on 2016/7/8.
 */
public interface TotalView extends MvpView{

    void refresh();
    void hidefresh();
    void loadData(List<ZhuangbiBean> list);
}
