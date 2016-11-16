package com.qf.news.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.qf.news.CareActivity;
import com.qf.news.LoginActivity;
import com.qf.news.R;
import com.qf.news.ShowNewsActivity;
import com.qf.news.model.MyUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class FragmentMy extends Fragment implements LoginActivity.UpdateLogin {
    View view;
    @BindView(R.id.sdv_head)
    SimpleDraweeView sdvHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_info)
    TextView tvInfo;
    @BindView(R.id.tv_jingong)
    TextView tvJd;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_care)
    TextView tvCare;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.tv_user_bg)
    ImageView tvUserBg;

    private BmobUser currentUser;
    private View alertView;
    private AlertDialog dialog;
    private String username;
    private String mobilePhoneNumber;
    private String email;
    private EditText etEmail;
    private EditText etPhone;
    private TextView tvUser2;
    private Button btnOk;
    private Button btnCancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_my, container, false);
            ButterKnife.bind(this, view);

            alertView = LayoutInflater.from(getContext()).inflate(R.layout.content_alert, container, false);
            etEmail = ((EditText) alertView.findViewById(R.id.et_email));
            etPhone = ((EditText) alertView.findViewById(R.id.et_phone));
            tvUser2 = ((TextView) alertView.findViewById(R.id.tv_user2));
            btnCancel = ((Button) alertView.findViewById(R.id.btnCancel));
            btnOk = ((Button) alertView.findViewById(R.id.btnOK));

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            dialog = builder.setView(alertView).create();

            Glide.with(this)
                    .load(Uri.parse("http://img4.imgtn.bdimg.com/it/u=2112656008,2228056660&fm=21&gp=0.jpg"))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(tvUserBg);

            LoginActivity.setUpdateLogin(this);

        }

        currentUser = MyUser.getCurrentUser();
        if (currentUser != null) {
            username = (String) BmobUser.getObjectByKey("username");
            mobilePhoneNumber = (String) BmobUser.getObjectByKey("mobilePhoneNumber");
            email = (String) BmobUser.getObjectByKey("email");
            tvName.setText(username);
            tvLogin.setText("退出登录");
        } else {
            tvLogin.setText("登录");
        }


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUser != null) {
                    MyUser myUser = new MyUser();
                    String email = etEmail.getText().toString();
                    String phone = etPhone.getText().toString();

                    if (email.length()>1 && phone.length()>1) {
                        myUser.setEmail(email);
                        myUser.setMobilePhoneNumber(phone);
                    }else{
                        Toast.makeText(getContext(), "手机和邮箱不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    myUser.update(currentUser.getObjectId(), new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e == null) {
                                Toast.makeText(getContext(), "更新成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "请输入合法的手机和邮箱", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    dialog.dismiss();
                } else {
                    Toast.makeText(getContext(), "请先登录", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ButterKnife.bind(this, view);
        return view;

    }

    @OnClick(R.id.tv_login)
    public void onClick(View v) {
        if (currentUser != null) {
            BmobUser.logOut();   //清除缓存用户对象
            tvLogin.setText("登录");
            currentUser = MyUser.getCurrentUser();
        } else {
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
        }

    }

    @OnClick(R.id.tv_info)
    public void onClickInfo(View v) {

        dialog.show();
        Log.e("test", "onClickInfo: "+mobilePhoneNumber+" "+email );

        if (currentUser != null) {
            tvUser2.setText(username);
            if (mobilePhoneNumber != null) {
                etPhone.setText(mobilePhoneNumber);
            }else{
                etPhone.setText("");
            }

            if (email != null) {
                etEmail.setText(email);
            }else{
                etEmail.setText("");
            }

        }else{
            tvUser2.setText("");
            etPhone.setText("");
            etEmail.setText("");
        }

    }

    @OnClick(R.id.tv_care)
    public void onClickCare(){
        Intent intent = new Intent(getContext(), CareActivity.class);

        startActivity(intent);
    }

    @Override
    public void updateLoginState() {
        currentUser = MyUser.getCurrentUser();
        tvLogin.setText("退出登录");

        username = (String) MyUser.getObjectByKey("username");
        tvName.setText(username);

        mobilePhoneNumber = (String) MyUser.getObjectByKey("mobilePhoneNumber");
        email = (String) MyUser.getObjectByKey("email");


    }

    @OnClick(R.id.tv_jingong)
    public void onClickJingDong(){
        Intent intent = new Intent(getContext(), ShowNewsActivity.class);
        intent.putExtra("link", "http://m.jd.com");
        startActivity(intent);
    }

    @OnClick(R.id.tv_question)
    public void onClickQuestion(){

    }

    @OnClick(R.id.tv_share)
    public void onClickShare(){
        showShare();
    }

    private void showShare() {
        ShareSDK.initSDK(getContext());
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(getContext());
    }
}
