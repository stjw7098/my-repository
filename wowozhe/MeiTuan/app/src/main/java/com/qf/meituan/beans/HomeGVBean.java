package com.qf.meituan.beans;

import java.util.List;

/**
 * Created by jun on 2016/11/2.
 */
public class HomeGVBean {

    /**
     * succeed : 1
     */

    private StatusBean status;
    private DataBean data;
    /**
     * total : 2561
     * count : 1
     * more : 1
     * data : 1478085913
     */

    private PaginatedBean paginated;
    /**
     * status : {"succeed":1}
     * data : {"items":[{"id":"136991","title":"男士风衣中长款","img":"http://img03.taobaocdn.com/bao/uploaded/i3/TB1E1goNpXXXXXXapXXXXXXXXXX_!!0-item_pic.jpg_310x310.jpg","price":"198.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DeqazIhlpk6ccQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2fw8%2B1lKWxSMWI6w0dMGH8gPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZ8qspARsEqQ3rP455TTGWCHWWzVhclNnBMYMXU3NNCg%2F","source":"天猫","cid":"2","click":"8","add_time":"1478053013","likes":"2974","comment":"0","preprice":"398.00","iid":"537568879289","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136990","title":"新款韩版毛线围巾","img":"http://img01.taobaocdn.com/bao/uploaded/i1/TB1V5OANXXXXXXhXFXXXXXXXXXX_!!0-item_pic.jpg_310x310.jpg","price":"21.80","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3Dl8ytWSvJhC8cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2fw8%2B1lKWxSMghoTQriFyXwPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z86iPwHIsTgT3nDLnAgUrS9xtnlNaul8rx8YMXU3NNCg%2F","source":"天猫","cid":"35","click":"7","add_time":"1478053013","likes":"2280","comment":"0","preprice":"158.00","iid":"536846311335","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136989","title":"伴娘服短款显瘦","img":"http://img02.taobaocdn.com/bao/uploaded/i2/TB1hLTUMXXXXXbtaXXXXXXXXXXX_!!0-item_pic.jpg_310x310.jpg","price":"65.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DqkUI%2FHakxJccQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2fw8%2B1lKWxSMmSMhGfkQJ74PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9ssKRSSGEILZ55XN%2BimfGVWGLJTxxpAQg50RRRFvsA13EqY%2Bakgpmw","source":"天猫","cid":"1","click":"6","add_time":"1478053013","likes":"1040","comment":"0","preprice":"198.00","iid":"529110438261","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136988","title":"珍美皙洗衣液3kg瓶装","img":"http://img.alicdn.com/imgextra/i1/2618140112/TB28yVrap15V1Bjy1XaXXaPqVXa_!!2618140112.jpg_310x310.jpg","price":"18.80","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DENwMU5GzwZ0cQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2fw8%2B1lKWxSMmSMhGfkQJ74PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z81irBEZbuYClZ%2F3YAV%2B6wSDIsiVBuSmZxcYMXU3NNCg%2F","source":"淘宝","cid":"33","click":"3","add_time":"1478053013","likes":"2958","comment":"0","preprice":"29.90","iid":"534403039327","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136987","title":"男士防滑人字拖","img":"http://img01.taobaocdn.com/bao/uploaded/i1/TB1gYNHMFXXXXbmaXXXXXXXXXXX_!!0-item_pic.jpg_310x310.jpg","price":"19.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DJkWhna56Xn8cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2fw8%2B1lKWxSMD%2FHdSRms18gPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z84qiHglCwR2KInOfk7aNVopL9jqM0eSgO8YMXU3NNCg%2F","source":"天猫","cid":"10","click":"4","add_time":"1478053013","likes":"2094","comment":"0","preprice":"58.00","iid":"534068567269","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136986","title":"婴儿抱被新生儿抱毯可脱胆","img":"http://imgcdn.coubei.com/2016/10/25/13/af937325c6ee8a58764bd1b2f9323bf9.jpg@310w_310h","price":"47.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DIb9WV5ay%2FkIcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2fw8%2B1lKWxSMD%2FHdSRms18gPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z82ZwM7zBSKbHLBLEMxKNrke5zGpd%2FcxcjsYMXU3NNCg%2F","source":"天猫","cid":"4","click":"3","add_time":"1478053012","likes":"2179","comment":"0","preprice":"156.60","iid":"538590229695","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136985","title":"韩版大码上衣衬衣","img":"http://img02.taobaocdn.com/bao/uploaded/i2/2779846245/TB2v6eyaWzyQeBjy0FbXXbZapXa_!!2779846245.jpg_310x310.jpg","price":"45.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3D%2F7r09ac0tiwcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2fw8%2B1lKWxSMVNjKoH%2FaCQMPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z80wpLvfxAugDthIG8oN%2BdJBQDnA91pG4R8YMXU3NNCg%2F","source":"淘宝","cid":"1","click":"8","add_time":"1478053012","likes":"2007","comment":"0","preprice":"138.00","iid":"535581615544","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136984","title":"秋女学院黑色小皮鞋","img":"http://img03.taobaocdn.com/bao/uploaded/i3/181441304/TB298.oXxvzQeBjSZFxXXXLBpXa_!!181441304.jpg_310x310.jpg","price":"25.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DcCnxQ0QjuYocQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2fw8%2B1lKWxSMVNjKoH%2FaCQMPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZ3624K1T4%2BiGEcGWAKtV%2FMTRsmkmDf06YHEqY%2Bakgpmw","source":"淘宝","cid":"10","click":"6","add_time":"1478053012","likes":"1249","comment":"0","preprice":"62.00","iid":"537018387272","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136983","title":"韩版新款女帆布双肩包","img":"http://img03.taobaocdn.com/bao/uploaded/i3/2377030887/TB2qbVAaB_B11BjSspcXXb0sVXa_!!2377030887.jpg_310x310.jpg","price":"19.70","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DopNJdNqWf4ccQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2fw8%2B1lKWxSMP9LlJoUu0c4PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z8x6Bq5ksDBthLyy0a0zzsXAxCW0yApfrycYMXU3NNCg%2F","source":"淘宝","cid":"10","click":"6","add_time":"1478053012","likes":"2199","comment":"0","preprice":"69.00","iid":"539048478102","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136982","title":"冬季女百搭平底鞋","img":"http://image.taobao.com/bao/uploaded/i1/TB1iNOUNXXXXXXaapXXYXGcGpXX_M2.SS2_310x310.jpg","price":"69.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DqsSL0b61Eq0cQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2fw8%2B1lKWxSMP9LlJoUu0c4PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD8F0vcuL%2FIk4gFL7amDu5bMZhEVW8rsybGsKa0%2BCzPsanEqY%2Bakgpmw","source":"淘宝","cid":"10","click":"3","add_time":"1478053012","likes":"1710","comment":"0","preprice":"198.00","iid":"536554763146","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136981","title":"女宽松牛仔裤","img":"http://img01.taobaocdn.com/bao/uploaded/i1/1857522724/TB2Iq.4XBLxQeBjy0FnXXcQwpXa_!!1857522724.jpg_310x310.jpg","price":"45.98","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DSaJhMsDvbkAcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2fw8%2B1lKWxSMTHm2guh0YLsPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZ93NBTwEStzOVgKIjWlqIHF6DBIicHiRo8YMXU3NNCg%2F","source":"淘宝","cid":"1","click":"6","add_time":"1478053012","likes":"2520","comment":"0","preprice":"100.00","iid":"537134958716","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136980","title":"粉慕大码文胸","img":"http://img01.taobaocdn.com/bao/uploaded/i1/TB1uqcsNFXXXXbtXFXXXXXXXXXX_!!0-item_pic.jpg_310x310.jpg","price":"119.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3D6B1jNQ9oQeocQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2fw8%2B1lKWxSM8FptwqKhdbEPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z81uG9G4t%2FmkMcOotP1LDTbaDrBxtqNw4rMYMXU3NNCg%2F","source":"天猫","cid":"1","click":"4","add_time":"1478053012","likes":"2572","comment":"0","preprice":"220.00","iid":"539887096453","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136979","title":"达顿庄园曲奇饼干908g*2盒","img":"http://img.alicdn.com/imgextra/i2/2868229513/TB2605ZXVYC11BjSspfXXXcPFXa_!!2868229513.jpg_310x310.jpg","price":"96.80","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DgFaP8kT4y8wcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2fw8%2B1lKWxSM8FptwqKhdbEPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z86%2BFvaoX9UQvJrh8BjfQQLADOjABIFr%2FbsYMXU3NNCg%2F","source":"天猫","cid":"16","click":"2","add_time":"1478053012","likes":"2290","comment":"0","preprice":"190.00","iid":"538946000598","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136978","title":"黑色连衣裙","img":"http://img04.taobaocdn.com/bao/uploaded/i4/TB1T23kNpXXXXXsXXXXXXXXXXXX_!!0-item_pic.jpg_310x310.jpg","price":"149.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DDoS3faS70LUcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2fw8%2B1lKWxSMsmcYjUfw1pIPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z80X%2Fvw9FD881BXcIRVDmf%2F9j9JUg1zB2TcYMXU3NNCg%2F","source":"天猫","cid":"1","click":"4","add_time":"1478053012","likes":"2576","comment":"0","preprice":"199.00","iid":"538426719441","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136977","title":"男长裤运动裤","img":"http://img.alicdn.com/imgextra/i1/2559277037/TB2yTm9XnnB11BjSspdXXaTIpXa_!!2559277037.jpg_310x310.jpg","price":"59.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DwsuS1fQRTywcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2fw8%2B1lKWxSMNGaA%2Fv7qa0QPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z8%2FW4ByqCOLx78Sb6abSzYMeRbx68xW34y8YMXU3NNCg%2F","source":"淘宝","cid":"2","click":"7","add_time":"1478053012","likes":"1112","comment":"0","preprice":"108.00","iid":"535497967546","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136976","title":"保暖加绒休闲长袖衬衫","img":"http://img04.taobaocdn.com/bao/uploaded/i4/TB11I2vLXXXXXXrXXXXXXXXXXXX_!!0-item_pic.jpg_310x310.jpg","price":"31.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3Df0%2BqEjiQiBIcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2fw8%2B1lKWxSMNGaA%2Fv7qa0QPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z89hYtlL6xtL8KmCnWFQ57EXj61dYAVe1SsYMXU3NNCg%2F","source":"天猫","cid":"2","click":"2","add_time":"1478053012","likes":"1074","comment":"0","preprice":"59.00","iid":"538209031504","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136974","title":"独特压皱设计百褶长裙半裙","img":"http://img.alicdn.com/imgextra/i2/56549726/TB26EqeXNMa61Bjy1zdXXXzcpXa_!!56549726.jpg_310x310.jpg","price":"259.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3Dgu%2BkxDsMHL8cQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2fw8%2B1lKWxSMWI6w0dMGH8gPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9SM%2ByJEnxpDBnPy4A9yzofy08ECcIoysaIy7o1FJX1xSGFCzYOOqAQ","source":"淘宝","cid":"1","click":"6","add_time":"1478053012","likes":"3005","comment":"0","preprice":"500.00","iid":"539604298808","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136973","title":"老北京布鞋女鞋冬季防滑保暖高帮棉鞋老年人鞋子厚底中老人妈妈","img":"http://img.alicdn.com/bao/uploaded/i1/925212467/TB29KV8bXHzQeBjSZFuXXanUpXa_!!925212467.jpg_400x400.jpg","price":"68.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DOhhghSMYHFwcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2TTYtb1StZPPmyBzYSO0LNwPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9gnCgDLxHjH1Qb1i9XWPkQjl0Zzd5Kvhy3C%2F6ElnUzbnEqY%2Bakgpmw","source":"天猫","cid":"10","click":"3","add_time":"1478052391","likes":"1728","comment":"0","preprice":"156.00","iid":"538762280427","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136972","title":"女装秋装2016新款潮毛衣套装裙长袖针织衫两件套时尚包臀半身短裙 ","img":"http://img01.taobaocdn.com/bao/uploaded/i1/79246440/TB2SEX4XCCI.eBjy1XbXXbUBFXa_!!79246440.jpg_400x400.jpg","price":"59.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3D0lac9moF7x8cQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2TTYtb1StZPPmyBzYSO0LNwPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9ssKRSSGEILY6TZ2aKa1EXmVtEyP2nT%2FAwi5Q92bFvDSGFCzYOOqAQ","source":"淘宝","cid":"1","click":"3","add_time":"1478052391","likes":"2007","comment":"0","preprice":"129.00","iid":"540252538391","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136971","title":"新品 韩国边夹 发夹饰品刘海夹字母花朵水钻韩版头饰一字夹鸭嘴夹 ","img":"http://img.alicdn.com/bao/uploaded/i4/2104864475/TB26G9UXeNOdeFjSZFBXXctzXXa_!!2104864475.jpg_400x400.jpg","price":"12.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DBaeMYarMPrccQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2fw8%2B1lKWxSM18u9BjgaVz4PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z86vvWv0mCH42PsMN1fDQowKxtyIL6UMj38YMXU3NNCg%2F","source":"天猫","cid":"35","click":"2","add_time":"1478052391","likes":"2483","comment":"0","preprice":"18.00","iid":"540411371715","is_like":0,"is_open_app":"0","item_type":"item"}],"menu":[{"type":7,"title":"幸运转盘","url":"http://www.wowozhe.com/app/miaosha/app_rotate_activity/v/310/target/android","icon":"http://s.wowozhe.com/Uploads/APP/menu/2016_3_10_discovery.png"},{"type":0,"title":"窝窝网盘","url":"http://pan.wowozhe.com/index.php","icon":"http://static.wowozhe.com/Uploads/APP/2016_8_3_pan.png"},{"type":2,"title":"九块九包邮","url":"","icon":"http://static.wowozhe.com/Uploads/APP/jiukuaijiu2.png"},{"type":7,"title":"签到","url":"http://www.wowozhe.com/app/miaosha/app_sign//v/310/target/android","icon":"http://static.wowozhe.com/Uploads/APP/check.png"}]}
     * paginated : {"total":"2561","count":1,"more":1,"data":1478085913}
     * login_tips_box :
     */

    private String login_tips_box;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public PaginatedBean getPaginated() {
        return paginated;
    }

    public void setPaginated(PaginatedBean paginated) {
        this.paginated = paginated;
    }

    public String getLogin_tips_box() {
        return login_tips_box;
    }

    public void setLogin_tips_box(String login_tips_box) {
        this.login_tips_box = login_tips_box;
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
        /**
         * id : 136991
         * title : 男士风衣中长款
         * img : http://img03.taobaocdn.com/bao/uploaded/i3/TB1E1goNpXXXXXXapXXXXXXXXXX_!!0-item_pic.jpg_310x310.jpg
         * price : 198.00
         * item_url : http://s.click.taobao.com/t?e=m%3D2%26s%3DeqazIhlpk6ccQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2fw8%2B1lKWxSMWI6w0dMGH8gPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZ8qspARsEqQ3rP455TTGWCHWWzVhclNnBMYMXU3NNCg%2F
         * source : 天猫
         * cid : 2
         * click : 8
         * add_time : 1478053013
         * likes : 2974
         * comment : 0
         * preprice : 398.00
         * iid : 537568879289
         * is_like : 0
         * is_open_app : 0
         * item_type : item
         */

        private List<ItemsBean> items;
        /**
         * type : 7
         * title : 幸运转盘
         * url : http://www.wowozhe.com/app/miaosha/app_rotate_activity/v/310/target/android
         * icon : http://s.wowozhe.com/Uploads/APP/menu/2016_3_10_discovery.png
         */

        private List<MenuBean> menu;

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public List<MenuBean> getMenu() {
            return menu;
        }

        public void setMenu(List<MenuBean> menu) {
            this.menu = menu;
        }

        public static class ItemsBean {
            private String id;
            private String title;
            private String img;
            private String price;
            private String item_url;
            private String source;
            private String cid;
            private String click;
            private String add_time;
            private String likes;
            private String comment;
            private String preprice;
            private String iid;
            private int is_like;
            private String is_open_app;
            private String item_type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getItem_url() {
                return item_url;
            }

            public void setItem_url(String item_url) {
                this.item_url = item_url;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getClick() {
                return click;
            }

            public void setClick(String click) {
                this.click = click;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getPreprice() {
                return preprice;
            }

            public void setPreprice(String preprice) {
                this.preprice = preprice;
            }

            public String getIid() {
                return iid;
            }

            public void setIid(String iid) {
                this.iid = iid;
            }

            public int getIs_like() {
                return is_like;
            }

            public void setIs_like(int is_like) {
                this.is_like = is_like;
            }

            public String getIs_open_app() {
                return is_open_app;
            }

            public void setIs_open_app(String is_open_app) {
                this.is_open_app = is_open_app;
            }

            public String getItem_type() {
                return item_type;
            }

            public void setItem_type(String item_type) {
                this.item_type = item_type;
            }
        }

        public static class MenuBean {
            private int type;
            private String title;
            private String url;
            private String icon;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }

    public static class PaginatedBean {
        private String total;
        private int count;
        private int more;
        private int data;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getMore() {
            return more;
        }

        public void setMore(int more) {
            this.more = more;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
