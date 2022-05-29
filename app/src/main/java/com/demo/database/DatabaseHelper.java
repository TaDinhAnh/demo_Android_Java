package com.demo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.demo.entities.Course;
import com.demo.entities.Student;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static String dbName = "studentDB";
    private static int dbVersion = 1;

    private static String studentTable = "student";
    private static String courseTable = "course";

    private static String idColumn = "id";
    private static String nameColumn = "name";
    private static String addressColumn = "address";
    private static String phoneColumn = "phone";
    private static String scoreColumn = "score";
    private static String studentIdColumn = "student_id";

    public DatabaseHelper(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }

    private static String CreateTableCourse = "create table " + courseTable + "(" +
            idColumn + " integer primary key autoincrement, " +
            nameColumn + " text, " +
            scoreColumn + " real, " +
            studentIdColumn + " integer references " + studentTable + "(" + idColumn + ")" +
            ")";

    private static String CreateTableStudent = "create table " + studentTable + "(" +
            idColumn + " integer primary key autoincrement, " +
            nameColumn + " text, " +
            addressColumn + " text, " +
            phoneColumn + " text " +
            ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTableCourse);
        db.execSQL(CreateTableStudent);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public double Agv(int id, Course course) {
        double agv=0;
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();

        } catch (Exception e) {
             agv =0;
        }
        return agv;
    }

    public boolean createStudent(Student student) {
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(nameColumn, student.getName());
            contentValues.put(addressColumn, student.getAddress());
            contentValues.put(phoneColumn, student.getPhone());
            return sqLiteDatabase.insert(studentTable, null, contentValues) > 0;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean createCourse(Course course) {
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(nameColumn, course.getName());
            contentValues.put(scoreColumn, course.getScore());
            contentValues.put(studentIdColumn, course.getStudent_id());
            return sqLiteDatabase.insert(courseTable, null, contentValues) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Student> ListStudent() {
        List<Student> students = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + studentTable, null);
            if (cursor.moveToFirst()) {
                students = new ArrayList<Student>();
                do {
                    Student student = new Student();
                    student.setId(cursor.getInt(0));
                    student.setName(cursor.getString(1));
                    student.setAddress(cursor.getString(2));
                    student.setPhone(cursor.getString(3));
                    students.add(student);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            students = null;
        }
        return students;
    }

    public List<Course> ListCourses(int id) {
        List<Course> courses = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + courseTable + " where " + studentIdColumn + " = ? ", new String[]{String.valueOf(id)});
            if (cursor.moveToFirst()) {
                courses = new ArrayList<Course>();
                do {
                    Course course = new Course();
                    course.setId(cursor.getInt(0));
                    course.setName(cursor.getString(1));
                    course.setScore(cursor.getDouble(2));
                    course.setStudent_id(cursor.getInt(3));
                    courses.add(course);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            courses = null;
        }
        return courses;
    }

    public boolean deleteStudent(int id) {
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            return sqLiteDatabase.delete(studentTable, idColumn + " = ?", new String[]{String.valueOf(id)}) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteCourse(int id) {
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            return sqLiteDatabase.delete(courseTable, idColumn + " = ?", new String[]{String.valueOf(id)}) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateStudent(Student student) {
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(nameColumn, student.getName());
            contentValues.put(addressColumn, student.getAddress());
            contentValues.put(phoneColumn, student.getPhone());
            return sqLiteDatabase.update(studentTable, contentValues, idColumn + " = ? ", new String[]{String.valueOf(student.getId())}) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateCourse(Course course) {
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(nameColumn, course.getName());
            contentValues.put(scoreColumn, course.getScore());
            contentValues.put(studentIdColumn, course.getStudent_id());
            return sqLiteDatabase.update(courseTable, contentValues, idColumn + " = ? ", new String[]{String.valueOf(course.getId())}) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
