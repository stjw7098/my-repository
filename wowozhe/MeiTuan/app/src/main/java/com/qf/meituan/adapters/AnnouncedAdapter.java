package com.qf.meituan.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.meituan.AnnouncedDetailActivity;
import com.qf.meituan.R;
import com.qf.meituan.beans.AnnouncedBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by administractor on 2016/11/1.
 */
public class AnnouncedAdapter extends BaseAdapter {

    Context context;
    List<AnnouncedBean.DataBean> data;
    LayoutInflater inflater;
    private String winnumber;
    private String win_nickname;
    private String join_num;

    public AnnouncedAdapter(Context context, List<AnnouncedBean.DataBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_announced,parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }else{
            holder = ((Holder) convertView.getTag());
        }
        String name = data.get(position).getName();
        String photos = data.get(position).getPhotos();
        final String id = data.get(position).getId();
        if(data.get(position).getJoin_num()!=null){
            join_num = data.get(position).getJoin_num();
        }

        if( data.get(position).getWinnumber()!=null){
            winnumber = data.get(position).getWinnumber();
        }

        if(data.get(position).getWinner_info()!=null){
            win_nickname = data.get(position).getWinner_info().getWin_nickname();
        }

        String nper = data.get(position).getNper();
        String month = nper.substring(0, 2);
        String day = nper.substring(2, 4);
        String hour = nper.substring(4, 6);
        String minute = nper.substring(6, 8);

        Glide.with(context).load(Uri.parse(photos)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ivImage);
        holder.tvCommodity.setText(name);
        holder.tvWinner2.setText(win_nickname);
        holder.tvPerson2.setText(join_num);
        holder.tvIndiana2.setText(winnumber);
        holder.tvTime2.setText(month+"-"+day+" "+hour+":"+minute);

        holder.rlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AnnouncedDetailActivity.class);
                intent.putExtra("id",id);
                context.startActivity(intent);
            }
        });




        return convertView;
    }


    class Holder {
        @BindView(R.id.rlRoot)
        RelativeLayout rlRoot;
        @BindView(R.id.ivImage)
        ImageView ivImage;
        @BindView(R.id.tvCommodity)
        TextView tvCommodity;
        @BindView(R.id.tvWinner1)
        TextView tvWinner1;
        @BindView(R.id.tvWinner2)
        TextView tvWinner2;
        @BindView(R.id.tvPersons1)
        TextView tvPersons1;
        @BindView(R.id.tvPerson2)
        TextView tvPerson2;
        @BindView(R.id.tvIndiana1)
        TextView tvIndiana1;
        @BindView(R.id.tvIndiana2)
        TextView tvIndiana2;
        @BindView(R.id.tvTime1)
        TextView tvTime1;
        @BindView(R.id.tvTime2)
        TextView tvTime2;

        Holder(View view) {
            ButterKnife.bind(this, view);
        }
    }



}
