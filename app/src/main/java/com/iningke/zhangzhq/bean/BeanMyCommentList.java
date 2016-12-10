package com.iningke.zhangzhq.bean;

import com.iningke.baseproject.BaseBean;

/**
 * Created by hxy on  2016/11/25.
 */
public class BeanMyCommentList extends BaseBean {
    private String workOrderNo;
    private String content;
    private String date;

    public BeanMyCommentList() {
    }

    public BeanMyCommentList(String workOrderNo, String content, String date) {
        this.workOrderNo = workOrderNo;
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {
        return "BeanMyCommentList{" +
                "workOrderNo='" + workOrderNo + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getWorkOrderNo() {
        return workOrderNo;
    }

    public void setWorkOrderNo(String workOrderNo) {
        this.workOrderNo = workOrderNo;
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
