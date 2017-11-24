## 接口
### 笑话大全
* http://route.showapi.com/341-1

    {
        "showapi_res_code": 0,
        "showapi_res_error": "",
        "showapi_res_body": {
            "allPages": 428,
            "ret_code": 0,
            "contentlist": [
                {
                    "text": "我家隔壁有一对极品夫妻,结婚后吃干玩净贷款买车买房用负资产的方式拴住对方,两人的债还到60岁也还不完。谁要是想拆散他们得做好背几十年债的心里准备。神马海誓山盟都弱爆了,这才是保持爱情忠贞的好办法！",
                    "title": "保持爱情忠贞的好办法",
                    "type": 1,
                    "ct": "2017-09-29 09:30:16.135"
                }
            ],
            "currentPage": 1,
            "allNum": 8552,
            "maxResult": 20
        }
    }
    
* http://api.markingyun.cn/sbgnews


    {
      "count": 2,
      "page": 0
    }
    {
        "code": 0,
        "msg": "success",
        "data": [
            {
                "title": "女客户是我喜欢的类型",
                "text": "早上去送水，女客户是我喜欢的类型。当即展开追求，她也没有开口拒绝。中午我亲手做了拿手菜带去她家与她共进午餐，我温柔地对她说：“我可以喂你吃吗？”她点了头，幸福来得太突然，“那你可不许喊哦。”说完我撕下了她嘴上的胶布。",
                "time": "2017-09-29 20:00:02.332"
            },
            {
                "title": "一百万元的补贴",
                "text": "刚刚某保险公司给我打电话，说我每个月只要存两百块，七十之前死了的话有一百万元的补贴。我瞬间想到等我六十多岁的时候，我的子女们跪在我面前端着一碗药，哭着说：爸，求你把药喝了吧。吓得我把手机都给扔了！",
                "time": "2017-09-29 20:00:02.332"
            }
        ]
    }
### 百思不得姐 type(查询的类型，默认全部返回。type=10 图片 type=29 段子 type=31 声音 type=41 视频) page(第几页。每页最多返回20条记录)

    pagebean	PageBean		分页对象
    - contentlist	Item[]		条目列表
    -- create_time	String		创建时间
    -- love	String		点赞的数量
    -- hate	String		点踩的数量
    -- height	String		图片高度
    -- width	String		图片宽度
    -- id	String		图片id
    -- image0	String		0号图，数字越大，尺寸越大
    -- image1	String		1号图
    -- image2	String		2号图
    -- image3	String		3号图
    -- text	String		段子正文
    -- type	String		类型
    -- videotime	String		视频时长
    -- video_uri	String		视频url
    -- voicelength	String		声音文件大小
    -- voicetime	String		声音时长
    -- voiceuri	String		声音url
    -- weixin_url	String		微信链接地址
    -- profile_image	String		用户头像
    -- name	String	用户昵称
    -- cdn_img	String	cdn图片
    - maxResult	String		每页最大数量
    - allNum	String		所有数量
    - allPages	String		所有页
    - currentPage	String		当前页
    ret_code	String	0	0为成功，其他失败
    
    
* http://route.showapi.com/255-1


    {
        "showapi_res_code": 0,
        "showapi_res_error": "",
        "showapi_res_body": {
            "ret_code": 0,
            "pagebean": {
                "allPages": 500,
                "contentlist": [
                    {
                        "text": "\n        【18部甜炸的电影】看多了真的会长胖～～准备好和ta一起看了吗？\n    ",
                        "hate": "57",
                        "videotime": "0",
                        "voicetime": "0",
                        "weixin_url": "http://m.budejie.com/detail-26513424.html/",
                        "profile_image": "http://wimg.spriteapp.cn/profile/large/2016/11/15/582b24d33dd0b_mini.jpg",
                        "width": "0",
                        "cdn_img": "http://wimg.spriteapp.cn/x/640x400/ugc/2017/10/05/59d5097ea0c86_1.jpg",
                        "voiceuri": "",
                        "type": "10",
                        "ct": "2017-10-05 17:00:12.950",
                        "image0": "http://wimg.spriteapp.cn/x/640x400/ugc/2017/10/05/59d5097ea0c86_1.jpg",
                        "id": "26513424",
                        "love": "153",
                        "image2": "http://wimg.spriteapp.cn/x/640x400/ugc/2017/10/05/59d5097ea0c86_1.jpg",
                        "image1": "http://wimg.spriteapp.cn/x/640x400/ugc/2017/10/05/59d5097ea0c86_1.jpg",
                        "height": "0",
                        "_id": "59d5f49c6e361e6950fd188c",
                        "name": "为你改变love",
                        "create_time": "2017-10-05 17:00:12"
                    }
                ],
                "currentPage": 1,
                "allNum": 10000,
                "maxResult": 20
            }
        }
    }

### 数据库
#### 用户 User
* id
* userName 	//账户	String(unique)
* nickName 	//昵称	String
* sex 		//性别	int
* msg			//个性签名	String
* passWord	//密码	String
* email		//邮箱	String
* phone		//电话号码	String
* imgUrl		//头像图片url	String
* pageHome	//主页链接	String
* created_at
* updated_at
#### 角色 Role
* id
* roleName  //角色名称  String(unique)
#### 权限 Permission
* id
* permissionName    //权限名称  String(unique)
#### 设备 Device
* id 	
* imei 	//唯一码(不一定能拿到)	String
* androidId 	//设备码(百分百存在，作为唯一标识)	String(unique)
* wifiMac 	//wifi的mac地址	String
* width 	//宽	int
* height 	//高	int
* manufacturer 	//品牌	String(index)
* model 	//型号	String(index)
* versionCode 	//Android版本	int(index)
* created_at
* updated_at
#### 笑话 Joke
* id
* title 	        //标题		String
* text 	        //内容		String
* userId 			//用户id(对应用户信息)	int
* mark 			//标记(id)			String(unique)
* ct 		        //创建时间	String
#### 百思不得姐-图片   PhotoBSBDJ
* id
* mark 			//标记(id)			String(unique)
* userId 			//用户id(对应用户信息)	int
* weixin_url 		//微信(原文)路径 String
* text 			//图片标题	String
* cdn_img 		//cdn图片	String
* sc_img        //缩略图片    String
* width         //宽         int
* height        //高        int
* create_time 	//创建时间	String
#### 百思不得姐-视频   VideoBSBDJ
* id
* mark 			//标记(id)			String(unique)
* userId 			//用户id(对应用户信息)	int
* weixin_url 		//微信(原文)路径 String
* text 			//视频标题	String
* video_uri 		//视频url	String
* sc_img        //缩略图片    String
* width         //宽         int
* height        //高        int
* playTime      //播放时长      int
* create_time 	//创建时间	String
#### 百思不得姐-段子   PunsterBSBDJ
* id
* mark 			//标记(id)			String(unique)
* userId 			//用户id(对应用户信息)	int
* weixin_url 		//微信(原文)路径 String
* text 			//段子正文	String
* create_time 	//创建时间	String
#### 百思不得姐-声音   VoiceBSBDJ
* id
* mark 			//标记(id)			String(unique)
* userId 			//用户id(对应用户信息)	int
* weixin_url 		//微信(原文)路径 String
* text 			//声音标题	String
* voiceuri 		//声音url	String
* cdn_img 		//cdn图片(缩放)	String
* create_time 	//创建时间	String
#### 评论             Comment
* id  
* user_id			//用户id	int(unique)
* desc_id			//表数据id	int(unique)
* table_name		//表名		String(unique)
* info			    //评论内容	text
#### 新闻交互信息(可同时存redis)  NewsOperate
* id
* news_id        //新闻id   int(unique)
* table_name //新闻表名  String(unique)
* love          //点赞次数  int
* hate          //点踩次数  int
* share         //分享次数  int
* comment         //评论次数  int



### 业务逻辑
* 数据来源
    * joke
        * 标题
        * 文本内容
        * 创建时间
    * 百思不得姐
        * 共有内容
            * 标题
            * 原文路径
            * 用户名
            * 用户头像
            * 创建时间
            * 唯一标识
        * 段子
            * 文本内容
        * 声音
            * 声音链接
        * 图片
            * 图片链接
        * 视频
            * 视频链接
* 数据来源处理
    * 整理用户信息
        * 生成用户
    * 处理图片信息
        * 获取图片尺寸
        * 大图片需生成缩略图
    * 处理声音信息
        * 获取声音时长
    * 处理视频信息
        * 获取视频缩略图
        * 获取视频时长
        * 获取视频尺寸
* 数据返回
    * 数据本体
        * 原生数据主体
        * 原文链接
    * 附带信息
        * 点赞、点踩、评论、分享数量
        * 用户信息
            * 用户名
            * 用户头像
* 数据交互(接口)
    * 用户注册
    * 用户登录
    * 用户信息更新
    * 获取段子等信息
    * 点赞
    * 点踩
    * 分享
    * 评论(评论记录)
