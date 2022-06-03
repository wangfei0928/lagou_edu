package com.wf.service.impl;

import com.wf.dao.CourseContentMapper;

import com.wf.domain.Course;
import com.wf.domain.CourseLesson;
import com.wf.domain.CourseSection;
import com.wf.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
   private CourseContentMapper courseContentMapper;

    @Override
    public List<CourseSection> findSectionAndLessionByCourseId(Integer courseId) {
        List<CourseSection> list = courseContentMapper.findSectionAndLessionByCourseId(courseId);
        return list;
    }

    @Override
    public Course findCourseByCourseId(Integer courseId) {

        Course course = courseContentMapper.findCourseByCourseId(courseId);
        return course;
    }

    @Override
    public void saveSection(CourseSection courseSection) {
        Date date = new Date();
        courseSection.setUpdateTime(date);
        courseSection.setCreateTime(date);
        courseContentMapper.saveSection(courseSection);
    }

    @Override
    public void updateSection(CourseSection courseSection) {
        Date date = new Date();
        courseSection.setUpdateTime(date);
        courseSection.setCreateTime(date);
        courseContentMapper.updateSection(courseSection);
    }

    @Override
    public void updateSectionStatus(Integer id,Integer status) {
        CourseSection courseSection = new CourseSection();
        courseSection.setId(id);
        courseSection.setStatus(status);
        courseSection.setUpdateTime(new Date());
        courseContentMapper.updateSectionStatus(courseSection);
    }

    @Override
    public void saveLesson(CourseLesson courseLesson) {
        Date date = new Date();
        courseLesson.setCreateTime(date);
        courseLesson.setUpdateTime(date);
        courseContentMapper.saveLesson(courseLesson);
    }

    @Override
    public void updateLesson(CourseLesson courseLesson) {
        Date date = new Date();
        courseLesson.setUpdateTime(date);
        courseLesson.setCreateTime(date);
        courseContentMapper.updateLesson(courseLesson);
    }
}
