package com.wf.controller;

import com.wf.domain.Test;
import com.wf.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController   //@Controller 和 @ResponseBody
@RequestMapping("/test")
public class Controller {

    @Autowired
    private TestService testService;
    @RequestMapping("/findAllTest")
    public List<Test> findAllTest(){
        List<Test> allTest = testService.findAllTest();
        return  allTest;
    }

}
