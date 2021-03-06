package com.example.a.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by a on 2016/11/2.
 */

public class StudentRepo {
    private DBHelper dbHelper;

    public StudentRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Student student) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Student.KEY_sno, student.sno);
        values.put(Student.KEY_banji,student.banji);
        values.put(Student.KEY_name, student.name);
       // values.put(Student.KEY_condition,student.condition);
        values.put(Student.KEY_week1,student.week1);
        values.put(Student.KEY_week2,student.week2);
        values.put(Student.KEY_week3,student.week3);
        values.put(Student.KEY_week4,student.week4);
        values.put(Student.KEY_week5,student.week5);
        values.put(Student.KEY_week6,student.week6);
        values.put(Student.KEY_week7,student.week7);
        values.put(Student.KEY_week8,student.week8);

        // Inserting Row
        long student_Id = db.insert(Student.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) student_Id;
    }

    public void delete(int student_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Student.TABLE, Student.KEY_ID + "= ?", new String[] { String.valueOf(student_Id) });
        db.close(); // Closing database connection
    }

    public void update(Student student) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Student.KEY_sno, student.sno);
        values.put(Student.KEY_banji,student.banji);
        values.put(Student.KEY_name, student.name);
        values.put(Student.KEY_week1,student.week1);
        values.put(Student.KEY_week2,student.week2);
        values.put(Student.KEY_week3,student.week3);
        values.put(Student.KEY_week4,student.week4);
        values.put(Student.KEY_week5,student.week5);
        values.put(Student.KEY_week6,student.week6);
        values.put(Student.KEY_week7,student.week7);
        values.put(Student.KEY_week8,student.week8);


        db.update(Student.TABLE, values, Student.KEY_ID + "= ?", new String[] { String.valueOf(student.student_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getStudentList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Student.KEY_ID + "," +
                Student.KEY_name + "," +
                Student.KEY_banji + "," +
                Student.KEY_sno +","+
                Student.KEY_week1+","+
                Student.KEY_week2+","+
                Student.KEY_week3+","+
                Student.KEY_week4+","+
                Student.KEY_week5+","+
                Student.KEY_week6+","+
                Student.KEY_week7+","+
                Student.KEY_week8+
                " FROM " + Student.TABLE;

        //Student student = new Student();
        ArrayList<HashMap<String, String>> studentList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> student = new HashMap<String, String>();
                student.put("id", cursor.getString(cursor.getColumnIndex(Student.KEY_ID)));
                student.put("name", cursor.getString(cursor.getColumnIndex(Student.KEY_name)));
                studentList.add(student);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return studentList;

    }

    public Student getStudentById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Student.KEY_ID + "," +
                Student.KEY_name + "," +
                Student.KEY_banji + "," +
                Student.KEY_sno +","+
                Student.KEY_week1+","+
                Student.KEY_week2+","+
                Student.KEY_week3+","+
                Student.KEY_week4+","+
                Student.KEY_week5+","+
                Student.KEY_week6+","+
                Student.KEY_week7+","+
                Student.KEY_week8+
                " FROM " + Student.TABLE
                + " WHERE " +
                Student.KEY_ID + "=?";

        int iCount =0;
        Student student = new Student();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                student.student_ID =cursor.getInt(cursor.getColumnIndex(Student.KEY_ID));
                student.name =cursor.getString(cursor.getColumnIndex(Student.KEY_name));
                student.banji  =cursor.getString(cursor.getColumnIndex(Student.KEY_banji));
                student.sno =cursor.getString(cursor.getColumnIndex(Student.KEY_sno));
                student.week1=cursor.getString(cursor.getColumnIndex(Student.KEY_week1));
                student.week2=cursor.getString(cursor.getColumnIndex(Student.KEY_week2));
                student.week3=cursor.getString(cursor.getColumnIndex(Student.KEY_week3));
                student.week4=cursor.getString(cursor.getColumnIndex(Student.KEY_week4));
                student.week5=cursor.getString(cursor.getColumnIndex(Student.KEY_week5));
                student.week6=cursor.getString(cursor.getColumnIndex(Student.KEY_week6));
                student.week7=cursor.getString(cursor.getColumnIndex(Student.KEY_week7));
                student.week8=cursor.getString(cursor.getColumnIndex(Student.KEY_week8));


            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return student;
    }

}
