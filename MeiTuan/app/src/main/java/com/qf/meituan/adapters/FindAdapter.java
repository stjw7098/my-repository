package com.qf.meituan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.meituan.R;
import com.qf.meituan.beans.FindBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class FindAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    Context context;
    List<FindBean.DataBean> data;


    public FindAdapter(Context context,  List<FindBean.DataBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
            if(data!=null){
                return data.size();
            }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.find_item, parent, false);
            holder= new Holder(convertView);
            convertView.setTag(holder);
        }else{
            holder=  ((Holder) convertView.getTag());
        }

        FindBean.DataBean dataBean = data.get(position);
        String title = dataBean.getTitle();
        String imgUrl = dataBean.getImg();
        String info = dataBean.getContent();
        holder.tittle.setText(title);
        holder.info.setText(info);
        Glide.with(context).load(imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.iv);

        holder.forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        return convertView;
    }

    static class Holder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tittle)
        TextView tittle;
        @BindView(R.id.info)
        TextView info;
        @BindView(R.id.forward)
        TextView forward;

        Holder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
