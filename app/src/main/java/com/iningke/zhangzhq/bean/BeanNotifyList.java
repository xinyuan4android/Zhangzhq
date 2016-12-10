package com.iningke.zhangzhq.bean;

import com.iningke.baseproject.BaseBean;

/**
 * 通知列表 实体类
 *
 * @author hxy
 * @date 2016/11/23
 */
public class BeanNotifyList extends BaseBean {
    private String title;
    private String content;
    private String date;

    public BeanNotifyList() {
    }

    public BeanNotifyList(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {
        return "BeanNotifyList{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
