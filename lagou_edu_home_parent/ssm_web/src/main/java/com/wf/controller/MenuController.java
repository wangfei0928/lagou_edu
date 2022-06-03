package com.wf.controller;

import com.wf.domain.Menu;
import com.wf.domain.ResponseResult;
import com.wf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /*
    * 查询所有菜单信息
    * */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> allMenu = menuService.findAllMenu();
        ResponseResult responseResult = new ResponseResult(true,200,"查询所有菜单信息",allMenu);
        return responseResult;
    }

    /*
    * 通过id进行查询菜单
    * */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(@RequestParam Integer id){
        //根据id判断是更新还是添加操作，
        if (id == -1){
            List<Menu> menuList = menuService.findSubMenuListByPid(-1);
            //封装数据
            Map<String,Object> map = new HashMap<>();
            map.put("menuInfo",null);
            map.put("parentMenuList",menuList);
            ResponseResult responseResult = new ResponseResult(true,200,"添加操作回显成功",map);
            return  responseResult;
        }else{
            Menu menu = menuService.findMenuById(id);
            List<Menu> menuList = menuService.findSubMenuListByPid(-1);
            Map<String,Object> map = new HashMap<>();
            map.put("menuInfo",menu);
            map.put("parentMenuList",menuList);
            ResponseResult result = new ResponseResult(true,200,"修改回显成功",map);
            return result;
        }
    }
}
