package com.qf.meituan.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.meituan.R;
import com.qf.meituan.adapters.ShoppingCartAdapter;
import com.qf.meituan.beans.Dingdan;
import com.qf.meituan.beans.Goods;
import com.qf.meituan.beans.IndianaBean;
import com.qf.meituan.beans.MyUser;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobRelation;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class ShoppingCartFragment extends Fragment {

    private long currentTime, totalTime = 0;
    private static final String TAG = "test";
    private static AlertDialog alertDialog;
    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.sRLRoot)
    SwipeRefreshLayout sRLRoot;

    @BindView(R.id.tvCommit)
    TextView tvCommit;
    @BindView(R.id.llCommit)
    LinearLayout llCommit;
    @BindView(R.id.tvGoIndiana)
    TextView tvGoIndiana;
    private View view;
    private static int lvChildCount = 0;
    public static int isShow = 0;
    private Handler handler = new Handler();
    private List<IndianaBean.DataBean> data = new ArrayList<>();
    private ShoppingCartAdapter shoppingCartAdapter;

    private static TextView tvGoods;
    private static TextView tvMoney;
    private Button mBtn;
    public static LinearLayout llNone;
    private static String allMoneyStr;
    //    public static LinearLayout llCommit;

    /**
     * 设置按钮点击的回调
     *
     * @author zhy
     */
//    public interface FOneBtnClickListener {
//        void onFOneBtnClick();
//    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.shopping_cart_fragment, container, false);
            ButterKnife.bind(this, view);

            tvGoods = ((TextView) view.findViewById(R.id.tvGoods));
            tvMoney = ((TextView) view.findViewById(R.id.tvMoney));
//            llCommit = ((LinearLayout) view.findViewById(R.id.llCommit));
            llNone = ((LinearLayout) view.findViewById(R.id.llNone));
            shoppingCartAdapter = new ShoppingCartAdapter(getContext(), data);
            lv.setAdapter(shoppingCartAdapter);

            sRLRoot.setColorSchemeResources(R.color.pink, R.color.blue, R.color.red);

            PulltoRefresh();


        }


        isShow(isShow);


        return view;
    }

    public static void isShow(int isShow) {
        if (isShow == 0) {
//            llCommit.setVisibility(View.VISIBLE);
            llNone.setVisibility(View.VISIBLE);
        } else {
            llNone.setVisibility(View.GONE);
        }
    }


    private void PulltoRefresh() {
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
    }


    /*
          事件总线
     */
    @Subscribe(threadMode = ThreadMode.MAIN, priority = 0, sticky = true)
    public void getData(IndianaBean.DataBean dataBean) {
        String short_name = dataBean.getShort_name();
        Log.e(TAG, "事件总线：IndianaBean.DataBean dataBean  getData: " + short_name);
        data.add(dataBean);


        ShoppingCartAdapter.nums.add(1);
        lvChildCount += 1;
        Log.e(TAG, "getData: " + data.size());
        tvGoods.setText("共" + data.size() + "件商品");
        ShoppingCartAdapter.allWoBi += 1;
        tvMoney.setText("合计" + ShoppingCartAdapter.allWoBi + "窝币");
        isShow += 1;
        Log.e(TAG, "isShow: " + isShow);
        isShow(isShow);
    }

    /*
           删除条目改变商品的数量
     */
    public static void deleteItemCountChage() {
        lvChildCount -= 1;
        tvGoods.setText("共" + lvChildCount + "件商品");
    }

    /*
       窝币的改变
     */
    public static void tvMoney(int allMoney) {
        allMoneyStr = String.valueOf(allMoney);
        tvMoney.setText("合计" + allMoneyStr + "窝币");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.tvGoIndiana)
    public void onClick(View v) {
        if (goToIndiana != null) {
            goToIndiana.shopCartToShowIndianaFragment();
        }
    }

    @OnClick(R.id.tvCommit)
    public void onClickCommit(View v) {
        Log.e("situ", "wobi: " + ShoppingCartAdapter.allWoBi);
        Log.e("situ", "goods num: " + lvChildCount);


        final MyUser user = BmobUser.getCurrentUser(MyUser.class);
        final Dingdan dingdan = new Dingdan();
        dingdan.setAuthor(user);
        dingdan.setNum(String.valueOf(lvChildCount));
        dingdan.setPrice(String.valueOf(ShoppingCartAdapter.allWoBi));
        dingdan.save(new SaveListener<String>() {
            @Override
            public void done(final String objectId, BmobException e) {
                if (e == null) {
                    Log.e("situ", "objectid: " + objectId);

                    for (int i = 0; i < data.size(); i++) {
                        final Goods goods = new Goods();
                        String short_name = data.get(i).getShort_name();
                        String photos = data.get(i).getPhotos();
                        Integer integer = ShoppingCartAdapter.nums.get(i);
                        goods.setImage(photos);
                        goods.setName(short_name);
                        goods.setNum(String.valueOf(integer));
                        goods.save(new SaveListener<String>() {
                            @Override
                            public void done(String s, BmobException e) {

                                goods.setObjectId(s);
                                BmobRelation relation = new BmobRelation();
                                relation.add(dingdan);
                                goods.setLikes(relation);
                                goods.update(new UpdateListener() {

                                    @Override
                                    public void done(BmobException e) {
                                        if (e == null) {
                                            currentTime = System.currentTimeMillis();
                                            if (currentTime - totalTime > 1000) {
                                                Toast.makeText(getContext(), "购买成功", Toast.LENGTH_SHORT).show();
                                                totalTime = currentTime;
                                            }

                                        } else {
                                            Toast.makeText(getContext(), "购买失败", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                                dingdan.setObjectId(objectId);
                                BmobRelation relation2 = new BmobRelation();
                                relation.add(goods);
                                dingdan.setLikes(relation2);
                                dingdan.update(new UpdateListener() {

                                    @Override
                                    public void done(BmobException e) {
                                        if (e == null) {
                                            currentTime = System.currentTimeMillis();
                                            if (currentTime - totalTime > 1000) {
                                                Toast.makeText(getContext(), "购买成功", Toast.LENGTH_SHORT).show();
                                                totalTime = currentTime;
                                            }

                                        } else {
                                            Toast.makeText(getContext(), "购买失败", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                });
                            }
                        });


                    }

                    data.clear();

                    shoppingCartAdapter.notifyDataSetChanged();

                    ShoppingCartAdapter.allWoBi = 0;
                    tvMoney.setText("合计" + 0 + "窝币");

                    lvChildCount = 0;
                    tvGoods.setText("共" + 0 + "件商品");

                } else {
                    Toast.makeText(getContext(), "购买失败", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    static GoToIndiana goToIndiana;

    public static void setGoToIndiana(GoToIndiana goToIndiana2) {
        goToIndiana = goToIndiana2;
    }

    public interface GoToIndiana {
        void shopCartToShowIndianaFragment();
    }

}


