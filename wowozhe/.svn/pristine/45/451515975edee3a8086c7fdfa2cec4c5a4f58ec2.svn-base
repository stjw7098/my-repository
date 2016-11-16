package com.qf.meituan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.qf.meituan.adapters.HomeGvAdapter;
import com.qf.meituan.beans.HomeGVBean;
import com.qf.meituan.utils.HttpUtil;
import com.qf.meituan.utils.JsonUtil;
import com.qf.meituan.utils.ThreadUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jun on 2016/11/2.
 */
public class HomeGVContentActivity extends AppCompatActivity {

    @BindView(R.id.tv_vp_content_back_ii)
    TextView tvVpContentBackIi;
    @BindView(R.id.tv_vp_content_title_ii)
    TextView tvVpContentTitleIi;
    @BindView(R.id.gv_vp_content_ii)
    GridView gvVpContentIi;
    private List<HomeGVBean.DataBean.ItemsBean> list = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case Constant.MSG_WHAT_DEAL_HOME_VP:
                    String json = (String) msg.obj;
                    HomeGVBean homeGVBean = JsonUtil.parseToHomeGVBean(json);
                    if(homeGVBean != null){
                        List<HomeGVBean.DataBean.ItemsBean> items = homeGVBean.getData().getItems();
                        list.clear();
                        list.addAll(items);
                        homeGvAdapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    };
    private HomeGvAdapter homeGvAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_gridview);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        final String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");

        tvVpContentTitleIi.setText(title);

        tvVpContentBackIi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ThreadUtil.execute(new Runnable() {
            @Override
            public void run() {
                HttpUtil.getHomeVpJson(HomeGVContentActivity.this, url, handler, Constant.MSG_WHAT_DEAL_HOME_VP);
            }
        });

        homeGvAdapter = new HomeGvAdapter(this, list);
        gvVpContentIi.setAdapter(homeGvAdapter);
    }
}
