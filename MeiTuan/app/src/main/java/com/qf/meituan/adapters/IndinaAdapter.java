package com.qf.meituan.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.meituan.IndianaDetailActivity;
import com.qf.meituan.MainActivity;
import com.qf.meituan.R;
import com.qf.meituan.beans.IndianaBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by administractor on 2016/11/1.
 */
public class IndinaAdapter extends BaseAdapter {

    private static final String TAG = "test";
    Context context;
    List<IndianaBean.DataBean> data;

    public IndinaAdapter(Context context, List<IndianaBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_indiana, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = ((Holder) convertView.getTag());
        }

        final IndianaBean.DataBean dataBean = data.get(position);
        String dataBeanId = dataBean.getId();
        final int id = Integer.parseInt(dataBeanId);
        String bitmapUrl = dataBean.getPhotos();
        String short_name = dataBean.getShort_name();
        float money = Float.parseFloat(dataBean.getMoney());
        int usedcount = Integer.parseInt(dataBean.getUsedcount());
        float progress = usedcount / money;
        holder.pb.setProgress(usedcount / 100);

        Glide.with(context).load(bitmapUrl).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ivImage);
        holder.tvCommodity.setText(short_name);
        holder.tv.setText(usedcount / 100 + "%");

        holder.llIndiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, IndianaDetailActivity.class);
                intent.putExtra("id",id);
                Log.e(TAG, "onClick: id="+id );
                ((MainActivity) context).startActivityForResult(intent,1);
            }
        });

        holder.tvShopCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(data.get(position));
            }
        });

        return convertView;
    }


    class Holder {
        @BindView(R.id.ivImage)
        ImageView ivImage;
        @BindView(R.id.tvCommodity)
        TextView tvCommodity;
        @BindView(R.id.tvP)
        TextView tvP;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.pb)
        ProgressBar pb;
        @BindView(R.id.llIndiana)
        LinearLayout llIndiana;
        @BindView(R.id.tvShopCart)
        TextView tvShopCart;

        Holder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
