package com.francis.simple_mvp.mvp.model;

/**
 * Created by yuer on 2016/7/8.
 */
public interface MvpModel<V extends ModelInterface> {
    /**
     * 加载数据
     */
   void LoadPresenter(V v);


}
