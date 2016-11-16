package com.qf.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.news.adapter.RvAdapter;
import com.qf.news.model.NavigationBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewsItemActivity extends AppCompatActivity implements RvAdapter.OnItemClickListener {

    private static final String TAG = "test";
    @BindView(R.id.rv_my)
    RecyclerView rvMy;
    @BindView(R.id.rv_all)
    RecyclerView rvAll;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.tv_save)
    TextView tvSave;
    private List<NavigationBean.ShowapiResBodyBean.ChannelListBean> channelListMy = new ArrayList<>();
    private List<NavigationBean.ShowapiResBodyBean.ChannelListBean> channelListAll = new ArrayList<>();
    private List<NavigationBean.ShowapiResBodyBean.ChannelListBean> channelListMyNone = new ArrayList<>();
    private ArrayList<String> chanIds = new ArrayList<>();


    private GridLayoutManager gridLayoutManager;
    private RvAdapter myAdapter;
    private RvAdapter allAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item);
        ButterKnife.bind(this);

        chanIds = getIntent().getStringArrayListExtra("chanIds");

        for (int i = 0; i < chanIds.size(); i++) {
            Log.e("jianwei", "chanidsqq: "+chanIds.get(i));
        }

        NavigationBean navigationBean = (NavigationBean) getIntent().getSerializableExtra("nav");
        channelListAll = navigationBean.getShowapi_res_body().getChannelList();


        for (int i = 0; i < chanIds.size(); i++) {
            for (int i1 = 0; i1 < channelListAll.size(); i1++) {
                if(chanIds.get(i).equals(channelListAll.get(i1).getChannelId())){
                    channelListMy.add(channelListAll.get(i1));
                    channelListAll.remove(channelListAll.get(i1));
                }
            }
        }

        channelListMyNone.addAll(channelListAll);

        allAdapter = new RvAdapter(this);
        initAdapter(allAdapter, channelListMyNone, rvAll, false);

        myAdapter = new RvAdapter(this);
        initAdapter(myAdapter, channelListMy, rvMy, true);

        rvMy.setItemAnimator(new DefaultItemAnimator());
        rvAll.setItemAnimator(new DefaultItemAnimator());


        setResultForNav();


    }


    private void setResultForNav() {
        Intent intent = new Intent();

        intent.putStringArrayListExtra("ids", chanIds);

        setResult(RESULT_OK, intent);
    }

    @NonNull
    private void initAdapter(RvAdapter adapter, List<NavigationBean.ShowapiResBodyBean.ChannelListBean> channelList, RecyclerView rv, boolean b) {
        adapter.setContentlist(channelList);
        gridLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        adapter.setOnItemClickListener(this, b);
        rv.setAdapter(adapter);
        rv.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void setOnItemClickListener(int position, boolean b) {
        Log.e(TAG, "setOnItemClickListener: ");
        if (b) {
            NavigationBean.ShowapiResBodyBean.ChannelListBean bean = channelListMy.get(position);
            String channelId = channelListMy.get(position).getChannelId();

            if(channelListMy.size()>1){
                channelListMyNone.add(bean);
                channelListMy.remove(position);

                chanIds.remove(position);

                myAdapter.notifyDataSetChanged();
                allAdapter.notifyDataSetChanged();
            }else{
                Toast.makeText(NewsItemActivity.this, "很抱歉！请至少留下一个栏目", Toast.LENGTH_SHORT).show();
            }



        } else {

            NavigationBean.ShowapiResBodyBean.ChannelListBean bean = channelListMyNone.get(position);
            channelListMy.add(bean);
            channelListMyNone.remove(position);

            chanIds.add(bean.getChannelId());

            myAdapter.notifyDataSetChanged();
            allAdapter.notifyDataSetChanged();
        }


    }

    @OnClick(R.id.tv_back)

    public void onClick(View v) {

        finish();

    }

    @OnClick(R.id.tv_save)

    public void onClickSave(View v) {
        Toast.makeText(NewsItemActivity.this, "保存成功", Toast.LENGTH_SHORT).show();

        finish();

    }


}
