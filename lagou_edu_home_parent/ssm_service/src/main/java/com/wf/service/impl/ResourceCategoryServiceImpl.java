package com.wf.service.impl;

import com.wf.dao.ResourceCategoryMapper;
import com.wf.domain.ResourceCategory;
import com.wf.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        List<ResourceCategory> allResourceCategory = resourceCategoryMapper.findAllResourceCategory();
        return allResourceCategory;
    }
}
