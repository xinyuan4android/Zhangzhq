package com.iningke.zhangzhq.bean;

import com.iningke.baseproject.BaseBean;

import java.util.List;

/**
 * Created by hxy on  2016/11/18.
 */
public class BeanHomeListView extends BaseBean {
    private String name;
    private String time;
    private String address;
    private String content;
    private List<String> imgUrl;
    private int type;

    public BeanHomeListView() {
    }

    public BeanHomeListView(String name, String time, String address, String contetn, int type, List<String> imgUrl) {
        this.name = name;
        this.type = type;
        this.time = time;
        this.address = address;
        this.content = contetn;
        this.imgUrl = imgUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContetn(String contetn) {
        this.content = contetn;
    }

    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }
}
