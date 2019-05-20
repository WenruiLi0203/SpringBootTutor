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

    public Boolean addOneCourse(CourseDto course){
        Course courseToCreate = Course.builder()
                .className(course.getCourseName())
                .instructor(new Instructor("Amy", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        try{
            courseRepository.addOneCourse(courseToCreate);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
