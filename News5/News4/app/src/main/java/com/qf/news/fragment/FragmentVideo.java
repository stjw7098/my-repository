package com.qf.news.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qf.news.R;
import com.qf.news.adapter.VideoBeanAdapter;
import com.qf.news.model.VideoBean;
import com.qf.news.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class FragmentVideo extends Fragment {
    View view;
    public static final int VIDEOBEAN = 1;
    @BindView(R.id.tv_update_num)
    TextView tvUpdateNum;
    @BindView(R.id.lv)
    PullToRefreshListView lv;
    private VideoBean videoBean;
    private List<VideoBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist = new ArrayList<>();
    public static final String TAG = "test";
    private VideoBeanAdapter adapter;
    public ILoadingLayout loadingLayoutProxy;
    int currentPage = 100;
    private int allPages;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case VIDEOBEAN:
                    videoBean = ((VideoBean) msg.obj);
                    contentlist.clear();
                    if (videoBean != null && videoBean.getShowapi_res_body() != null) {
//
                        if(videoBean.getShowapi_res_body().getPagebean() != null&&videoBean.getShowapi_res_body().getPagebean().getContentlist() != null){
                            contentlist.addAll(videoBean.getShowapi_res_body().getPagebean().getContentlist());
                            adapter.notifyDataSetChanged();
                            lv.getRefreshableView().setSelection(0);
                        }

                    }

                    setDownOrUpRefresh();


                    break;
            }
        }
    };

    private void setDownOrUpRefresh() {
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

                if (currentPage > 1) {
                    if (currentPage > 100) {
                        currentPage = 100;
                        Log.e(TAG, "onPullDownToRefresh: ");
                    }
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.e(TAG, "run: " + (currentPage - 1));
                            getVideo(--currentPage);
                            tvUpdateNum.setVisibility(View.VISIBLE);
                            tvUpdateNum.setText("成功为你刷新20个视频");


                            lv.onRefreshComplete();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    tvUpdateNum.setVisibility(View.GONE);
                                }
                            }, 1000);
                        }
                    }, 1000);
                } else {
                    lv.onRefreshComplete();
                    tvUpdateNum.setVisibility(View.VISIBLE);
                    tvUpdateNum.setText("暂无最新新闻");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvUpdateNum.setVisibility(View.GONE);
                        }
                    }, 1000);
                }

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (currentPage < allPages) {
                    if (currentPage < 100) {
                        currentPage = 100;
                        Log.e(TAG, "onPullDownToRefresh: ");
                    }
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            getVideo(++currentPage);
                            tvUpdateNum.setVisibility(View.VISIBLE);
                            tvUpdateNum.setText("成功为你加载20个视频");

                            Log.e(TAG, "count: " + (adapter.getCount() - 1));
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    tvUpdateNum.setVisibility(View.GONE);
                                }
                            }, 1000);

                            lv.onRefreshComplete();

                        }
                    }, 1000);


                } else {
                    lv.onRefreshComplete();
                    tvUpdateNum.setVisibility(View.VISIBLE);
                    tvUpdateNum.setText("暂无最新新闻");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvUpdateNum.setVisibility(View.GONE);
                        }
                    }, 1000);
                }
            }
        });
    }

    private void getVideo(final int page) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                String videoJson = HttpUtil.getVideo(page, getContext());
                Log.e(TAG, "videoJson: " + videoJson);
                VideoBean videoBean = HttpUtil.getVideoBean(videoJson);
                if (videoBean != null && videoBean.getShowapi_res_body() != null) {
                    if(videoBean.getShowapi_res_body().getPagebean() != null&&videoBean.getShowapi_res_body().getPagebean().getAllPages()>0){
                        allPages = videoBean.getShowapi_res_body().getPagebean().getAllPages();
                    }

                }

                Log.e(TAG, "videoBean: " + videoBean);
                Message message = handler.obtainMessage();
                message.what = VIDEOBEAN;
                message.obj = videoBean;
                handler.sendMessage(message);
            }
        }).start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_video, container, false);
            ButterKnife.bind(this, view);

            adapter = new VideoBeanAdapter(getContext(), contentlist);
            lv.setAdapter(adapter);

            getVideo(100);
        }

        return view;
    }

    @OnClick(R.id.tvBack)
    public void onClickBack(View v) {
        if(mgoToHouse !=null){
            mgoToHouse.setHouse();
        }
    }

    static GoToHouse mgoToHouse;

    public static void setGoToHouse(GoToHouse goToHouse) {
        mgoToHouse = goToHouse;
    }

    public interface GoToHouse {
        void setHouse();
    }


}
