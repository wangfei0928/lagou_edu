package com.wf.dao;

import com.wf.domain.Resource;
import com.wf.domain.ResourceVo;

import java.util.List;

public interface ResourceMapper {

    public List<Resource> findAllResourceByPage(ResourceVo resourceVo);

}
