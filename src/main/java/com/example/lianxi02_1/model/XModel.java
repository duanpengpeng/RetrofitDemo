package com.example.lianxi02_1.model;



import com.example.lianxi02_1.app.MyApp;
import com.example.lianxi02_1.bean.XBean;

import java.util.HashMap;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/5/9.
 */

public class XModel {
//    http://120.27.23.105/product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1
    public void get(String keywords, String page, final XCallBack callBack){
        HashMap<String, String> map = new HashMap<>();
        map.put("keywords",keywords);
        map.put("page",page);

        MyApp.inters.Xget(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XBean>() {
                    @Override
                    public void accept(XBean bean) throws Exception {
                        callBack.success(bean);
                    }
                });
    }
    public interface XCallBack{
        public void success(XBean bean);
        public void failure(String e);
    }
}
