package com.qf.news;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qf.news.fragment.FragmentHome;
import com.qf.news.fragment.FragmentMain;
import com.qf.news.fragment.FragmentMy;
import com.qf.news.fragment.FragmentSearch;
import com.qf.news.fragment.FragmentVideo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;
import cn.sharesdk.framework.ShareSDK;

public class MainActivity extends AppCompatActivity implements FragmentSearch.GoToHome,FragmentVideo.GoToHouse{

    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1;
    private static final int MOUNT_UNMOUNT_FILESYSTEMS = 2;
    private static final String TAG = "test";
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_search)
    RadioButton rbSearch;
    @BindView(R.id.rb_video)
    RadioButton rbVideo;
    @BindView(R.id.rb_my)
    RadioButton rbMy;
    @BindView(R.id.rg)
    RadioGroup rg;
    private FragmentMain fragmentMain;

    private FragmentVideo fragmentVideo;
    private FragmentMy fragmentMy;
    private FragmentHome fragmentHome;
    private FragmentSearch fragmentSearch;
    List<Fragment> fragments = new ArrayList<>();
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ShareSDK.initSDK(this,"18c5b201960c4");

        Bmob.initialize(this, "4dec9d0208c01a72f892ad1de7fc8ce8");

        fragmentVideo = new FragmentVideo();
        fragmentMy = new FragmentMy();
        fragmentHome = new FragmentHome();
        fragmentSearch = new FragmentSearch();

        fragmentSearch.setGoToHome(this);
        fragmentVideo.setGoToHouse(this);

        fragments.add(fragmentVideo);
        fragments.add(fragmentMy);
        fragments.add(fragmentHome);
        fragments.add(fragmentSearch);
        showFragment(fragmentHome);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);

        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS)
                != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, MOUNT_UNMOUNT_FILESYSTEMS);

        }

        //     getSupportFragmentManager().beginTransaction().add(R.id.fl_content,fragmentHome).commit();

        ((RadioGroup) findViewById(R.id.rg)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < group.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) group.getChildAt(i);
                    radioButton.setTextColor(getResources().getColor(R.color.black));
                }
                switch (checkedId) {
                    case R.id.rb_home:
                        showFragment(fragmentHome);
                        rbHome.setTextColor(getResources().getColor(R.color.red));
                        break;
                    case R.id.rb_search:
                        showFragment(fragmentSearch);
                        rbSearch.setTextColor(getResources().getColor(R.color.red));
                        break;
                    case R.id.rb_video:
                        showFragment(fragmentVideo);
                        rbVideo.setTextColor(getResources().getColor(R.color.red));
                        break;
                    case R.id.rb_my:
                        showFragment(fragmentMy);
                        rbMy.setTextColor(getResources().getColor(R.color.red));
                        break;
                }
            }
        });
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
    public void setHome() {
        showFragment(fragmentHome);
        rbHome.setChecked(true);
    }

    @Override
    public void setHouse() {
        showFragment(fragmentHome);
        rbHome.setChecked(true);
    }


}
