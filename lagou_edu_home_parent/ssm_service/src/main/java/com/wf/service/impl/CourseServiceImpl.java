package com.wf.service.impl;

import com.wf.dao.CourseMapper;
import com.wf.domain.Course;
import com.wf.domain.CourseVO;
import com.wf.domain.Teacher;
import com.wf.service.CourseService;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper ;



    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {

        List<Course> courseList = courseMapper.findCourseByCondition(courseVO);
        return courseList;
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        //��װ�γ���Ϣ
        Course course = new Course();

        BeanUtils.copyProperties(course,courseVO);

        //��ȫ�γ���Ϣ
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);

        courseMapper.saveCourse(course);

        //��ȡ�²�������id
        int id =  course.getId();
        //��װ��ʦ��Ϣ
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);
        //��ȫ��Ϣ
        teacher.setCourseId(id);
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        courseMapper.saveTeacher(teacher);


    }

    @Override
    public CourseVO findCourseById(Integer id) {
        return courseMapper.findCourseById(id);
    }


    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {

        //��װ�γ���Ϣ
        Course course = new Course();
        BeanUtils.copyProperties(course,courseVO);

        //��ȫ��Ϣ
        Date date = new Date();
        course.setUpdateTime(date);

        //���¿γ�
        courseMapper.updateCourse(course);

        //��װ��ʦ��Ϣ
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);

        //��ȫ��Ϣ
        teacher.setUpdateTime(date);

        //���½�ʦ��Ϣ
        courseMapper.updateTeacher(teacher);
    }

    @Override
    public void updateCourseStatus(Integer id, Integer status) {
        //��װ����
        Course course = new Course();
        course.setId(id);
        course.setStatus(status);
        course.setUpdateTime(new Date());
        //����mapper
        courseMapper.updateCourseStatus(course);
    }
}
