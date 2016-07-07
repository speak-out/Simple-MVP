package com.francis.simple_mvp.mvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yuer on 2016/7/7.
 */
public class MeiMeiResutBean  {
    public boolean error;
    public @SerializedName("results")
    List<MeiMeiBean> data;
}


