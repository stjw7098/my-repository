package com.qf.meituan.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.qf.meituan.HomeGVContentActivity;
import com.qf.meituan.HomeVpContentActivity;
import com.qf.meituan.IndianaDetailActivity;

import java.util.List;
import java.util.Map;

/**
 * Created by jun on 2016/11/1.
 */
public class HomeViewPagerAdapter extends PagerAdapter{

    private static final String TAG = "test";
    private Context context;
    private List<Map<String, Object>> views;

    public HomeViewPagerAdapter(Context context, List<Map<String, Object>> views) {
        this.context = context;
        this.views = views;
    }

    public void setViews(List<Map<String, Object>> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final Map<String, Object> map = views.get(position%4);
        View view = (View) map.get("view");
        final String url = (String) map.get("url");
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "点击了第"+position+"项");
                if(url.length() > 6){
                    Intent intent = new Intent(context, HomeVpContentActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("title", "网盘");
                    context.startActivity(intent);
                }else if("".equals(url)){
                    Intent intent = new Intent(context, IndianaDetailActivity.class);
                    String id = (String) map.get("id");
                    int _id = Integer.parseInt(id);
                    intent.putExtra("id", _id);
                    context.startActivity(intent);
                }else if("食品".equals(url)){
                    Intent intent = new Intent(context, HomeGVContentActivity.class);
                    String iurl = "http://120.55.198.252/home/m?target=android&v=310&act=home%2Fdata_v2_6&json=%7B%22search%22%3A%7B%22q%22%3A%22a%22%7D%2C%22pagination%22%3A%7B%22page%22%3A1%7D%7D";
                    intent.putExtra("url", iurl);
                    intent.putExtra("title", "精挑细选");
                    context.startActivity(intent);
                }else if("女鞋".equals(url)){
                    Intent intent = new Intent(context, HomeGVContentActivity.class);
                    String iurl = "http://120.55.198.252/home/m?target=android&v=310&act=home%2Fdata_v2_6&json=%7B%22search%22%3A%7B%22cid%22%3A%2232%22%7D%2C%22pagination%22%3A%7B%22page%22%3A1%7D%7D";
                    intent.putExtra("url", iurl);
                    intent.putExtra("title", "九块九包邮");
                    context.startActivity(intent);
                }
            }
        });

        if (container.indexOfChild(view) != -1) {
            container.removeView(view);
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
