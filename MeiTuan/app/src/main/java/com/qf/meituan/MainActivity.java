package com.qf.meituan;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qf.meituan.fragments.FindFragment;
import com.qf.meituan.fragments.FragmentMy;
import com.qf.meituan.fragments.HomeFragment;
import com.qf.meituan.fragments.SecondFragment;
import com.qf.meituan.fragments.ShoppingCartFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;
import cn.smssdk.SMSSDK;

public class MainActivity extends AppCompatActivity implements ShoppingCartFragment.GoToIndiana {
    private static final String TAG = "test";
    List<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_get_bao)
    RadioButton rbGetBao;
    @BindView(R.id.rb_find)
    RadioButton rbFind;
    @BindView(R.id.rb_shop_car)
    RadioButton rbShopCar;
    @BindView(R.id.rb_my)
    RadioButton rbMy;
    @BindView(R.id.rg)
    RadioGroup rg;
    private FragmentMy fragmentMy;
    private FragmentTransaction ft;
    private HomeFragment homeFragment;
    private FindFragment findFragment;
    private ShoppingCartFragment shoppingCartFragment;
    private SecondFragment secondFragment;
    private boolean flag;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bmob.initialize(this, "040b1d3bf471f953ce3c5ba2bc938862");

        SMSSDK.initSDK(this, "18cae761ed7e8", "a8c9b90e7d3d2b0c0a536f94d6247636");

         ShoppingCartFragment.setGoToIndiana(this);
        ButterKnife.bind(this);
        fragmentMy = new FragmentMy();
        homeFragment = new HomeFragment();
        findFragment = new FindFragment();
        shoppingCartFragment = new ShoppingCartFragment();
        secondFragment = new SecondFragment();
        fragments.add(homeFragment);
        fragments.add(secondFragment);
        fragments.add(findFragment);
        fragments.add(shoppingCartFragment);
        fragments.add(fragmentMy);

        showFragment(homeFragment);




        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < rg.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) rg.getChildAt(i);
                    radioButton.setTextColor(getResources().getColor(R.color.black));
                }
                switch (checkedId) {
                    case R.id.rb_home:
                        showFragment(homeFragment);
                        rbHome.setTextColor(getResources().getColor(R.color.red));
                        break;
                    case R.id.rb_get_bao:
                        showFragment(secondFragment);
                        rbGetBao.setTextColor(getResources().getColor(R.color.red));
                        break;
                    case R.id.rb_find:
                        showFragment(findFragment);
                        rbFind.setTextColor(getResources().getColor(R.color.red));
                        break;
                    case R.id.rb_shop_car:
                        showFragment(shoppingCartFragment);
                        rbShopCar.setTextColor(getResources().getColor(R.color.red));
                        break;
                    case R.id.rb_my:
                        showFragment(fragmentMy);
                        rbMy.setTextColor(getResources().getColor(R.color.red));
                        break;

                }
            }
        });

//        IndianaDetailActivity.setListener(this);
    }

    public void showFragment(Fragment fragment) {
        ft = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            ft.add(R.id.fl_content, fragment);
        }
        for (Fragment fragment1 : fragments) {
            if (fragment1 == fragment) {
                ft.show(fragment1);
            } else {
                ft.hide(fragment1);
            }
        }
        ft.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(flag){
                finish();
            }else{
                Toast toast = Toast.makeText(MainActivity.this, "再按一次退出应用", Toast.LENGTH_SHORT);
                toast.show();
                flag = true;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        flag = false;
                    }
                }, 2000);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==3){
            showFragment(shoppingCartFragment);
            rbShopCar.setChecked(true);
        }
    }


    @Override
    public void shopCartToShowIndianaFragment() {
//        showFragment(secondFragment);
        rbGetBao.setTextColor(getResources().getColor(R.color.red));
        rbGetBao.setChecked(true);
    }
}
