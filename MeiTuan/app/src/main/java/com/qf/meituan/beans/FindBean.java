package com.qf.meituan.beans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class FindBean {

    /**
     * succeed : 1
     */

    private StatusBean status;
    /**
     * status : {"succeed":1}
     * data : [{"title":"晒单分享","content":"没错，就是我中的奖！你来咬我呀","img":"http://static.wowozhe.com/Uploads/APP/2016_3_22_sun.png","url":"http://www.wowozhe.com/app/miaosha/app_jump_sun#isself/target/android/v/310","type":0,"tip_title":"","tip_color":""},{"title":"幸运大转盘，100%有奖!","content":"每日登录即可获得抽奖机会,惊喜等你来!","img":"http://static.wowozhe.com/Uploads/APP/2016_3_10_rotate.png","url":"http://www.wowozhe.com/app/miaosha/app_rotate_activity/target/android/v/310","type":1,"tip_title":"new","tip_color":"#e92d24"},{"title":"不中包赔","content":"不中包赔,你不中我们就赔!","img":"http://static.wowozhe.com/Uploads/APP/menu/2016_4_27_pei.png","url":"http://www.wowozhe.com/app/miaosha/app_miaosha_activity/target/android/v/310","type":0,"tip_title":"new","tip_color":"#e92d24"},{"title":"领取新人红包","content":"新人红包分享即得","img":"http://static.wowozhe.com/Uploads/APP/2016_app_redpakage.png","url":"","type":2,"tip_title":"","tip_color":"","share_info":{"title":"1元能干嘛？买不了吃亏，买不了上当，但能买个苹果6s，哦也~！","content":"1元能干嘛？买不了吃亏，买不了上当，但能买个苹果6s，哦也~！","url":"http://www.teaizhe.com/hd/hd.html","img":"http://s.wowozhe.com/Uploads/APP/share_show.png"}},{"title":"邀请好友得现金","content":"邀请一个好友最高奖励10元","img":"http://static.wowozhe.com/Uploads/APP/people.png","url":"http://www.wowozhe.com/app/miaosha/app_invite","type":1,"tip_title":"","tip_color":""},{"title":"签到领积分","content":"坚持连续签到，积分翻倍！","img":"http://static.wowozhe.com/Uploads/APP/sign.png","url":"http://www.wowozhe.com/app/miaosha/app_sign/v/310/target/android","type":1,"tip_title":"","tip_color":""},{"title":"分享得积分","content":"每日分享，立即得10积分","img":"http://s.wowozhe.com/Uploads/APP/2016_1_14_sign_share.png","url":"http://www.wowozhe.com/app/miaosha/app_sign_show/v/310/target/android","type":1,"tip_title":"","tip_color":""},{"title":"免费赚红包","content":"免费红包,你敢来,我就敢送！","img":"http://static.wowozhe.com/Uploads/APP/wmoney.png","url":"http://www.wowozhe.com/app/miaosha/app_task/target/android","type":1,"tip_title":"","tip_color":""}]
     * login_tips_box :
     */

    private String login_tips_box;
    /**
     * title : 晒单分享
     * content : 没错，就是我中的奖！你来咬我呀
     * img : http://static.wowozhe.com/Uploads/APP/2016_3_22_sun.png
     * url : http://www.wowozhe.com/app/miaosha/app_jump_sun#isself/target/android/v/310
     * type : 0
     * tip_title :
     * tip_color :
     */

    private List<DataBean> data;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public String getLogin_tips_box() {
        return login_tips_box;
    }

    public void setLogin_tips_box(String login_tips_box) {
        this.login_tips_box = login_tips_box;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class StatusBean {
        private int succeed;

        public int getSucceed() {
            return succeed;
        }

        public void setSucceed(int succeed) {
            this.succeed = succeed;
        }
    }

    public static class DataBean {
        private String title;
        private String content;
        private String img;
        private String url;
        private int type;
        private String tip_title;
        private String tip_color;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTip_title() {
            return tip_title;
        }

        public void setTip_title(String tip_title) {
            this.tip_title = tip_title;
        }

        public String getTip_color() {
            return tip_color;
        }

        public void setTip_color(String tip_color) {
            this.tip_color = tip_color;
        }
    }

    @Override
    public String toString() {
        return "FindBean{" +
                "status=" + status +
                ", login_tips_box='" + login_tips_box + '\'' +
                ", data=" + data +
                '}';
    }
}
