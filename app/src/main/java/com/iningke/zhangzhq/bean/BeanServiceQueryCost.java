package com.iningke.zhangzhq.bean;

import com.iningke.baseproject.BaseBean;

/**
 * Created by hxy on  2016/11/22.
 */
public class BeanServiceQueryCost extends BaseBean {
    private int imgUrl;
    private String typeName;
    private float costMoney;

    public BeanServiceQueryCost() {
    }

    public BeanServiceQueryCost(int imgUrl, String typeName, float costMoney) {
        this.imgUrl = imgUrl;
        this.typeName = typeName;
        this.costMoney = costMoney;
    }

    @Override
    public String toString() {
        return "BeanServiceQueryCost{" +
                "costMoney='" + costMoney + '\'' +
                ", typeName='" + typeName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public float getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(float costMoney) {
        this.costMoney = costMoney;
    }
}
