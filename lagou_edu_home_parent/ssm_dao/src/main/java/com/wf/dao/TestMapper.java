package com.wf.dao;

import com.wf.domain.Test;

import java.util.List;

public interface TestMapper {

    /*
    * ��test���ѯ���в���
    * */
    public List<Test> findAllTest();
}
