package com.eeeentelecheia.rss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 引导类。Springboot项目的入口
 */
@SpringBootApplication
@EnableScheduling
public class RssApplication {
    public static void main(String[] args) {
        SpringApplication.run(RssApplication.class, args);
    }
}