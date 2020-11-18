package com.tyl.oa.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud
 * @description:
 * @author: tututyl
 * @create: 2020-06-18 19:00
 **/
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced//Ribbon 配置负载均衡实现restfulTemplate
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
