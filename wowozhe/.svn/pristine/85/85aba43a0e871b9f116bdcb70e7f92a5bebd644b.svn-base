package com.qf.meituan.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qf.meituan.FindItemOponActivity;
import com.qf.meituan.R;
import com.qf.meituan.adapters.FindAdapter;
import com.qf.meituan.beans.FindBean;
import com.qf.meituan.utils.HttpUtil;
import com.qf.meituan.utils.JsonUtil;
import com.qf.meituan.utils.ThreadUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class FindFragment extends Fragment {


    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.sRLRoot)
    SwipeRefreshLayout sRLRoot;
    private View view;
    private FindAdapter findAdapter;
    private FindBean findBean;
    private List<FindBean.DataBean> data=new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String json = (String) msg.obj;
                    findBean = JsonUtil.findBeanJson(json);

                    if(findBean!=null){
                        List<FindBean.DataBean> dataBean = findBean.getData();
                        for (int i = 0; i < dataBean.size(); i++) {
                            data.add(dataBean.get(i));
                        }
                    }
                    findAdapter.notifyDataSetChanged();
                    Log.e("test", "handleMessage: " + json);
                    break;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.find_fragment, container, false);
            ButterKnife.bind(this, view);
        }


        findAdapter = new FindAdapter(getContext(), data);
        lv.setAdapter(findAdapter);
        sRLRoot.setColorSchemeColors(new int[]{Color.RED,Color.BLUE,Color.GREEN,Color.CYAN});
        getJson();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FindItemOponActivity.class);
                String url = data.get(position).getUrl();
                intent.putExtra("url",url);
                startActivity(intent);
//                   findAdapter.notifyDataSetChanged();
            }
        });


        sRLRoot.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sRLRoot.setRefreshing(false);
                    }
                }, 3000);

            }
        });


        return view;
    }

    private void getJson() {
        ThreadUtil.execute(new Runnable() {
            @Override
            public void run() {

                String json = HttpUtil.getFind(getContext());
                Message message = handler.obtainMessage();
                message.obj = json;
                message.what = 1;
                handler.sendMessage(message);
            }
        });
    }


}
