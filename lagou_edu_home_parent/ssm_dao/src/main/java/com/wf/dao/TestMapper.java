package com.wf.dao;

import com.wf.domain.Test;

import java.util.List;

public interface TestMapper {

    /*
    * 对test表查询所有操作
    * */
    public List<Test> findAllTest();
}
