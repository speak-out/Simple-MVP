package com.francis.simple_mvp.mvp.model;

import java.util.List;

/**
 * Created by yuer on 2016/7/8.
 */
public interface TotalModelIn extends ModelInterface{
    void Susessce(List<ZhuangbiBean> list);
    void error();
    void onCompleted();
}
