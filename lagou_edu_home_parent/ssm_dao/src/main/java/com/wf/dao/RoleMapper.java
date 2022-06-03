package com.wf.dao;

import com.wf.domain.Role;
import com.wf.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    /*
    * 查询角色列表(条件)
    *
    * */
    public List<Role> findAllRole(Role role);

    /*
    * 根据ID查询角色关联信息
    * */
    public List<Integer> findMenuByRoleId(Integer id);

    /*
    * 修改角色菜单
    * */
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    public void deleteRoleContextMenu(Integer id);

    /*
    * 删除角色
    * */
    public void deleteRole(Integer id);
}
