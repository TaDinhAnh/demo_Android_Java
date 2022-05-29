package com.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.demo.entities.Course;
import com.demo.entities.Student;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<Course> {
    private Context context;
    private int layout;
    private List<Course> courses;

    public CourseAdapter(@NonNull Context context, int resource, @NonNull List<Course> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout =resource;
        this.courses = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Course course =courses.get(position);
        View view = LayoutInflater.from(context).inflate(layout, null);
//        TextView textViewName = view.findViewById(R.id.);
//        textViewName.setText(course.getName());
//        TextView textViewScore = view.findViewById(R.id.);
//        textViewName.setText(String.valueOf(course.getScore()));
//        TextView textViewStudentId = view.findViewById(R.id.);
//        textViewName.setText(course.getId());
                return view;
    }
}
