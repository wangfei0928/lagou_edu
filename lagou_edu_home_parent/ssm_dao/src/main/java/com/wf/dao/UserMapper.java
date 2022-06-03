package com.wf.dao;

import com.wf.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /*分页查询用户信息*/
    public List<User> findAllUserByPage(UserVo userVo);

    /*修改用户状态*/
    public void updateUserStatus(@Param("id") Integer id,@Param("status") String status);

    /*
    * 用户登录（根据用户名查询具体的用户信息）
    * */
    public User login(User user);


    /*
    * 删除用户当权角色信息
    * */
    public void  deleteUserContextRole(Integer userid);

    /*
    * 分配角色
    * */
    public void userContextRole(User_Role_relation user_role_relation);


    /*
     * 1. 根据id查询用户当前信息
     * */
    public List<Role> findUserRelationRoleById(int id);

    /*
    * 2. 根据角色id查询角色所拥有的顶级菜单
    * */
    public List<Menu>findParentMenuByRoleId(List<Integer> ids);

    /*
      3.  根据PID 查询子菜单信息
    */
    public List<Menu> findSubMenuByPid(int pid);

    /*
    * 4. 获取用户拥有的资源权限信息
    * */
    public List<Resource> findResourceByRoleId(List<Integer> ids);
}
