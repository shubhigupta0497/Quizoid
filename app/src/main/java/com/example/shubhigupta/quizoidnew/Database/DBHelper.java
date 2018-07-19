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
 * Created by shubhigupta on 25/03/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "database2.db";
    public static final String TABLE_NAME = "login1";
    public static final int DATABASE_VERSION = 1;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";
    public static final String EMAILID = "email";
    public static final String SCORE = "score";
    public static final String TABLE_CREATE = "create table if not exists "+ TABLE_NAME +" ( username text primary key not null ," +
            " password text not null , " +
            " name text not null , " +
            " score integer , " +
            " email text not null);";
    SQLiteDatabase db;
    //public static final String TABLE_ALTER = "ALTER TABLE " + TABLE_NAME+ " ADD "+ SCORE + " INT DEFAULT 0;";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //Log.d("pathInfo",context.getDatabasePath("database2.db").toString());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String query = " Drop table if exists " + TABLE_NAME;
        //db.execSQL(query);
        this.db = db;
        db.execSQL(TABLE_CREATE);
        String path = db.getPath().toString();
        Log.d("path0",path);
        //db.execSQL(TABLE_ALTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = " Drop table if exists " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertUser(User u) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,u.getName());
        values.put(EMAILID,u.getEmailId());
        values.put(USERNAME,u.getUsername());
        values.put(PASSWORD,u.getPassword());
        values.put(SCORE,u.getScores());
        db.insert(TABLE_NAME ,null ,values);
        db.close();
    }

    public String searchPass(String userstr) {
        db = this.getReadableDatabase();

        String query = " select * from " + TABLE_NAME + " where username = '" + userstr + "'";
        Cursor cursor = db.rawQuery(query,null);
        String password = "";
        if(cursor.moveToFirst()) {
            do {
                password = cursor.getString(1);
            } while (cursor.moveToNext());
        }
        return password;
    }

//    public ArrayList<HighScoreObject> getScoreBoard(){
////        db = this.getReadableDatabase();
////        HighScoreObject temp;
////        ArrayList<HighScoreObject> list = new ArrayList<>();
////        String query = "select * from " + TABLE_NAME + "order by " + SCORE + " DESC LIMIT 2;";
////        Cursor cursor = db.rawQuery(query,null);
////        if(cursor.moveToFirst()) {
////            do {
////                temp = new HighScoreObject(cursor.getString(2),cursor.getInt(3));
////                list.add(temp);
////            } while (cursor.moveToNext());
////        }
////        return list;
//        // SELECT id, num1 + num2 AS total FROM table1 ORDER BY num1 + num2 DESC LIMIT 5
//        String[] PROJECTION = {
//                USERNAME  , NAME
//        };
//        sqB = new SQLiteQueryBuilder();
//        Cursor cur = sqB.query(
//                db,
//                PROJECTION,
//                null ,null ,null ,null , SCORE
//        );
//        ArrayList<HighScoreObject> list = new ArrayList<>();
//        int userIndex = cur.getColumnIndex(USERNAME);
////        int passIndex = cur.getColumnIndex(PASSWORD);
////        int idIndex = cur.getColumnIndex(EMAILID);
////        int ScoreIndex = cur.getColumnIndex(SCORE);
//        int nameIndex = cur.getColumnIndex(NAME);
//
//        cur.moveToFirst();
//        while(cur.moveToNext()){
//            list.add(new HighScoreObject(cur.getString(nameIndex),0));
//            Log.d("database",cur.getString(nameIndex)+" "+cur.getInt(userIndex));
//        }
//        cur.close();
//        return list;
//    }

//    String[] PROJECTION = {
//            Columns.ID, Columns.TASK
//    };
//
//
//    Cursor cur = db.query(
//            TABLE_NAME,
//            PROJECTION,
//            null, null, null, null, null
//    );
//
//    ArrayList<Todo> todos = new ArrayList<>();
//    cur.moveToFirst();
//    int idIndex = cur.getColumnIndex(Columns.ID);
//    int taskIndex = cur.getColumnIndex(Columns.TASK);
//
//    while(cur.moveToNext()) {
//        Log.d(TAG, "getAllTasks: " +  cur.getString(taskIndex));
//        todos.add(
//                new Todo(
//                        cur.getInt(idIndex),
//                        cur.getString(taskIndex)
//                )
//        );
//    }
//    cur.close();
//
//    return todos;

}
