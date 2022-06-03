package com.wf.dao;

import com.wf.domain.Course;
import com.wf.domain.CourseVO;
import com.wf.domain.Teacher;

import java.util.List;

public interface CourseMapper {
    /* �������γ��б��ѯ */
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /*����γ���Ϣ*/
    public void saveCourse(Course course);

    /*���潲ʦ��Ϣ*/
    public void saveTeacher(Teacher teacher);


    /*ͨ��id��ѯ�γ���Ϣ*/
    public CourseVO findCourseById(Integer id);

    /*�޸Ŀγ���Ϣ*/
    public void updateCourse(Course course);

    /*�޸Ľ�ʦ��Ϣ*/
    public void updateTeacher(Teacher teacher);

    /*�޸Ŀγ�״̬*/
    public void updateCourseStatus(Course course);
}
