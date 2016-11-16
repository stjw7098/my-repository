package com.qf.news.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qf.news.NewsItemActivity;
import com.qf.news.R;
import com.qf.news.adapter.ViewPagerAdapter;
import com.qf.news.model.NavigationBean;
import com.qf.news.util.HttpUtil;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class FragmentHome extends Fragment {
    private static final int INVIGATION_INFO = 1;
    private static final String TAG = "test";
    View view;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    private ViewPagerAdapter adapter;
    List<Fragment> fragments = new ArrayList<>();
    ArrayList<String> chanIds = new ArrayList<>();
    Set<String> set = new LinkedHashSet<>();
    private SharedPreferences spChanids;
    private SharedPreferences.Editor edit;
    private Set<String> cids=new LinkedHashSet<>();
    private NavigationBean navigationBean;
    private String navJson;
    private int totalNum;
    private List<NavigationBean.ShowapiResBodyBean.ChannelListBean> channelList=new ArrayList<>();
    private List<NavigationBean.ShowapiResBodyBean.ChannelListBean> spchannelList=new ArrayList<>();
    private List<NavigationBean.ShowapiResBodyBean.ChannelListBean> realchannelList=new ArrayList<>();
    private List<String> channNames = new ArrayList<>();
    private List<String> sparrs = new ArrayList<>();

    private RecommendFragment recommendFragment;
    private ArrayList<String> ids;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case INVIGATION_INFO:
                    channelList = (List<NavigationBean.ShowapiResBodyBean.ChannelListBean>) msg.obj;
                    totalNum = msg.arg1;

                    if (cids==null) {
                        Log.e("situ", "cids==null: " );
                        for (int i = 0; i < 8; i++) {
                            recommendFragment = new RecommendFragment();
                            Bundle bundle = new Bundle();
                            String channelId = channelList.get(i).getChannelId();
                            chanIds.add(channelId);

                            bundle.putString("id", channelId);

                            Log.e("weidie", "handleMessage: " + channelId);
                            recommendFragment.setArguments(bundle);
                            fragments.add(recommendFragment);
                        }
                        tab.setupWithViewPager(vp);
                        adapter = new ViewPagerAdapter(getChildFragmentManager(), fragments, channelList);
                        vp.setAdapter(adapter);

                    }else{
                        Log.e("situ", "cids!=null: " );

                        for (String cid : cids) {
                            recommendFragment = new RecommendFragment();
                            Bundle bundle = new Bundle();

                            Log.e("jianwei", "cid: "+cid);

                            chanIds.add(cid);


                            for (int i = 0; i < channelList.size(); i++) {
                                if(cid.equals(channelList.get(i).getChannelId())){
                                    spchannelList.add(channelList.get(i));
                                }
                            }

                            bundle.putString("id", cid);
                            recommendFragment.setArguments(bundle);
                            fragments.add(recommendFragment);

//                            sparrs.add(cid);

                        }




                        adapter = new ViewPagerAdapter(getChildFragmentManager(), fragments,spchannelList);
                        vp.setAdapter(adapter);

                        tab.setupWithViewPager(vp);
                    }



                    tvAdd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(), NewsItemActivity.class);
                            intent.putExtra("nav", navigationBean);
                            intent.putStringArrayListExtra("chanIds", chanIds);
                            startActivityForResult(intent, 100);

                            for (int i = 0; i < chanIds.size(); i++) {
                                Log.e("jianwei", "chanids: "+chanIds.get(i));
                            }

                        }
                    });
                    break;

            }
        }

    };



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult: ");
        if (requestCode == 100) {
            ids = data.getStringArrayListExtra("ids");

            set.clear();

            for (int i = 0; i < ids.size(); i++) {
                set.add(ids.get(i));

            }
            for (String s : set) {
                Log.e("jianwei", "ids: "+s );
            }

            edit = spChanids.edit();
            edit.putStringSet("chanid", set);
            edit.commit();

            fragments.clear();
            chanIds.clear();
            channNames.clear();
            for (int i = 0; i < ids.size(); i++) {
                RecommendFragment recommendFragment = new RecommendFragment();
                Bundle bundle = new Bundle();
                String channelId = ids.get(i);
                chanIds.add(channelId);

                bundle.putString("id", channelId);

                Log.e("weidie", "chanid " + channelId);
                recommendFragment.setArguments(bundle);
                fragments.add(recommendFragment);

            }
            for (int i = 0; i < ids.size(); i++) {
                for (int j = 0; j < channelList.size(); j++) {
                    if (channelList.get(j).getChannelId().equals(ids.get(i))) {
                        channNames.add(channelList.get(j).getName());
             //           realchannelList.add(channelList.get(j));
                        Log.e(TAG, "onActivityResult: " + channelList.get(j).getName());
                    }
                }
            }


            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext(),getChildFragmentManager(), fragments, channNames);
            vp.setAdapter(viewPagerAdapter);

            tab.setupWithViewPager(vp);
            //这句话绝对不能放在适配adapter前面，否则爆炸
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spChanids = getContext().getSharedPreferences("chanids", Context.MODE_PRIVATE);

        cids = spChanids.getStringSet("chanid", null);
        if(cids!=null){
            for (String cid : cids) {
                Log.e("situ", "cid: "+cid);
            }

        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                navJson = HttpUtil.getNavigation(getContext());
                Log.e("situ", "weidie oncreate");
                if (navJson != null) {
                    navigationBean = HttpUtil.getNavigationBean(navJson);
                    if (navigationBean != null && navigationBean.getShowapi_res_body() != null) {
                        totalNum = navigationBean.getShowapi_res_body().getTotalNum();
                        channelList = navigationBean.getShowapi_res_body().getChannelList();
                        Log.e("test", "totalnum: " + totalNum);
                        Log.e("test", "list: " + channelList.get(1).getName());
                        Message message = handler.obtainMessage();
                        message.what = INVIGATION_INFO;
                        message.obj = channelList;
                        message.arg1 = totalNum;
                        handler.sendMessage(message);
                    }

                }


            }
        }).start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home, container, false);
            ButterKnife.bind(this, view);

        }
        return view;
    }
}
