package com.wf.service;

import com.github.pagehelper.PageInfo;
import com.wf.domain.*;

import java.util.List;

public interface UserService {
    /*
    ��ѯ�����û�
     */
    public PageInfo findAllUserByPage(UserVo userVo);

    /*�޸��û�״̬*/
    public void updateUserStatus(Integer id,String status);

    /*
    *�û���¼
    **/
    public User login(User user) throws Exception;

    /*
    * ��ȡ�û�ӵ�еĽ�ɫ
    * */
    public List<Role> findUserRelationRoleById(int id) ;

    /*
    * �û�������ɫ
    * */
    public void userContextRole(UserVo userVo);

    /*
    * ��ȡ�û�Ȩ��
    * */
    public ResponseResult getUserPermissions(Integer id);
}
