package com.example.administrator.nsurecords;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 20/05/2016.
 */
public class HelperDatabaseClass extends SQLiteOpenHelper { //used to create our datatbase

    private static final String DATABASE_NAME = "NSURecords"; //defining database name
    private static final int DATABASE_VERSION = 1; //defining database version
    private static final String TABLE_NAME = "Student_Records"; //defining table name
    private static final String ID = "_ID"; //defining column
    private static final String NAME = "NAME"; //defining column
    private static final String CLASS_NAME = "CLASS_NAME"; //defining column
    private static final String EMAIL = "EMAIL"; //defining column
    private static final String ADDRESS = "ADDRESS"; //defining column
    private static final String CREATE_TABLE = "CREATE TABLE " +TABLE_NAME+"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" TEXT NOT NULL,"+CLASS_NAME+" TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL"+");";
    private static final String CREATE_TABLE1 = "CREATE TABLE " +TABLE_NAME+"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" TEXT NOT NULL,"+CLASS_NAME+" TEXT NOT NULL,"+");";

    public HelperDatabaseClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //only called once
        db.execSQL(CREATE_TABLE); //this method is not called automatically
        //db.execSQL(CREATE_TABLE1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { // called again and again
        db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+ ADDRESS+" TEXT");//data not lost after changing database version only one column added
        //db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME); //all data will be lost

    }
    public long insert(Student_Detail detail){ //using insert method(parameter Student_Detail Class used) to insert our data
        SQLiteDatabase db = getWritableDatabase(); // calling this method onCreate will be called internally and will execute db.execSQL and create our database
        ContentValues values = new ContentValues(); //used to put columns at the position provided by developer
        values.put(NAME,detail.getName());
        values.put(CLASS_NAME,detail.getClass_name());
        values.put(EMAIL,detail.getEmail());
        return db.insert(TABLE_NAME,null,values); // will return two values: -1 for unsuccessful , a number greater 0 indicating columns/values/database inserted; can be checked using TOAST
    }
}
