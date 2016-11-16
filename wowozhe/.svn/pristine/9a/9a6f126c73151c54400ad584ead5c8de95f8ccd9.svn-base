package com.qf.meituan.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.qf.meituan.beans.AnnouncedBean;
import com.qf.meituan.beans.AnnouncedDetailBean;
import com.qf.meituan.beans.FindBean;
import com.qf.meituan.beans.HomeBean;
import com.qf.meituan.beans.HomeGVBean;
import com.qf.meituan.beans.IndianaBean;
import com.qf.meituan.beans.IndianaDetailBean;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class JsonUtil {

    public static FindBean findBeanJson(String json) {
        FindBean findBean = null;
        try {
            findBean = new Gson().fromJson(json, FindBean.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return findBean;
    }
    

    public static HomeBean parseToHomeBean(String json){
        HomeBean homeBean = null;
        try {
            homeBean = new Gson().fromJson(json, HomeBean.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return homeBean;
    }

    public static AnnouncedBean parseToAnnouncedBean(String json){
        AnnouncedBean announcedBean = null;
        try {
            announcedBean = new Gson().fromJson(json, AnnouncedBean.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return announcedBean;
    }

    public static IndianaBean parseToIndianaBean(String json){
        IndianaBean indianaBean= null;
        try {
            indianaBean = new Gson().fromJson(json, IndianaBean.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return indianaBean;
    }

    public static IndianaDetailBean parseToIndianaDetailBean(String json){
        IndianaDetailBean indianaDetailBean= null;
        try {
            indianaDetailBean = new Gson().fromJson(json, IndianaDetailBean.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return indianaDetailBean;
    }

    public static AnnouncedDetailBean parseToAnnouncedDetailBean(String json){
        AnnouncedDetailBean announcedDetailBean= null;
        try {
            announcedDetailBean = new Gson().fromJson(json, AnnouncedDetailBean.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return announcedDetailBean;
    }

    public static HomeGVBean parseToHomeGVBean(String json){
        HomeGVBean homeGVBean = null;
        try {
            homeGVBean = new Gson().fromJson(json, HomeGVBean.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return homeGVBean;
    }
}
