package com.wf.service;

import com.wf.domain.Menu;

import java.util.List;

public interface MenuService {
    /*
    * ��ѯ���и��Ӳ˵���Ϣ
    * */
    public List<Menu> findSubMenuListByPid(int pid);

    /*
    * ��ѯ�˵�����ҳ��
    * */
    public List<Menu> findAllMenu();

    /*
    * ͨ��id��ѯ�˵�
    * */
    public Menu findMenuById(Integer id);
}
