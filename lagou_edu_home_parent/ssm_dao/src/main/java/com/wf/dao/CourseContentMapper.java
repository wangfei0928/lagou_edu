package com.wf.dao;

import com.wf.domain.Course;
import com.wf.domain.CourseLesson;
import com.wf.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {

    /*根据课程Id查询相关章节信息以及章节信息关联的课时信息*/
    public List<CourseSection> findSectionAndLessionByCourseId(Integer courseId);

    /*回显章节对应的课程信息*/
    public Course findCourseByCourseId(int courseId);

    /*新增章节信息*/
    public void saveSection(CourseSection courseSection);

    /*修改章节信息*/
    public void updateSection(CourseSection courseSection);

    /*修改章节状态*/
    public void updateSectionStatus(CourseSection courseSection);

    /*新增课时信息*/
    public void saveLesson(CourseLesson courseLesson);

    /*修改课时信息*/
    public void updateLesson(CourseLesson courseLesson);

}
