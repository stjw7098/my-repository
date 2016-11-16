package com.qf.meituan;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.tv_search_back)
    TextView tvSearchBack;
    @BindView(R.id.et_search_text)
    EditText etSearchText;
    @BindView(R.id.tv_search_search)
    TextView tvSearchSearch;
    @BindView(R.id.gv_search_result)
    GridView gvSearchResult;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.tv_search_back)
    public void onTvSearchBackClick(){
        finish();
    }

    @OnClick(R.id.tv_search_search)
    public void onTvSearchSearchClick(){

    }

}
