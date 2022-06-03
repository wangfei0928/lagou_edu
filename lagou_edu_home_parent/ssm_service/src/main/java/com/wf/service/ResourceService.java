package com.wf.service;

import com.github.pagehelper.PageInfo;
import com.wf.domain.Resource;
import com.wf.domain.ResourceVo;

import java.util.List;

public interface ResourceService {
    public PageInfo<Resource> findAllResourceByPage(ResourceVo resourceVo);
}
