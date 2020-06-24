package com.tyl.oa.service;

import com.tyl.oa.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springcloud
 * @description:
 * @author: tututyl
 * @create: 2020-06-15 19:01
 **/
@Service
public interface DeptService {
    boolean addDept(Dept dept);
    void deleteDept(Dept dept);
    void updateDept(Dept dept);
    Dept selectDept(Dept dept);
    List<Dept> getAllDept();

}
