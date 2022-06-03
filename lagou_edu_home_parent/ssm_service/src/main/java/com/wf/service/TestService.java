package com.wf.service;

import com.wf.domain.Test;

import java.util.List;

public interface TestService {
    /*
    * 查询test表中的所有用户
    * */
    public List<Test> findAllTest();
}
