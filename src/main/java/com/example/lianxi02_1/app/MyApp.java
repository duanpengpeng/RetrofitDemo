package com.example.lianxi02_1.app;

import android.app.Application;

import com.example.lianxi02_1.bean.XBean;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by CZ on 2018/5/9.
 */

public class MyApp extends Application{

    public static Inters inters;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        //http://120.27.23.105/product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://120.27.23.105/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        inters = retrofit.create(Inters.class);
    }
    public interface Inters{

        @GET("product/searchProducts")
        Observable<XBean> Xget(@QueryMap HashMap<String, String> map);
    }
}
