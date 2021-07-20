package com.ccut.controller;


import com.ccut.pojo.vo.LoginVO;
import com.ccut.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@CrossOrigin
@RestController
@RequestMapping("/Login")
public class LoginController {

    @Resource
    LoginService loginService;

    @GetMapping("/signIn")
    public boolean  Login(LoginVO loginVO){
        boolean flag = loginService.login(loginVO.getUsername(),loginVO.getUserpass());
        if (flag){
            return true;
        }else {
            return false;
        }
    }

}
