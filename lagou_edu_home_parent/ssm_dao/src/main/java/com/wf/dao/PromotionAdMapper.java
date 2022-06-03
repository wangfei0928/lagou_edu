package com.wf.dao;

import com.wf.domain.PromotionAd;
import com.wf.domain.PromotionAdVo;

import java.util.List;

public interface PromotionAdMapper {

    /*
    * ��ҳ��ѯ�����Ϣ
    * */
    public List<PromotionAd> findAllPromotionByPage();

    /*�������*/
    public void savePromotionAd(PromotionAd promotionAd);

    /*�޸Ĺ��*/
    public void updatePromotionAd(PromotionAd promotionAd);

    /*�޸Ĺ��״̬*/
    public void updatePromotionAdStatus(PromotionAd promotionAd);
}
