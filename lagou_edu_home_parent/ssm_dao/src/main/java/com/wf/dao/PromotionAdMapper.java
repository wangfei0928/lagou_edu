package com.wf.dao;

import com.wf.domain.PromotionAd;
import com.wf.domain.PromotionAdVo;

import java.util.List;

public interface PromotionAdMapper {

    /*
    * 分页查询广告信息
    * */
    public List<PromotionAd> findAllPromotionByPage();

    /*新增广告*/
    public void savePromotionAd(PromotionAd promotionAd);

    /*修改广告*/
    public void updatePromotionAd(PromotionAd promotionAd);

    /*修改广告状态*/
    public void updatePromotionAdStatus(PromotionAd promotionAd);
}
