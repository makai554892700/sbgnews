package com.mayousheng.www.sbgnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Configuration
@PropertySource({
        "classpath:${spring.profiles.active}/topnews.properties",
})
public class SbgnewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbgnewsApplication.class, args);
    }
}
