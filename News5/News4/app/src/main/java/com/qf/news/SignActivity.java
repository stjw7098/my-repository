package com.qf.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.news.model.MyUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class SignActivity extends AppCompatActivity {


    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.etUser)
    EditText etUser;
    @BindView(R.id.llUser)
    LinearLayout llUser;
    @BindView(R.id.etPwd)
    EditText etPwd;
    @BindView(R.id.llPwd)
    LinearLayout llPwd;
    @BindView(R.id.etPwd2)
    EditText etPwd2;
    @BindView(R.id.llPwd2)
    LinearLayout llPwd2;
    @BindView(R.id.tvSign)
    TextView tvSign;
    @BindView(R.id.rl_bg)
    RelativeLayout rlBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        ButterKnife.bind(this);
//        Glide.with(this)
//    //            .load(Uri.parse("http://cdn.duitang.com/uploads/item/201508/04/20150804231457_xVBsR.png"))
//                .load(Uri.parse("http://imgsrc.baidu.com/forum/pic/item/582b40899e510fb36a9acb7cd933c895d3430c44.jpg"))
//   //             .override(50, 100)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(ivBg);




    }

    @OnClick(R.id.tvSign)
    public void onClickSign(View v) {
        String name = etUser.getText().toString();
        String pwd = etPwd.getText().toString();
        String pwd2= etPwd2.getText().toString();
        if(!pwd.equals(pwd2)){
            Toast.makeText(SignActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        MyUser myUser = new MyUser();
        myUser.setUsername(name);
        myUser.setPassword(pwd);
        myUser.signUp(new SaveListener<Object>() {
            @Override
            public void done(Object o, BmobException e) {
                if (e == null) {
                    finish();
                    Toast.makeText(SignActivity.this, "注册成功!", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("test", "注册失败" + e.getMessage());
                }
            }
        });
    }

}
