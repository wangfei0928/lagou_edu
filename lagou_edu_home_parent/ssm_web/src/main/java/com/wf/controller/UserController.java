package com.wf.controller;

import com.github.pagehelper.PageInfo;
import com.wf.domain.ResponseResult;
import com.wf.domain.Role;
import com.wf.domain.User;
import com.wf.domain.UserVo;
import com.wf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo) {

        PageInfo pageInfo = userService.findAllUserByPage(userVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", pageInfo);
        List<User> list = pageInfo.getList();
        System.out.println(list);
        return responseResult;
    }

    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(Integer id, String status) {
        userService.updateUserStatus(id, status);
        ResponseResult responseResult = new ResponseResult(true, 200, "更新成功", null);
        return responseResult;
    }
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User login = userService.login(user);
        if (login != null){
            //保存access_token
            Map<String,Object> map = new HashMap<>();
            String access_token = UUID.randomUUID().toString();
            map.put("access_token",access_token);
            map.put("user_id",login.getId());
            HttpSession session = request.getSession();
            session.setAttribute("user_id",login.getId());
            session.setAttribute("access_token",access_token);
            ResponseResult result = new ResponseResult(true,1,"响应成功",map);
            return  result;
        }else{
            ResponseResult result = new ResponseResult(true,1,"用户名密码错误",null);
            return  result;
        }

    }

    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRoleById(int id){
        List<Role> roleList = userService.findUserRelationRoleById(id);
        System.out.println(id);
        System.out.println(roleList);
        return new ResponseResult(true,200,"分配角色回显成功",roleList);
    }

    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVo userVo){
        userService.userContextRole(userVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "修改用户角色成功", null);
        return responseResult;
    }

    /*
     获取用户权限
    */
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){
        //获取请求头中的 token
        String token = request.getHeader("Authorization");
        //获取session中的access_token
        HttpSession session = request.getSession();
        String access_token = (String)session.getAttribute("access_token");
        //判断
        if(token.equals(access_token)){
            int user_id = (Integer)session.getAttribute("user_id");
            ResponseResult result = userService.getUserPermissions(user_id);
            return result;
        }else{ResponseResult result = new ResponseResult(false,400,"获取失败",null);
            return result;
        }
    }
}
