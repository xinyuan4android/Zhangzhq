package com.iningke.zhangzhq.bean;

/**
 * Created by hxy on  2016/12/3.
 */
public class BeanSafeHistoryList extends BeanNotifyList {
    private String address;

    public BeanSafeHistoryList() {
        super();
    }

    public BeanSafeHistoryList(String title, String content, String date, String address) {
        super(title, content, date);
        this.address = address;
    }

    @Override
    public String toString() {
        return "BeanSafeHistoryList{" +
                "address='" + address + '\'' + super.toString() +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
