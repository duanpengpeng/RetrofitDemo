package com.example.lianxi02_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.lianxi02_1.adapter.MyAdapter;
import com.example.lianxi02_1.bean.XBean;
import com.example.lianxi02_1.persenter.XPersenter;
import com.example.lianxi02_1.view.XView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements XView {

    XPersenter persenter = new XPersenter(this);
    @BindView(R.id.xRecyclerView)
    XRecyclerView xRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        persenter.getData("笔记本", "1");
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        xRecyclerView.setLayoutManager(manager);
        
    }
    @Override
    public void success(XBean bean) {
        List<XBean.DataBean> list = new ArrayList<>();
        for (int i = 0; i < bean.getData().size(); i++) {
            list.add(bean.getData().get(i));
        }

        MyAdapter adapter = new MyAdapter(list, this);
        xRecyclerView.setAdapter(adapter);

    }

    @Override
    public void failure(String e) {
        Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.Xpersenter();
    }
}
