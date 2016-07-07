package com.francis.simple_mvp.mvp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.francis.simple_mvp.R;
import com.francis.simple_mvp.mvp.model.ZhuangbiBean;
import com.francis.simple_mvp.mvp.view.ZhuangbiView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuer on 2016/7/7.
 */
public class ZhuangbiAdapter extends RecyclerView.Adapter {


    private Activity mActivity;
    private List<ZhuangbiBean> list = new ArrayList<ZhuangbiBean>();

    public ZhuangbiAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public void setList(List<ZhuangbiBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mActivity.getLayoutInflater().inflate(R.layout.zhuagnbi_item, null);
        ZhuangbiViewHolder mZhuangbiViewHolder = new ZhuangbiViewHolder(view);
        return mZhuangbiViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ZhuangbiViewHolder mZhuangbiViewHolder = (ZhuangbiViewHolder) holder;
        if (list.get(position) != null) {
            mZhuangbiViewHolder.tv.setText(list.get(position).getDescription());
            Glide.with(mActivity).load(list.get(position).getImage_url()).into(mZhuangbiViewHolder.iv);
        }
    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    class ZhuangbiViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv;
        public TextView tv;

        public ZhuangbiViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
