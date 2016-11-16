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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qf.news.R;
import com.qf.news.adapter.SearchAdapter;
import com.qf.news.model.NewsBean;
import com.qf.news.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class FragmentSearch extends Fragment {
    View view;
    @BindView(R.id.tvBack)
    TextView tvBack;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.tvSearch)
    TextView tvSearch;
    @BindView(R.id.lvRecent)
    ListView lvRecent;
    @BindView(R.id.lvResult)
    PullToRefreshListView lvResult;
    String search;
    private static final int SEARCH = 1;
    private static final int NORESULT = 2;
    public static final String TAG = "test";
    private ILoadingLayout loadingLayoutProxy;
    private int currentPage=1;
    private TextView tvUpdateNum;
    private SearchAdapter adapter;
    private List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist=new ArrayList<>();
    private List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> totalList=new ArrayList<>();
    int allPages;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case NORESULT:
                    Toast.makeText(getContext(), "搜索字段不能为空", Toast.LENGTH_SHORT).show();
                    break;

                case SEARCH:
                    NewsBean newsBean = (NewsBean) msg.obj;

                    if(newsBean!=null&&newsBean.getShowapi_res_body()!=null){
                        allPages = newsBean.getShowapi_res_body().getPagebean().getAllPages();

                        totalList = newsBean.getShowapi_res_body().getPagebean().getContentlist();
                        contentlist.addAll(totalList);

                        adapter = new SearchAdapter(getContext(),contentlist);
                        lvResult.setAdapter(adapter);
                        lvResult.getRefreshableView().setSelection(adapter.getCount()-10);

                    }else{
                        Toast.makeText(getContext(), "很抱歉!搜不到相关数据.", Toast.LENGTH_SHORT).show();
                    }



                    lvResult.setMode(PullToRefreshBase.Mode.BOTH);
                    loadingLayoutProxy = lvResult.getLoadingLayoutProxy();
                    loadingLayoutProxy.setPullLabel("放开刷新");
                    loadingLayoutProxy.setReleaseLabel("放开刷新");
                    loadingLayoutProxy.setRefreshingLabel("正在为你更新...");
                    //       loadingLayoutProxy.setLastUpdatedLabel("last update at "+new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
                    loadingLayoutProxy.setLoadingDrawable(getResources().getDrawable(R.mipmap.perm_group_sync_settings));

                    lvResult.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {


                        @Override
                        public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                            tvUpdateNum.setVisibility(View.VISIBLE);
                            tvUpdateNum.setText("请向上拉为你加载新数据");
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    tvUpdateNum.setVisibility(View.GONE);
                                    lvResult.onRefreshComplete();
                                }
                            },1000);
                        }

                        @Override
                        public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                            if(currentPage<allPages){

                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        getVideo(++currentPage);
                                        tvUpdateNum.setVisibility(View.VISIBLE);
                                        tvUpdateNum.setText("成功为你加载20个视频");

                                        Log.e(TAG, "count: "+ (adapter.getCount()-1));
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                tvUpdateNum.setVisibility(View.GONE);
                                            }
                                        },1000);

                                        lvResult.onRefreshComplete();

                                    }
                                }, 1000);



                            }else{
                                lvResult.onRefreshComplete();
                                tvUpdateNum.setVisibility(View.VISIBLE);
                                tvUpdateNum.setText("暂无最新新闻");
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        tvUpdateNum.setVisibility(View.GONE);
                                    }
                                },1000);
                            }
                        }
                    });

                    break;
            }
        }
    };



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {

            view = inflater.inflate(R.layout.fragment_search, container, false);
            tvUpdateNum = ((TextView) view.findViewById(R.id.tv_update_num));
            ButterKnife.bind(this, view);



        }
        return view;
    }

    @OnClick(R.id.tvSearch)
    public void onClick(View v) {
        getVideo(1);
    }

    private void getVideo(final int currentPage) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                search = etSearch.getText().toString();
                search=search.trim();
                Log.e(TAG, "search "+search );
                if(search!=null&&search!=""){
                    Log.e(TAG, "onCreateView: "+search );
                    String searchJson = HttpUtil.getSearch(search, currentPage);
                    Log.e(TAG, "run: "+searchJson );
                    NewsBean newsBean = HttpUtil.getNewsBean(searchJson);
                    Log.e(TAG, "run: "+newsBean );
                    Message message = handler.obtainMessage();
                    message.what= SEARCH;
                    message.obj=newsBean;
                    handler.sendMessage(message);
                }else{
                    Log.e(TAG, "no result" );
                    Message message = handler.obtainMessage();
                    message.what= NORESULT;
                    message.obj=1;
                    handler.sendMessage(message);
                }

            }
        }).start();

    }

    @OnClick(R.id.tvBack)
    public void onClickBack(View v) {
        if(mgoToHome!=null){
            mgoToHome.setHome();
        }
    }

    static GoToHome mgoToHome;

    public static void setGoToHome(GoToHome goToHome) {
        mgoToHome = goToHome;
    }

    public interface GoToHome {
        void setHome();
    }
}
