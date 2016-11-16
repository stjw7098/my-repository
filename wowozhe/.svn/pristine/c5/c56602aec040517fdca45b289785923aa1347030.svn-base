package com.qf.meituan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeVpContentActivity extends AppCompatActivity {

    @BindView(R.id.tv_vp_content_back)
    TextView tvVpContentBack;
    @BindView(R.id.tv_vp_content_title)
    TextView tvVpContentTitle;
    @BindView(R.id.pb_vp_content_progress)
    ProgressBar pbVpContentProgress;
    @BindView(R.id.wv_vp_content)
    WebView wvVpContent;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            getProgress();
        }
    };
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_webview);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");

        tvVpContentTitle.setText(title);

        wvVpContent.getSettings().setJavaScriptEnabled(true);
        wvVpContent.loadUrl(url);
        wvVpContent.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        getProgress();

        tvVpContentBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void getProgress(){
        pbVpContentProgress.setVisibility(View.VISIBLE);
        int progress = wvVpContent.getProgress();
        pbVpContentProgress.setProgress(progress);
        if(progress >= 100){
            pbVpContentProgress.setVisibility(View.GONE);
            pbVpContentProgress.setProgress(0);
            handler.removeCallbacks(runnable);
        }
        handler.post(runnable);
    }
}
