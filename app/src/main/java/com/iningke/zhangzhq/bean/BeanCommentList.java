package com.iningke.zhangzhq.bean;

import com.iningke.baseproject.BaseBean;

/**
 * Created by hxy on  2016/11/23.
 */
public class BeanCommentList extends BaseBean {
    private int imgUrl;
    private String name;
    private String date;
    private String content;

    public BeanCommentList() {
    }

    public BeanCommentList(int imgUrl, String name, String date, String content) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.date = date;
        this.content = content;
    }

    @Override
    public String toString() {
        return "BeanCommentList{" +
                "imgUrl=" + imgUrl +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
