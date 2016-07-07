package com.francis.simple_mvp.mvp.presenter;

import android.util.Log;

import com.francis.simple_mvp.mvp.model.MeiMeiBean;
import com.francis.simple_mvp.mvp.model.MeiMeiResutBean;
import com.francis.simple_mvp.mvp.model.ZhuangbiBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.functions.Func1;


/**
 * Created by yuer on 2016/7/7.
 */
public class MeiMeiDataChange implements Func1<MeiMeiResutBean, List<ZhuangbiBean>> {
    public static MeiMeiDataChange meiMeiDataChange;

    public static MeiMeiDataChange getInstance() {
        if (meiMeiDataChange == null) {
            meiMeiDataChange = new MeiMeiDataChange();
        }
        return meiMeiDataChange;
    }

    @Override
    public List<ZhuangbiBean> call(MeiMeiResutBean meiMeiResutBean) {
        List<ZhuangbiBean> list = new ArrayList<ZhuangbiBean>();
        List<MeiMeiBean> meiList = meiMeiResutBean.data;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        for(int i = 0 ;i < meiList.size();i++){
           ZhuangbiBean zhuangbiBean = new ZhuangbiBean();
            zhuangbiBean.setImage_url(meiList.get(i).url);
            try {
                Date time = inputFormat.parse(meiList.get(i).createdAt);
                zhuangbiBean.setDescription(outputFormat.format(time));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            list.add(zhuangbiBean);
        }
        return list;
    }
}
