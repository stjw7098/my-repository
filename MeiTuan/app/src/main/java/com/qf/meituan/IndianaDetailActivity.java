package com.qf.meituan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.meituan.beans.IndianaDetailBean;
import com.qf.meituan.utils.HttpUtil;
import com.qf.meituan.utils.JsonUtil;
import com.qf.meituan.utils.ThreadUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IndianaDetailActivity extends AppCompatActivity {

    private static final String TAG = "test";
    private static final int MSG_GET_JSON = 23;
    public static final Object MSG_ID_FRAGMENT = 3;
    @BindView(R.id.tvBack)
    TextView tvBack;
    @BindView(R.id.tvIndiana)
    TextView tvIndiana;
    @BindView(R.id.ivDetail)
    ImageView ivDetail;
    @BindView(R.id.tvDetail)
    TextView tvDetail;
    @BindView(R.id.pb)
    ProgressBar pb;
    @BindView(R.id.tvTotalPerson)
    TextView tvTotalPerson;
    @BindView(R.id.tvRemainPerson)
    TextView tvRemainPerson;
    @BindView(R.id.llDetails)
    LinearLayout llDetails;
    @BindView(R.id.llAnnounced)
    LinearLayout llAnnounced;
    @BindView(R.id.llShowAndSharing)
    LinearLayout llShowAndSharing;
    @BindView(R.id.llCalculationRule)
    LinearLayout llCalculationRule;
    @BindView(R.id.btnOne_dollar_indiana)
    Button btnOneDollarIndiana;
    @BindView(R.id.btnAdd_to_cart)
    Button btnAddToCart;
    @BindView(R.id.ivGoToShoppingCart)
    ImageView ivGoToShoppingCart;
    private MainActivity mainActivity = new MainActivity();
    int id;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_GET_JSON:
                    String indianaDetailJson = (String) msg.obj;
                    IndianaDetailBean indianaDetailBean = JsonUtil.parseToIndianaDetailBean(indianaDetailJson);
                    IndianaDetailBean.DataBean data = null;
                    try {
                        data = indianaDetailBean.getData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (data == null) {
                        return;
                    }
                    List<String> photos = data.getPhotos();//获得多张图片地址集合
                    String money = data.getMoney();//获得总价，也为总需人次
                    String totalCount = money.substring(0, money.length() - 3);
                    String usedcount = data.getUsedcount();
                    String residuecount = data.getResiduecount();
                    Log.e(TAG, "IndianaDetailActivity handleMessage: residuecount=" + residuecount);
                    int joinedNumbers = Integer.parseInt(usedcount);//已参加人次
                    String name = data.getName();//商品简要信息
                    pb.setProgress(joinedNumbers / 100);
                    tvDetail.setText(name);
                    tvTotalPerson.setText("总需" + totalCount + "人次");
                    tvRemainPerson.setText("剩余" + residuecount + "人次");
                    Glide.with(IndianaDetailActivity.this).load(photos.get(0)).diskCacheStrategy(DiskCacheStrategy.ALL).into(ivDetail);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indiana_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);//交易id
        ThreadUtil.execute(new Runnable() {
            @Override
            public void run() {
                String indianaDetailJson = HttpUtil.getIndianaDetail(id, IndianaDetailActivity.this);//获得夺宝的item详情
                Message message = handler.obtainMessage();
                message.what = MSG_GET_JSON;
                message.obj = indianaDetailJson;
                handler.sendMessage(message);
            }
        });
    }

    @OnClick(R.id.tvBack)
    public void onTvBackClick(View v) {
        finish();
    }

    @OnClick(R.id.tvIndiana)
    public void onTvIndianaClick(View v) {
        finish();
    }

    @OnClick(R.id.ivGoToShoppingCart)
    public void onIvGoToShoppingCartClick(View v) {
        IndianaDetailActivity.this.setResult(3);
        finish();
    }

    @OnClick(R.id.llDetails)//图文详情
    public void onLlDetailsClick(View v) {
        Intent intent = new Intent(this, HomeVpContentActivity.class);
        String url="http://www.wowozhe.com/Home/m/app_yungou/id/"+id;
        intent.putExtra("title",url);
        intent.putExtra("url",url);
        startActivity(intent);
    }

    @OnClick(R.id.llAnnounced)//往期揭晓
    public void onLlShowAndSharingClick(View v) {
        Intent intent = new Intent(this, HomeVpContentActivity.class);
        String url="http://www.wowozhe.com/app/miaosha/app_record_before/ygpid/6720cc5e7eb1bbb1ad56b801eacf8e11";
        intent.putExtra("title","往期揭晓");
        intent.putExtra("url",url);
        startActivity(intent);
    }

    @OnClick(R.id.llCalculationRule)//计算规则
    public void onLlCalculationRuleClick(View v) {
        Intent intent = new Intent(this, HomeVpContentActivity.class);
        String url="http://www.wowozhe.com/home/m/m_caculate";
        intent.putExtra("url",url);
        intent.putExtra("title","计算规则");
        startActivity(intent);
    }

    static Callback listener;

    public static void setListener(Callback _listener) {
        listener = _listener;
    }

    public interface Callback {
        void backToFragment();
    }
}
