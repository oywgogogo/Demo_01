package com.ccut.controller;


import com.ccut.pojo.CovData;
import com.ccut.pojo.DataTest;
import com.ccut.service.CovDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/students")
public class CovDataController {
    @Resource
    CovDataService covDataService;

    @ResponseBody
    @RequestMapping("/addstudents")
    public int addData(@RequestBody CovData covData){
        return covDataService.addData(covData);
    }

    @ResponseBody
    @RequestMapping(value = "/gettest/{name}/{sex}",method = RequestMethod.GET)
    public String getTest(@PathVariable String name,
                          @PathVariable String sex){
        System.out.println(name+"  "+sex);
        return "getTest succeed";
    }

    @ResponseBody
    @RequestMapping(value = "/dataTest/{currPage}/{currPageSize}")
    public List queryData(@PathVariable int currPage,
                          @PathVariable int currPageSize){
        return covDataService.queryData(currPage,currPageSize);
    }

    @RequestMapping("allStudents")
    public String list(Model model) {
        List list = covDataService.allstudents();
        model.addAttribute("list",list);
        return "allStudents";
    }
}
