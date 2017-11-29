# sbgnews
新闻web端springboot+gradle实现
#spring boot + swagger + shiro
#### nginx相关 
* centos7下nginx安装命令

      echo "[nginx]" > /etc/yum.repos.d/nginx.repo
      echo "name=nginx repo" >> /etc/yum.repos.d/nginx.repo
      echo "baseurl=http://nginx.org/packages/mainline/rhel/7/\$basearch/" >> /etc/yum.repos.d/nginx.repo
      echo "gpgcheck=0" >> /etc/yum.repos.d/nginx.repo
      echo "enabled=1" >> /etc/yum.repos.d/nginx.repo
      yum install nginx -y
      
* centos7下nginx相关命令
    * service nginx start # 启动nginx
    * service nginx stop # 停止nginx
    * service nginx restart # 重启nginx
    * service ngixn relaod # 在不关闭nginx的情况下启用nginx新配置，运行前最好先运行nginx -t检测配置文件的合法性
    * nginx -t # 测试配置文件是否符合规则
    * nginx -s reopen # 启动nginx
    * nginx -s stop # 停止nginx

#### jdk相关
* centos7下jdk安装命令(需[官网](https://www.oracle.com)下载jdk-8u141-linux-x64.tar.gz)
	
        tar -zxvf jdk-8u141-linux-x64.tar.gz -C /usr/local/src
        mv /usr/local/src/jdk1.8.0_141 /usr/local/src/jdk1.8

* centos7下jdk环境变量配置
    
        echo "JAVA_HOME=/usr/java/jdk1.8.0_121" >> /etc/profile
        echo "PATH=\$PATH:\$JAVA_HOME/bin" >> /etc/profile
        echo "CLASSPATH=.:\$JAVA_HOME/lib/jt.jar:\$JAVA_HOME/lib/tools.jar" >> /etc/profile
        echo "export JAVA_HOME PATH CLASSPATH" >> /etc/profile

#### mysql相关
* mysql安装(需[官网](https://www.mysql.com/)下载mysql-5.6.38-linux-glibc2.12-x86_64.tar.gz文件)

        tar -zxvf mysql-5.6.38-linux-glibc2.12-x86_64.tar.gz -C /usr/local
	    mv /usr/local/mysql-5.6.38-linux-glibc2.12-x86_64 /usr/local/mysql
	    
* mysql配置
    * 5.7运行mysqld --initialize --user=mysql时会生成初始密码
	* 5.7以下所有配置运行完并启动mysql后需登录mysql并执行 set password=('your_pass') 重置密码开始使用
	* 5.6启动mysql后直接运行mysql登录使用
	* 配置命令
	
	        echo "[mysql]" > /etc/my.cnf
	        echo "default-character-set=utf8" >> /etc/my.cnf
	        echo "socket=/var/lib/mysql/mysql.sock" >> /etc/my.cnf
	        echo "[mysqld]" >> /etc/my.cnf
	        echo "skip-name-resolve" >> /etc/my.cnf
	        echo "port=3306" >> /etc/my.cnf
	        echo "socket=/var/lib/mysql/mysql.sock" >> /etc/my.cnf
	        echo "basedir=/usr/local/mysql" >> /etc/my.cnf
	        echo "datadir=/usr/local/mysql/data" >> /etc/my.cnf
	        echo "max_connections=200" >> /etc/my.cnf
	        echo "character-set-server=utf8" >> /etc/my.cnf
	        echo "default-storage-engine=INNODB" >> /etc/my.cnf
	        echo "lower_case_table_names=1" >> /etc/my.cnf
	        echo "max_allowed_packet=16M" >> /etc/my.cnf
	        mkdir -p /var/lib/mysql/mysql
	        groupadd mysql
	        useradd -g mysql mysql
	        chown -R mysql:mysql /usr/local/mysql
	        chown -R mysql:mysql /var/lib/mysql
	        yum install -y perl-Module-Install.noarch
	        /usr/local/mysql/scripts/mysql_install_db --user=mysql --basedir=/usr/local/mysql # 5.6
	        #mysqld --initialize --user=mysql # 5.7
	        cp /usr/local/mysql/support-files/mysql.server /etc/rc.d/init.d/mysqld
	        chmod +x /etc/rc.d/init.d/mysqld
	        chkconfig --add mysqld
	        chkconfig --list mysqld
	        echo "export PATH=\$PATH:/usr/local/mysql/bin" >> /etc/profile
	        source /etc/profile
	
#### tomcat相关
* tomcat安装(需[官网](http://tomcat.apache.org/)下载apache-tomcat-9.0.1.tar.gz文件)

        tar -zxvf apache-tomcat-9.0.1.tar.gz -C /
	    mv /apache-tomcat-9.0.1 /tomcat
	    echo "<?xml version='1.0' encoding='utf-8'?>" > /tomcat/conf/tomcat-user.xml
	    echo "<tomcat-users>" >> /tomcat/conf/tomcat-user.xml
	    echo "<role rolename=\"admin-gui\" />" >> /tomcat/conf/tomcat-user.xml
	    echo "<role rolename=\"admin-script\" />" >> /tomcat/conf/tomcat-user.xml
	    echo "<role rolename=\"manager-gui\" />" >> /tomcat/conf/tomcat-user.xml
	    echo "<role rolename=\"manager-script\" />" >> /tomcat/conf/tomcat-user.xml
	    echo "<role rolename=\"manager-jmx\" />" >> /tomcat/conf/tomcat-user.xml
	    echo "<role rolename=\"manager-status\" />" >> /tomcat/conf/tomcat-user.xml
	    echo "<user username=\"your_username\" password=\"your_password\" roles=\"manager-gui,manager-script,manager-jmx,manager-status,admin-script,admin-gui\" />" >> /tomcat/conf/tomcat-user.xml
	    echo "</tomcat-users>" >> /tomcat/conf/tomcat-user.xml

#### redis相关
* redis安装
	
	    yum install epel-release.noarch -y
	    yum install redis -y
	    
#### ffmpeg相关
* [ffmpeg官网](https://www.ffmpeg.org/)
* [ffmpeg git地址](https://github.com/FFmpeg/FFmpeg)
* ffmpeg安装
    * 启用epel仓库
    * 安装nux-dextop仓库
    * 安装ffmpeg
    
          yum install epel-release -y
          rpm --import http://li.nux.ro/download/nux/RPM-GPG-KEY-nux.ro
          rpm -Uvh http://li.nux.ro/download/nux/dextop/el7/x86_64/nux-dextop-release-0-5.el7.nux.noarch.rpm
          yum install ffmpeg ffmpeg-devel -y
          ffmpeg -h
          
        * 如果最后出现ffmpeg帮助信息则表示安装成功
* ffmpeg常用命令

        ffmpeg -h # 获取帮助
        ffmpeg -i %s # 获取视频信息(视频地址)
        ffmpeg -i %s -y -f image2 -t 0.001 -s %sx%s %s # 生成缩略图(视频地址/视频宽/视频高/缩略图地址)
        ffmpeg -i %s -vf crop=%s:%s:%s:%s %s # 对图片进行指定大小截图(图片地址/结果图片宽/结果图片高/原图x轴起截点/原图y轴起截点/结果图片生成地址)
    
### swagger相关
* [swagger官网](https://swagger.io/)
* 添加依赖：

        compile("io.springfox:springfox-swagger2:${swaggerVersion}") //swagger2核心jar包
        compile("io.springfox:springfox-swagger-ui:${swaggerVersion}") //swagger2核心jar包
    
* 各个注解说明

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
    
* 访问路径： 

        http://${host}/swagger-ui.html
    
### vue 相关 (需先安装nodejs)
* [vue官网](https://cn.vuejs.org/)
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
### redis相关
* 添加redis依赖

        "org.springframework.boot:spring-boot-starter-redis:$springRedisVersion",
        "org.springframework.data:spring-data-redis:$springDataRedis",
    
* 配置redis(application.yml)

        spring:
            redis:
              host: 127.0.0.1
              port: 6379
          
### shiro 相关
* [shiro官网](http://shiro.apache.org/)
* shiro依赖添加（gradle）

        "org.apache.shiro:shiro-core:${shiroVersion}",
        "org.apache.shiro:shiro-web:${shiroVersion}",
        "org.apache.shiro:shiro-spring:${shiroVersion}",
    
* 用户权限等相关数据库添加及pojo类书写

        用户表 id  userName    password
        角色表 id  permissionName
        权限表 id  roleName
        用户_角色表  userId  roleId
        角色_权限表  roleId  permissionId
        (一个用户拥有多个角色，一个角色拥有多个权限)
    
* 编写配置类(具体查看[代码](https://github.com/makai554892700/sbgnews/tree/master/src/main/java/com/mayousheng/www/sbgnews/common/auth))
    
        ShiroConfig
        AuthRealm
        CredentialsMatcher
    
* Shiro内置的FilterChain

 Filter Name | Class | Descrption
----------  | ------ | -----
 anon        | org.apache.shiro.web.filter.authc.AnonymousFilter | 所有url都都可以匿名访问
 authc       | org.apache.shiro.web.filter.authc.FormAuthenticationFilter | 需要认证才能进行访问
 authcBasic  | org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter |
 perms       | org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter |
 port        | org.apache.shiro.web.filter.authz.PortFilter |
 rest        | org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter |
 roles       | org.apache.shiro.web.filter.authz.RolesAuthorizationFilter |
 ssl         | org.apache.shiro.web.filter.authz.SslFilter |
 user        | org.apache.shiro.web.filter.authc.UserFilter | 配置记住我或认证通过可以访问
 
* /src/main/resources/private/joke.properties 文件示例

        #笑话大全
        joke.baseurl=https://route.showapi.com/341-1?showapi_appid=47095&showapi_sign=you_showapi_sign&page=%s&maxResult=%s
        joke.showapiResCode=0
        joke.retCode=0
        joke.defaultPage=1
        joke.defaultCount=50
        joke.initSleepTime=1000
        joke.loaded=true
        joke.sleepTime=5000
        #百思不得姐
        bsbdj.baseurl=https://route.showapi.com/255-1?showapi_appid=47095&showapi_sign=you_showapi_sign&type=%s&page=%s
        bsbdj.showapiResCode=0
        bsbdj.retCode=0
        bsbdj.defaultPage=1
        bsbdj.initSleepTime=1000
        #图片
        bsbdj.types[0]=10
        #段子
        bsbdj.types[1]=29
        #声音
        bsbdj.types[2]=31
        #视频
        bsbdj.types[3]=41
        bsbdj.loaded=true
        bsbdj.sleepTime=5000
    
* 因为生成的截图保存在指定位置(/data/bsbdj/img)了
    * 所以需要给nginx添加如下配置
    * 同时最好运行chmod 777 -R /data/bsbdj 赋予文件夹权限
    * 没有此文件夹的最好先手动创建文件夹 mkdir -P /data/bsbdj/img

            server {
                .....
                location /bsbdj/img/ {
                    root /data/;
                    autoindex on;
                }
                .....
            }
