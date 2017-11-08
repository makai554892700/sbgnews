# sbgnews
新闻web端springboot+gradle实现
#spring boot + swagger + shiro
### swagger相关
##### [swagger官网](https://swagger.io/)
##### 添加依赖：

    compile("io.springfox:springfox-swagger2:${swaggerVersion}") //swagger2核心jar包
    compile("io.springfox:springfox-swagger-ui:${swaggerVersion}") //swagger2核心jar包
##### 各个注解说明

    @Api：用在类上，说明该类的作用
    @ApiOperation：用在方法上，说明方法的作用
    @ApiImplicitParams：用在方法上包含一组参数说明
    @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
        paramType：参数放在哪个地方
            header-->请求参数的获取：@RequestHeader
            query-->请求参数的获取：@RequestParam
            path（用于restful接口）-->请求参数的获取：@PathVariable
            body（不常用）
            form（不常用）
        name：参数名
        dataType：参数类型
        required：参数是否必须传
        value：参数的意思
        defaultValue：参数的默认值
    @ApiResponses：用于表示一组响应
    @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
        code：数字，例如400
        message：信息，例如"请求参数没填好"
        response：抛出异常的类
    @ApiModel：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
    @ApiModelProperty：描述一个model的属性
##### 访问路径： 

    http://${host}/swagger-ui.html
#### CENTOS7下ffmpeg安装与总结
##### [ffmpeg官网](https://www.ffmpeg.org/)
##### [ffmpeg git地址](https://github.com/FFmpeg/FFmpeg)
##### ffmpeg安装
* 启用epel仓库
* 安装nux-dextop仓库
* 安装ffmpeg

      yum install epel-release -y
      rpm --import http://li.nux.ro/download/nux/RPM-GPG-KEY-nux.ro
      rpm -Uvh http://li.nux.ro/download/nux/dextop/el7/x86_64/nux-dextop-release-0-5.el7.nux.noarch.rpm
      yum install ffmpeg ffmpeg-devel -y
      ffmpeg -h
    * 如果最后出现ffmpeg帮助信息则表示安装成功
### ffmpeg常用命令

    //获取帮助
    ffmpeg -h
    //获取视频信息(视频地址)
    ffmpeg -i %s
    //生成缩略图(视频地址/视频宽/视频高/缩略图地址)
    ffmpeg -i %s -y -f image2 -t 0.001 -s %sx%s %s
### vue 相关 (需先安装nodejs)
##### [vue官网](https://cn.vuejs.org/)
* 安装淘宝镜像(根据个人需求,若安装后，可用cnpm替换npm运行npm命令)
    * npm install -g cnpm --registry=https://registry.npm.taobao.org
* 初始化package.json文件
    * 于webapp目录下运行 npm init 并填写或跳过相应属性
* 安装webpack
    * npm install webpack -g
* 安装vue脚手架
    * npm install vue-cli -g
* 安装vue
    * 于webapp目录下运行 npm install vue --save 
* 创建vue项目
    * vue init webpack projectName
    * npm install
* 启动项目
    * npm run dev
* 生成相关资源
    * npm buile
### shiro 相关
##### [shiro官网](http://shiro.apache.org/)
#### shiro依赖添加（gradle）

    "org.apache.shiro:shiro-core:${shiroVersion}",
    "org.apache.shiro:shiro-web:${shiroVersion}",
    "org.apache.shiro:shiro-spring:${shiroVersion}",
#### 用户权限等相关数据库添加及pojo类书写

    用户表 id  userName    password
    角色表 id  permissionName
    权限表 id  roleName
    用户_角色表  userId  roleId
    角色_权限表  roleId  permissionId
    (一个用户拥有多个角色，一个角色拥有多个权限)
#### 编写配置类(具体查看[代码](https://github.com/makai554892700/sbgnews/tree/master/src/main/java/com/mayousheng/www/sbgnews/common/auth))
    
    ShiroConfig
    AuthRealm
    CredentialsMatcher

