package com.francis.simple_mvp.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.francis.simple_mvp.R;
import com.francis.simple_mvp.mvp.adapter.MeiMeiAdapter;
import com.francis.simple_mvp.mvp.model.ZhuangbiBean;
import com.francis.simple_mvp.mvp.presenter.MeiMeiPresenter;
import com.francis.simple_mvp.mvp.view.MeiMeiView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuer on 2016/7/7.
 */
public class MeiMeiActivity extends AppCompatActivity implements MeiMeiView, SwipeRefreshLayout.OnRefreshListener {
    RecyclerView rvMeimei;
    SwipeRefreshLayout srfMeimei;
    private MeiMeiAdapter mMeiMeiAdapter;
    private MeiMeiPresenter meiMeiPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meimei);
        initView();
        initPresent();
    }

    private void initPresent() {
        meiMeiPresenter = new MeiMeiPresenter();
        meiMeiPresenter.attachView(this);
        meiMeiPresenter.LoadData(100, 1);
    }

    private void initView() {
        rvMeimei = (RecyclerView) findViewById(R.id.rv_meimei);
        srfMeimei = (SwipeRefreshLayout) findViewById(R.id.srf_meimei);
        srfMeimei.setRefreshing(true);
        srfMeimei.setOnRefreshListener(this);
        srfMeimei.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light
        );
        mMeiMeiAdapter = new MeiMeiAdapter(this);
        rvMeimei.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        rvMeimei.setAdapter(mMeiMeiAdapter);
    }

    @Override
    public void onRefresh() {
        //刷新数据
        srfMeimei.setRefreshing(true);
        meiMeiPresenter.LoadData(10, 2);
    }

    @Override
    public void hideRefresh() {
        srfMeimei.setRefreshing(false);
    }

    @Override
    public void startRefresh() {

    }

    @Override
    public void LoadData(List<ZhuangbiBean> list) {
        mMeiMeiAdapter.setData(list);
    }
}
