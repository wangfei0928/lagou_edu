package com.wf.dao;

import com.wf.domain.Menu;

import java.util.List;

public interface MenuMapper {

    /*
    * ��ѯ���и��Ӳ˵���Ϣ
    * */
    public List<Menu> findSubMenuListByPid(int pid);

    /*
    * ��ѯ���в˵��б�
    * */
    public List<Menu> findAllMenu();


    public Menu findMenuById(Integer id);
}
