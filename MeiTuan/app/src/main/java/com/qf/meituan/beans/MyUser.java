package com.qf.meituan.beans;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2016/11/8 0008.
 */
public class MyUser extends BmobUser{
    private String age;
    private String myname;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMyname() {
        return myname;
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
