package com.wf.dao;

import com.wf.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceMapper {

    /*
    *��ȡ���й��λ
    **/
    public List<PromotionSpace> findAllPromotionSpace();

    /*
    * ��ӹ��λ
    * */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /*
    * ���¹��λ
    * */
    public void updatePromotionSpace(PromotionSpace promotionSpace);

    /*
    * ����id���Թ��λ����
    * */
    public PromotionSpace findPromotionSpaceById(int id);


}
