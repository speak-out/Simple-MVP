package com.francis.simple_mvp.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.francis.simple_mvp.R;
import com.francis.simple_mvp.mvp.adapter.ZhuangbiAdapter;
import com.francis.simple_mvp.mvp.model.ZhuangbiBean;
import com.francis.simple_mvp.mvp.presenter.TotalPresenter;
import com.francis.simple_mvp.mvp.view.TotalView;

import java.util.List;

/**
 * Created by yuer on 2016/7/8.
 */
public class TotalActivity extends AppCompatActivity implements TotalView, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private ZhuangbiAdapter mZhuangbiAdapter;
    private  TotalPresenter mTotalPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total_activity);
        initView();
        initPresenter();
    }

    private void initPresenter() {
        mTotalPresenter = new TotalPresenter();
        mTotalPresenter.attachView(this);
        mTotalPresenter.LoadData();
    }

    private void initView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srf_total_layout);
        mSwipeRefreshLayout.setRefreshing(true);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light
        );
        mRecyclerView = (RecyclerView) findViewById(R.id.rll_total_layout);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));
        mZhuangbiAdapter = new ZhuangbiAdapter(this);
        mRecyclerView.setAdapter(mZhuangbiAdapter);
    }

    @Override
    public void refresh() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hidefresh() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadData(List<ZhuangbiBean> list) {
        Log.e("数据加载成功了",list.size()+":"+list.get(0).toString());
        mZhuangbiAdapter.setList(list);
    }

    //SwipeRefreshLayout自带的刷新
    @Override
    public void onRefresh() {
        mTotalPresenter.LoadData();
    }
}
