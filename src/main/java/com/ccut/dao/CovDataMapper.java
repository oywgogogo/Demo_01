package com.ccut.dao;

import com.ccut.pojo.CovData;
import com.ccut.pojo.DataTest;

import java.util.List;
import java.util.Map;

public interface CovDataMapper {
    //插入数据
    public int addData(CovData covData);
    //删除数据
    public int deteleData();
    //修改数据
    public int updateData();
    //查询数据
    public List queryData(Map<String,Object> data);

    //
    public List allstudents();
}
