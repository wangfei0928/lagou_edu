package com.wf.controller;

import com.wf.domain.PromotionSpace;
import com.wf.domain.ResponseResult;
import com.wf.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;

    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){
        List<PromotionSpace> allPromotionSpace = promotionSpaceService.findAllPromotionSpace();
        ResponseResult responseResult = new ResponseResult(true,200,"查询所有广告位成功",allPromotionSpace);
        return responseResult;
    }

    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult savePromotionSpace(@RequestBody PromotionSpace promotionSpace){
        if (promotionSpace.getId()==null) {
            promotionSpaceService.savePromotionSpace(promotionSpace);
            ResponseResult responseResult = new ResponseResult(true, 200, "新增广告位成功", null);
            return responseResult;
        }else {
            promotionSpaceService.updatePromotionSpace(promotionSpace);
            ResponseResult responseResult = new ResponseResult(true,200,"修改广告成功",null);
            return  responseResult;
        }
    }

    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(@RequestParam int id){
        PromotionSpace promotionSpaceById = promotionSpaceService.findPromotionSpaceById(id);
        ResponseResult responseResult = new ResponseResult(true,200,"查询具体广告位成功",promotionSpaceById);
        return responseResult;

    }
}
