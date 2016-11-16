package com.qf.meituan.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.meituan.R;
import com.qf.meituan.beans.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jun on 2016/11/1.
 */
public class HomeRvAdapter extends RecyclerView.Adapter<HomeRvAdapter.Holder> {

    private static final String TAG = "test";
    private final LayoutInflater inflater;
    private Context context;
    private List<HomeBean.DataBean.ItemsBean> list;
    private OnItemClickListener onItemClickListener;

    public HomeRvAdapter(Context context, List<HomeBean.DataBean.ItemsBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_home_goods, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        HomeBean.DataBean.ItemsBean itemsBean = list.get(position);
        if (itemsBean != null) {
            String item_type = itemsBean.getItem_type();
            if ("miaosha".equals(item_type)) {
                holder.rlMiaoshaRoot.setVisibility(View.VISIBLE);
                holder.rlItemRoot.setVisibility(View.GONE);

                String name = itemsBean.getName();
                String usedcount = itemsBean.getUsedcount();
                String states = itemsBean.getStates();
                float count = Float.parseFloat(usedcount);
                int totalCount = itemsBean.getTotalCount();
                int progress = (int) (count * 100 / totalCount);
                String photos = itemsBean.getPhotos();
//                holder.sdvHomePic.setImageURI(Uri.parse(photos));
                Glide.with(context).load(Uri.parse(photos)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.sdvHomePic);
                holder.tvHomeProgress.setText(progress + "%");
                holder.pbHomeProgress.setProgress(progress);
                holder.tvHomeTitle.setText(name);

                holder.rlMiaoshaRoot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(onItemClickListener != null){
                            onItemClickListener.onItemClick(position);
                        }
                    }
                });
            } else {
                holder.rlMiaoshaRoot.setVisibility(View.GONE);
                holder.rlItemRoot.setVisibility(View.VISIBLE);

                String title = itemsBean.getTitle();
                String price = itemsBean.getPrice();
                String likes = itemsBean.getLikes();
                String img = itemsBean.getImg();
//                holder.sdvHomeIiPic.setImageURI(Uri.parse(img));
                Glide.with(context).load(Uri.parse(img)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.sdvHomeIiPic);
                holder.tvHomeIiTitle.setText(title);
                holder.tvHomeIiMoney.setText(price);
                holder.tvHomeIiLove.setText(likes);

                holder.rlItemRoot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(onItemClickListener != null){
                            onItemClickListener.onItemClick(position);
                        }
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
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
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
