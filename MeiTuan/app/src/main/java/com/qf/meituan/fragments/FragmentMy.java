package com.qf.meituan.fragments;

import android.content.Intent;
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

import com.qf.meituan.MyBookActivity;
import com.qf.meituan.R;
import com.qf.meituan.beans.MyUser;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class FragmentMy extends Fragment {
    View view;
    @BindView(R.id.iv_user)
    ImageView ivUser;
    @BindView(R.id.tvLogin)
    TextView tvLogin;
    @BindView(R.id.tvInfo)
    TextView tvInfo;
    @BindView(R.id.tvBuy)
    TextView tvBuy;
    @BindView(R.id.tv_kefu)
    TextView kefu;
    @BindView(R.id.tvShare)
    TextView tvShare;
    @BindView(R.id.tvName)
    TextView tvName;

    private BmobUser currentUser;
    private String username;
    private String mobilePhoneNumber;
    private String memail;
    private View alertView;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etAge;
    private TextView tvUser2;
    private Button btnOk;
    private Button btnCancel;
    private AlertDialog dialog;
    private String age;
    private EditText etAddress;

    private String myName;
    private String address;
    private EditText etUser;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_my, container, false);
            ButterKnife.bind(this, view);

            alertView = LayoutInflater.from(getContext()).inflate(R.layout.content_alert, container, false);
            etEmail = ((EditText) alertView.findViewById(R.id.et_email));
            etPhone = ((EditText) alertView.findViewById(R.id.et_phone));
            etAge = ((EditText) alertView.findViewById(R.id.et_age));
            etUser = ((EditText) alertView.findViewById(R.id.et_user));
            btnCancel = ((Button) alertView.findViewById(R.id.btnCancel));
            btnOk = ((Button) alertView.findViewById(R.id.btnOK));
            etAddress = ((EditText) alertView.findViewById(R.id.et_address));

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            dialog = builder.setView(alertView).create();

        }
        updateLoginStatus();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUser != null) {
                    final MyUser myUser = new MyUser();
                    final String email = etEmail.getText().toString();
                    final String phone = etPhone.getText().toString();
                    final String age = etAge.getText().toString();
                    final String address = etAddress.getText().toString();
                    final String myname = etUser.getText().toString();

                    BmobQuery<MyUser> query = new BmobQuery<MyUser>();
                    query.addWhereEqualTo("username",username);
                    query.setLimit(50);
                    query.findObjects(new FindListener<MyUser>() {
                        @Override
                        public void done(List<MyUser> object, BmobException e) {
                            String mpn=null;
                            if(object.size()>0){
                                mpn = object.get(0).getMobilePhoneNumber();
                            }
                            if(e==null){
                                if(object.size()>0&&phone.equals(mpn)&&email.equals(memail)){
                                    Log.e("weidie", "situ: " );
                                    myUser.setAge(age);
                                    myUser.setMyname(myname);
                                    myUser.setAddress(address);

                                    updateUserInfo(myUser);
                                }
                                if(object.size()>0&&!phone.equals(mpn)&&email.equals(memail)){
                                    myUser.setAge(age);
                                    myUser.setMyname(myname);
                                    myUser.setAddress(address);
                                    myUser.setMobilePhoneNumber(phone);

                                    updateUserInfo(myUser);
                                }

                                if(object.size()>0&&phone.equals(mpn)&&!email.equals(memail)){
                                    myUser.setAge(age);
                                    myUser.setMyname(myname);
                                    myUser.setAddress(address);
                                    myUser.setEmail(email);

                                    updateUserInfo(myUser);
                                }

                                if(object.size()>0&&!phone.equals(mpn)&&!email.equals(memail)){
                                    myUser.setAge(age);
                                    myUser.setMyname(myname);
                                    myUser.setAddress(address);
                                    myUser.setEmail(email);
                                    myUser.setMobilePhoneNumber(phone);

                                    updateUserInfo(myUser);
                                }
                            }
                        }
                    });

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

        return view;
    }

    private void updateUserInfo(MyUser myUser) {
        myUser.update(currentUser.getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Toast.makeText(getContext(), "更新成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
           //         Toast.makeText(getContext(), "请输入合法的手机和邮箱", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.dismiss();
    }

    private void updateLoginStatus() {
        currentUser = MyUser.getCurrentUser();
        if (currentUser != null) {
            username = (String) MyUser.getObjectByKey("username");
            myName = (String) MyUser.getObjectByKey("myname");
            mobilePhoneNumber = (String) MyUser.getObjectByKey("mobilePhoneNumber");
            memail = (String) MyUser.getObjectByKey("email");
            age = (String) MyUser.getObjectByKey("age");
            address = (String) MyUser.getObjectByKey("address");
            tvName.setText(username);
            tvLogin.setText("退出登录");
        } else {
            tvLogin.setText("登录");
        }
    }

    @OnClick(R.id.tvLogin)
    public void onClickLogin(View v) {
        if (currentUser != null) {
            MyUser.logOut();   //清除缓存用户对象
            tvLogin.setText("登录");
            tvName.setText("某某某");
            currentUser = MyUser.getCurrentUser();
        } else {
            userLogin();
        }

    }

    public void userLogin() {
        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    final String phone = (String) phoneMap.get("phone");

                    BmobQuery<MyUser> query = new BmobQuery<MyUser>();
                    query.addWhereEqualTo("username",phone);
                    query.setLimit(50);
                    query.findObjects(new FindListener<MyUser>() {
                        @Override
                        public void done(List<MyUser> object, BmobException e) {
                            if(e==null){
                                if(object!=null&&object.size()>0){
                                    FragmentMy.this.userLogin(phone);

                                }else{
                                    MyUser myUser = new MyUser();
                                    myUser.setUsername(phone);
                                    myUser.setPassword("123456");
                                    myUser.signUp(new SaveListener<Object>() {
                                        @Override
                                        public void done(Object o, BmobException e) {
                                            if (e == null) {
                                                FragmentMy.this.userLogin(phone);

                                            } else {
                                            }
                                        }
                                    });
                                }

                            }else{
                                Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                            }
                        }
                    });

                }
            }
        });

        registerPage.show(getContext());
    }

    private void userLogin(String phone) {
        MyUser myUser2 = new MyUser();
        myUser2.setUsername(phone);
        myUser2.setPassword("123456");
        myUser2.login(new SaveListener<MyUser>() {
            @Override
            public void done(MyUser bmobUser, BmobException e) {
                if(e==null){
                    currentUser = MyUser.getCurrentUser();
                    if (currentUser != null) {
                        username = (String) MyUser.getObjectByKey("username");
                        myName = (String) MyUser.getObjectByKey("myname");
                        mobilePhoneNumber = (String) MyUser.getObjectByKey("mobilePhoneNumber");
                        memail = (String) MyUser.getObjectByKey("email");
                        age = (String) MyUser.getObjectByKey("age");
                        address = (String) MyUser.getObjectByKey("address");
                        tvName.setText(username);
                        tvLogin.setText("退出登录");

                        Log.e("test", "phone: "+mobilePhoneNumber );
                        Log.e("test", "memail: "+ memail);
                        Log.e("test", "age: "+age );
                    }
                }else{
                }
            }
        });
    }

    @OnClick(R.id.tvInfo)
    public void onClickInfo(View v) {

        dialog.show();
        Log.e("test", "onClickInfo: "+mobilePhoneNumber+" "+ memail);
        etUser.setText("某某某");
        etEmail.setText("");
        etPhone.setText("");
        etAge.setText("");
        etAddress.setText("");

        updateLoginStatus();
        Log.e("test", "phone: "+mobilePhoneNumber );
        Log.e("test", "memail: "+ memail);
        Log.e("test", "age: "+age );
        if (currentUser != null) {
            etUser.setText(myName);
            if (mobilePhoneNumber != null) {
                etPhone.setText(mobilePhoneNumber);
            }else{
                etPhone.setText("");
            }

            if (memail != null) {
                etEmail.setText(memail);
            }else{
                etEmail.setText("");
            }

            if ( age!= null) {
                etAge.setText(age);
            }else{
                etAge.setText("");
            }
            if ( address!= null) {
                etAddress.setText(address);
            }else{
                etAddress.setText("");
            }

        }else{
            etUser.setText("");
            etPhone.setText("");
            etEmail.setText("");
            etAge.setText("");
            etAddress.setText("");
        }

    }

    @OnClick(R.id.tv_kefu)
    public void clickKefu(){
        Toast.makeText(getContext(), "客服暂时不在，请稍后联系！", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tvShare)
    public void clickShare(){
        Toast.makeText(getContext(), "请先选择要分享的内容！", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tvBuy)
    public void clickBuy() {
        Intent intent = new Intent(getContext(), MyBookActivity.class);
        startActivity(intent);

    }




}
