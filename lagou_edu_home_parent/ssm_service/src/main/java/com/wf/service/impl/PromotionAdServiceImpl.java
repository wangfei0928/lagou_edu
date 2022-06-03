package com.wf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.dao.PromotionAdMapper;
import com.wf.domain.PromotionAd;
import com.wf.domain.PromotionAdVo;
import com.wf.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    @Override
    public PageInfo<PromotionAd> findPromotionAdByPage(PromotionAdVo promotionAdVo) {

        PageHelper.startPage(promotionAdVo.getCurrentPage(),promotionAdVo.getPageSize());
        List<PromotionAd> allPromotionByPage = promotionAdMapper.findAllPromotionByPage();

        PageInfo<PromotionAd> pageInfo = new PageInfo<>(allPromotionByPage);
        return pageInfo;
    }

    @Override
    public void savePromotionAd(PromotionAd promotionAd) {
        Date date = new Date();
        promotionAd.setCreateTime(date);
        promotionAd.setUpdateTime(date);
        promotionAdMapper.savePromotionAd(promotionAd);
    }

    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        promotionAd.setUpdateTime(new Date());
        promotionAdMapper.updatePromotionAd(promotionAd);
    }

    @Override
    public void updatePromotionAdStatus(Integer id, Integer status) {

        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(new Date());

        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }
}
