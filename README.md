# sbgnews
新闻web端springboot+gradle实现
#spring boot + swagger
#### [swagger官网](https://swagger.io/)
### 添加依赖：

    compile("io.springfox:springfox-swagger2:${swaggerVersion}") //swagger2核心jar包
    compile("io.springfox:springfox-swagger-ui:${swaggerVersion}") //swagger2核心jar包
### 各个注解说明

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
### 访问路径： 

    http://${host}/swagger-ui.html
# CENTOS7下ffmpeg安装与总结
#### [ffmpeg官网](https://www.ffmpeg.org/)
#### [ffmpeg git地址](https://github.com/FFmpeg/FFmpeg)
### ffmpeg安装
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