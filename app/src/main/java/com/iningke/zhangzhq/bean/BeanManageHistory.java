package com.iningke.zhangzhq.bean;

import com.iningke.baseproject.BaseBean;

/**
 * Created by hxy on  2016/11/19.
 */
public class BeanManageHistory extends BaseBean {
    private String date;
    private String money;
    private String amont;

    public BeanManageHistory() {
    }

    public BeanManageHistory(String date, String money, String amont) {
        this.date = date;
        this.money = money;
        this.amont = amont;
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

    public String getAmont() {
        return amont;
    }

    public void setAmont(String amont) {
        this.amont = amont;
    }
}
