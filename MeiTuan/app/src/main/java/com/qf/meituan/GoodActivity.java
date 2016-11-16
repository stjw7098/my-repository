package com.qf.meituan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.qf.meituan.adapters.GoodRvAdapter;
import com.qf.meituan.beans.Dingdan;
import com.qf.meituan.beans.Goods;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class GoodActivity extends AppCompatActivity implements GoodRvAdapter.OnGoodItemClickListener{

    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.rv_book)
    RecyclerView rvBook;
    private GoodRvAdapter goodRvAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<Goods> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);
        ButterKnife.bind(this);

        String objectId = getIntent().getStringExtra("objectId");
        Log.e("situ", "objectId: " + objectId);

        BmobQuery<Goods> query = new BmobQuery<Goods>();
        Dingdan dingdan = new Dingdan();
        dingdan.setObjectId(objectId);
        query.addWhereEqualTo("likes", new BmobPointer(dingdan));

        query.findObjects(new FindListener<Goods>() {

            @Override
            public void done(List<Goods> objects, BmobException e) {

                if (objects != null && objects.size() > 0) {
                    data = objects;
                    goodRvAdapter.setData(data);
                }

            }
        });

        goodRvAdapter = new GoodRvAdapter(this, data);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        goodRvAdapter.setOnGoodItemClickListener(this);
        rvBook.setLayoutManager(linearLayoutManager);
        rvBook.setAdapter(goodRvAdapter);
    }

    @Override
    public void setOnItemClickListener(String objectId) {

    }

    @OnClick(R.id.tv_back)
    public void onClickBack(){
        finish();
    }
}
