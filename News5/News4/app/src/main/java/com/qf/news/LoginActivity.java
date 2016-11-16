package com.qf.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class LoginActivity extends AppCompatActivity {


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
    @BindView(R.id.tvlogin)
    TextView tvlogin;
    @BindView(R.id.tv_sign)
    TextView tvSign;
    @BindView(R.id.rl_bg)
    RelativeLayout rlBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
//        Glide.with(this)
//                .load(Uri.parse("http://cdn.duitang.com/uploads/item/201404/16/20140416184252_Hvjxi.jpeg"))
//  //              .override(5, 10)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(ivBg);


    }

    @OnClick(R.id.tv_sign)
    public void onClick(View v) {
        Intent intent = new Intent(this, SignActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tvlogin)
    public void onClickLogin(View v) {
        String name = etUser.getText().toString();
        String pwd = etPwd.getText().toString();
        if(name.trim().length()<1||pwd.trim().length()<1){
            Toast.makeText(LoginActivity.this, "账户或者密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        MyUser myUser = new MyUser();
        myUser.setUsername(name);
        myUser.setPassword(pwd);
        myUser.login(new SaveListener<MyUser>() {

            @Override
            public void done(MyUser bmobUser, BmobException e) {
                if(e==null){
                    if(mupdateLogin!=null){
                        mupdateLogin.updateLoginState();
                    }
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    finish();
                    //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                    //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                }else{
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    static UpdateLogin mupdateLogin;

    public static void setUpdateLogin(UpdateLogin updateLogin) {
        mupdateLogin = updateLogin;
    }

    public interface UpdateLogin{
        void updateLoginState();
    }

}
