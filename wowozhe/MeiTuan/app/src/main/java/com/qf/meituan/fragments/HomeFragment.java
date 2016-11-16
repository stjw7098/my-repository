package com.qf.meituan.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.meituan.Constant;
import com.qf.meituan.HomeGVContentActivity;
import com.qf.meituan.HomeVpContentActivity;
import com.qf.meituan.IndianaDetailActivity;
import com.qf.meituan.R;
import com.qf.meituan.adapters.HomeGvAdapter;
import com.qf.meituan.adapters.HomeRvAdapter;
import com.qf.meituan.adapters.HomeViewPagerAdapter;
import com.qf.meituan.beans.HomeBean;
import com.qf.meituan.utils.HttpUtil;
import com.qf.meituan.utils.JsonUtil;
import com.qf.meituan.utils.ThreadUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jun on 2016/11/1.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "test";
    @BindView(R.id.tv_home_sort)
    TextView tvHomeSort;
    @BindView(R.id.tv_home_search)
    TextView tvHomeSearch;
    @BindView(R.id.vp_home_slide)
    ViewPager vpHomeSlide;
    @BindView(R.id.tv_home_lucky)
    TextView tvHomeLucky;
    @BindView(R.id.tv_home_pan)
    TextView tvHomePan;
    @BindView(R.id.tv_home_baoyou)
    TextView tvHomeBaoyou;
    @BindView(R.id.tv_home_sign)
    TextView tvHomeSign;
    @BindView(R.id.rv_home_goods)
    RecyclerView rvHomeGoods;
    @BindView(R.id.sdv_home_lucky)
    ImageView sdvHomeLucky;
    @BindView(R.id.sdv_home_pan)
    ImageView sdvHomePan;
    @BindView(R.id.sdv_home_baoyou)
    ImageView sdvHomeBaoyou;
    @BindView(R.id.sdv_home_sign)
    ImageView sdvHomeSign;
    @BindView(R.id.rb_home_first)
    RadioButton rbHomeFirst;
    @BindView(R.id.rb_home_second)
    RadioButton rbHomeSecond;
    @BindView(R.id.rb_home_third)
    RadioButton rbHomeThird;
    @BindView(R.id.rb_home_forth)
    RadioButton rbHomeForth;
    @BindView(R.id.rg_home_title)
    RadioGroup rgHomeTitle;
    @BindView(R.id.srl_home_root)
    SwipeRefreshLayout srlHomeRoot;
    @BindView(R.id.sv_home_root)
    ScrollView svHomeRoot;
    @BindView(R.id.ll_home_lucky)
    LinearLayout llHomeLucky;
    @BindView(R.id.ll_home_pan)
    LinearLayout llHomePan;
    @BindView(R.id.ll_home_baoyou)
    LinearLayout llHomeBaoyou;
    @BindView(R.id.ll_home_sign)
    LinearLayout llHomeSign;
    private View view;
    private HomeViewPagerAdapter homeViewPagerAdapter;
    private List<Map<String, Object>> views = new ArrayList<>();
    private List<HomeBean.DataBean.ItemsBean> list = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constant.MSG_WHAT_DEAL_HOME_PAGE:
                    String json = (String) msg.obj;
                    HomeBean homeBean = JsonUtil.parseToHomeBean(json);
                    if (homeBean != null) {
                        dealHomeViewPager(homeBean);
                        dealHomeMenu(homeBean);
                        dealGoods(homeBean);
                    }
                    srlHomeRoot.setRefreshing(false);
                    break;
                case Constant.MSG_WHAT_DEAL_HOME_MORE_PAGE:
                    String moreJson = (String) msg.obj;
                    HomeBean moreHomeBean = JsonUtil.parseToHomeBean(moreJson);
                    if (moreHomeBean != null) {
                        dealMoreGoods(moreHomeBean);
                    }
                    srlHomeRoot.setRefreshing(false);
                    break;
                case Constant.MSG_WHAT_NO_RESPONSE:
                    Toast.makeText(getContext(), "当前无网络连接，或网络连接慢！", Toast.LENGTH_SHORT).show();
                    srlHomeRoot.setRefreshing(false);
                    break;
            }
        }
    };

    private HomeRvAdapter homeRvAdapter;

    private GridLayoutManager gridLayoutManager;
    private int currentPosition = -1;
    private HomeGvAdapter homeGvAdapter;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            play();
        }
    };
    private int currentPage = -1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home, container, false);
            ButterKnife.bind(this, view);

            initData();

            getData(1);

            someMonitor();
        }
        return view;
    }

    private void someMonitor() {
        svHomeRoot.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                srlHomeRoot.setEnabled(svHomeRoot.getScrollY() == 0);
            }
        });

        rvHomeGoods.setOnScrollListener(new RecyclerView.OnScrollListener() {

            private int lastVisibleItemPosition = -1;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && homeRvAdapter != null && lastVisibleItemPosition + 1 == homeRvAdapter.getItemCount()) {
                    srlHomeRoot.setRefreshing(true);
                    Log.e(TAG, "onScrollStateChanged: RecyclerView");
                    ThreadUtil.execute(new Runnable() {
                        @Override
                        public void run() {
                            HttpUtil.getHomePageJson(getContext(), ++currentPage, handler, Constant.MSG_WHAT_DEAL_HOME_MORE_PAGE);
                        }
                    });
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                Log.e(TAG, "lastVisibleItemPosition = " + lastVisibleItemPosition);
//                    lastVisibleItemPosition = gridLayoutManager.findLastCompletelyVisibleItemPosition();
            }
        });

        rgHomeTitle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home_first:
                        vpHomeSlide.setCurrentItem(0);
                        break;
                    case R.id.rb_home_second:
                        vpHomeSlide.setCurrentItem(1);
                        break;
                    case R.id.rb_home_third:
                        vpHomeSlide.setCurrentItem(2);
                        break;
                    case R.id.rb_home_forth:
                        vpHomeSlide.setCurrentItem(3);
                        break;
                }
            }
        });

        vpHomeSlide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < rgHomeTitle.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) rgHomeTitle.getChildAt(i);
                    if (i == position % rgHomeTitle.getChildCount()) {
                        radioButton.setChecked(true);
                        break;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        srlHomeRoot.setColorSchemeColors(getResources().getColor(R.color.pink));
        srlHomeRoot.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.removeCallbacks(runnable);
                getData(1);
            }
        });
    }

    private void getData(final int page) {
        ThreadUtil.execute(new Runnable() {
            @Override
            public void run() {
                HttpUtil.getHomePageJson(getContext(), page, handler, Constant.MSG_WHAT_DEAL_HOME_PAGE);
                currentPage = 1;
            }
        });
    }

    private void initData() {
        gridLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        homeRvAdapter = new HomeRvAdapter(getContext(), list);
        homeRvAdapter.setOnItemClickListener(new HomeRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                HomeBean.DataBean.ItemsBean itemsBean = list.get(position);
                String id = itemsBean.getId();
                int _id = Integer.parseInt(id);
//                Toast.makeText(getContext(), "id = " + id, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), IndianaDetailActivity.class);
                intent.putExtra("id", _id);
                getContext().startActivity(intent);
            }
        });
        rvHomeGoods.setAdapter(homeRvAdapter);
        rvHomeGoods.setLayoutManager(gridLayoutManager);
        rvHomeGoods.setNestedScrollingEnabled(false);
    }

    private void dealGoods(HomeBean homeBean) {
        List<HomeBean.DataBean.ItemsBean> items = homeBean.getData().getItems();
        if (items != null && items.size() > 0) {
            list.clear();
            for (int i = 0; i < items.size(); i++) {
                HomeBean.DataBean.ItemsBean itemsBean = items.get(i);
                String photos = itemsBean.getPhotos();
                String img = itemsBean.getImg();
                if (photos != null || img != null) {
                    list.add(itemsBean);
                }
            }
        }
        homeRvAdapter.notifyDataSetChanged();
    }

    private void dealMoreGoods(HomeBean homeBean) {
        List<HomeBean.DataBean.ItemsBean> items = homeBean.getData().getItems();
        if (items != null && items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                HomeBean.DataBean.ItemsBean itemsBean = items.get(i);
                String photos = itemsBean.getPhotos();
                String img = itemsBean.getImg();
                if (photos != null || img != null) {
                    list.add(itemsBean);
                }
            }
        }
        homeRvAdapter.notifyDataSetChanged();
    }

    private void dealHomeMenu(HomeBean homeBean) {
        List<HomeBean.DataBean.MenuBean> menu = homeBean.getData().getMenu();
        if (menu != null && menu.size() > 0) {
            HomeBean.DataBean.MenuBean menuBean = menu.get(0);
            String icon1 = menuBean.getIcon();
            String title1 = menuBean.getTitle();
            String url1 = menuBean.getUrl();
//            sdvHomeLucky.setImageURI(Uri.parse(icon1));
            Glide.with(getContext()).load(Uri.parse(icon1)).diskCacheStrategy(DiskCacheStrategy.ALL).into(sdvHomeLucky);
            tvHomeLucky.setText(title1);
            llHomeLucky.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), HomeVpContentActivity.class);
                    String url = "http://www.wowozhe.com/app/miaosha/app_rotate_activity/v/310/target/android/imei/aAmOuCDomLsLxlA_n5Xos9uMvdTXV0bFL_tXlZFHe7iIK/uid/3979552/sid/mfbwww";
                    intent.putExtra("url", url);
                    intent.putExtra("title", "幸运转盘");
                    getContext().startActivity(intent);
                }
            });

            menuBean = menu.get(1);
            String icon2 = menuBean.getIcon();
            String title2 = menuBean.getTitle();
            String url2 = menuBean.getUrl();
            Glide.with(getContext()).load(Uri.parse(icon2)).diskCacheStrategy(DiskCacheStrategy.ALL).into(sdvHomePan);
            tvHomePan.setText(title2);
            llHomePan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), HomeVpContentActivity.class);
                    String url = "http://pan.wowozhe.com/index.php";
                    intent.putExtra("url", url);
                    intent.putExtra("title", "网盘");
                    getContext().startActivity(intent);
                }
            });

            menuBean = menu.get(2);
            String icon3 = menuBean.getIcon();
            String title3 = menuBean.getTitle();
            String url3 = menuBean.getUrl();
            Glide.with(getContext()).load(Uri.parse(icon3)).diskCacheStrategy(DiskCacheStrategy.ALL).into(sdvHomeBaoyou);
            tvHomeBaoyou.setText(title3);
            llHomeBaoyou.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), HomeGVContentActivity.class);
                    String url = "http://120.55.198.252/home/m?target=android&v=310&act=home%2Fdata_v2_6&json=%7B%22search%22%3A%7B%22cid%22%3A%2232%22%7D%2C%22pagination%22%3A%7B%22page%22%3A1%7D%7D";
                    intent.putExtra("url", url);
                    intent.putExtra("title", "九块九包邮");
                    getContext().startActivity(intent);
                }
            });

            menuBean = menu.get(3);
            String icon4 = menuBean.getIcon();
            String title4 = menuBean.getTitle();
            String url4 = menuBean.getUrl();
            Glide.with(getContext()).load(Uri.parse(icon4)).diskCacheStrategy(DiskCacheStrategy.ALL).into(sdvHomeSign);
            tvHomeSign.setText(title4);
            llHomeSign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), HomeVpContentActivity.class);
                    String url = "http://www.wowozhe.com/app/miaosha/app_sign//v/310/target/android/imei/aAmOuCDomLsLxlA_n5Xos9uMvdTXV0bFL_tXlZFHe7iIK/uid/3979552/sid/mfbwww";
                    intent.putExtra("url", url);
                    intent.putExtra("title", "签到");
                    getContext().startActivity(intent);
                }
            });
        }
    }

    private void dealHomeViewPager(HomeBean homeBean) {
        List<HomeBean.DataBean.SliderBean> slider = homeBean.getData().getSlider();
        if (slider != null && slider.size() > 0) {
            vpHomeSlide.setVisibility(View.VISIBLE);
            views.clear();
            for (int i = 0; i < slider.size(); i++) {
                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home_vp, null, false);
                HomeBean.DataBean.SliderBean sliderBean = slider.get(i);
                String imgUrl = sliderBean.getImg();
                String url = sliderBean.getUrl();
                String id = sliderBean.getId();
                ImageView imageView = (ImageView) view1.findViewById(R.id.sdv_home_vp);
                Glide.with(getContext()).load(Uri.parse(imgUrl)).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
                HashMap<String, Object> map = new HashMap<>();
                map.put("view", view1);
                map.put("url", url);
                map.put("id", id);
                views.add(map);
            }
            homeViewPagerAdapter = new HomeViewPagerAdapter(getContext(), views);
            vpHomeSlide.setAdapter(homeViewPagerAdapter);
            vpHomeSlide.setCurrentItem(0);
            currentPosition = 0;

            play();
        } else {
            vpHomeSlide.setVisibility(View.GONE);
        }
    }

    public void play() {
        int currentItem = vpHomeSlide.getCurrentItem();
        if (currentItem == 3)
            vpHomeSlide.setCurrentItem(0);
        else
            vpHomeSlide.setCurrentItem(currentItem + 1);
        handler.postDelayed(runnable, 2500);
    }

    @OnClick(R.id.tv_home_search)
    public void onTvHomeSearchClick(){
//        Intent intent = new Intent(getContext(), SearchActivity.class);
//        startActivity(intent);

    }
}
