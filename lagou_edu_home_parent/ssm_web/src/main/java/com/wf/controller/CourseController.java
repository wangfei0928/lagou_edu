package com.wf.controller;

import com.wf.domain.Course;
import com.wf.domain.CourseVO;
import com.wf.domain.ResponseResult;
import com.wf.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    /*
    *查询课程信息，条件查询   接口
    * */
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO){

        List<Course> courseList =courseService.findCourseByCondition(courseVO);
        ResponseResult result = new ResponseResult(true,200,"响应成功",courseList);
        return  result;
    }

    /*
    * 课程图片上传
    * */
    @RequestMapping("/courseUpload")
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

    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        if (courseVO.getId() == null) {
            courseService.saveCourseOrTeacher(courseVO);
            ResponseResult responseResult = new ResponseResult(true,200,"新增成功",null);
            return responseResult;
        }else {
            courseService.updateCourseOrTeacher(courseVO);
            ResponseResult responseResult = new ResponseResult(true,200,"修改成功",null);
            return responseResult;
        }


    }

    @RequestMapping("/findCourseById")
    /*根据id查询课程的具体信息以及讲师信息*/
    public ResponseResult findCourseById(Integer id){
        CourseVO courseVO = courseService.findCourseById(id);
        ResponseResult responseResult = new ResponseResult(true,200,"根据Id查询课程信息",courseVO);
        return responseResult;
    }

    /*修改课程状态*/
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(Integer id,Integer status){
        //调用service传递参数
        courseService.updateCourseStatus(id,status);
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        ResponseResult responseResult = new ResponseResult(true,200,"修改课程状态",map);
        return responseResult;
    }


}
