package com.wf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.dao.UserMapper;
import com.wf.domain.*;
import com.wf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVo userVo) {
        // 使用pageHelper
        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());
        List<User> allUser = userMapper.findAllUserByPage(userVo);
        PageInfo<User> pageInfo = new PageInfo<>(allUser);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());
        System.out.println("是否第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());
        return pageInfo;

    }

    @Override
    public void updateUserStatus(Integer id, String status) {
        userMapper.updateUserStatus(id, status);
    }

    @Override
    public User login(User user) throws Exception {
        User user1 = userMapper.login(user);
        if (user1 != null && Md5.verify(user.getPassword(),"wf",user1.getPassword())){
            return user1;
        }else {
            return null;
        }

    }

    @Override
    public List<Role> findUserRelationRoleById(int id) {
        List<Role> roleList = userMapper.findUserRelationRoleById(id);
        return roleList;
    }

    @Override
    public void userContextRole(UserVo userVo) {

        userMapper.deleteUserContextRole(userVo.getUserId());

        for (Integer roleid : userVo.getRoleIdList()) {
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVo.getUserId());
            user_role_relation.setRoleId(roleid);

            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);

            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");
            userMapper.userContextRole(user_role_relation);
        }

    }

    @Override
    public ResponseResult getUserPermissions(Integer id) {
        //1.获取当前用户拥有的角色
        List<Role> roleList = userMapper.findUserRelationRoleById(id);
        //2.获取角色ID,保存到list
        List<Integer> list = new ArrayList<>();
        for (Role role : roleList) {
            list.add(role.getId());
        }
        //3.根据角色id查询 父菜单
        List<Menu> parentMenu = userMapper.findParentMenuByRoleId(list);
        //4.封装父菜单下的子菜单
        for (Menu menu : parentMenu) {
            List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenu); }
        //5.获取资源权限
        List<Resource> resourceList = userMapper.findResourceByRoleId(list);
        //6.封装数据
        Map<String,Object> map = new HashMap<>();
        map.put("menuList",parentMenu);//menuList: 菜单权限数据
        map.put("resourceList",resourceList);//resourceList: 资源权限数据
        ResponseResult result = new ResponseResult(true,200,"响应成功",map);
        return result;

    }


}
