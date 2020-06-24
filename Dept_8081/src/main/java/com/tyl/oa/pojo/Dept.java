package com.tyl.oa.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: springcloud
 * @description:
 * @author: tututyl
 * @create: 2020-06-15 19:00
 **/
@Data
@NoArgsConstructor
@Accessors(chain=true)
public class Dept {
    private long deptNo;
    private String dname;

    //存在哪个数据库，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private  String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
