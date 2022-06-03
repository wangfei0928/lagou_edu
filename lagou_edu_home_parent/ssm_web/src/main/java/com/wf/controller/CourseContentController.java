package com.wf.controller;

import com.wf.domain.Course;
import com.wf.domain.CourseLesson;
import com.wf.domain.CourseSection;
import com.wf.domain.ResponseResult;
import com.wf.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(@RequestParam(value = "courseId") Integer id){
        //调用service
        List<CourseSection> list = courseContentService.findSectionAndLessionByCourseId(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "章节及课时内容查询成功", list);
        return  responseResult;
    }

    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer courseId){
        Course course = courseContentService.findCourseByCourseId(courseId);
        ResponseResult responseResult = new ResponseResult(true,200,"章节回显响应成功",course);
        return responseResult;
    }

    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){

        if (courseSection.getId()==null){
            courseContentService.saveSection(courseSection);
            ResponseResult responseResult = new ResponseResult(true,200,"章节添加成功",null);
            return  responseResult;
        }else {
            courseContentService.updateSection(courseSection);
            ResponseResult responseResult = new ResponseResult(true,200,"章节修改成功",null);
            return  responseResult;
        }
    }
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(int id,int status){
        courseContentService.updateSectionStatus(id,status);

        //封装最新的状态
        Map<String,Integer> map = new HashMap<>();
        map.put("status",status);

        ResponseResult responseResult = new ResponseResult(true,200,"章节状态更新成功",map);
        return responseResult;
    }

    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResult saveLesson(@RequestBody CourseLesson courseLesson){
        if (courseLesson.getId()==null){
            courseContentService.saveLesson(courseLesson);
            ResponseResult responseResult = new ResponseResult(true,200,"课时添加成功",null);
            return  responseResult;
        }else {
            courseContentService.updateLesson(courseLesson);
            ResponseResult responseResult = new ResponseResult(true,200, "课时修改成功",null);
            return responseResult;
        }
    }
}
