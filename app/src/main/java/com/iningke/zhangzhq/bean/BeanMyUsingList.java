package com.iningke.zhangzhq.bean;

import com.iningke.baseproject.BaseBean;

/**
 * Created by hxy on  2016/11/24.
 */
public class BeanMyUsingList extends BaseBean {
    private String name;
    private String brand;
    private int count;
    private String date;

    public BeanMyUsingList() {
    }

    public BeanMyUsingList(String name, String brand, int count, String date) {
        this.name = name;
        this.brand = brand;
        this.count = count;
        this.date = date;
    }

    @Override
    public String toString() {
        return "BeanMyUsingList{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", count=" + count +
                ", date='" + date + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
