package com.qf.news;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ShowNewsActivity extends AppCompatActivity {

    private static final String TAG = "test";
    private WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_news);

        webview = ((WebView) findViewById(R.id.webview));
        String link = getIntent().getStringExtra("link");

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

        //设置打开页面，自适应屏幕
        settings.setUseWideViewPort(true);
        settings.setLoadsImagesAutomatically(true);


        //支持缩放
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);

        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        webview.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                Log.e(TAG, "shouldOverrideUrlLoading: " );
                view.loadUrl(url);
                return true;
            }
        });

        webview.loadUrl(link);


        //设置网页加载进度对话框
      //  setLoadNewsProgress();

    }

    private void setLoadNewsProgress() {
        webview.setWebChromeClient(new WebChromeClient() {

            private ProgressDialog dialog;

            @Override

            // newProgress是1-100之间的整数

            public void onProgressChanged(WebView view, int newProgress) {

                super.onProgressChanged(view, newProgress);

                // 网页加载完成

                if (newProgress == 100) {

                    // 关闭加载完毕，关闭ProgressDialog

                    closeDialog();

                } else {

                    // 网页正在加载,打开ProgressDialog

                    openDialog(newProgress);

                }

            }

            private void openDialog(int newProgress) {

                if (dialog == null) {

                    dialog = new ProgressDialog(ShowNewsActivity.this);


                    dialog.setTitle("正在加载");

                    dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

                    dialog.setProgress(newProgress);

                    dialog.show();

                } else {

                    dialog.setProgress(newProgress);

                }

            }

            protected void closeDialog() {

                if (dialog != null && dialog.isShowing()) {

                    dialog.dismiss();

                    dialog = null;

                }

            }

        });
    }


    //设置网页回退
//    @Override
//
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//        if (keyCode==KeyEvent.KEYCODE_BACK) {
//
//            判断网页是否能返回
//
//            if (webview.canGoBack()) {
//
//                webview.goBack();
//
//                return true;
//
//            }else {
//
//                System.exit(0);
//
//            }
//
//        }
//
//        return super.onKeyDown(keyCode, event);
//
//    }


}
