package com.qf.news.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.qf.news.R;
import com.qf.news.model.Care;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public class CareRvAdapter extends RecyclerView.Adapter <CareRvAdapter.ViewHolder>{
    Context context;
    List<Care> data = new ArrayList<>();
    private View view;


    public CareRvAdapter(Context context, List<Care> data) {
        this.context = context;
        this.data = data;
    }

    public void setData(List<Care> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.care_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
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
                if(onCareItemClickListener!=null){
                    onCareItemClickListener.setOnItemClickListener(url);
                }
            }
        });

    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
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

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    OnCareItemClickListener onCareItemClickListener;

    public void setOnCareItemClickListener(OnCareItemClickListener onItemClickListener) {
        this.onCareItemClickListener = onItemClickListener;
    }

    public interface OnCareItemClickListener {
        void setOnItemClickListener(String url);
    }
}
