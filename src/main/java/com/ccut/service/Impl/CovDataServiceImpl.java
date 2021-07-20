package com.ccut.service.Impl;

import com.ccut.dao.CovDataMapper;
import com.ccut.pojo.CovData;
import com.ccut.service.CovDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CovDataServiceImpl implements CovDataService {
    @Resource
    CovDataMapper covDataMapper;
    @Override
    public int addData(CovData covData) {
        return covDataMapper.addData(covData);
    }

    @Override
    public List queryData(int currPage,int currPageSize) {
        Map<String, Object> data = new HashMap<>();
        data.put("currPage", (currPage-1)*currPageSize);
        data.put("currPageSize", currPageSize);
        return covDataMapper.queryData(data);
    }

    @Override
    public List allstudents() {
        return covDataMapper.allstudents();
    }
}
