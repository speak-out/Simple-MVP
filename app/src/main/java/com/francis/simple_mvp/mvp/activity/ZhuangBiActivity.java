package com.francis.simple_mvp.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.francis.simple_mvp.R;
import com.francis.simple_mvp.mvp.adapter.ZhuangbiAdapter;
import com.francis.simple_mvp.mvp.model.ZhuangbiBean;
import com.francis.simple_mvp.mvp.presenter.ZhungbiPresenter;
import com.francis.simple_mvp.mvp.view.ZhuangbiView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuer on 2016/7/7.
 */
public class ZhuangBiActivity extends AppCompatActivity implements ZhuangbiView,SwipeRefreshLayout.OnRefreshListener{

    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView mRecycerView;
    private ZhuangbiAdapter mZhuangbiAdapter;
    private ZhungbiPresenter mZhungbiPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuangbi);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.sfl_layout);
        mRecycerView = (RecyclerView) findViewById(R.id.rv_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light
        );
        mSwipeRefreshLayout.setRefreshing(true);
        mRecycerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));
        mZhuangbiAdapter = new ZhuangbiAdapter(this);
        mRecycerView.setAdapter(mZhuangbiAdapter);
        initPreSenter();

    }

    private void initPreSenter() {
        mZhungbiPresenter = new ZhungbiPresenter();
        mZhungbiPresenter.attachView(this);
        mZhungbiPresenter.LoadData();
    }
    @Override
    public void hideRefresh() {
    mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void startRefresh() {
    mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void setData(List<ZhuangbiBean> list) {
        mZhuangbiAdapter.setList(list);
    }

    @Override
    public void onRefresh() {
        mZhungbiPresenter.LoadData();
    }

}
