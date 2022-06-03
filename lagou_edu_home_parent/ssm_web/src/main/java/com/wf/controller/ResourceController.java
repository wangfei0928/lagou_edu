package com.wf.controller;

import com.github.pagehelper.PageInfo;
import com.wf.domain.Resource;
import com.wf.domain.ResourceVo;
import com.wf.domain.ResponseResult;
import com.wf.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/findAllResourceByPage")
    public ResponseResult findAllResourceByPage(@RequestBody ResourceVo resourceVo){
        PageInfo<Resource> pageInfo = resourceService.findAllResourceByPage(resourceVo);
        return  new ResponseResult(true,200,"分页多条件查询所有资源信息",pageInfo);
    }
}
