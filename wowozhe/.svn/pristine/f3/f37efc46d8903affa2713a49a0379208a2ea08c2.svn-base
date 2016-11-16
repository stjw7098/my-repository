package com.qf.meituan.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qf.meituan.AnnouncedDetailActivity;
import com.qf.meituan.HomeVpContentActivity;
import com.qf.meituan.R;
import com.qf.meituan.adapters.IndianaFragmentAdapter;
import com.qf.meituan.fragments.second.AnnouncedFragment;
import com.qf.meituan.fragments.second.IndianaFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by administractor on 2016/11/1.
 */
public class SecondFragment extends Fragment implements AnnouncedDetailActivity.GoToDuoBao {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.rbIndiana)
    RadioButton rbIndiana;
    @BindView(R.id.rbAnnounced)
    RadioButton rbAnnounced;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.tvIndianaRule)
    TextView tvIndianaRule;
    private View view;
    private List<Fragment> fragments = new ArrayList<>();
    private AnnouncedFragment announcedFragment;
    private IndianaFragment indianaFragment;
    private IndianaFragmentAdapter indianaFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_second, container, false);
            ButterKnife.bind(this, view);

            announcedFragment = new AnnouncedFragment();
            indianaFragment = new IndianaFragment();
            fragments.add(indianaFragment);
            fragments.add(announcedFragment);

            indianaFragmentAdapter = new IndianaFragmentAdapter(getChildFragmentManager(), fragments);
            vp.setAdapter(indianaFragmentAdapter);
            vp.setCurrentItem(0);

            vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    for (int i = 0; i < rg.getChildCount(); i++) {
                        if (i == position) {
                            ((RadioButton) rg.getChildAt(i)).setChecked(true);
                        }
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    for (int i = 0; i < rg.getChildCount(); i++) {
                        RadioButton radioButton = (RadioButton) rg.getChildAt(i);
                        radioButton.setTextColor(getResources().getColor(R.color.white));
                    }

                    switch (checkedId) {
                        case R.id.rbIndiana:
                            vp.setCurrentItem(0);
                            rbIndiana.setTextColor(getResources().getColor(R.color.pink));
                            break;
                        case R.id.rbAnnounced:
                            vp.setCurrentItem(1);
                            rbAnnounced.setTextColor(getResources().getColor(R.color.pink));
                            break;
                    }
                }
            });

            AnnouncedDetailActivity.setGoToDuoBao(this);


        }
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void setDuoBao() {
        Log.e("test", "setDuoBao: ");
        vp.setCurrentItem(0);
    }

    @OnClick(R.id.tvIndianaRule)
    public void onTvIndianaRule(View v) {
        Intent intent = new Intent(this.getActivity(), HomeVpContentActivity.class);
        String url = "http://www.wowozhe.com/home/m/miaosrule/target/android/v/310";
        intent.putExtra("url", url);
        intent.putExtra("title", "常见问题");
        startActivity(intent);
    }


}
