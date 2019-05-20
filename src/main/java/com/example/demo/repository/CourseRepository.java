package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import com.example.demo.modal.dto.CourseDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        Course javaOne = Course.builder()
                .className("Java I")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaOne);
        Course javaTwo = Course.builder()
                .className("Java II")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaTwo);
    }


    public List<Course> findAllClasses(){
        //链接数据库
        //返回数据库的信息
        return  courses;
    }

    public List<Course> findAllCourse(String searchByCourseName){

        return new ArrayList<Course>();
    }

    public List<Course> findCourseByName(String courseName) {
        List<Course> res = new ArrayList<Course>();
        String replaced = courseName.replaceAll("_"," ");
        for(Course c : courses){
            if(c.getClassName().equals(replaced)){
                res.add(c);
            }
        }
        return res;
    }

    public Boolean deleteOneCourse(String courseName){
        String replaced = courseName.replaceAll("_"," ");
        for(Course c : courses){
            if(c.getClassName().equals(replaced)){
                courses.remove(c);
                return true;
            }
        }
        return false;
    }

    public Boolean addOneCourse(Course course){
        try{
            courses.add(course);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
