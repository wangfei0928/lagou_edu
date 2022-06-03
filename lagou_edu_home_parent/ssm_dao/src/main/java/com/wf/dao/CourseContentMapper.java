package com.wf.dao;

import com.wf.domain.Course;
import com.wf.domain.CourseLesson;
import com.wf.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {

    /*���ݿγ�Id��ѯ����½���Ϣ�Լ��½���Ϣ�����Ŀ�ʱ��Ϣ*/
    public List<CourseSection> findSectionAndLessionByCourseId(Integer courseId);

    /*�����½ڶ�Ӧ�Ŀγ���Ϣ*/
    public Course findCourseByCourseId(int courseId);

    /*�����½���Ϣ*/
    public void saveSection(CourseSection courseSection);

    /*�޸��½���Ϣ*/
    public void updateSection(CourseSection courseSection);

    /*�޸��½�״̬*/
    public void updateSectionStatus(CourseSection courseSection);

    /*������ʱ��Ϣ*/
    public void saveLesson(CourseLesson courseLesson);

    /*�޸Ŀ�ʱ��Ϣ*/
    public void updateLesson(CourseLesson courseLesson);

}
