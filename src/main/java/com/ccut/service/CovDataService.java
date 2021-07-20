package com.ccut.service;

import com.ccut.pojo.CovData;
import com.ccut.pojo.DataTest;

import java.util.List;

public interface CovDataService {
    public int addData(CovData covData);

    //查询数据
    public List queryData(int currPage,int currPageSize);

    //查询所有学生
    public List allstudents();
}
