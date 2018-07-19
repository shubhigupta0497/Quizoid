package com.example.shubhigupta.quizoidnew;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.shubhigupta.quizoidnew.Database.DBHelper;
import com.example.shubhigupta.quizoidnew.Database.HighScoreDb;
import com.example.shubhigupta.quizoidnew.Database.HighScoreObject;
import com.example.shubhigupta.quizoidnew.QuestionsSubCategories.QuestionListAdapter;
import com.example.shubhigupta.quizoidnew.QuestionsSubCategories.ScoreBoardAdapter;

import java.util.ArrayList;

public class HighScoreBoard extends AppCompatActivity {

    HighScoreDb db1 = new HighScoreDb(this);
    ArrayList<HighScoreObject> showList;
    RecyclerView rv;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_board);
        //db1.addRow(new HighScoreObject("shubhi gupta",9));
        //db1.addRow(new HighScoreObject("shivam gupta",9));
        //db1.addRow(new HighScoreObject("shubham roy",2));
//        db1.addRow(new HighScoreObject("sameer sakshi",10));
        showList = new ArrayList<>();
        //showList = db1.getScoreBoard();
        int score = getIntent().getIntExtra("score",0);
        String name = getIntent().getStringExtra("name");
        HighScoreObject obj = new HighScoreObject(name,score);

        showList.add(new HighScoreObject("shubhi gupta",9));
        showList.add(new HighScoreObject("shubham gupta",9));
        showList.add(new HighScoreObject("ankit chawla",9));
        showList.add(new HighScoreObject("shivam gupta",8));
        showList.add(new HighScoreObject("sameer singh",8));
        showList.add(new HighScoreObject("anjali arora",7));
        showList.add(new HighScoreObject("Danil clifff",7));
        showList.add(new HighScoreObject("Luarel gupta",7));
        showList.add(new HighScoreObject("arjun singh",7));
        //showList.add(obj);
        for (int i = 0;i< showList.size();i++){
            if(score > showList.get(i).getScore() ){
                insertBanda(showList,obj,i);
                return ;
            }
        }
//        c=db.rawQuery("SELECT * FROM scores", null);
//        if(!c.moveToFirst()){
//
//        }
//        else {
//
//        }
        //showList = db.getScoreBoard();

        rv = (RecyclerView) findViewById(R.id.HighScoreRv);
        ScoreBoardAdapter sbAdapter = new ScoreBoardAdapter(showList,this);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(sbAdapter);

    }

    private void insertBanda(ArrayList<HighScoreObject> showlist,HighScoreObject item,int position) {
        int length = showlist.size();
        HighScoreObject temp = showlist.get(position);
        showlist.add(position,item);
        position++;
        HighScoreObject temp2 ;
        for (int i = position ; i< length;i++){
            temp2 = showlist.get(position);
            showlist.add(position,temp);
            temp = temp2;
        }
    }
}
