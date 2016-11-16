package com.qf.meituan;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public class FindItemOponActivity extends Activity {


    @BindView(R.id.tvback)
    TextView tvback;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.tvItemName)
    TextView tvItemName;
    @BindView(R.id.pb_vp_content_progress)
    ProgressBar pbVpContentProgress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        ButterKnife.bind(this);

        //设置WebView属性，能够执行Javascript脚本
        webview.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        String url = getIntent().getStringExtra("url");
        //item名称
        String itemName = getIntent().getStringExtra("itemName");
        int progress = webview.getProgress();
        pbVpContentProgress.setProgress(progress);
        if (itemName != null) {
            tvItemName.setText(itemName);
        }
        webview.loadUrl(url);
        //设置Web视图
        webview.setWebViewClient(new HelloWebViewClient());

    }

    @Override
    //设置回退
    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        return false;
    }

    //Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


    }

    @OnClick(R.id.tvback)
    public void onClick(View v) {
        finish();
    }
}
