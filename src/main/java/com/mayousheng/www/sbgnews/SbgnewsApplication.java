package com.mayousheng.www.sbgnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication //spring boot 主启动注解
@EnableScheduling //启用定时任务注解
@PropertySource(value = {
        "classpath:/private/joke.properties",//笑话大全配置文件
}, encoding = "UTF-8") //导入个人配置文件
@EnableSwagger2 //启动swagger注解
public class SbgnewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbgnewsApplication.class, args);
    }
}
