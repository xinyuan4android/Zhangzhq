package com.iningke.zhangzhq.bean;

import com.iningke.baseproject.BaseBean;

/**
 * Created by hxy on  2016/11/15.
 */
public class BeanAdViewPager extends BaseBean {
    private String imgUrl;
    private String imgTxt;

    public BeanAdViewPager() {
    }

    public BeanAdViewPager(String imgUrl, String imgTxt) {
        this.imgUrl = imgUrl;
        this.imgTxt = imgTxt;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgTxt() {
        return imgTxt;
    }

    public void setImgTxt(String imgTxt) {
        this.imgTxt = imgTxt;
    }
}
