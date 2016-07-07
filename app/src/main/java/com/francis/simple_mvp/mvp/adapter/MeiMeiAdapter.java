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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuer on 2016/7/7.
 */
public class MeiMeiAdapter extends RecyclerView.Adapter {

    private Activity mActivity;
    private List<ZhuangbiBean> list;

    public MeiMeiAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public void setData(List<ZhuangbiBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mActivity.getLayoutInflater().inflate(R.layout.zhuagnbi_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        if (list.get(position) != null) {
            myViewHolder.tv.setText(list.get(position).getDescription());
            Glide.with(mActivity).load(list.get(position).getImage_url()).into(myViewHolder.iv);
        }
    }
    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            tv= (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
