package com.qf.meituan.fragments.second;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.qf.meituan.R;
import com.qf.meituan.adapters.AnnouncedAdapter;
import com.qf.meituan.beans.AnnouncedBean;
import com.qf.meituan.utils.HttpUtil;
import com.qf.meituan.utils.JsonUtil;
import com.qf.meituan.utils.ThreadUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by administractor on 2016/11/1.
 */
public class AnnouncedFragment extends Fragment {

    @BindView(R.id.gv)
    GridView gv;
    private View view;
    private AnnouncedAdapter announcedAdapter;
    private static final int ANNOUNCEDBENA=1;
    private List<AnnouncedBean.DataBean> data=new ArrayList<>();
    public static final String TAG = "test";

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case ANNOUNCEDBENA:
                    AnnouncedBean announcedBean = (AnnouncedBean) msg.obj;
        //            data = announcedBean.getData();
                    if(announcedBean.getData()!=null){
                    data.addAll(announcedBean.getData());
                        announcedAdapter.notifyDataSetChanged();
                    }

                    Log.e(TAG, "handleMessage: "+data );

                    break;
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_announced, container, false);
        }
        ButterKnife.bind(this, view);

        announcedAdapter=new AnnouncedAdapter(getContext(),data);
        gv.setAdapter(announcedAdapter);

        ThreadUtil.execute(new Runnable() {
            @Override
            public void run() {
                String announcedJson = HttpUtil.getAnnounced(1,getContext());
                Log.e(TAG, "run: "+announcedJson );
                AnnouncedBean announcedBean = JsonUtil.parseToAnnouncedBean(announcedJson);
                Message message = handler.obtainMessage();
                message.what= ANNOUNCEDBENA;
                message.obj=announcedBean;
                handler.sendMessage(message);
            }
        });






        return view;
    }
}
