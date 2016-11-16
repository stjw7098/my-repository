package com.qf.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.qf.news.adapter.CareRvAdapter;
import com.qf.news.model.Care;
import com.qf.news.model.MyUser;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class CareActivity extends AppCompatActivity implements CareRvAdapter.OnCareItemClickListener{

    @BindView(R.id.tvBack)
    TextView tvBack;
    @BindView(R.id.tab)
    TextView tab;
    @BindView(R.id.tv_update_num)
    TextView tvUpdateNum;
    @BindView(R.id.lv)
    RecyclerView lv;
    private BmobUser currentUser;
    private String objectId;
    private CareRvAdapter careAdapter;
    private List<Care> data=new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);
        ButterKnife.bind(this);

        currentUser = MyUser.getCurrentUser();

        if(currentUser!=null){
            objectId = (String) BmobUser.getObjectByKey("objectId");
            Log.e("bmob", "objectId: " + objectId);

            BmobQuery<Care> query = new BmobQuery<Care>();
            //用此方式可以构造一个BmobPointer对象。只需要设置objectId就行
            MyUser myUser = new MyUser();
            myUser.setObjectId(objectId);
            query.addWhereEqualTo("likes",new BmobPointer(myUser));
            //希望同时查询该评论的发布者的信息，以及该帖子的作者的信息，这里用到上面`include`的并列对象查询和内嵌对象的查询
            //        query.include("user,post.author");
            query.findObjects(new FindListener<Care>() {

                @Override
                public void done(List<Care> objects,BmobException e) {

                    if(objects!=null&&objects.size()>0){
                        data=objects;
                        careAdapter.setData(data);
                    }
                }
            });
        }



        careAdapter = new CareRvAdapter(this,data);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        careAdapter.setOnCareItemClickListener(this);
        lv.setLayoutManager(linearLayoutManager);
        lv.setAdapter(careAdapter);
    }

    @Override
    public void setOnItemClickListener(String url) {
        Intent intent = new Intent(this, ShowNewsActivity.class);
        intent.putExtra("link", url);
        startActivity(intent);
    }

    @OnClick(R.id.tvBack)
    public void onClickBack(){
        finish();
    }
}
