package com.wf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.dao.ResourceMapper;
import com.wf.domain.Resource;
import com.wf.domain.ResourceVo;
import com.wf.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResourceByPage(ResourceVo resourceVo) {
        //∑÷“≥≤È—Ø
        PageHelper.startPage(resourceVo.getCurrentPage(),resourceVo.getPageSize());

        List<Resource> allResourceByPage = resourceMapper.findAllResourceByPage(resourceVo);

        PageInfo<Resource> pageInfo = new PageInfo<>(allResourceByPage);

        return pageInfo;
    }
}
