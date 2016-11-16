package com.qf.news.model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobRelation;

/**
 * Created by weidie on 2016/11/6.
 */
public class Care extends BmobObject{
    private String title;//帖子标题

    private String url;// 帖子内容

//    private MyUser author;//帖子的发布者，这里体现的是一对一的关系，该帖子属于某个用户

    private String date;//帖子图片

    private BmobRelation likes;//多对多关系：用于存储喜欢该帖子的所有用户

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    //自行实现getter和setter方法

    public BmobRelation getLikes() {
        return likes;
    }

    public void setLikes(BmobRelation likes) {
        this.likes = likes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
