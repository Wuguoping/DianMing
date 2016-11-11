package com.example.a.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by a on 2016/11/2.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_STUDENT = "CREATE TABLE " + Student.TABLE  + "("
                + Student.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Student.KEY_name + " TEXT, "
                + Student.KEY_sno + " TEXT , "
                + Student.KEY_banji + " TEXT, "
                +Student.KEY_week1+" TEXT ,"
                +Student.KEY_week2+" TEXT ,"
                +Student.KEY_week3+" TEXT ,"
                +Student.KEY_week4+" TEXT ,"
                +Student.KEY_week5+" TEXT ,"
                +Student.KEY_week6+" TEXT ,"
                +Student.KEY_week7+" TEXT ,"
                +Student.KEY_week8+" TEXT )";

        db.execSQL(CREATE_TABLE_STUDENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Student.TABLE);
        onCreate(db);

    }
}
