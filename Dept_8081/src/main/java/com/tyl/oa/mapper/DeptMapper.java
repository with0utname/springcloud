package com.tyl.oa.mapper;

import com.tyl.oa.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springcloud
 * @description:
 * @author: tututyl
 * @create: 2020-06-15 19:00
 **/
@Component
public class DeptMapper {

    @Autowired
    RedisTemplate redisTemplate;

    @Transactional
    public boolean addDept(Dept dept) {
        return redisTemplate.opsForHash().putIfAbsent("H_depts", dept.getDeptNo(), dept);
    }

    @Transactional
    public void deleteDept(Dept dept) {
        redisTemplate.opsForHash().delete("H_depts", dept.getDeptNo());
    }

    @Transactional
    public void updateDept(Dept dept) {
        redisTemplate.opsForHash().put("H_depts", dept.getDeptNo(), dept);
    }

    @Transactional
    public Dept selectDept(Dept dept) {
        return (Dept) redisTemplate.opsForHash().get("H_depts", dept);
    }

    public List<Dept> getAllDept() {
        return redisTemplate.opsForHash().values("H_depts");
    }

}
