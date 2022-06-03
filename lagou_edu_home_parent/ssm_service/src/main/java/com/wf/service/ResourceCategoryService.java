package com.wf.service;

import com.wf.dao.ResourceCategoryMapper;
import com.wf.domain.ResourceCategory;

import java.util.List;

public interface ResourceCategoryService {

    public List<ResourceCategory> findAllResourceCategory();
}
