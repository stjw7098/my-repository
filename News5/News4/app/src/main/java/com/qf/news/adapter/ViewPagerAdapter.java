package com.qf.news.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.qf.news.model.NavigationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragments;
    List<NavigationBean.ShowapiResBodyBean.ChannelListBean> data=new ArrayList<>();
    List<String> arr;



    public ViewPagerAdapter(FragmentManager fm,List<Fragment> fragments,List<NavigationBean.ShowapiResBodyBean.ChannelListBean> data) {
        super(fm);
        this.fragments=fragments;
        this.data=data;
        Log.e("weidie", "data.size: " +data.size());
    }
    public ViewPagerAdapter(final Context context, FragmentManager fm, List<Fragment> fragments, final List<String> arr) {
        super(fm);
        this.fragments=fragments;
        this.arr=arr;
        for (int i = 0; i < arr.size(); i++) {
            Log.e("test", "ViewPagerAdapter: "+arr.get(i) );
        }

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(arr!=null){
            return arr.get(position);
        }
            return data.get(position).getName();

    }

}
