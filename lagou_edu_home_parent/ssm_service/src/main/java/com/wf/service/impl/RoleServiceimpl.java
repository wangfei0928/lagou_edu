package com.wf.service.impl;

import com.wf.dao.RoleMapper;
import com.wf.domain.Role;
import com.wf.domain.RoleMenuVo;
import com.wf.domain.Role_menu_relation;
import com.wf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RoleServiceimpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        return allRole;
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer id) {
        List<Integer> menuByRoleId = roleMapper.findMenuByRoleId(id);
        return menuByRoleId;
    }

    @Override
    public void RoleContextMenu(RoleMenuVo roleMenuVo) {
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());
        for (Integer mid : roleMenuVo.getMenuIdList()) {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setCreatedTime(new Date());
            role_menu_relation.setUpdatedTime(new Date());
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedBy("system");
            roleMapper.roleContextMenu(role_menu_relation);
        }
    }

    @Override
    public void deleteRole(Integer id) {
        roleMapper.deleteRoleContextMenu(id);
        roleMapper.deleteRole(id);
    }
}
