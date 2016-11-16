package com.qf.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qf.news.R;
import com.qf.news.model.NavigationBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.Holder> {
    int[] heads = new int[]{R.mipmap.head1, R.mipmap.head3};
    Context context;

    private View view;
    private List<NavigationBean.ShowapiResBodyBean.ChannelListBean> channelList;
    private String imageUrl;
    private boolean b;

    public RvAdapter(Context context) {
        this.context = context;
    }

    public void setContentlist(List<NavigationBean.ShowapiResBodyBean.ChannelListBean> channelList) {
        this.channelList = channelList;
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.gv_my_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        String name = channelList.get(position).getName();
        String chanId = channelList.get(position).getChannelId();

        holder.tvPindao.setText(name);

        holder.llRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.setOnItemClickListener(position,b);
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return channelList.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_pindao)
        TextView tvPindao;
        @BindView(R.id.llRoot)
        LinearLayout llRoot;

        Holder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener,boolean flag) {
        b = flag;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void setOnItemClickListener(int position,boolean b);
    }
}
