package com.tyl.oa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @program: springcloud
 * @description:
 * @author: tututyl
 * @create: 2020-06-15 19:08
 **/

@SpringBootApplication
@EnableEurekaClient
public class App_80 {
    public static void main(String[] args) {
        SpringApplication.run(App_80.class,args);
    }
}
