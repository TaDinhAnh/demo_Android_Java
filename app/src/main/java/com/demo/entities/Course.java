package com.demo.entities;

import java.io.Serializable;

public class Course implements Serializable {
  private int id;
  private String name;
  private double score;
  private int student_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Course() {
    }

    public Course(int id, String name, double score, int student_id) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.student_id = student_id;
    }
}
