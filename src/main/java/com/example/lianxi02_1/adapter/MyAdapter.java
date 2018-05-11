package com.example.lianxi02_1.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lianxi02_1.R;
import com.example.lianxi02_1.bean.XBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CZ on 2018/5/9.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private List<XBean.DataBean> list;
    Context              context;
    private int sellerid;

    public MyAdapter(List<XBean.DataBean> list, Context context) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        switch (viewType){
            case 0:
            view=LayoutInflater.from(context).inflate(R.layout.item_adapterzuo, null);
                holder=new ZuoViewHolder(view);
                break;
            case 1:
                view= LayoutInflater.from(context).inflate(R.layout.item_adapteryou, null);
                holder=new YouViewHolder(view);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        XBean.DataBean dataBean = list.get(position);
        if (holder instanceof ZuoViewHolder){
            String images = dataBean.getImages();
            String[] split = images.split("[|]");
            ((ZuoViewHolder) holder).name.setText(dataBean.getTitle());
            ((ZuoViewHolder) holder).simple.setImageURI(Uri.parse(split[0]));
        }
        if (holder instanceof YouViewHolder){
            ((YouViewHolder) holder).name.setText(dataBean.getTitle());
            String images = dataBean.getImages();
            String[] split = images.split("[|]");
            ((YouViewHolder) holder).simple.setImageURI(Uri.parse(split[0]));
        }


    }

    @Override
    public int getItemViewType(int position) {
        int selleridType = list.get(position).getSellerid();
        if (selleridType%2==0){//偶数
            return 0;
        }else{//奇数
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ZuoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simple)
        SimpleDraweeView simple;
        @BindView(R.id.name)
        TextView         name;

        public ZuoViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class YouViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView         name;
        @BindView(R.id.simple)
        SimpleDraweeView simple;
        public YouViewHolder(View you) {
            super(you);
            ButterKnife.bind(this, you);
        }
    }

}
