package com.iningke.zhangzhq.bean;

import com.iningke.baseproject.BaseBean;

import java.util.List;

/**
 * Created by hxy on  2016/11/19.
 */
public class BeanMineFixPullToListView extends BaseBean {
    private String id;
    private String date;
    private int state;
    private String title;
    private String content;
    private List<String> imgUrls;

    public BeanMineFixPullToListView() {
    }

    public BeanMineFixPullToListView(String id, String date, int state, String title, String content, List<String> imgUrls) {
        this.id = id;
        this.date = date;
        this.state = state;
        this.title = title;
        this.content = content;
        this.imgUrls = imgUrls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }
}
