package com.example.shubhigupta.quizoidnew.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by shubhigupta on 26/04/17.
 */

public class HighScoreDb extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "database2.db";
    public static final String TABLE_NAME = "bishan";
    public static final int DATABASE_VERSION = 1;
    public static final String SCORE = "score";
    public static final String NAME = "name";
    public static final String TABLE_CREATE = "create table if not exists "+ TABLE_NAME +" ( name text primary key not null , " +
            " score integer ); ";
    SQLiteDatabase db;

    public HighScoreDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        Log.d("pathInfo",context.getDatabasePath("database2.db").toString());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = " Drop table if exists " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public ArrayList<HighScoreObject> getScoreBoard(){
        String path = db.getPath().toString();
        Log.d("path",path);
        db = this.getReadableDatabase();

        ArrayList<HighScoreObject> list = new ArrayList<>();
        // String query = "select * from " + TABLE_NAME + " order by " + SCORE + " DESC LIMIT 2;";
        String query = " SELECT * FROM bishan ; "  ;
        Cursor cursor = db.rawQuery(query,null);
//        if(cursor.moveToFirst()) {
//            do {
//                HighScoreObject temp = new HighScoreObject(cursor.getString(0),cursor.getInt(1));
//                list.add(temp);
//            } while (cursor.moveToNext());
//        }
        cursor.moveToFirst();
        do {
            HighScoreObject temp = new HighScoreObject(cursor.getString(0),cursor.getInt(1));
            list.add(temp);
        } while (cursor.moveToNext());
        return list;
        // SELECT id, num1 + num2 AS total FROM table1 ORDER BY num1 + num2 DESC LIMIT 5
    }

    public void addRow(HighScoreObject obj){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,obj.getName());
        values.put(SCORE,obj.getScore());
        db.insert(TABLE_NAME ,null ,values);
        db.close();

    }
}
