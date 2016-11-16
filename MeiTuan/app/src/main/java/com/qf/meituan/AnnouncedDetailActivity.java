package com.qf.meituan;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.qf.meituan.beans.AnnouncedDetailBean;
import com.qf.meituan.utils.HttpUtil;
import com.qf.meituan.utils.JsonUtil;
import com.qf.meituan.utils.ThreadUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnnouncedDetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_home_sort)
    TextView tvHomeSort;
    @BindView(R.id.tv_home_search)
    TextView tvHomeSearch;
//    @BindView(R.id.vp_home_slide)
//    ViewPager vpHomeSlide;
    @BindView(R.id.iv_goods)
    ImageView iv_goods;
    @BindView(R.id.tvDetail)
    TextView tvDetail;
    @BindView(R.id.sdv_head)
    SimpleDraweeView sdvHead;
    @BindView(R.id.tv_win)
    TextView tvWin;
    @BindView(R.id.tv_win2)
    TextView tvWin2;
    @BindView(R.id.tv_join)
    TextView tvJoin;
    @BindView(R.id.tv_join2)
    TextView tvJoin2;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.tv_result2)
    TextView tvResult2;
    @BindView(R.id.tv_win_num)
    TextView tvWinNum;
    @BindView(R.id.btn_buy)
    Button btnBuy;
    private static final int ANNOUNCED_DETAIL_BEAN = 1;
    private AnnouncedDetailBean announcedDetailBean;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case ANNOUNCED_DETAIL_BEAN:
                    announcedDetailBean = ((AnnouncedDetailBean) msg.obj);
                    if(announcedDetailBean.getData().getPhotos().size()>0){
                        photos = announcedDetailBean.getData().getPhotos().get(0);
                    }

                    String name = announcedDetailBean.getData().getName();
                    String nper = announcedDetailBean.getData().getNper();
                    String month = nper.substring(0, 2);
                    String day = nper.substring(2, 4);
                    String hour = nper.substring(4, 6);
                    String minute = nper.substring(6, 8);

                    if(announcedDetailBean.getData().getWinner_info()!=null){
                        win_nickname = announcedDetailBean.getData().getWinner_info().getWin_nickname();
                    }
                    if(announcedDetailBean.getData().getBuyCount()!=null){
                        buyCount = announcedDetailBean.getData().getBuyCount();
                    }
                    if(announcedDetailBean.getData().getWinnumber()!=null){
                        winnumber = announcedDetailBean.getData().getWinnumber();
                    }




                    Glide.with(AnnouncedDetailActivity.this).load(Uri.parse(photos)).diskCacheStrategy(DiskCacheStrategy.ALL).into(iv_goods);
                    tvDetail.setText(name);
                    tvWin2.setText(win_nickname);
                    tvJoin2.setText(buyCount);
                    tvResult2.setText(month+"-"+day+" "+hour+":"+minute);
                    tvWinNum.setText(winnumber);

                    break;
            }
        }
    };
    private String win_nickname;
    private String buyCount;
    private String winnumber;
    private String photos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announced_detail);
        ButterKnife.bind(this);

        String sid = getIntent().getStringExtra("id");
        final int id = Integer.parseInt(sid);

        ThreadUtil.execute(new Runnable() {
            @Override
            public void run() {
                String detail = HttpUtil.getIndianaDetail(id,AnnouncedDetailActivity.this);
                AnnouncedDetailBean announcedDetailBean = JsonUtil.parseToAnnouncedDetailBean(detail);
                Message message = handler.obtainMessage();
                message.what= ANNOUNCED_DETAIL_BEAN;
                message.obj=announcedDetailBean;
                handler.sendMessage(message);
            }
        });

    }

    @OnClick(R.id.tv_home_sort)
    public void onClickBack(View v) {
        finish();
    }

    @OnClick(R.id.btn_buy)
    public void onClickBuy(View v) {
        finish();
        if(mgoToDuoBao!=null){
            mgoToDuoBao.setDuoBao();
        }
    }

    static GoToDuoBao mgoToDuoBao;

    public static void setGoToDuoBao(GoToDuoBao goToDuoBao) {
        mgoToDuoBao = goToDuoBao;
    }

    public interface GoToDuoBao{
        void setDuoBao();
    }
}
