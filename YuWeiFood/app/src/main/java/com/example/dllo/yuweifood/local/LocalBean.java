package com.example.dllo.yuweifood.local;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dllo on 16/9/3.
 */
public class LocalBean {
    private static final String TAG = "LocalBean --> ***********";


    private DataBean data;
    /**
     * data : {"list":[{"type":"city","content":{"id":"10083","name":"大连","country":"中国","url":"yuwei://city/10083","in_china":1,"language":"","cover":"http://cdn.youyuwei.com/o_19kcs39mq1lubetn1rfvl3dliga.jpg?imageView2/2/w/1080/h/628","thumbnail":"http://cdn.youyuwei.com/o_19kcs39mq1lubetn1rfvl3dliga.jpg?imageView2/2/w/108/h/93","labelid":"","labellist":[{"labelid":1000,"labelname":"附近","labelimg":"http://cdn.youyuwei.com/o_1aaihom70ojs177b1igh1qn6k6p9.png","url":"yuwei://restlist/10083?labelid=1000","class":"","count":9999},{"labelid":"10105","labelname":"当地菜","labelimg":"http://cdn.youyuwei.com/o_1aae74vq0pjt104j1o56150vfm39.png","url":"yuwei://restlist/10083?labelid=10105","class":"0","count":5},{"labelid":"10005","labelname":"特色小吃","labelimg":"http://cdn.youyuwei.com/o_1aae747jf1iq111cq1lb614i7mb79.png","url":"yuwei://restlist/10083?labelid=10005","class":"0","count":1},{"labelid":"10008","labelname":"西餐","labelimg":"http://cdn.youyuwei.com/o_1aae7700g19ecrrqgbk6091b599.png","url":"yuwei://restlist/10083?labelid=10008","class":"0","count":1},{"labelid":"10003","labelname":"商务品味","labelimg":"http://cdn.youyuwei.com/o_1aae72mji1dbv8le16491l4j1gkq9.png","url":"yuwei://restlist/10083?labelid=10003","class":"4","count":-1},{"labelid":"10004","labelname":"一人食","labelimg":"http://cdn.youyuwei.com/o_1aae71pirbk31op1b3g1bua67v9.png","url":"yuwei://restlist/10083?labelid=10004","class":"4","count":-5},{"labelid":"10000","labelname":"饮食男女","labelimg":"http://cdn.youyuwei.com/o_1aae75nknfh11sucj7uacphrh9.png","url":"yuwei://restlist/10083?labelid=10000","class":"4","count":-7},{"labelid":"10002","labelname":"亲子美食","labelimg":"http://cdn.youyuwei.com/o_1aae73bn4b1oodkh791lk61jas9.png","url":"yuwei://restlist/10083?labelid=10002","class":"4","count":-7},{"labelid":"10001","labelname":"组团嗨吃","labelimg":"http://cdn.youyuwei.com/o_1aae768c5unkokrv021rd01ksk9.png","url":"yuwei://restlist/10083?labelid=10001","class":"4","count":-11}]},"title":"城市","subtitle":""},{"type":"map","content":[{"id":"10557","lng":"121.563149","lat":"38.887303","phone":"0411-86990099","cover":"http://cdn.youyuwei.com/o_19kcsa08pluc1c931hpgbe91m9aa.jpg?imageView2/1/w/220/h/147","name":"恐龙蘑菇(无限店)","name_origin":"","address":"沙河口区星海名庭北门对面 ","address_origin":"","cost":"129","open_time":"11:00-22:00 ","type":"西餐","summary":"锅炉摇身边沙发，怀旧工厂里的美食艺术家","reason":"在恐龙蘑菇，吃东西不仅仅是简单的品尝味道，而是在食物中包含了一种理念，一种哲理，是大连美食的创新之地。","desc":"一个废弃锅炉房变身一家集文化餐厅、设计中心于一身的生活艺术空间，转而又成为大连文青圈的文化阵地，这之间究竟实现了怎样的跨越？在来光顾的人们眼中，这里不仅仅是颇有调调、超有范儿、巨有内涵的西餐厅，而且是集合服饰、美食、空间设计、产品展示、艺术体验为一体的生活艺术空间。在这里，吃东西不仅仅是简单的品尝味道，而是在食物中包含了一种理念，一种哲理。烤鸭pizza，就像是可爱的混血儿，壳是意大利壳，心还是中国心。还有那每餐必点的天鹅泡芙，硬是把没身材的泡芙雕饰成美丽高傲的天鹅。来这里\u201c做平衡的智者，做生活的艺术家。\u201d","url":"yuwei://rest/10557","km":"12,680.48Km","sort":"12,680.48"},{"id":"11897","lng":"121.588655","lat":"38.916427","phone":"15174553789","cover":"http://cdn.youyuwei.com/o_19sdo7loc1ug21etqh4f7n8885e.jpg?imageView2/1/w/220/h/147","name":"该吃肉了","name_origin":"","address":"西安路机车商厦北侧（兴工街地铁口B出口）","address_origin":"","cost":"20","open_time":"10:30-20:00","type":"小吃","summary":"大连最富腔调街头小吃","reason":"\u201c高知们\u201d创办的炸肉店，没有一点油腻腻的duangduang肥膘，紧实的肉质，让你在咬下去的每一口都能感受到咀嚼的快乐。","desc":"这家街头小店，不仅吸引了众多吃货慕名前来，更被央视、人民日报、北京卫视等多家知名媒体争相报道，除了自身出品的好口味，还因为它拥有博士+硕士+海归=排骨店老板的奇葩组合。店内精选外脊制作的炸肉，没有一点油腻腻的duangduang肥膘，紧实的肉质，让你在咬下去的每一口都能感受到咀嚼的快乐。\n","url":"yuwei://rest/11897","km":"12,681.37Km","sort":"12,681.37"},{"id":"11444","lng":"121.62915","lat":"38.918263","phone":"","cover":"http://cdn.youyuwei.com/o_19qatlkrc7lfrp71tqkq9i1vn7a.jpg?imageView2/1/w/220/h/147","name":"外婆家","name_origin":"","address":"中山区大公街9-5大连中心裕景T3四楼","address_origin":"","cost":"58","open_time":"","type":"杭帮菜","summary":"外婆喊你吃饭了","reason":"外婆家是大连美食餐厅中杭帮菜的代名词，以高性价比和排队营销著称。外婆做的熟悉的味道，尽在外婆家！","desc":"1998年成立的外婆家几乎是正宗杭帮菜的代名词，60元以内的客单价，以高性价比和排队营销著称。来到这里，可以尽情享受名师一手打造的环境、微笑细致的星级服务、色香味俱全的丰盛菜肴。休闲的礼拜天，带上全家一起来到外婆家，点几道店里的招牌菜，在温馨静谧的环境里同家人一起度过这温暖的用餐时光。亦或是在繁忙的工作间隙，约上同事，一起来犒劳一下因为平常辛苦工作而无暇顾及的胃，也为纷繁忙碌的生活里点缀上丝丝欢乐。\n","url":"yuwei://rest/11444","km":"12,684.57Km","sort":"12,684.57"},{"id":"11445","lng":"121.62915","lat":"38.918263","phone":"0411-39652333","cover":"http://cdn.youyuwei.com/o_19qaut9n8tjt7agr2p326blsa.jpg?imageView2/1/w/220/h/147","name":"57℃湘铁板烧(柏威年店)","name_origin":"","address":"中山区中山路柏威年购物广场5L5013","address_origin":"","cost":"88","open_time":"11:00-21:00","type":"湘菜,铁板烧","summary":"文艺铁板大荟萃","reason":"57度湘将湘菜和铁板烧融合在一起，让用餐者与创作者面对面，不仅能观赏整个制作过程，也会瞬间勾起你对每一道菜的食欲。","desc":"走进店内，斑驳的墙面，铁艺的门窗，复古的吊灯\u2026\u2026一走进来就会感到强烈的情感冲击，颠覆了我们以往对湘菜馆的印象。57度湘将湘菜和铁板烧融合在一起，让用餐者与美食创作者直接面对面，不仅能观赏整个制作过程，也会瞬间勾起你对每一道菜的食欲。在这里，大蒜、葱段、辣椒成了铁板上的主角，铁板烧为快速炒制，菜肴只有表面上的辣劲，若是不能吃辣的朋友，也可以选择不辣的，因为店家的悉心烹饪，都很入味美味。最有意思的就是这家店的菜单，每一道菜都被赋予了一部电影的名字，巧妙的诠释了每一道菜的口感，也更有助于顾客更形象的记住喜欢的菜肴。\n","url":"yuwei://rest/11445","km":"12,684.57Km","sort":"12,684.57"},{"id":"11899","lng":"121.628317","lat":"38.913576","phone":"0411-83600660,18698704450","cover":"http://cdn.youyuwei.com/o_19sdqjqj816g51l1n719hdl193e9.jpg?imageView2/1/w/220/h/147","name":"御多幸日本料理","name_origin":"","address":"中山路145号香洲大饭店5楼","address_origin":"","cost":"96","open_time":"11:00-14:00，17:00-22:00 ","type":"日本料理","summary":"正宗的日本料理","reason":"御多幸日本料理是大连美食中口碑较好的日料店，没有去过日本却依旧可以在这里吃到正宗的日本料理。","desc":"御多幸日本料理是大连口碑较好的日料店，在日本人中也颇有人气，午餐基本座无虚席。环境雅致，菜色正宗应该是它的一个特点，很适合商务会餐或者情侣约会，带你的她来吃御多幸，相信她会爱上这里。\n","url":"yuwei://rest/11899","km":"12,684.69Km","sort":"12,684.69"},{"id":"11446","lng":"121.633898","lat":"38.917224","phone":"0411-83679809","cover":"http://cdn.youyuwei.com/o_19qb03m9e1q3m7ne1unu1n1t1qroa.jpg?imageView2/1/w/220/h/147","name":"설빙雪冰(大连旗舰店) ","name_origin":"","address":"中山区青泥洼桥大商步行街(上品堂海参对面)","address_origin":"","cost":"39","open_time":"10:00-20:00","type":"甜品店","summary":"夏日里的一抹冰凉","reason":"来自韩剧《匹诺曹》的설빙雪冰，炎炎夏日，开启一段凉爽的味蕾体验吧。","desc":"坊间传言来自韩剧《匹诺曹》的설빙雪冰，在韩国具有相当高的人气，尤其在冰凉的夏日，来此的顾客更是络绎不绝，超高的人气不仅因为时尚潮流带动的名声，更因为用心制作的色彩斑斓和丝滑嫩香的夏日饮品，芒果的，香蕉的，夹心的，各种味道，各种类型，随你挑选。炎炎夏日，来到설빙雪冰，开启一段凉爽的味蕾体验吧。\n","url":"yuwei://rest/11446","km":"12,684.99Km","sort":"12,684.99"},{"id":"10559","lng":"121.635115","lat":"38.917496","phone":"0411-83637676","cover":"http://cdn.youyuwei.com/o_19kcsen3n4h11q9flss139f172bc.jpg?imageView2/1/w/220/h/147","name":"汉巴味德(大都会店)","name_origin":"","address":"中山区武汉街71号大都会购物中心B1楼 ","address_origin":"","cost":"69","open_time":"11:00-21:00","type":"自助餐","summary":"中式餐桌上的浓情桑巴","reason":"大连美食之异域风情的汉巴味德将巴西烤肉与中国传统美食融汇创新，以国际化的开阔视野探究中国人的饮食风尚。","desc":"巴西烤肉是荟萃了葡萄牙人、非洲黑人及印第安人食品精华的巴西国宴佳肴，浓郁肉香让我们享受到了餐桌上的热情桑巴，汉巴味德就将巴西烤肉与中国传统美食融汇创新，以国际化的开阔视野探究中国人的饮食风尚，汉巴味德人潜心研究烤炙工艺，这里有异域口味的臻品烤肉，可以感受真味的中、西式菜肴，体验到桑巴国的热情浪漫和中国温润悠久的味道结合的精妙。","url":"yuwei://rest/10559","km":"12,685.08Km","sort":"12,685.08"},{"id":"10558","lng":"121.639846","lat":"38.924166","phone":"0411-88878817","cover":"http://cdn.youyuwei.com/o_19kcsc2ah1moa5sebq61g7t9tnd.jpg?imageView2/1/w/220/h/147","name":"九福自慢料理","name_origin":"","address":"中山区天津街207-16天和广场(新世界百货附近) ","address_origin":"","cost":"177","open_time":"11:00-14:00，17:00-21:30 ","type":"日本料理","summary":"自慢和风香，鲜活是王道","reason":"九福自慢料理浓郁的日本风情展露无遗，让你恨不得马上盘着腿享受一番正宗的日式服务！","desc":"每个职场高手都有自豪的本事，每个大厨都有\u201c自慢\u201d的料理，这里的牛小排肉质香嫩温和，鲜美多汁，在口中游弋着点点油香，挤上几滴柠檬汁再蘸上海盐，咸淡适宜还十分清香，味道非常赞！连器皿都特有范，端上桌就令人肉欲大发，搭着带有梅子香的菠萝，简直惊艳全场！这里看得见的鲜美更是无处不在，刺身拼盘可谓诚意十足。此外，这里一系列的木桌、木椅、木拉门、柔和的灯光、日式酒瓶和日本娃娃，浓郁的日本风情展露无遗，让你恨不得马上盘着腿享受一番正宗的日式服务！","url":"yuwei://rest/10558","km":"12,685.19Km","sort":"12,685.19"},{"id":"12063","lng":"121.645196","lat":"38.929392","phone":"0411-82657491","cover":"http://cdn.youyuwei.com/o_19tfg935vub41iqr1ctkev61td19.jpg?imageView2/1/w/220/h/147","name":"68-86大连老菜馆","name_origin":"","address":"大连市中山区新生街3号","address_origin":"","cost":"67","open_time":"10:00-21:30","type":"东北菜","summary":"大连人气火爆的东北菜馆","reason":"大连美食餐厅中一间地道东北菜馆，大连本地人的最爱，菜品量大实惠，味道正宗，还能感受热情豪迈的东北氛围。","desc":"68-86大连老菜馆是一家地道东北菜馆，位置在一条偏僻的单行胡同里，比较不容易找到，门面装修也一般，但门口却停满了车，让人不禁疑惑到底是什么让它人气如此火爆。但当开门走进去的一瞬间，疑惑便迎然而解，大厅里满满都是菜的香味，让人光闻了就想流口水。大厅座无虚席，耳边到处都是浓浓的东北口音，可以深深感受到东北人的豪迈与热情。这家的东北菜做的相当正宗，锅包肉、地三鲜、疙瘩汤\u2026\u2026样样经典，菜品量大味好，而且价格非常实惠。\n","url":"yuwei://rest/12063","km":"12,685.42Km","sort":"12,685.42"},{"id":"10556","lng":"121.638505","lat":"38.914358","phone":"0411-39912888","cover":"http://cdn.youyuwei.com/o_19kcs7e7ah5tp77161bg1sat4c.jpg?imageView2/1/w/220/h/147","name":"万宝海鲜舫","name_origin":"","address":"中山区解放路108号(劳动公园东门对面) ","address_origin":"","cost":"241","open_time":"09:00-21:00","type":"海鲜","summary":"奢华与享受极品海鲜之巅","reason":"大连万宝海鲜舫金碧辉煌，海鲜为主，结合鲁菜，粤菜之精华，独创出具有自己风格的海鲜菜肴，是大连美食的精华之地。","desc":"俗话说：靠山吃山，靠水吃水。来到了大连这个海滨城市，不吃海鲜就好比去了北京没登过长城，没吃过全聚德烤鸭一样遗憾。而大连万宝海鲜舫金碧辉煌，海鲜为主，结合鲁菜，粤菜之精华，独创出具有自己风格的海鲜菜肴更是不可错过。这里的海鲜菜肴色泽艳丽，造型美观，口感脆滑，味道鲜美，基本保持海鲜菜肴的原汁原味。闲暇之时，一杯红酒，两道珍馐，这才是浪漫之都的真谛！","url":"yuwei://rest/10556","km":"12,685.48Km","sort":"12,685.48"}],"title":"附近地图","subtitle":""},{"type":"strategy","content":[{"type":"zn","title":"城市印象","img":"http://cdn.youyuwei.com/o_1a9ttvkdivvp1nc9mnovdsa7q9.png","isdisplay":1,"url":"http://www.youyuwei.com/etiquette/10083"},{"type":"jp","title":"特别推荐","img":"http://cdn.youyuwei.com/o_1a9ttvkdivvp1nc9mnovdsa7q9.png","isdisplay":1,"url":"yuwei://restrefined/10083"}],"title":"攻略锦囊","subtitle":""},{"type":"dish","content":[{"cityname":"大连","name":"锅包肉","sum":"锅包肉是东北人喜欢的菜品之一，口感酥脆，味道酸甜，尤其是女性们的最爱，下酒也很不错的选择。","id":"10149","url":"yuwei://mustdish/10149","cover":"http://cdn.youyuwei.com/o_19tk44s3f18u51ktcn9m11jqaso9.jpg?imageView2/1/w/498/h/378"},{"cityname":"大连","name":"海胆","sum":"大连的海胆不管生吃、蒸蛋、入汤，都柔嫩鲜美，带着淡淡的海味。","id":"10150","url":"yuwei://mustdish/10150","cover":"http://cdn.youyuwei.com/o_19tk46svslig3m432lgqj12n29.jpg?imageView2/1/w/498/h/378"},{"cityname":"大连","name":"炒海肠","sum":"在大连海肠子是很有名的海鲜，味道十分鲜美，素有7个海肠子胜过1个鸡蛋的美誉。","id":"10946","url":"yuwei://mustdish/10946","cover":"http://cdn.youyuwei.com/o_1ad0bt8r18fp1ns117pj1nel1eqh9.jpg?imageView2/1/w/498/h/378"},{"cityname":"大连","name":"海鲜焖子","sum":"大连人最爱吃的小吃之，外酥里嫩，非常鲜美。","id":"10954","url":"yuwei://mustdish/10954","cover":"http://cdn.youyuwei.com/o_1ad0d6n9l1n043t6mes1i6l1q5b9.jpg?imageView2/1/w/498/h/378"}],"title":"必吃美食","subtitle":"","state":"0"},{"type":"rest","content":[{"id":"10556","lng":"121.638505","lat":"38.914358","phone":"0411-39912888","cover":"http://cdn.youyuwei.com/o_19kcs7e7ah5tp77161bg1sat4c.jpg?imageView2/1/w/369/h/276","name":"万宝海鲜舫","name_origin":"","address":"中山区解放路108号(劳动公园东门对面) ","address_origin":"","cost":"241","open_time":"09:00-21:00","type":"海鲜","summary":"奢华与享受极品海鲜之巅","url":"yuwei://rest/10556","reason":"大连万宝海鲜舫金碧辉煌，海鲜为主，结合鲁菜，粤菜之精华，独创出具有自己风格的海鲜菜肴，是大连美食的精华之地。","desc":"俗话说：靠山吃山，靠水吃水。来到了大连这个海滨城市，不吃海鲜就好比去了北京没登过长城，没吃过全聚德烤鸭一样遗憾。而大连万宝海鲜舫金碧辉煌，海鲜为主，结合鲁菜，粤菜之精华，独创出具有自己风格的海鲜菜肴更是不可错过。这里的海鲜菜肴色泽艳丽，造型美观，口感脆滑，味道鲜美，基本保持海鲜菜肴的原汁原味。闲暇之时，一杯红酒，两道珍馐，这才是浪漫之都的真谛！","num":12},{"id":"10557","lng":"121.563149","lat":"38.887303","phone":"0411-86990099","cover":"http://cdn.youyuwei.com/o_19kcsa08pluc1c931hpgbe91m9aa.jpg?imageView2/1/w/369/h/276","name":"恐龙蘑菇(无限店)","name_origin":"","address":"沙河口区星海名庭北门对面 ","address_origin":"","cost":"129","open_time":"11:00-22:00 ","type":"西餐","summary":"锅炉摇身边沙发，怀旧工厂里的美食艺术家","url":"yuwei://rest/10557","reason":"在恐龙蘑菇，吃东西不仅仅是简单的品尝味道，而是在食物中包含了一种理念，一种哲理，是大连美食的创新之地。","desc":"一个废弃锅炉房变身一家集文化餐厅、设计中心于一身的生活艺术空间，转而又成为大连文青圈的文化阵地，这之间究竟实现了怎样的跨越？在来光顾的人们眼中，这里不仅仅是颇有调调、超有范儿、巨有内涵的西餐厅，而且是集合服饰、美食、空间设计、产品展示、艺术体验为一体的生活艺术空间。在这里，吃东西不仅仅是简单的品尝味道，而是在食物中包含了一种理念，一种哲理。烤鸭pizza，就像是可爱的混血儿，壳是意大利壳，心还是中国心。还有那每餐必点的天鹅泡芙，硬是把没身材的泡芙雕饰成美丽高傲的天鹅。来这里\u201c做平衡的智者，做生活的艺术家。\u201d"},{"id":"10558","lng":"121.639846","lat":"38.924166","phone":"0411-88878817","cover":"http://cdn.youyuwei.com/o_19kcsc2ah1moa5sebq61g7t9tnd.jpg?imageView2/1/w/369/h/276","name":"九福自慢料理","name_origin":"","address":"中山区天津街207-16天和广场(新世界百货附近) ","address_origin":"","cost":"177","open_time":"11:00-14:00，17:00-21:30 ","type":"日本料理","summary":"自慢和风香，鲜活是王道","url":"yuwei://rest/10558","reason":"九福自慢料理浓郁的日本风情展露无遗，让你恨不得马上盘着腿享受一番正宗的日式服务！","desc":"每个职场高手都有自豪的本事，每个大厨都有\u201c自慢\u201d的料理，这里的牛小排肉质香嫩温和，鲜美多汁，在口中游弋着点点油香，挤上几滴柠檬汁再蘸上海盐，咸淡适宜还十分清香，味道非常赞！连器皿都特有范，端上桌就令人肉欲大发，搭着带有梅子香的菠萝，简直惊艳全场！这里看得见的鲜美更是无处不在，刺身拼盘可谓诚意十足。此外，这里一系列的木桌、木椅、木拉门、柔和的灯光、日式酒瓶和日本娃娃，浓郁的日本风情展露无遗，让你恨不得马上盘着腿享受一番正宗的日式服务！"},{"id":"10559","lng":"121.635115","lat":"38.917496","phone":"0411-83637676","cover":"http://cdn.youyuwei.com/o_19kcsen3n4h11q9flss139f172bc.jpg?imageView2/1/w/369/h/276","name":"汉巴味德(大都会店)","name_origin":"","address":"中山区武汉街71号大都会购物中心B1楼 ","address_origin":"","cost":"69","open_time":"11:00-21:00","type":"自助餐","summary":"中式餐桌上的浓情桑巴","url":"yuwei://rest/10559","reason":"大连美食之异域风情的汉巴味德将巴西烤肉与中国传统美食融汇创新，以国际化的开阔视野探究中国人的饮食风尚。","desc":"巴西烤肉是荟萃了葡萄牙人、非洲黑人及印第安人食品精华的巴西国宴佳肴，浓郁肉香让我们享受到了餐桌上的热情桑巴，汉巴味德就将巴西烤肉与中国传统美食融汇创新，以国际化的开阔视野探究中国人的饮食风尚，汉巴味德人潜心研究烤炙工艺，这里有异域口味的臻品烤肉，可以感受真味的中、西式菜肴，体验到桑巴国的热情浪漫和中国温润悠久的味道结合的精妙。"},{"id":"10560","lng":"121.648311","lat":"38.922286","phone":"0411-82813086","cover":"http://cdn.youyuwei.com/o_19kcshamu1kcmgb0147830qto9b.jpg?imageView2/1/w/369/h/276","name":"船歌鱼水饺(安乐街店)","name_origin":"","address":"中山区安乐街28号(国际金融大厦旁) ","address_origin":"","cost":"51","open_time":"10:00-21:30 ","type":"东北菜","summary":"渔家饺子，每一粒都饱含海洋般深情","url":"yuwei://rest/10560","reason":"船歌鱼水饺给你与大海浑然一体的、原味的、地道的渔家味道及渔家文化的全新体验。","desc":"在大连，连饺子也要吃出大海的味道。船歌的饺子皮薄馅大，口感细腻爽滑，味道鲜美无比，具有浓郁的渔家风味特色，为中华民族灿烂悠久的饺子美食增添了一丝鲜美的海洋味道。在船歌，除了能品尝到优质海鱼原料为特色，用独特渔家配方和纯手工包制而成的海鱼水饺，更能给你与大海浑然一体的、原味的、地道的渔家味道及渔家文化的全新体验。"}],"title":"必去餐厅","subtitle":"","num":"14","url":"yuwei://restlist/10083"},{"type":"note","content":[{"id":"11085","name":"一只单身汪的大连亲测路线（主美食 景点）","url":"yuwei://note/11085","cover":"http://cdn.youyuwei.com/o_1a3q60otaqtr1lsbubnk6128cf.jpg?imageView2/1/w/270/h/180","ctitle":"本文来自：去哪儿网的S_Seishiro\n\n\n此攻略主要针对景点及美食，交通大致路线。\n大连的服务员都像在梦游\u2026\u2026所以，朋友们，吃饭购物什么的自己长点儿心眼儿吧= =。","city":"大连","rest":"","time":1447045753,"author":{"uid":"10283","uname":"我竟然没有情敌？","header":"http://cdn.youyuwei.com/229D7E702F1ED12B892881A644F5E3B7.jpg","gender":"2","location":"","desc":"请给我一个好一点的情敌","score":"130","v":"0","vname":"","url":"yuwei://user/10283","label":"","concern":"23","fans":"3"}},{"id":"11680","name":"JF皇家茶馆（柏威年店）大连最好的下午茶，仿佛置身英国，不愧是网上好评如潮","url":"yuwei://note/11680","cover":"http://cdn.youyuwei.com/9e45ef2dda2c2fdad6ad12e878357f1b.jpg360345.jpg?imageView2/1/w/270/h/180","ctitle":null,"city":"大连","rest":"","time":1453566282,"author":{"uid":"21592","uname":"Pascal","header":"http://wx.qlogo.cn/mmopen/oa6ibIVByGLSbUDdII7fMEo5QibAsleLVqfH9ibeQE3bibic4xhT0XfgqcYUPLX9gbatjYWiaIBStUq8Mfolics2hcwog/0","gender":"1","location":", Montreal,","desc":"","score":"59","v":"0","vname":"","url":"yuwei://user/21592","label":"","concern":"2","fans":"1"}},{"id":"12523","name":"夏天来大连，不吃海鲜吃甜品！","url":"yuwei://note/12523","cover":null,"ctitle":null,"city":"大连","rest":"","time":1467012716,"author":{"uid":"61923","uname":"泣夜","header":"http://tva4.sinaimg.cn/crop.0.0.1080.1080.50/68c917b1jw8erkixaqnm7j20u00u079b.jpg","gender":"2","location":"辽宁 大连","desc":"","score":"40","v":"0","vname":"","url":"yuwei://user/61923","label":"","concern":"2","fans":"0"}}],"title":"相关美食游记","subtitle":""}]}
     * is_array : 1
     */

    private int is_array;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getIs_array() {
        return is_array;
    }

    public void setIs_array(int is_array) {
        this.is_array = is_array;
    }

    public static class DataBean {
        /**
         * type : city
         * content : {"id":"10083","name":"大连","country":"中国","url":"yuwei://city/10083","in_china":1,"language":"","cover":"http://cdn.youyuwei.com/o_19kcs39mq1lubetn1rfvl3dliga.jpg?imageView2/2/w/1080/h/628","thumbnail":"http://cdn.youyuwei.com/o_19kcs39mq1lubetn1rfvl3dliga.jpg?imageView2/2/w/108/h/93","labelid":"","labellist":[{"labelid":1000,"labelname":"附近","labelimg":"http://cdn.youyuwei.com/o_1aaihom70ojs177b1igh1qn6k6p9.png","url":"yuwei://restlist/10083?labelid=1000","class":"","count":9999},{"labelid":"10105","labelname":"当地菜","labelimg":"http://cdn.youyuwei.com/o_1aae74vq0pjt104j1o56150vfm39.png","url":"yuwei://restlist/10083?labelid=10105","class":"0","count":5},{"labelid":"10005","labelname":"特色小吃","labelimg":"http://cdn.youyuwei.com/o_1aae747jf1iq111cq1lb614i7mb79.png","url":"yuwei://restlist/10083?labelid=10005","class":"0","count":1},{"labelid":"10008","labelname":"西餐","labelimg":"http://cdn.youyuwei.com/o_1aae7700g19ecrrqgbk6091b599.png","url":"yuwei://restlist/10083?labelid=10008","class":"0","count":1},{"labelid":"10003","labelname":"商务品味","labelimg":"http://cdn.youyuwei.com/o_1aae72mji1dbv8le16491l4j1gkq9.png","url":"yuwei://restlist/10083?labelid=10003","class":"4","count":-1},{"labelid":"10004","labelname":"一人食","labelimg":"http://cdn.youyuwei.com/o_1aae71pirbk31op1b3g1bua67v9.png","url":"yuwei://restlist/10083?labelid=10004","class":"4","count":-5},{"labelid":"10000","labelname":"饮食男女","labelimg":"http://cdn.youyuwei.com/o_1aae75nknfh11sucj7uacphrh9.png","url":"yuwei://restlist/10083?labelid=10000","class":"4","count":-7},{"labelid":"10002","labelname":"亲子美食","labelimg":"http://cdn.youyuwei.com/o_1aae73bn4b1oodkh791lk61jas9.png","url":"yuwei://restlist/10083?labelid=10002","class":"4","count":-7},{"labelid":"10001","labelname":"组团嗨吃","labelimg":"http://cdn.youyuwei.com/o_1aae768c5unkokrv021rd01ksk9.png","url":"yuwei://restlist/10083?labelid=10001","class":"4","count":-11}]}
         * title : 城市
         * subtitle :
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String type;
            /**
             * id : 10083
             * name : 大连
             * country : 中国
             * url : yuwei://city/10083
             * in_china : 1
             * language :
             * cover : http://cdn.youyuwei.com/o_19kcs39mq1lubetn1rfvl3dliga.jpg?imageView2/2/w/1080/h/628
             * thumbnail : http://cdn.youyuwei.com/o_19kcs39mq1lubetn1rfvl3dliga.jpg?imageView2/2/w/108/h/93
             * labelid :
             * labellist : [{"labelid":1000,"labelname":"附近","labelimg":"http://cdn.youyuwei.com/o_1aaihom70ojs177b1igh1qn6k6p9.png","url":"yuwei://restlist/10083?labelid=1000","class":"","count":9999},{"labelid":"10105","labelname":"当地菜","labelimg":"http://cdn.youyuwei.com/o_1aae74vq0pjt104j1o56150vfm39.png","url":"yuwei://restlist/10083?labelid=10105","class":"0","count":5},{"labelid":"10005","labelname":"特色小吃","labelimg":"http://cdn.youyuwei.com/o_1aae747jf1iq111cq1lb614i7mb79.png","url":"yuwei://restlist/10083?labelid=10005","class":"0","count":1},{"labelid":"10008","labelname":"西餐","labelimg":"http://cdn.youyuwei.com/o_1aae7700g19ecrrqgbk6091b599.png","url":"yuwei://restlist/10083?labelid=10008","class":"0","count":1},{"labelid":"10003","labelname":"商务品味","labelimg":"http://cdn.youyuwei.com/o_1aae72mji1dbv8le16491l4j1gkq9.png","url":"yuwei://restlist/10083?labelid=10003","class":"4","count":-1},{"labelid":"10004","labelname":"一人食","labelimg":"http://cdn.youyuwei.com/o_1aae71pirbk31op1b3g1bua67v9.png","url":"yuwei://restlist/10083?labelid=10004","class":"4","count":-5},{"labelid":"10000","labelname":"饮食男女","labelimg":"http://cdn.youyuwei.com/o_1aae75nknfh11sucj7uacphrh9.png","url":"yuwei://restlist/10083?labelid=10000","class":"4","count":-7},{"labelid":"10002","labelname":"亲子美食","labelimg":"http://cdn.youyuwei.com/o_1aae73bn4b1oodkh791lk61jas9.png","url":"yuwei://restlist/10083?labelid=10002","class":"4","count":-7},{"labelid":"10001","labelname":"组团嗨吃","labelimg":"http://cdn.youyuwei.com/o_1aae768c5unkokrv021rd01ksk9.png","url":"yuwei://restlist/10083?labelid=10001","class":"4","count":-11}]
             */

            private Object content;
            private String title;
            private String subtitle;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Object getContent() {
                return content;
            }

            public void setContent(Object content) {
                this.content = content;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

//            public static class ContentBean {
//                private String id;
//                private String name;
//                private String country;
//                private String url;
//                private int in_china;
//                private String language;
//                private String cover;
//                private String thumbnail;
//                private String labelid;
//                /**
//                 * labelid : 1000
//                 * labelname : 附近
//                 * labelimg : http://cdn.youyuwei.com/o_1aaihom70ojs177b1igh1qn6k6p9.png
//                 * url : yuwei://restlist/10083?labelid=1000
//                 * class :
//                 * count : 9999
//                 */
//
//                private List<LabellistBean> labellist;
//
//                public String getId() {
//                    return id;
//                }
//
//                public void setId(String id) {
//                    this.id = id;
//                }
//
//                public String getName() {
//                    return name;
//                }
//
//                public void setName(String name) {
//                    this.name = name;
//                }
//
//                public String getCountry() {
//                    return country;
//                }
//
//                public void setCountry(String country) {
//                    this.country = country;
//                }
//
//                public String getUrl() {
//                    return url;
//                }
//
//                public void setUrl(String url) {
//                    this.url = url;
//                }
//
//                public int getIn_china() {
//                    return in_china;
//                }
//
//                public void setIn_china(int in_china) {
//                    this.in_china = in_china;
//                }
//
//                public String getLanguage() {
//                    return language;
//                }
//
//                public void setLanguage(String language) {
//                    this.language = language;
//                }
//
//                public String getCover() {
//                    return cover;
//                }
//
//                public void setCover(String cover) {
//                    this.cover = cover;
//                }
//
//                public String getThumbnail() {
//                    return thumbnail;
//                }
//
//                public void setThumbnail(String thumbnail) {
//                    this.thumbnail = thumbnail;
//                }
//
//                public String getLabelid() {
//                    return labelid;
//                }
//
//                public void setLabelid(String labelid) {
//                    this.labelid = labelid;
//                }
//
//                public List<LabellistBean> getLabellist() {
//                    return labellist;
//                }
//
//                public void setLabellist(List<LabellistBean> labellist) {
//                    this.labellist = labellist;
//                }
//
//                public static class LabellistBean {
//                    private int labelid;
//                    private String labelname;
//                    private String labelimg;
//                    private String url;
//                    @SerializedName("class")
//                    private String classX;
//                    private int count;
//
//                    public int getLabelid() {
//                        return labelid;
//                    }
//
//                    public void setLabelid(int labelid) {
//                        this.labelid = labelid;
//                    }
//
//                    public String getLabelname() {
//                        return labelname;
//                    }
//
//                    public void setLabelname(String labelname) {
//                        this.labelname = labelname;
//                    }
//
//                    public String getLabelimg() {
//                        return labelimg;
//                    }
//
//                    public void setLabelimg(String labelimg) {
//                        this.labelimg = labelimg;
//                    }
//
//                    public String getUrl() {
//                        return url;
//                    }
//
//                    public void setUrl(String url) {
//                        this.url = url;
//                    }
//
//                    public String getClassX() {
//                        return classX;
//                    }
//
//                    public void setClassX(String classX) {
//                        this.classX = classX;
//                    }
//
//                    public int getCount() {
//                        return count;
//                    }
//
//                    public void setCount(int count) {
//                        this.count = count;
//                    }
//                }
//            }
        }
    }
}
