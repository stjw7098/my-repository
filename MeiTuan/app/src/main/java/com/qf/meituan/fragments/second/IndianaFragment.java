package com.qf.meituan.fragments.second;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.qf.meituan.R;
import com.qf.meituan.adapters.IndinaAdapter;
import com.qf.meituan.beans.IndianaBean;
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
public class IndianaFragment extends Fragment {

    private static final int MSG_GET_INDIANA = 22;
    @BindView(R.id.gv)
    GridView gv;
    private View view;
    private List<IndianaBean.DataBean> data = new ArrayList<>();
    private IndinaAdapter indinaAdapter;
    private IndianaBean indianaBean;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_GET_INDIANA:
                    IndianaBean indianaBean = (IndianaBean) msg.obj;
                    List<IndianaBean.DataBean> dataBean = indianaBean.getData();
                    if (dataBean!=null) {
                        data.addAll(dataBean);
                        indinaAdapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_indiana, container, false);
            ButterKnife.bind(this, view);
            ThreadUtil.execute(new Runnable() {
                @Override
                public void run() {
                    String indianaJson = HttpUtil.getIndiana(1, getContext());
                    indianaBean = JsonUtil.parseToIndianaBean(indianaJson);
                    Message message = handler.obtainMessage();
                    message.what = MSG_GET_INDIANA;
                    message.obj = indianaBean;
                    handler.sendMessage(message);
                }
            });
            indinaAdapter = new IndinaAdapter(getContext(),data);
            gv.setAdapter(indinaAdapter);
        }
        return view;
    }
}
