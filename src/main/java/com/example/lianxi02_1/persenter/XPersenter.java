package com.example.lianxi02_1.persenter;


import com.example.lianxi02_1.bean.XBean;
import com.example.lianxi02_1.model.XModel;
import com.example.lianxi02_1.view.XView;

/**
 * Created by CZ on 2018/5/9.
 */

public class XPersenter {
    XView view;
    private final XModel model;

    public XPersenter(XView view) {
        this.view = view;
        model = new XModel();
    }
    public void getData(String keywords, String page){
        model.get(keywords, page, new XModel.XCallBack() {
            @Override
            public void success(XBean bean) {
                if (view != null){
                    view.success(bean);
                }
            }

            @Override
            public void failure(String e) {
                if (view != null){
                    view.failure(e);
                }
            }
        });
    }
    public void Xpersenter(){
        this.view = null;
    }
}
