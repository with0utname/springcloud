package com.tyl.oa.controller;

import com.tyl.oa.pojo.Dept;
import com.tyl.oa.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: tututyl
 * @create: 2020-06-15 19:00
 **/
@RestController
public class DeptController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    DeptServiceImpl deptServiceImpl;


    //server的缓存数据就算localhost关闭都不会丢失
    @RequestMapping("/hello1")
    public Object hello1() {
        System.out.println("inside:hello1");
        redisTemplate.opsForValue().set("k1", "v1", 10, TimeUnit.SECONDS);
        return redisTemplate.opsForValue().get("k1");
    }

    @RequestMapping("/hello2")
    public Object hello2() {
        System.out.println("inside:hello2");
        redisTemplate.opsForValue().set("k1", "v11", 10, TimeUnit.SECONDS);
        return redisTemplate.opsForValue().get("k1");
    }

    @RequestMapping("/hello3")
    public Object hello3() {
        System.out.println("inside:hello3");
        return redisTemplate.opsForValue().get("k1");
    }

    @RequestMapping("/hello4")
    public Object hello4() {
        System.out.println("inside:hello4");
////        插入单条语句
//        redisTemplate.opsForList().leftPush("L_depts", new Dept().setDname("研发部").setDeptNo(1).setDb_source("data_1"));
//        redisTemplate.opsForList().leftPush("L_depts", new Dept().setDname("市场部").setDeptNo(2).setDb_source("data_1"));
        redisTemplate.opsForList().leftPushAll("L_depts", new Dept().setDname("研发部").setDeptNo(1).setDb_source("data_1"), new Dept().setDname("市场部").setDeptNo(2).setDb_source("data_1"));
        return redisTemplate.opsForList().range("L_depts", 0, -1);
    }

    @RequestMapping("/hello5")
    public Object hello5() {
        System.out.println("inside:hello5");
        redisTemplate.opsForSet().add("S_depts", new Dept().setDname("研发部").setDeptNo(1).setDb_source("data_1"), new Dept().setDname("市场部").setDeptNo(2).setDb_source("data_1"));
        return redisTemplate.opsForSet().members("S_depts");
    }
    @RequestMapping("/hello6")
    public Object hello6() {
        System.out.println("inside:hello5");
//        //单个插入
//        redisTemplate.opsForHash().put("H_depts","1",new Dept().setDname("研发部").setDeptNo(1).setDb_source("data_1"));
//        return redisTemplate.opsForHash().get("H_depts","1");
        //群体插入
        Map<String,Object> depts = new HashMap<String, Object>();
        depts.put("1",new Dept().setDname("研发部").setDeptNo(1).setDb_source("data_1"));
        depts.put("2",new Dept().setDname("市场部").setDeptNo(2).setDb_source("data_1"));
        redisTemplate.opsForHash().putAll("H_depts",depts);
//       这个的返回值：[{"deptNo":2,"dname":"市场部","db_source":"data_1"},{"deptNo":1,"dname":"研发部","db_source":"data_1"}]
        return redisTemplate.opsForHash().values("H_depts");
//      这个的返回值：{"2":{"deptNo":2,"dname":"市场部","db_source":"data_1"},"1":{"deptNo":1,"dname":"研发部","db_source":"data_1"}}
//        return redisTemplate.opsForHash().entries("H_depts");
    }


/*
http://127.0.0.1/user/1 GET 根据用户id查询用户数据
http://127.0.0.1/user POST 新增用户
http://127.0.0.1/user PUT 修改用户信息
http://127.0.0.1/user DELETE 删除用户信息
 */
    @GetMapping("/dept/get/{deptNo}")
    public Object getDept(@PathVariable("deptNo") long deptNo) {
        return deptServiceImpl.selectDept(new Dept().setDeptNo(deptNo));
    }
    @GetMapping("/dept/getAll")
    public List<Dept> getAllDept() {
        return deptServiceImpl.getAllDept();
    }
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptServiceImpl.addDept(dept);
    }
    @PutMapping("/dept/update")
    public void updateDept(Dept dept) {
        deptServiceImpl.updateDept(dept);
    }
    @DeleteMapping("/dept/delete")
    public void deleteDept(Dept dept) {
        deptServiceImpl.deleteDept(dept);
    }
}
