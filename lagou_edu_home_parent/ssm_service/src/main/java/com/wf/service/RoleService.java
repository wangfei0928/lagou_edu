package com.wf.service;

import com.wf.domain.Role;
import com.wf.domain.RoleMenuVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {

    /*
    * 查询用户（条件）
    * */
    public List<Role> findAllRole(Role role);

    /*
     * 根据ID查询角色关联信息
     * */
    public List<Integer> findMenuByRoleId(Integer id);

    /*
    * 修改角色菜单关联
    * */
    public void RoleContextMenu(RoleMenuVo roleMenuVo);

    /*
    * 删除角色
    * */
    public void deleteRole(Integer integer);
}
