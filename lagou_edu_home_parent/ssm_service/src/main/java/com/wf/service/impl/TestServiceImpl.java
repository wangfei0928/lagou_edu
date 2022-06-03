package com.wf.service.impl;

import com.wf.dao.TestMapper;
import com.wf.domain.Test;
import com.wf.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAllTest() {
        List<Test> allTest = testMapper.findAllTest();
        return allTest;
    }
}
