package com.francis.simple_mvp.mvp.model;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by yuer on 2016/7/7.
 */
public class ZhuangbiBean implements Serializable {
    public String description;
    public String image_url;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return description+":"+ image_url;
    }
}
