package com.wf.controller;


import com.wf.dao.ResourceCategoryMapper;
import com.wf.domain.ResourceCategory;
import com.wf.domain.ResponseResult;
import com.wf.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();
        ResponseResult responseResult = new ResponseResult(true, 200, "查找资源成功", allResourceCategory);
        return responseResult;
    }
}
