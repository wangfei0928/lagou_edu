package com.wf.service;

import com.wf.domain.Course;
import com.wf.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {

    /*多条件课程列表查询*/
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /*添加课程及讲师信息*/
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /*根据id查询课程信息*/
    public CourseVO findCourseById(Integer id);

    /*修改课程信息*/
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /*修改课程状态*/
    public void updateCourseStatus(Integer id,Integer status);
}
