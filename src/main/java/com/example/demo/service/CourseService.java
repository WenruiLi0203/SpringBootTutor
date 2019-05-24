package com.example.demo.service;


import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import com.example.demo.modal.dto.CourseDto;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> findAllCourses(){

        return courseRepository.findAllClasses();
    }

    public List<Course> searchByCourseName(String input){

        return courseRepository.findCourseByName(input);
    }

    public Boolean deleteOneCourse(String input){
        return courseRepository.deleteOneCourse(input);
    }

    public void addCourse(CourseDto course) throws Exception{
        Course courseBeingSaved = Course.builder()
                .className(course.getCourseName())
                .instructor(course.getInstructor())
                .startDate(course.getStartDate())
                .endDate(course.getEndDate())
                .timeFrame(course.getTimeFrame())
                .build();
            try {
            courseRepository.saveAndFlush(courseBeingSaved);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
