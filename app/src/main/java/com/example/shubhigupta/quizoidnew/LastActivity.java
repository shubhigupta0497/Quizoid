package com.example.shubhigupta.quizoidnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shubhigupta.quizoidnew.Database.HighScoreDb;
import com.example.shubhigupta.quizoidnew.Database.HighScoreObject;

public class LastActivity extends AppCompatActivity {

    Button OpenHighScore, OpenGameStart;
    HighScoreDb dbHelper = new HighScoreDb(this);
    //EditText tv;
    TextView tv;
    String name;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        Intent gotIntent = getIntent();
        //tv = (EditText) findViewById(R.id.editText);
//        HighScoreObject obj = new HighScoreObject();
//        //obj.setName(gotIntent.getStringExtra("Name"));
//        obj.setName("shubhi");
//        obj.setScore(gotIntent.getIntExtra("score",0));
//        Boolean CompletedTest = gotIntent.getBooleanExtra("CompletedTest",true);
        //dbHelper.addRow(obj);
        name = getIntent().getStringExtra("Name");
        score = getIntent().getIntExtra("score",0);

        OpenGameStart = (Button) findViewById(R.id.button2);
        OpenHighScore = (Button) findViewById(R.id.button10);
        tv = (TextView) findViewById(R.id.yo);
        tv.setText(Integer.toString(score));
        OpenHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LastActivity.this,HighScoreBoard.class);
                i.putExtra("score", score);
                i.putExtra("Name", name);
//                i.putExtra("CompletedTest",false);
                startActivity(i);
            }
        });
        OpenGameStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LastActivity.this,QuestionsListPage.class);
                //i.putExtra("Replay",true);
                i.putExtra("name",name);
                startActivity(i);
            }
        });
    }
}
