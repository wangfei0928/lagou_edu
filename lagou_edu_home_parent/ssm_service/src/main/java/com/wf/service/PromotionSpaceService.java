package com.wf.service;

import com.wf.domain.Course;
import com.wf.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {

    public List<PromotionSpace> findAllPromotionSpace();

    public void savePromotionSpace(PromotionSpace promotionSpace);

    public void updatePromotionSpace(PromotionSpace promotionSpace);

    public PromotionSpace findPromotionSpaceById(int id);


}
