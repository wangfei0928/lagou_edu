package com.wf.service;

import com.wf.domain.Course;
import com.wf.domain.CourseLesson;
import com.wf.domain.CourseSection;

import java.util.List;

public interface CourseContentService {

    public List<CourseSection> findSectionAndLessionByCourseId(Integer courseId);

    public Course findCourseByCourseId(Integer courseId);

    public void saveSection(CourseSection courseSection);

    public void updateSection(CourseSection courseSection);

    public void updateSectionStatus(Integer id ,Integer status);

    public void saveLesson(CourseLesson courseLesson);

    public void updateLesson(CourseLesson courseLesson);
}
