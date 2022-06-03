package com.wf.dao;

import com.wf.domain.Course;
import com.wf.domain.CourseVO;
import com.wf.domain.Teacher;

import java.util.List;

public interface CourseMapper {
    /* 多条件课程列表查询 */
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /*保存课程信息*/
    public void saveCourse(Course course);

    /*保存讲师信息*/
    public void saveTeacher(Teacher teacher);


    /*通过id查询课程信息*/
    public CourseVO findCourseById(Integer id);

    /*修改课程信息*/
    public void updateCourse(Course course);

    /*修改讲师信息*/
    public void updateTeacher(Teacher teacher);

    /*修改课程状态*/
    public void updateCourseStatus(Course course);
}
