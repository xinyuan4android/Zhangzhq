package com.iningke.zhangzhq.bean;

import com.iningke.baseproject.BaseBean;

/**
 * Created by hxy on  2016/11/28.
 */
public class BeanDeviceInformationList extends BaseBean {
    private String name;
    private String content;

    public BeanDeviceInformationList() {
    }

    public BeanDeviceInformationList(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String toString() {
        return "BeanDeviceInformationList{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
