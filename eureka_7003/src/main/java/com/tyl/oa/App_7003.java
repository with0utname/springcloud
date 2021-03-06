package com.tyl.oa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: springcloud
 * @description:
 * @author: tututyl
 * @create: 2020-06-18 20:53
 **/
@EnableEurekaServer
@SpringBootApplication
public class App_7003 {
    public static void main(String[] args) {
        SpringApplication.run(App_7003.class,args);
    }
}