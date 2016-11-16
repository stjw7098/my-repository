package com.qf.meituan.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.meituan.HomeVpContentActivity;
import com.qf.meituan.R;
import com.qf.meituan.beans.HomeGVBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jun on 2016/11/2.
 */
public class HomeGvAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private Context context;
    private List<HomeGVBean.DataBean.ItemsBean> list;

    public HomeGvAdapter(Context context, List<HomeGVBean.DataBean.ItemsBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
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
            convertView = inflater.inflate(R.layout.item_home_goods, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }else{
            holder = ((Holder) convertView.getTag());
        }

        holder.rlItemRoot.setVisibility(View.VISIBLE);
        holder.rlMiaoshaRoot.setVisibility(View.GONE);

        HomeGVBean.DataBean.ItemsBean itemsBean = list.get(position);
        if(itemsBean != null){
            final String title = itemsBean.getTitle();
            String img = itemsBean.getImg();
            String likes = itemsBean.getLikes();
            String price = itemsBean.getPrice();
            final String item_url = itemsBean.getItem_url();

            Glide.with(context).load(Uri.parse(img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.sdvHomeIiPic);
            holder.tvHomeIiTitle.setText(title);
            holder.tvHomeIiLove.setText(likes);
            holder.tvHomeIiMoney.setText(price);

            holder.rlItemRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, HomeVpContentActivity.class);
                    intent.putExtra("url", item_url);
                    intent.putExtra("title", title);
                    context.startActivity(intent);
                }
            });
        }

        return convertView;
    }

    class Holder {
        @BindView(R.id.sdv_home_pic)
        ImageView sdvHomePic;
        @BindView(R.id.tv_home_mark)
        TextView tvHomeMark;
        @BindView(R.id.tv_home_title)
        TextView tvHomeTitle;
        @BindView(R.id.tv_home_progress)
        TextView tvHomeProgress;
        @BindView(R.id.pb_home_progress)
        ProgressBar pbHomeProgress;
        @BindView(R.id.rl_miaosha_root)
        RelativeLayout rlMiaoshaRoot;
        @BindView(R.id.sdv_home_ii_pic)
        ImageView sdvHomeIiPic;
        @BindView(R.id.tv_home_ii_mark)
        TextView tvHomeIiMark;
        @BindView(R.id.tv_home_ii_title)
        TextView tvHomeIiTitle;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv_home_ii_money)
        TextView tvHomeIiMoney;
        @BindView(R.id.tv_home_ii_love)
        TextView tvHomeIiLove;
        @BindView(R.id.rl_item_root)
        RelativeLayout rlItemRoot;

        Holder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
