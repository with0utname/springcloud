package com.tyl.oa.service.impl;

import com.tyl.oa.mapper.DeptMapper;
import com.tyl.oa.pojo.Dept;
import com.tyl.oa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springcloud
 * @description:
 * @author: tututyl
 * @create: 2020-06-15 19:01
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    public void deleteDept(Dept dept) {
        deptMapper.deleteDept(dept);
    }

    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }

    public Dept selectDept(Dept dept) {
        return deptMapper.selectDept(dept);
    }

    public List<Dept> getAllDept() {
        return deptMapper.getAllDept();
    }
}
