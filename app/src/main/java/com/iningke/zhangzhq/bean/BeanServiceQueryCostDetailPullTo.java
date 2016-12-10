package com.iningke.zhangzhq.bean;

import com.iningke.baseproject.BaseBean;

/**
 * Created by hxy on  2016/11/22.
 */
public class BeanServiceQueryCostDetailPullTo extends BaseBean {
    private String date;
    private String money;
    private String content;

    public BeanServiceQueryCostDetailPullTo() {
    }

    public BeanServiceQueryCostDetailPullTo(String date, String money, String content) {
        this.date = date;
        this.money = money;
        this.content = content;
    }

    @Override
    public String toString() {
        return "BeanServiceQueryCostDetailPullTo{" +
                "date='" + date + '\'' +
                ", money='" + money + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
