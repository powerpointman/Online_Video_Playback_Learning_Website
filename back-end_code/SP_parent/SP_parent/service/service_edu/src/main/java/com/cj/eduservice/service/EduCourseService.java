package com.cj.eduservice.service;

import com.cj.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cj.eduservice.entity.vo.CourseInfoVo;
import com.cj.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2023-03-30
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    void removeCourse(String courseId);
}
