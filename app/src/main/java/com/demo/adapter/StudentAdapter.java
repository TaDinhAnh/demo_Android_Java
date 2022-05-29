package com.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.demo.entities.Student;
import com.demo.examandroid.R;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    private int layout;
    private List<Student> students;

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.context =context;
        this.layout =resource;
        this.students =objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student =students.get(position);
        View view = LayoutInflater.from(context).inflate(layout, null);
//        TextView textViewName = view.findViewById(R.id.);
//        textViewName.setText(student.getName());
//        TextView textViewAddress = view.findViewById(R.id.);
//        textViewName.setText(student.getAddress());
//        TextView textViewAddress = view.findViewById(R.id.);
//        textViewName.setText(student.getPhone());
                return view;
    }
}
