package com.ccut.dao;

import com.ccut.pojo.vo.LoginVO;

public interface LoginMapper {

    //登录
    public LoginVO findUserByUserName(String username);
}
