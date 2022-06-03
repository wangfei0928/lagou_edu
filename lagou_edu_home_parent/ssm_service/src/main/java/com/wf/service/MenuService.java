package com.wf.service;

import com.wf.domain.Menu;

import java.util.List;

public interface MenuService {
    /*
    * 查询所有父子菜单信息
    * */
    public List<Menu> findSubMenuListByPid(int pid);

    /*
    * 查询菜单所有页面
    * */
    public List<Menu> findAllMenu();

    /*
    * 通过id查询菜单
    * */
    public Menu findMenuById(Integer id);
}
