package com.qf.meituan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.qf.meituan.adapters.BookRvAdapter;
import com.qf.meituan.beans.Dingdan;
import com.qf.meituan.beans.MyUser;

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

public class MyBookActivity extends AppCompatActivity implements BookRvAdapter.OnBookItemClickListener{

    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.rv_book)
    RecyclerView rvBook;
    private BookRvAdapter bookRvAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<Dingdan> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book);
        ButterKnife.bind(this);

        BmobUser currentUser = BmobUser.getCurrentUser();
        if (currentUser != null) {

        }

        BmobQuery<Dingdan> query = new BmobQuery<Dingdan>();

        MyUser myUser = new MyUser();
        String objectId = (String) myUser.getObjectByKey("objectId");
        myUser.setObjectId(objectId);
        query.addWhereEqualTo("author", new BmobPointer(myUser));


        query.findObjects(new FindListener<Dingdan>() {

            @Override
            public void done(List<Dingdan> objects, BmobException e) {

                if(objects!=null&&objects.size()>0){
                    data=objects;
                    bookRvAdapter.setData(data);
                }
//                for (int i = 0; i < objects.size(); i++) {
//                    String num = objects.get(i).getNum();
//                    String price = objects.get(i).getPrice();
//                    String objectId1 = objects.get(i).getObjectId();
//
//                    String createdAt = objects.get(i).getCreatedAt();
//
//
//
//
//                }
            }
        });

        bookRvAdapter = new BookRvAdapter(this,data);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        bookRvAdapter.setOnBookItemClickListener(this);
        rvBook.setLayoutManager(linearLayoutManager);
        rvBook.setAdapter(bookRvAdapter);

    }

    @OnClick(R.id.tv_back)
    public void onClickBack(){
        finish();
    }

    @Override
    public void setOnItemClickListener(String objectId) {
        Intent intent = new Intent(this, GoodActivity.class);
        intent.putExtra("objectId",objectId);
        startActivity(intent);
    }
}
