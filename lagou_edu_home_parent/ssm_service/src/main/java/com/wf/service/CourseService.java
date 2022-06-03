package com.wf.service;

import com.wf.domain.Course;
import com.wf.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {

    /*�������γ��б��ѯ*/
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /*��ӿγ̼���ʦ��Ϣ*/
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /*����id��ѯ�γ���Ϣ*/
    public CourseVO findCourseById(Integer id);

    /*�޸Ŀγ���Ϣ*/
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /*�޸Ŀγ�״̬*/
    public void updateCourseStatus(Integer id,Integer status);
}
