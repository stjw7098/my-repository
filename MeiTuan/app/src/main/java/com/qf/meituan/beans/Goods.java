package com.qf.meituan.beans;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobRelation;

/**
 * Created by Administrator on 2016/11/9 0009.
 */
public class Goods extends BmobObject {
    private String image;
    private String num;
    private String name;
    private BmobRelation likes;




    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public BmobRelation getLikes() {
        return likes;
    }

    public void setLikes(BmobRelation likes) {
        this.likes = likes;
    }


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
