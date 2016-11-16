package com.qf.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
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
import com.qf.news.model.NewsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by weidie on 2016/10/23.
 */
public class SearchAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    Context context;
    List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist = new ArrayList<>();
    private Holder holder;


    public SearchAdapter(Context context, List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist) {
        this.context = context;
        this.contentlist = contentlist;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return contentlist.size();
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.recommend_item, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }else{
            holder=((Holder) convertView.getTag());
        }

        String title = contentlist.get(position).getTitle();
        String pubDate = contentlist.get(position).getPubDate();
        final String link = contentlist.get(position).getLink();

        if(contentlist.get(position).getImageurls().size()>0&&contentlist.get(position).getImageurls()!=null){
            holder.sdv2.setVisibility(View.VISIBLE);
            String imageUrl = contentlist.get(position).getImageurls().get(0).getUrl();
            holder.sdv.setImageURI(imageUrl);
            Glide.with(context).load(Uri.parse(imageUrl)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.sdv2);
        }else {
            holder.sdv2.setVisibility(View.GONE);
            holder.sdv.setBackgroundResource(R.mipmap.head3);
        }

        holder.tvTitile.setText(title);
        holder.tvAuthor.setText(pubDate);

        holder.llRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowNewsActivity.class);
                intent.putExtra("link", link);
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
