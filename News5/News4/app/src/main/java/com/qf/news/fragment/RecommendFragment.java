package com.qf.news.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qf.news.R;
import com.qf.news.adapter.RecomLvAdapter;
import com.qf.news.adapter.RvAdapter;
import com.qf.news.model.NewsBean;
import com.qf.news.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class RecommendFragment extends Fragment {
    public static final int NEWSBEAN = 1;
    //    @BindView(R.id.rv)
//    RecyclerView rv;
    private ILoadingLayout loadingLayoutProxy;

    @BindView(R.id.lv)
    PullToRefreshListView lv;
    @BindView(R.id.tv_update_num)
    TextView tvUpdateNum;

    private int real = 1;

    private LinearLayoutManager linearLayoutManager;
    private RvAdapter rvAdapter;
    List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist = new ArrayList<>();
    List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> totalList = new ArrayList<>();
    private View view;
    private String id;
    int currentPage = 3;
    private int allPages;
    int count = 0;
    private RecomLvAdapter recomLvAdapter;
    public static final String TAG = "test";
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case NEWSBEAN:
                    int downOrUp = msg.arg1;
                    final NewsBean newsbean = (NewsBean) msg.obj;

                    if (newsbean != null && newsbean.getShowapi_res_body() != null) {
                        totalList = newsbean.getShowapi_res_body().getPagebean().getContentlist();
                        allPages = newsbean.getShowapi_res_body().getPagebean().getAllPages();

                        if (downOrUp == 1) {
                            for (int i = 0; i < totalList.size(); i++) {
                                if (totalList.get(i).getImageurls().size() > 0) {
                                    contentlist.add(0, totalList.get(i));
                                    count++;
                                }
                            }
                            if (currentPage != 3) {
                                lv.onRefreshComplete();

                                tvUpdateNum.setText("成功为你刷新" + count + "条新闻");
                                tvUpdateNum.setVisibility(View.VISIBLE);

                                initAnimation();


                            }

                        } else {
                            for (int i = 0; i < totalList.size(); i++) {
                                if (totalList.get(i).getImageurls().size() > 0) {
                                    contentlist.add(totalList.get(i));
                                    count++;
                                } else {
                                    totalList.remove(i);
                                }
                            }
                            lv.onRefreshComplete();

                            tvUpdateNum.setVisibility(View.VISIBLE);
                            tvUpdateNum.setText("成功为你加载" + count + "条新闻");


                            initAnimation();

                        }

                        recomLvAdapter.setContentlist(contentlist);

                        if (downOrUp == -1) {
                            lv.getRefreshableView().setSelection(recomLvAdapter.getCount() - 1);
                        }

                        setDonwOrUpRefresh();
                    } else {
                        lv.onRefreshComplete();

                        tvUpdateNum.setVisibility(View.VISIBLE);
                        tvUpdateNum.setText("暂无网络");

                        initAnimation();
                    }

                    break;
            }
        }
    };

    private void initAnimation() {
        animation = new TranslateAnimation(0, 0, 0, -90);
        animation.setDuration(1500);
        animation.setFillAfter(false);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tvUpdateNum.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tvUpdateNum.startAnimation(animation);
        lv.startAnimation(animation);
        animation.start();
    }

    private TranslateAnimation animation;


    private void setDonwOrUpRefresh() {
        lv.setMode(PullToRefreshBase.Mode.BOTH);
        loadingLayoutProxy = lv.getLoadingLayoutProxy();
        loadingLayoutProxy.setPullLabel("放开刷新");
        loadingLayoutProxy.setReleaseLabel("放开刷新");
        loadingLayoutProxy.setRefreshingLabel("正在为你更新...");
        //       loadingLayoutProxy.setLastUpdatedLabel("last update at "+new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        loadingLayoutProxy.setLoadingDrawable(getResources().getDrawable(R.mipmap.perm_group_sync_settings));

        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {


            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                count = 0;
                if (currentPage > 1) {
                    if (currentPage > 3) {
                        currentPage = 3;
                        Log.e(TAG, "onPullDownToRefresh: ");
                    }
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.e(TAG, "run: " + (currentPage - 1));
                            getNews(--currentPage, 1);
//
                        }
                    }, 1000);
                } else {
                    lv.onRefreshComplete();
                    tvUpdateNum.setVisibility(View.VISIBLE);
                    tvUpdateNum.setText("暂无最新新闻");

                    initAnimation();
                }

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                count = 0;
                if (currentPage < allPages - 5) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            getNews(++currentPage + 4, -1);
//

                        }
                    }, 1000);

                    lv.getRefreshableView().setSelection(recomLvAdapter.getCount() - 1);

                } else {
                    lv.onRefreshComplete();
                    tvUpdateNum.setVisibility(View.VISIBLE);
                    tvUpdateNum.setText("暂无最新新闻");

                    initAnimation();
                }
            }
        });
    }


    private void getNews(final int page, final int donwOrUp) {

        id = getArguments().getString("id");

        Log.e("weidie", "id: " + id);

        new Thread(new Runnable() {
            @Override
            public void run() {

                String news = HttpUtil.getNews(id, page, getContext());
                NewsBean newsBean = HttpUtil.getNewsBean(news);

                Message message = handler.obtainMessage();

                message.what = NEWSBEAN;
                message.obj = newsBean;
                message.arg1 = donwOrUp;
                handler.sendMessage(message);

            }
        }).start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_recommend, container, false);
            ButterKnife.bind(this, view);

            Log.e("weidie", "recomm onCreateView: ");

            recomLvAdapter = new RecomLvAdapter(getContext());
            lv.setAdapter(recomLvAdapter);

            recomLvAdapter.setContentlist(contentlist);

            getNews(currentPage, 1);
        }


        return view;
    }


}
