package com.qf.meituan.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.qf.meituan.R;
import com.qf.meituan.beans.Goods;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public class GoodRvAdapter extends RecyclerView.Adapter<GoodRvAdapter.ViewHolder> {
    Context context;
    List<Goods> data = new ArrayList<>();

    private View view;


    public GoodRvAdapter(Context context, List<Goods> data) {
        this.context = context;
        this.data = data;
    }

    public void setData(List<Goods> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.goods_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Goods goods = data.get(position);
        String image = goods.getImage();
        String num = goods.getNum();
        String name = goods.getName();


        holder.tvTitile.setText(name);
        holder.tvNum.setText(num);

        Glide.with(context).load(Uri.parse(image)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.sdv2);



        holder.llRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onGoodItemClickListener != null) {
 //                   onBookItemClickListener.setOnItemClickListener();
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
        @BindView(R.id.tv_num)
        TextView tvNum;
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

    OnGoodItemClickListener onGoodItemClickListener;

    public void setOnGoodItemClickListener(OnGoodItemClickListener onItemClickListener) {
        this.onGoodItemClickListener = onItemClickListener;
    }

    public interface OnGoodItemClickListener {
        void setOnItemClickListener(String objectId);
    }
}
