package com.wf.controller;

import com.github.pagehelper.PageInfo;
import com.wf.domain.PromotionAd;
import com.wf.domain.PromotionAdVo;
import com.wf.domain.ResponseResult;
import com.wf.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.PipedReader;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;
    /*
    分页广告查询
    */
    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllAdByPage(PromotionAdVo promotionAdVo){
        PageInfo<PromotionAd> promotionAdByPage = promotionAdService.findPromotionAdByPage(promotionAdVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "广告分页查询成功", promotionAdByPage);
        return responseResult;
    }
    /*
     * 广告图片上传
     * */
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult fileUpload(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {

        //1. 判断被接受到的文件是否为空
        if (file.isEmpty()){
            throw  new RuntimeException();
        }
        //2. 获取文件项目部署路径
        // D:\apache-tomcat-8.5.56\webapps\ssm_web\
        String realPath = request.getServletContext().getRealPath("/");
        // D:\apache-tomcat-8.5.56\webapps\
        String subString = realPath.substring(0, realPath.indexOf("ssm_web"));

        //获取原文件名
        String originalFilename = file.getOriginalFilename();

        //4. 生成新文件名
        String newFileName =System.currentTimeMillis()+originalFilename.substring(originalFilename.lastIndexOf("."));

        //文件上传
        String uploadPath = subString + "upload\\";
        File filePath = new File(uploadPath,newFileName);

        //如果目录不存在，就创建目录
        if(!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录："+filePath);
        }
        //图片进行了真正的上传
        file.transferTo(filePath);
        //将文件名和文件路径返回，进行响应
        Map<String,String> map = new HashMap<>();
        map.put("filename",newFileName);
        map.put("filepath","http://localhost:8080/upload/"+newFileName);

        ResponseResult responseResult = new ResponseResult(true, 200, "图片上传成功", map);
        return responseResult;
    }
    /*
    * 广告的添加和修改
    * */
    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd){
        if (promotionAd.getId()==null){
            promotionAdService.savePromotionAd(promotionAd);
            ResponseResult responseResult = new ResponseResult(true,200,"新增广告成功",null);
            return  responseResult;
        }else {
            promotionAdService.updatePromotionAd(promotionAd);
            ResponseResult responseResult = new ResponseResult(true,200,"修改广告成功",null);
            return  responseResult;
        }
    }

    /*
    * 广告状态的修改
    * */
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(Integer id,Integer status){
        promotionAdService.updatePromotionAdStatus(id, status);
        ResponseResult responseResult = new ResponseResult(true,200,"广告状态修改成功",null);
        return responseResult;
    }
}
