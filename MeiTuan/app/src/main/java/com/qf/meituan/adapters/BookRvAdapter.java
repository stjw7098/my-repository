package com.qf.meituan.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qf.meituan.R;
import com.qf.meituan.beans.Dingdan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public class BookRvAdapter extends RecyclerView.Adapter<BookRvAdapter.ViewHolder> {
    Context context;
    List<Dingdan> data = new ArrayList<>();
    int []images=new int[]{
            R.mipmap.shopcar,
            R.mipmap.shopcar2,
            R.mipmap.shopcar3
    };

    private View view;


    public BookRvAdapter(Context context, List<Dingdan> data) {
        this.context = context;
        this.data = data;
    }

    public void setData(List<Dingdan> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Dingdan dingdan = data.get(position);
        String createdAt = dingdan.getCreatedAt();
        String num = dingdan.getNum();
        String price = dingdan.getPrice();
        final String objectId = dingdan.getObjectId();


        int image = images[new Random().nextInt(images.length)];

        holder.tvBookCount2.setText(num+"种");
        holder.tvBookNum2.setText(objectId);
        holder.tvBookPrice2.setText(price+"元");
        holder.tvBookTime2.setText(createdAt);
        holder.sdv2.setImageResource(image);


        holder.llRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBookItemClickListener != null) {
                    onBookItemClickListener.setOnItemClickListener(objectId);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_book_num)
        TextView tvBookNum;
        @BindView(R.id.tv_book_num2)
        TextView tvBookNum2;
        @BindView(R.id.tv_book_time)
        TextView tvBookTime;
        @BindView(R.id.tv_book_time2)
        TextView tvBookTime2;
        @BindView(R.id.tv_book_count)
        TextView tvBookCount;
        @BindView(R.id.tv_book_count2)
        TextView tvBookCount2;
        @BindView(R.id.tv_book_price)
        TextView tvBookPrice;
        @BindView(R.id.tv_book_price2)
        TextView tvBookPrice2;
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

    OnBookItemClickListener onBookItemClickListener;

    public void setOnBookItemClickListener(OnBookItemClickListener onItemClickListener) {
        this.onBookItemClickListener = onItemClickListener;
    }

    public interface OnBookItemClickListener {
        void setOnItemClickListener(String objectId);
    }
}
