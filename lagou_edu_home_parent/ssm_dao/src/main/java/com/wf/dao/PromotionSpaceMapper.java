package com.wf.dao;

import com.wf.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceMapper {

    /*
    *获取所有广告位
    **/
    public List<PromotionSpace> findAllPromotionSpace();

    /*
    * 添加广告位
    * */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /*
    * 更新广告位
    * */
    public void updatePromotionSpace(PromotionSpace promotionSpace);

    /*
    * 根据id回显广告位名称
    * */
    public PromotionSpace findPromotionSpaceById(int id);


}
