package com.tyl.oa.controller;

import com.tyl.oa.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: springcloud
 * @description:
 * @author: tututyl
 * @create: 2020-06-18 19:02
 **/
//这个restTemplate是用来发起url请求的，利用restful风格，把8081端口的服务复制到这个8082端口，
//这个服务有个奇怪的地方（误？），如果请求8081端口的服务，直接返回到8082，就是把8081所有端口塞到8082上面，但是8082不会塞到8081上
//经过测试，不打开8081也可使用8081端口操作，意味着，这是把8081端口的所有接口，全部本地复制到8082
    //且端口的控制层路径不能重名，不然会报错
@RestController
public class DeptConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    //Ribbon 地址应该改为服务器名字，就是eureka 中 application 的值
    //private static final String REST_URL_PREFIX = "http://localhost:8081";
    private static final String REST_URL_PREFIX = "http://provider";

    @RequestMapping("/")
    public Object index() {
        System.out.println("80 is ok");
        return "80 is ok";
    }

    @RequestMapping("/consumer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") long deptNo) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get" + deptNo, Dept.class);
    }
/*如果使用Object就会报错
    *org.springframework.web.client.RestClientException: No HttpMessageConverter for java.lang.Object
 */

    @RequestMapping("/consumer/dept/add")
    public Dept add(Object dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Dept.class);
    }

    @RequestMapping("/consumer/dept/getAll")
    public List getAll() {
        System.out.println("getAll"+REST_URL_PREFIX);
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/getAll", List.class);
    }

    @RequestMapping("/hello11")
    public Object hello1l1() {
        System.out.println("hello11");
        return restTemplate.getForObject(REST_URL_PREFIX + "/hello1", String.class);
    }

}
