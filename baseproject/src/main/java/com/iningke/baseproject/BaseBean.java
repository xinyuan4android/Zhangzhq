package com.iningke.baseproject;

import java.io.Serializable;

/**
 * Created by iningke on 2016/6/13.
 */

public class BaseBean implements Serializable {

    private boolean success;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
