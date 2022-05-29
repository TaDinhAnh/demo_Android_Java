package com.demo.models;

import com.demo.entities.Course;
import com.demo.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseModel {
    public List<Course> findAll(){
        List<Course> courses = new ArrayList<Course>();
        courses.add(new Course(1,"Toan", 8.9, 1));
        courses.add(new Course(2,"Ly", 7, 1));
        courses.add(new Course(3,"Toan", 6, 2));
        courses.add(new Course(4,"Ly", 5.5, 2));
        return  courses;
    }

}
