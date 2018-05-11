package com.example.lianxi02_1.view;


import com.example.lianxi02_1.bean.XBean;

/**
 * Created by CZ on 2018/5/9.
 */

public interface XView {
    public void success(XBean bean);
    public void failure(String e);
}
