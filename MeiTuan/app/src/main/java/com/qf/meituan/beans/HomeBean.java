package com.qf.meituan.beans;

import java.util.List;

/**
 * Created by jun on 2016/11/1.
 */
public class HomeBean {

    /**
     * succeed : 1
     */

    private StatusBean status;
    /**
     * adver_info : [{"id":"3041798","title":"100%包赔商品","content":"Apple iPhone SE 64GB 颜色随机","type":"web","img":"http://static.wowozhe.com/Uploads/APP/menu/2016_5_3_pei.png","url":"http://www.wowozhe.com/app/miaosha/app_miaosha_activity"},{"id":"3041877","title":"1元抢飞机","content":"大疆无人机","type":"miaosha","url":"","img":"http://static.wowozhe.com/Uploads/Picture/2016-01-18/569cc6fba09a9.jpg"},{"id":"3042075","title":"1元抢话费","content":"100元话费","type":"miaosha","url":"","img":"http://static.wowozhe.com/Uploads/Picture/2016-03-17/56ea2046c4c57.png"}]
     * slider : [{"id":"777","img":"http://static.wowozhe.com/Uploads/APP/slider/2016_8_3_slider_pan.png","title":"网盘","descript":"网盘","url":"http://pan.wowozhe.com/","type":0,"callback_url":""},{"id":"","img":"http://static.wowozhe.com/Uploads/APP/slider/2016_7_14_2.png","title":"食品","descript":"","url":"食品","type":4,"callback_url":""},{"id":"3042057","img":"http://static.wowozhe.com/Uploads/APP/slider/2016_9_19_iphone7.jpg","title":"夺宝","descript":"","url":"","type":6,"callback_url":""},{"id":"2416869","img":"http://static.wowozhe.com/Uploads/APP/index/2016_7_14_jiukuaijiu.png","title":"女鞋","descript":"","url":"女鞋","type":9,"callback_url":""}]
     * update_time : 1427424600
     * items : [{"id":"3041852","name":"【100%赔】苹果iPhone 7 Plus 32G版","money":"7200.00","usedcount":"2450","residuecount":"4750","ygpid":"6720cc5e7eb1bbb1ad56b801eacf8e11","nper":"65","photos":"http://static.wowozhe.com/Uploads/Picture/2016-09-20/57e0f8b8d44ff_a.jpg","states":"11","item_type":"miaosha","totalCount":7200},{"id":"3041985","name":"Apple iPhone 6s 16G版","money":"5288.00","usedcount":"2101","residuecount":"3187","ygpid":"c7e15a1cf3aa2a6ffebc7c22279208ad","nper":"1839","photos":"http://static.wowozhe.com/Uploads/Picture/2016-05-30/574b988029670_a.png","states":"1","item_type":"miaosha","totalCount":5288},{"id":"3041312","name":"【100%赔】苹果iPhone 7 32G版","money":"6300.00","usedcount":"5640","residuecount":"660","ygpid":"3d53efa54a0886abdbf26baf2402171e","nper":"67","photos":"http://static.wowozhe.com/Uploads/Picture/2016-09-20/57e0f8db57ec8_a.jpg","states":"11","item_type":"miaosha","totalCount":6300},{"id":"3042057","name":"苹果iPhone 7 Plus 32G版","money":"7188.00","usedcount":"2308","residuecount":"4880","ygpid":"5474b5717cfe5e5334e75aa40d9686e9","nper":"382","photos":"http://static.wowozhe.com/Uploads/Picture/2016-09-20/57e0f8b8d44ff_a.jpg","states":"1","item_type":"miaosha","totalCount":7188},{"id":"3041648","name":"【100%赔】Apple iPhone 6s 16G版","money":"5450.00","usedcount":"2780","residuecount":"2670","ygpid":"784b6d057a45e78dc3657cff00d16b16","nper":"577","photos":"http://static.wowozhe.com/Uploads/Picture/2016-05-30/574b988029670_a.png","states":"11","item_type":"miaosha","totalCount":5450},{"id":"3041917","name":"小米 九号平衡车 智能代步体感车","money":"2298.00","usedcount":"2181","residuecount":"117","ygpid":"832c47a86b87ad1600d33e758033e9c2","nper":"1537","photos":"http://static.wowozhe.com/Uploads/Picture/2016-05-24/57441b03c85d9_a.jpg","states":"1","item_type":"miaosha","totalCount":2298},{"id":"135989","title":"天猫双十一","img":"http://static.wowozhe.com/Uploads/Picture/2016-10-21/1477015983.jpg","price":"11.11","item_url":"http://s.click.taobao.com/tYkYWQx","source":"天猫","cid":"32","click":"99","add_time":"1477016244","likes":"2080","comment":"0","preprice":"11.11","iid":"0","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136854","title":"依馨蜜缘无缝保暖内衣套装女士内衣","img":"http://img02.taobaocdn.com/bao/uploaded/i2/TB1oGlbNVXXXXcAXpXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"21.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DeqDAD0ac%2BbccQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4mJ%2BAVY%2F4wKC0PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD%2B%2BWWkbyVLWEMb8SH9FpyzlbxNYt3iYq7W39HjvU6nRPnEqY%2Bakgpmw","source":"天猫","cid":"1","click":"14","add_time":"1477880517","likes":"1653","comment":"0","preprice":"159.00","iid":"539323867319","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"132899","title":"2016儿童打底裤外穿宝宝女童秋季款九分裤长裤子童裤纯棉秋装外穿","img":"https://img.alicdn.com/imgextra/i1/TB1GmGMJFXXXXaLaXXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"13.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DrG1hmByaRu4cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QsN59NWLE6pbJxUEh8sgi8PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z85ap5BrAiFQ1zPrlBrIDLc%2F69bwY6ZAUXcYMXU3NNCg%2F","source":"天猫","cid":"34","click":"26","add_time":"1477880518","likes":"2291","comment":"0","preprice":"48.00","iid":"533056259383","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136875","title":"女神圈有钢圈聚拢文胸调整型秋冬性感蕾丝胸罩","img":"http://img04.taobaocdn.com/bao/uploaded/i4/TB18omwNFXXXXaAaXXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"29.80","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DOQpVKOWvrWEcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4m%2Fl0%2B1yuzCtIPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z8zmcGhcjQaDBr4hum%2B36PZSPpbaq6avfpcYMXU3NNCg%2F","source":"天猫","cid":"1","click":"6","add_time":"1477880518","likes":"1695","comment":"0","preprice":"55.00","iid":"538643075585","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136876","title":"包邮低帮平底板鞋帆布女鞋懒人鞋小白鞋全黑色工作鞋魔术贴球鞋女","img":"https://gd1.alicdn.com/imgextra/i1/191614205/TB2m_P7XGi5V1BjSspaXXbrApXa_!!191614205.jpg_400x400","price":"29.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DsEqOSLKPg6McQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4m%2Fl0%2B1yuzCtIPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZwFmaaYRIHtvYMe%2FgqQCzw%2FNIIzb9xQhzHEqY%2Bakgpmw","source":"淘宝","cid":"10","click":"9","add_time":"1477880518","likes":"2083","comment":"0","preprice":"129.00","iid":"536093583658","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136855","title":"冬季厚底男鞋保暖低帮棉鞋休闲平底板鞋英伦潮男士加绒商务工装鞋","img":"http://img03.taobaocdn.com/bao/uploaded/i3/408446144/TB23og0XF95V1Bjy0FbXXawipXa_!!408446144.jpg_400x400","price":"29.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3Dtu3y0SN7jewcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mkJM98MoZX0gPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD8F0vcuL%2FIk4kfynOke355eLStRYlnD%2BujHftdG0RbhAHEqY%2Bakgpmw","source":"淘宝","cid":"10","click":"10","add_time":"1477880517","likes":"1154","comment":"0","preprice":"188.00","iid":"522866855752","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136857","title":"正品特价羽绒内胆男装加厚加大款内衣清仓中老年保暖内外穿羽绒服","img":"http://img01.taobaocdn.com/bao/uploaded/i1/TB1ll.xGXXXXXaZXFXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"58.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DCrWMuP%2Bdrz8cQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mNMWYSf9G9hEPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZ59GAusYBFofSrtfF0Sa9cvrKtPK85NjOnEqY%2Bakgpmw","source":"淘宝","cid":"2","click":"10","add_time":"1477880517","likes":"2442","comment":"0","preprice":"256.00","iid":"21998627884","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136858","title":"2016秋装新款两件套加厚性感包臀连衣裙","img":"http://img03.taobaocdn.com/bao/uploaded/i3/TB1crv3NXXXXXbOXpXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"29.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DaV%2FzvBiR9R8cQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mNMWYSf9G9hEPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9ssKRSSGEILTfxCvaRs8%2BybMQhEwtAHoH9RnvXGDg583EqY%2Bakgpmw","source":"淘宝","cid":"1","click":"10","add_time":"1477880517","likes":"1469","comment":"0","preprice":"88.00","iid":"538382973507","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136859","title":"秋季皮鞋男真皮休闲男士商务皮鞋圆头透气父亲鞋牛皮中老年爸爸鞋","img":"http://img04.taobaocdn.com/bao/uploaded/i4/362521779/TB2Tha0Xnga61BjSspfXXadSpXa_!!362521779.jpg_400x400","price":"39.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DE2OhaeeLY3EcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4m%2Bx%2FKLma%2BVNkPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9wDOHys66%2Fz%2FbdnCm3CalfWFJn%2FWaXKcTybQReJ6DCXHEqY%2Bakgpmw","source":"淘宝","cid":"10","click":"10","add_time":"1477880517","likes":"2877","comment":"0","preprice":"268.00","iid":"537344053151","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136860","title":"秋冬季长袖印花修身中年保暖衬衣男装加绒加厚款男针织衫爸爸装寸","img":"http://img03.taobaocdn.com/bao/uploaded/i3/TB1mLd8NpXXXXaWXVXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"39.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3D4Yp4z09R1iocQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4m%2Bx%2FKLma%2BVNkPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z82Ou1WVDLvsB6flkLHlapWJ558ummxT2ZsYMXU3NNCg%2F","source":"天猫","cid":"2","click":"11","add_time":"1477880517","likes":"1745","comment":"0","preprice":"398.00","iid":"538467218164","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136861","title":"【天天特价】老北京布鞋女士棉鞋中老年防滑短靴加厚保暖妈妈雪地","img":"http://img03.taobaocdn.com/bao/uploaded/i3/1072049346/TB2qQOdipXXXXbeXpXXXXXXXXXX_!!1072049346.jpg_400x400","price":"14.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DHfhfWA4mAawcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mxqmPbz6xcicPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZyY9do2hYxeDlw9XKYEZGLpd8Mi1sqsH3cYMXU3NNCg%2F","source":"淘宝","cid":"10","click":"9","add_time":"1477880517","likes":"2132","comment":"0","preprice":"109.00","iid":"526447025372","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136862","title":"秋冬季中年男士长袖纯棉t恤爸爸体恤大码中老年翻领加绒加厚男装T","img":"http://img03.taobaocdn.com/bao/uploaded/i3/TB15AunNVXXXXXQXXXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"39.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DRpA6wx3q82QcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mxqmPbz6xcicPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z8%2BZX%2Bg8Xxx%2FKquEnP%2Ffb0s8Wq%2Bn7lehgacYMXU3NNCg%2F","source":"淘宝","cid":"2","click":"5","add_time":"1477880517","likes":"1355","comment":"0","preprice":"108.00","iid":"536746746721","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136863","title":"馨诗居水精灵强力去渍酵素有氧洗衣粉厨房油污清洁剂清洗剂500g","img":"http://img02.taobaocdn.com/bao/uploaded/i2/TB12py9NFXXXXXRaXXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"10.80","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3D7lxL6lJ%2FZhwcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4mLzyWwQxzkU8PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z855D552UparGgGwWhVxBDFr6WLdWl4ut8cYMXU3NNCg%2F","source":"天猫","cid":"33","click":"10","add_time":"1477880517","likes":"1365","comment":"0","preprice":"56.00","iid":"539421274804","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136864","title":"2016秋季新款童装女童打底裤春秋款外穿长裤中大儿童公主打底裤","img":"http://img01.taobaocdn.com/bao/uploaded/i1/TB15eNANFXXXXbVXFXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"39.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DC8JBpzNBUO0cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4mLzyWwQxzkU8PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z8%2BP%2FZg60fn1z%2FS0%2BKyAfOiPyuuUdipM7ccYMXU3NNCg%2F","source":"天猫","cid":"34","click":"14","add_time":"1477880517","likes":"2063","comment":"0","preprice":"168.00","iid":"535869645155","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136866","title":"职业包臀半身裙弹力西装包裙冬大码显瘦一步裙黑色OL工作短裙女秋","img":"http://img01.taobaocdn.com/bao/uploaded/i1/2742811513/TB2m0.UtVXXXXaSXpXXXXXXXXXX_!!2742811513.jpg_400x400","price":"29.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DnoWxYS%2B0xHQcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mbJxUEh8sgi8PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z89k955haVgGlDnLGfuPC7LoL7eQzLu%2FIx8YMXU3NNCg%2F","source":"淘宝","cid":"1","click":"6","add_time":"1477880517","likes":"1988","comment":"0","preprice":"169.00","iid":"536215087641","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136867","title":"卫衣男2016秋冬运动套装男修身外套装男青少年休闲加绒卫衣男装","img":"http://img04.taobaocdn.com/bao/uploaded/i4/TB1QzHBNVXXXXblapXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"39.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DDagHVAzFBK8cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4mIfNVgZHErC4PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z81FuSTjpdANptFD74IHgDv7RTkAxuBtUfcYMXU3NNCg%2F","source":"天猫","cid":"2","click":"9","add_time":"1477880517","likes":"1927","comment":"0","preprice":"369.00","iid":"538780581276","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136868","title":"蕾丝针织打底衫女长袖秋冬女装大码宽松上衣中长款包臀毛衣连衣裙","img":"http://img01.taobaocdn.com/bao/uploaded/i1/829181956/TB2KVJ8bNvzQeBjSZFqXXXN5VXa_!!829181956.jpg_400x400","price":"45.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DHFqFEVH1XNscQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mP5bxJy%2F%2Fu7gPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD%2FnFXCkOmgDkzScWANjp4NMacPmUgzccfZU9qT4c4G90HEqY%2Bakgpmw","source":"淘宝","cid":"1","click":"14","add_time":"1477880517","likes":"1526","comment":"0","preprice":"128.00","iid":"539054824670","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136869","title":"秋冬季新款法兰绒睡衣女长袖可爱纯棉大码宽松保暖家居服套装加厚","img":"http://img02.taobaocdn.com/bao/uploaded/i2/2087869606/TB2kG3VaRLzQeBjSZFjXXcscpXa_!!2087869606.jpg_400x400","price":"49.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DwdOzvlBdoAocQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mP5bxJy%2F%2Fu7gPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z8%2F0asgJcZ%2FJ7cf3HeceGB59PbuEb%2BKjOfcYMXU3NNCg%2F","source":"淘宝","cid":"1","click":"6","add_time":"1477880517","likes":"1078","comment":"0","preprice":"99.00","iid":"537053761605","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136870","title":"2016春秋薄款拉链开衫青少年运动连帽卫衣大码休闲男士外套上衣潮","img":"http://img04.taobaocdn.com/bao/uploaded/i4/1603695835/TB2eNARXBzA11Bjy0FbXXcRXVXa_!!1603695835.jpg_400x400","price":"59.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3D9YMJSmisURocQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mZW1Lr5j6DecPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZ71rgbXlZqA2D5CD2NhngAlONFOEBteP0sYMXU3NNCg%2F","source":"淘宝","cid":"2","click":"6","add_time":"1477880517","likes":"2184","comment":"0","preprice":"108.00","iid":"537690608688","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136872","title":"男士保暖内衣加厚加绒保暖内衣男秋冬套装青年圆领秋衣秋裤","img":"http://img01.taobaocdn.com/bao/uploaded/i1/2456121623/TB27oBcsFXXXXXJXpXXXXXXXXXX_!!2456121623.jpg_400x400","price":"19.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DZ9kKod2p6SUcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mxlg8LvO%2Bev8PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z86Si%2Bt55%2FLi33cERbtGrpMaeBTMYu4pRD8YMXU3NNCg%2F","source":"淘宝","cid":"2","click":"10","add_time":"1477880517","likes":"2448","comment":"0","preprice":"19.90","iid":"535328567306","is_like":0,"is_open_app":"0","item_type":"item"}]
     * menu : [{"type":7,"title":"幸运转盘","url":"http://www.wowozhe.com/app/miaosha/app_rotate_activity/v/310/target/android","icon":"http://s.wowozhe.com/Uploads/APP/menu/2016_3_10_discovery.png"},{"type":0,"title":"窝窝网盘","url":"http://pan.wowozhe.com/index.php","icon":"http://static.wowozhe.com/Uploads/APP/2016_8_3_pan.png"},{"type":2,"title":"九块九包邮","url":"","icon":"http://static.wowozhe.com/Uploads/APP/jiukuaijiu2.png"},{"type":7,"title":"签到","url":"http://www.wowozhe.com/app/miaosha/app_sign//v/310/target/android","icon":"http://static.wowozhe.com/Uploads/APP/check.png"}]
     */

    private DataBean data;
    /**
     * total : 2856
     * count : 1
     * more : 1
     * data : 1477966983
     */

    private PaginatedBean paginated;
    /**
     * status : {"succeed":1}
     * data : {"adver_info":[{"id":"3041798","title":"100%包赔商品","content":"Apple iPhone SE 64GB 颜色随机","type":"web","img":"http://static.wowozhe.com/Uploads/APP/menu/2016_5_3_pei.png","url":"http://www.wowozhe.com/app/miaosha/app_miaosha_activity"},{"id":"3041877","title":"1元抢飞机","content":"大疆无人机","type":"miaosha","url":"","img":"http://static.wowozhe.com/Uploads/Picture/2016-01-18/569cc6fba09a9.jpg"},{"id":"3042075","title":"1元抢话费","content":"100元话费","type":"miaosha","url":"","img":"http://static.wowozhe.com/Uploads/Picture/2016-03-17/56ea2046c4c57.png"}],"slider":[{"id":"777","img":"http://static.wowozhe.com/Uploads/APP/slider/2016_8_3_slider_pan.png","title":"网盘","descript":"网盘","url":"http://pan.wowozhe.com/","type":0,"callback_url":""},{"id":"","img":"http://static.wowozhe.com/Uploads/APP/slider/2016_7_14_2.png","title":"食品","descript":"","url":"食品","type":4,"callback_url":""},{"id":"3042057","img":"http://static.wowozhe.com/Uploads/APP/slider/2016_9_19_iphone7.jpg","title":"夺宝","descript":"","url":"","type":6,"callback_url":""},{"id":"2416869","img":"http://static.wowozhe.com/Uploads/APP/index/2016_7_14_jiukuaijiu.png","title":"女鞋","descript":"","url":"女鞋","type":9,"callback_url":""}],"update_time":1427424600,"items":[{"id":"3041852","name":"【100%赔】苹果iPhone 7 Plus 32G版","money":"7200.00","usedcount":"2450","residuecount":"4750","ygpid":"6720cc5e7eb1bbb1ad56b801eacf8e11","nper":"65","photos":"http://static.wowozhe.com/Uploads/Picture/2016-09-20/57e0f8b8d44ff_a.jpg","states":"11","item_type":"miaosha","totalCount":7200},{"id":"3041985","name":"Apple iPhone 6s 16G版","money":"5288.00","usedcount":"2101","residuecount":"3187","ygpid":"c7e15a1cf3aa2a6ffebc7c22279208ad","nper":"1839","photos":"http://static.wowozhe.com/Uploads/Picture/2016-05-30/574b988029670_a.png","states":"1","item_type":"miaosha","totalCount":5288},{"id":"3041312","name":"【100%赔】苹果iPhone 7 32G版","money":"6300.00","usedcount":"5640","residuecount":"660","ygpid":"3d53efa54a0886abdbf26baf2402171e","nper":"67","photos":"http://static.wowozhe.com/Uploads/Picture/2016-09-20/57e0f8db57ec8_a.jpg","states":"11","item_type":"miaosha","totalCount":6300},{"id":"3042057","name":"苹果iPhone 7 Plus 32G版","money":"7188.00","usedcount":"2308","residuecount":"4880","ygpid":"5474b5717cfe5e5334e75aa40d9686e9","nper":"382","photos":"http://static.wowozhe.com/Uploads/Picture/2016-09-20/57e0f8b8d44ff_a.jpg","states":"1","item_type":"miaosha","totalCount":7188},{"id":"3041648","name":"【100%赔】Apple iPhone 6s 16G版","money":"5450.00","usedcount":"2780","residuecount":"2670","ygpid":"784b6d057a45e78dc3657cff00d16b16","nper":"577","photos":"http://static.wowozhe.com/Uploads/Picture/2016-05-30/574b988029670_a.png","states":"11","item_type":"miaosha","totalCount":5450},{"id":"3041917","name":"小米 九号平衡车 智能代步体感车","money":"2298.00","usedcount":"2181","residuecount":"117","ygpid":"832c47a86b87ad1600d33e758033e9c2","nper":"1537","photos":"http://static.wowozhe.com/Uploads/Picture/2016-05-24/57441b03c85d9_a.jpg","states":"1","item_type":"miaosha","totalCount":2298},{"id":"135989","title":"天猫双十一","img":"http://static.wowozhe.com/Uploads/Picture/2016-10-21/1477015983.jpg","price":"11.11","item_url":"http://s.click.taobao.com/tYkYWQx","source":"天猫","cid":"32","click":"99","add_time":"1477016244","likes":"2080","comment":"0","preprice":"11.11","iid":"0","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136854","title":"依馨蜜缘无缝保暖内衣套装女士内衣","img":"http://img02.taobaocdn.com/bao/uploaded/i2/TB1oGlbNVXXXXcAXpXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"21.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DeqDAD0ac%2BbccQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4mJ%2BAVY%2F4wKC0PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD%2B%2BWWkbyVLWEMb8SH9FpyzlbxNYt3iYq7W39HjvU6nRPnEqY%2Bakgpmw","source":"天猫","cid":"1","click":"14","add_time":"1477880517","likes":"1653","comment":"0","preprice":"159.00","iid":"539323867319","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"132899","title":"2016儿童打底裤外穿宝宝女童秋季款九分裤长裤子童裤纯棉秋装外穿","img":"https://img.alicdn.com/imgextra/i1/TB1GmGMJFXXXXaLaXXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"13.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DrG1hmByaRu4cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QsN59NWLE6pbJxUEh8sgi8PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z85ap5BrAiFQ1zPrlBrIDLc%2F69bwY6ZAUXcYMXU3NNCg%2F","source":"天猫","cid":"34","click":"26","add_time":"1477880518","likes":"2291","comment":"0","preprice":"48.00","iid":"533056259383","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136875","title":"女神圈有钢圈聚拢文胸调整型秋冬性感蕾丝胸罩","img":"http://img04.taobaocdn.com/bao/uploaded/i4/TB18omwNFXXXXaAaXXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"29.80","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DOQpVKOWvrWEcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4m%2Fl0%2B1yuzCtIPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z8zmcGhcjQaDBr4hum%2B36PZSPpbaq6avfpcYMXU3NNCg%2F","source":"天猫","cid":"1","click":"6","add_time":"1477880518","likes":"1695","comment":"0","preprice":"55.00","iid":"538643075585","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136876","title":"包邮低帮平底板鞋帆布女鞋懒人鞋小白鞋全黑色工作鞋魔术贴球鞋女","img":"https://gd1.alicdn.com/imgextra/i1/191614205/TB2m_P7XGi5V1BjSspaXXbrApXa_!!191614205.jpg_400x400","price":"29.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DsEqOSLKPg6McQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4m%2Fl0%2B1yuzCtIPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZwFmaaYRIHtvYMe%2FgqQCzw%2FNIIzb9xQhzHEqY%2Bakgpmw","source":"淘宝","cid":"10","click":"9","add_time":"1477880518","likes":"2083","comment":"0","preprice":"129.00","iid":"536093583658","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136855","title":"冬季厚底男鞋保暖低帮棉鞋休闲平底板鞋英伦潮男士加绒商务工装鞋","img":"http://img03.taobaocdn.com/bao/uploaded/i3/408446144/TB23og0XF95V1Bjy0FbXXawipXa_!!408446144.jpg_400x400","price":"29.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3Dtu3y0SN7jewcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mkJM98MoZX0gPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD8F0vcuL%2FIk4kfynOke355eLStRYlnD%2BujHftdG0RbhAHEqY%2Bakgpmw","source":"淘宝","cid":"10","click":"10","add_time":"1477880517","likes":"1154","comment":"0","preprice":"188.00","iid":"522866855752","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136857","title":"正品特价羽绒内胆男装加厚加大款内衣清仓中老年保暖内外穿羽绒服","img":"http://img01.taobaocdn.com/bao/uploaded/i1/TB1ll.xGXXXXXaZXFXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"58.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DCrWMuP%2Bdrz8cQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mNMWYSf9G9hEPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZ59GAusYBFofSrtfF0Sa9cvrKtPK85NjOnEqY%2Bakgpmw","source":"淘宝","cid":"2","click":"10","add_time":"1477880517","likes":"2442","comment":"0","preprice":"256.00","iid":"21998627884","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136858","title":"2016秋装新款两件套加厚性感包臀连衣裙","img":"http://img03.taobaocdn.com/bao/uploaded/i3/TB1crv3NXXXXXbOXpXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"29.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DaV%2FzvBiR9R8cQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mNMWYSf9G9hEPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9ssKRSSGEILTfxCvaRs8%2BybMQhEwtAHoH9RnvXGDg583EqY%2Bakgpmw","source":"淘宝","cid":"1","click":"10","add_time":"1477880517","likes":"1469","comment":"0","preprice":"88.00","iid":"538382973507","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136859","title":"秋季皮鞋男真皮休闲男士商务皮鞋圆头透气父亲鞋牛皮中老年爸爸鞋","img":"http://img04.taobaocdn.com/bao/uploaded/i4/362521779/TB2Tha0Xnga61BjSspfXXadSpXa_!!362521779.jpg_400x400","price":"39.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DE2OhaeeLY3EcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4m%2Bx%2FKLma%2BVNkPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9wDOHys66%2Fz%2FbdnCm3CalfWFJn%2FWaXKcTybQReJ6DCXHEqY%2Bakgpmw","source":"淘宝","cid":"10","click":"10","add_time":"1477880517","likes":"2877","comment":"0","preprice":"268.00","iid":"537344053151","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136860","title":"秋冬季长袖印花修身中年保暖衬衣男装加绒加厚款男针织衫爸爸装寸","img":"http://img03.taobaocdn.com/bao/uploaded/i3/TB1mLd8NpXXXXaWXVXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"39.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3D4Yp4z09R1iocQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4m%2Bx%2FKLma%2BVNkPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z82Ou1WVDLvsB6flkLHlapWJ558ummxT2ZsYMXU3NNCg%2F","source":"天猫","cid":"2","click":"11","add_time":"1477880517","likes":"1745","comment":"0","preprice":"398.00","iid":"538467218164","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136861","title":"【天天特价】老北京布鞋女士棉鞋中老年防滑短靴加厚保暖妈妈雪地","img":"http://img03.taobaocdn.com/bao/uploaded/i3/1072049346/TB2qQOdipXXXXbeXpXXXXXXXXXX_!!1072049346.jpg_400x400","price":"14.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DHfhfWA4mAawcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mxqmPbz6xcicPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZyY9do2hYxeDlw9XKYEZGLpd8Mi1sqsH3cYMXU3NNCg%2F","source":"淘宝","cid":"10","click":"9","add_time":"1477880517","likes":"2132","comment":"0","preprice":"109.00","iid":"526447025372","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136862","title":"秋冬季中年男士长袖纯棉t恤爸爸体恤大码中老年翻领加绒加厚男装T","img":"http://img03.taobaocdn.com/bao/uploaded/i3/TB15AunNVXXXXXQXXXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"39.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DRpA6wx3q82QcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mxqmPbz6xcicPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z8%2BZX%2Bg8Xxx%2FKquEnP%2Ffb0s8Wq%2Bn7lehgacYMXU3NNCg%2F","source":"淘宝","cid":"2","click":"5","add_time":"1477880517","likes":"1355","comment":"0","preprice":"108.00","iid":"536746746721","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136863","title":"馨诗居水精灵强力去渍酵素有氧洗衣粉厨房油污清洁剂清洗剂500g","img":"http://img02.taobaocdn.com/bao/uploaded/i2/TB12py9NFXXXXXRaXXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"10.80","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3D7lxL6lJ%2FZhwcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4mLzyWwQxzkU8PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z855D552UparGgGwWhVxBDFr6WLdWl4ut8cYMXU3NNCg%2F","source":"天猫","cid":"33","click":"10","add_time":"1477880517","likes":"1365","comment":"0","preprice":"56.00","iid":"539421274804","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136864","title":"2016秋季新款童装女童打底裤春秋款外穿长裤中大儿童公主打底裤","img":"http://img01.taobaocdn.com/bao/uploaded/i1/TB15eNANFXXXXbVXFXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"39.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DC8JBpzNBUO0cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4mLzyWwQxzkU8PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z8%2BP%2FZg60fn1z%2FS0%2BKyAfOiPyuuUdipM7ccYMXU3NNCg%2F","source":"天猫","cid":"34","click":"14","add_time":"1477880517","likes":"2063","comment":"0","preprice":"168.00","iid":"535869645155","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136866","title":"职业包臀半身裙弹力西装包裙冬大码显瘦一步裙黑色OL工作短裙女秋","img":"http://img01.taobaocdn.com/bao/uploaded/i1/2742811513/TB2m0.UtVXXXXaSXpXXXXXXXXXX_!!2742811513.jpg_400x400","price":"29.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DnoWxYS%2B0xHQcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mbJxUEh8sgi8PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z89k955haVgGlDnLGfuPC7LoL7eQzLu%2FIx8YMXU3NNCg%2F","source":"淘宝","cid":"1","click":"6","add_time":"1477880517","likes":"1988","comment":"0","preprice":"169.00","iid":"536215087641","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136867","title":"卫衣男2016秋冬运动套装男修身外套装男青少年休闲加绒卫衣男装","img":"http://img04.taobaocdn.com/bao/uploaded/i4/TB1QzHBNVXXXXblapXXXXXXXXXX_!!0-item_pic.jpg_400x400","price":"39.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DDagHVAzFBK8cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QzyddgwFT4mIfNVgZHErC4PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z81FuSTjpdANptFD74IHgDv7RTkAxuBtUfcYMXU3NNCg%2F","source":"天猫","cid":"2","click":"9","add_time":"1477880517","likes":"1927","comment":"0","preprice":"369.00","iid":"538780581276","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136868","title":"蕾丝针织打底衫女长袖秋冬女装大码宽松上衣中长款包臀毛衣连衣裙","img":"http://img01.taobaocdn.com/bao/uploaded/i1/829181956/TB2KVJ8bNvzQeBjSZFqXXXN5VXa_!!829181956.jpg_400x400","price":"45.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DHFqFEVH1XNscQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mP5bxJy%2F%2Fu7gPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD%2FnFXCkOmgDkzScWANjp4NMacPmUgzccfZU9qT4c4G90HEqY%2Bakgpmw","source":"淘宝","cid":"1","click":"14","add_time":"1477880517","likes":"1526","comment":"0","preprice":"128.00","iid":"539054824670","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136869","title":"秋冬季新款法兰绒睡衣女长袖可爱纯棉大码宽松保暖家居服套装加厚","img":"http://img02.taobaocdn.com/bao/uploaded/i2/2087869606/TB2kG3VaRLzQeBjSZFjXXcscpXa_!!2087869606.jpg_400x400","price":"49.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DwdOzvlBdoAocQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mP5bxJy%2F%2Fu7gPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z8%2F0asgJcZ%2FJ7cf3HeceGB59PbuEb%2BKjOfcYMXU3NNCg%2F","source":"淘宝","cid":"1","click":"6","add_time":"1477880517","likes":"1078","comment":"0","preprice":"99.00","iid":"537053761605","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136870","title":"2016春秋薄款拉链开衫青少年运动连帽卫衣大码休闲男士外套上衣潮","img":"http://img04.taobaocdn.com/bao/uploaded/i4/1603695835/TB2eNARXBzA11Bjy0FbXXcRXVXa_!!1603695835.jpg_400x400","price":"59.00","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3D9YMJSmisURocQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mZW1Lr5j6DecPCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD9Tu7cuuK%2BkZ71rgbXlZqA2D5CD2NhngAlONFOEBteP0sYMXU3NNCg%2F","source":"淘宝","cid":"2","click":"6","add_time":"1477880517","likes":"2184","comment":"0","preprice":"108.00","iid":"537690608688","is_like":0,"is_open_app":"0","item_type":"item"},{"id":"136872","title":"男士保暖内衣加厚加绒保暖内衣男秋冬套装青年圆领秋衣秋裤","img":"http://img01.taobaocdn.com/bao/uploaded/i1/2456121623/TB27oBcsFXXXXXJXpXXXXXXXXXX_!!2456121623.jpg_400x400","price":"19.90","item_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DZ9kKod2p6SUcQipKwQzePOeEDrYVVa64Qih%2F7PxfOKS5VBFTL4hn2QzyddgwFT4mxlg8LvO%2Bev8PCfyiAiNw3C7gcHmrTqM%2BLGOuAcW%2BoD914lBCtU3Z86Si%2Bt55%2FLi33cERbtGrpMaeBTMYu4pRD8YMXU3NNCg%2F","source":"淘宝","cid":"2","click":"10","add_time":"1477880517","likes":"2448","comment":"0","preprice":"19.90","iid":"535328567306","is_like":0,"is_open_app":"0","item_type":"item"}],"menu":[{"type":7,"title":"幸运转盘","url":"http://www.wowozhe.com/app/miaosha/app_rotate_activity/v/310/target/android","icon":"http://s.wowozhe.com/Uploads/APP/menu/2016_3_10_discovery.png"},{"type":0,"title":"窝窝网盘","url":"http://pan.wowozhe.com/index.php","icon":"http://static.wowozhe.com/Uploads/APP/2016_8_3_pan.png"},{"type":2,"title":"九块九包邮","url":"","icon":"http://static.wowozhe.com/Uploads/APP/jiukuaijiu2.png"},{"type":7,"title":"签到","url":"http://www.wowozhe.com/app/miaosha/app_sign//v/310/target/android","icon":"http://static.wowozhe.com/Uploads/APP/check.png"}]}
     * paginated : {"total":2856,"count":1,"more":1,"data":1477966983}
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
        private int update_time;
        /**
         * id : 3041798
         * title : 100%包赔商品
         * content : Apple iPhone SE 64GB 颜色随机
         * type : web
         * img : http://static.wowozhe.com/Uploads/APP/menu/2016_5_3_pei.png
         * url : http://www.wowozhe.com/app/miaosha/app_miaosha_activity
         */

        private List<AdverInfoBean> adver_info;
        /**
         * id : 777
         * img : http://static.wowozhe.com/Uploads/APP/slider/2016_8_3_slider_pan.png
         * title : 网盘
         * descript : 网盘
         * url : http://pan.wowozhe.com/
         * type : 0
         * callback_url :
         */

        private List<SliderBean> slider;
        /**
         * id : 3041852
         * name : 【100%赔】苹果iPhone 7 Plus 32G版
         * money : 7200.00
         * usedcount : 2450
         * residuecount : 4750
         * ygpid : 6720cc5e7eb1bbb1ad56b801eacf8e11
         * nper : 65
         * photos : http://static.wowozhe.com/Uploads/Picture/2016-09-20/57e0f8b8d44ff_a.jpg
         * states : 11
         * item_type : miaosha
         * totalCount : 7200
         */

        private List<ItemsBean> items;
        /**
         * type : 7
         * title : 幸运转盘
         * url : http://www.wowozhe.com/app/miaosha/app_rotate_activity/v/310/target/android
         * icon : http://s.wowozhe.com/Uploads/APP/menu/2016_3_10_discovery.png
         */

        private List<MenuBean> menu;

        public int getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(int update_time) {
            this.update_time = update_time;
        }

        public List<AdverInfoBean> getAdver_info() {
            return adver_info;
        }

        public void setAdver_info(List<AdverInfoBean> adver_info) {
            this.adver_info = adver_info;
        }

        public List<SliderBean> getSlider() {
            return slider;
        }

        public void setSlider(List<SliderBean> slider) {
            this.slider = slider;
        }

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

        public static class AdverInfoBean {
            private String id;
            private String title;
            private String content;
            private String type;
            private String img;
            private String url;

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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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
        }

        public static class SliderBean {
            private String id;
            private String img;
            private String title;
            private String descript;
            private String url;
            private int type;
            private String callback_url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescript() {
                return descript;
            }

            public void setDescript(String descript) {
                this.descript = descript;
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

            public String getCallback_url() {
                return callback_url;
            }

            public void setCallback_url(String callback_url) {
                this.callback_url = callback_url;
            }
        }

        public static class ItemsBean {
            private String id;
            private String title;
            private String name;
            private String money;
            private String usedcount;
            private String residuecount;
            private String ygpid;
            private String nper;
            private String photos;
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
            private String states;
            private String item_type;
            private int totalCount;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getUsedcount() {
                return usedcount;
            }

            public void setUsedcount(String usedcount) {
                this.usedcount = usedcount;
            }

            public String getResiduecount() {
                return residuecount;
            }

            public void setResiduecount(String residuecount) {
                this.residuecount = residuecount;
            }

            public String getYgpid() {
                return ygpid;
            }

            public void setYgpid(String ygpid) {
                this.ygpid = ygpid;
            }

            public String getNper() {
                return nper;
            }

            public void setNper(String nper) {
                this.nper = nper;
            }

            public String getPhotos() {
                return photos;
            }

            public void setPhotos(String photos) {
                this.photos = photos;
            }

            public String getStates() {
                return states;
            }

            public void setStates(String states) {
                this.states = states;
            }

            public String getItem_type() {
                return item_type;
            }

            public void setItem_type(String item_type) {
                this.item_type = item_type;
            }

            public int getTotalCount() {
                return totalCount;
            }

            public void setTotalCount(int totalCount) {
                this.totalCount = totalCount;
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
        private int total;
        private int count;
        private int more;
        private int data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
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
