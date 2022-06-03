package com.wf.service;

import com.github.pagehelper.PageInfo;
import com.wf.domain.PromotionAd;
import com.wf.domain.PromotionAdVo;

import java.util.List;

public interface PromotionAdService {

    public PageInfo<PromotionAd> findPromotionAdByPage(PromotionAdVo promotionAdVo);

    public void savePromotionAd(PromotionAd promotionAd);

    public void updatePromotionAd(PromotionAd promotionAd);

    public void updatePromotionAdStatus(Integer id,Integer status);
}
