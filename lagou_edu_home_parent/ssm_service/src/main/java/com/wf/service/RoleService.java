package com.wf.service;

import com.wf.domain.Role;
import com.wf.domain.RoleMenuVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {

    /*
    * ��ѯ�û���������
    * */
    public List<Role> findAllRole(Role role);

    /*
     * ����ID��ѯ��ɫ������Ϣ
     * */
    public List<Integer> findMenuByRoleId(Integer id);

    /*
    * �޸Ľ�ɫ�˵�����
    * */
    public void RoleContextMenu(RoleMenuVo roleMenuVo);

    /*
    * ɾ����ɫ
    * */
    public void deleteRole(Integer integer);
}
