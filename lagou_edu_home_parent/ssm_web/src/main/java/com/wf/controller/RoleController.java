package com.wf.controller;

import com.wf.domain.Menu;
import com.wf.domain.ResponseResult;
import com.wf.domain.Role;
import com.wf.domain.RoleMenuVo;
import com.wf.service.MenuService;
import com.wf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){
        List<Role> allRole = roleService.findAllRole(role);
        ResponseResult responseResult = new ResponseResult(true,200,"角色查询成功",allRole);
        return responseResult;
    }

    /*
    * 查询所有的父子菜单信息
    * */
    @Autowired
    private MenuService menuService;
    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid(){

        //-1表示查询所有的父子级菜单
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);
        //响应数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("parentMenuList",menuList);
        ResponseResult responseResult = new ResponseResult(true,200,"查询所有父子菜单信息",map);
        return  responseResult;
    }

    /*
    * 根据角色信息查询关联信息Id
    * */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);
        ResponseResult responseResult = new ResponseResult(true,200,"查询角色关联的菜单信息成功",menuByRoleId);
        return  responseResult;
    }

    /*
    *修改角色菜单关联
    * */
    @RequestMapping("/roleContextMenu")
    public ResponseResult  roleContextMenu(@RequestBody RoleMenuVo roleMenuVo){

        roleService.RoleContextMenu(roleMenuVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "修改角色菜单关联成功", null);
        return responseResult;
    }
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){
        roleService.deleteRole(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "删除角色成功", null);
        return responseResult;
    }
}
