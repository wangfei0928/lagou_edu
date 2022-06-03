package com.wf.dao;

import com.wf.domain.Role;
import com.wf.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    /*
    * ��ѯ��ɫ�б�(����)
    *
    * */
    public List<Role> findAllRole(Role role);

    /*
    * ����ID��ѯ��ɫ������Ϣ
    * */
    public List<Integer> findMenuByRoleId(Integer id);

    /*
    * �޸Ľ�ɫ�˵�
    * */
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    public void deleteRoleContextMenu(Integer id);

    /*
    * ɾ����ɫ
    * */
    public void deleteRole(Integer id);
}
