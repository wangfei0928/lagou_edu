package com.wf.dao;

import com.wf.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /*��ҳ��ѯ�û���Ϣ*/
    public List<User> findAllUserByPage(UserVo userVo);

    /*�޸��û�״̬*/
    public void updateUserStatus(@Param("id") Integer id,@Param("status") String status);

    /*
    * �û���¼�������û�����ѯ������û���Ϣ��
    * */
    public User login(User user);


    /*
    * ɾ���û���Ȩ��ɫ��Ϣ
    * */
    public void  deleteUserContextRole(Integer userid);

    /*
    * �����ɫ
    * */
    public void userContextRole(User_Role_relation user_role_relation);


    /*
     * 1. ����id��ѯ�û���ǰ��Ϣ
     * */
    public List<Role> findUserRelationRoleById(int id);

    /*
    * 2. ���ݽ�ɫid��ѯ��ɫ��ӵ�еĶ����˵�
    * */
    public List<Menu>findParentMenuByRoleId(List<Integer> ids);

    /*
      3.  ����PID ��ѯ�Ӳ˵���Ϣ
    */
    public List<Menu> findSubMenuByPid(int pid);

    /*
    * 4. ��ȡ�û�ӵ�е���ԴȨ����Ϣ
    * */
    public List<Resource> findResourceByRoleId(List<Integer> ids);
}
