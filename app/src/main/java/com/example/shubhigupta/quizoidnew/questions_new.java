package com.example.shubhigupta.quizoidnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class questions_new extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_new);
        id = 0;
        final String Username = getIntent().getStringExtra("name");
        tv1 = (TextView) findViewById(R.id.category1);
        tv2 = (TextView) findViewById(R.id.category2);
       // tv3 = (TextView) findViewById(R.id.category3);
        tv4 = (TextView) findViewById(R.id.category4);
        tv5 = (TextView) findViewById(R.id.category5);
        tv6 = (TextView) findViewById(R.id.category6);
        tv7 = (TextView) findViewById(R.id.category7);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 1;
                Intent i = new Intent(questions_new.this,GameStartActivity.class);
                i.putExtra("id",id);
                i.putExtra("nameA",Username);
                startActivity(i);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 5;
                Intent i = new Intent(questions_new.this,GameStartActivity.class);
                i.putExtra("id",id);
                i.putExtra("nameA",Username);
                startActivity(i);
            }
        });
//        tv3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                id = 3;
//                Intent i = new Intent(questions_new.this,GameStartActivity.class);
//                i.putExtra("id",id);
//                i.putExtra("nameA",Username);
//                startActivity(i);
//            }
//        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 87;
                Intent i = new Intent(questions_new.this,GameStartActivity.class);
                i.putExtra("id",id);
                i.putExtra("nameA",Username);
                startActivity(i);
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 87;
                Intent i = new Intent(questions_new.this,GameStartActivity.class);
                i.putExtra("id",id);
                i.putExtra("nameA",Username);
                startActivity(i);
            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 6;
                Intent i = new Intent(questions_new.this,GameStartActivity.class);
                i.putExtra("id",id);
                i.putExtra("nameA",Username);
                startActivity(i);
            }
        });
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 7;
                Intent i = new Intent(questions_new.this,GameStartActivity.class);
                i.putExtra("id",id);
                i.putExtra("nameA",Username);
                startActivity(i);
            }
        });


    }
}
