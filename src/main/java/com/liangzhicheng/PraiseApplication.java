package com.liangzhicheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching //启用缓存
@SpringBootApplication
public class PraiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PraiseApplication.class, args);
    }

}
