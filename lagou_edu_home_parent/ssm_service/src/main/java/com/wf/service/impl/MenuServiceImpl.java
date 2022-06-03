package com.wf.service.impl;

import com.wf.dao.MenuMapper;
import com.wf.domain.Menu;
import com.wf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findSubMenuListByPid(int pid) {
        List<Menu> subMenuListByPid = menuMapper.findSubMenuListByPid(pid);
        return subMenuListByPid;
    }

    @Override
    public List<Menu> findAllMenu() {
        List<Menu> list = menuMapper.findAllMenu();
        return list;
    }

    @Override
    public Menu findMenuById(Integer id) {

        return  menuMapper.findMenuById(id);
    }
}
