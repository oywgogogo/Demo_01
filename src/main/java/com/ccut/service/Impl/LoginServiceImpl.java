package com.ccut.service.Impl;

import com.ccut.dao.LoginMapper;
import com.ccut.pojo.vo.LoginVO;
import com.ccut.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    LoginMapper loginMapper;


    @Override
    public boolean login(String username, String password) {
        LoginVO loginVO = loginMapper.findUserByUserName(username);
        if (loginVO!=null && loginVO.getUserpass().equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
