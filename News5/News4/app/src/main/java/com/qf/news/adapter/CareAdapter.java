package com.qf.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.qf.news.R;
import com.qf.news.ShowNewsActivity;
import com.qf.news.model.Care;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by weidie on 2016/11/6.
 */
public class CareAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    Context context;
    List<Care> data = new ArrayList<>();


    public CareAdapter(Context context, List<Care> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<Care> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(data!=null&&data.size()>0){
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.care_item, parent,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }else{
            holder=((Holder) convertView.getTag());
        }
        Care care = data.get(position);
        String title = care.getTitle();
        final String url = care.getUrl();
        String date = care.getDate();
        String image = care.getImage();

        holder.tvTitile.setText(title);
        holder.tvAuthor.setText(date);
        Log.e("bmob", "getView: "+url );
        Glide.with(context).load(Uri.parse(image)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.sdv2);
        holder.sdv.setImageURI(image);

        holder.llRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowNewsActivity.class);
                intent.putExtra("link", url);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
    static class Holder {
        @BindView(R.id.tv_titile)
        TextView tvTitile;
        @BindView(R.id.sdv)
        SimpleDraweeView sdv;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.sdv2)
        ImageView sdv2;
        @BindView(R.id.llRoot)
        LinearLayout llRoot;
        @BindView(R.id.cardview)
        CardView cardview;

        Holder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
