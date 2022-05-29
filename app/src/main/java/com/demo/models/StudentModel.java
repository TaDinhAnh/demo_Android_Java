package com.demo.models;

import com.demo.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    public List<Student> findAll(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"Nguyen Van A", "Da Lat", "01233210100"));
        students.add(new Student(2,"Nguyen Van B", "Binh Thuan", "036452165"));
        return  students;
    }
}
