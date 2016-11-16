package com.qf.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.news.R;
import com.qf.news.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class FragmentMain extends Fragment {
    View view;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private ViewPagerAdapter adapter;
    List<Fragment> fragments =new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_main, container, false);
            ButterKnife.bind(this, view);
            for (int i = 0; i < 10; i++) {
                RecommendFragment recommendFragment = new RecommendFragment();
                Bundle bundle = new Bundle();
                bundle.putString("title","title"+i);
                recommendFragment.setArguments(bundle);
                fragments.add(recommendFragment);
            }
            tab.setupWithViewPager(vp);
   //         adapter = new ViewPagerAdapter(getChildFragmentManager(),fragments);
            vp.setAdapter(adapter);
        }
        return view;
    }
}
