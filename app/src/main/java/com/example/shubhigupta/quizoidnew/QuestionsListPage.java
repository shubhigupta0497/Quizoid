package com.example.shubhigupta.quizoidnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.shubhigupta.quizoidnew.QuestionsSubCategories.QuestionListAdapter;

import java.util.ArrayList;

public class QuestionsListPage extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<String> imageLists;
    public static final int NO_OF_TOPICS = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_new2);
        String name = getIntent().getStringExtra("name");
        imageLists = new ArrayList<>();
        imageLists.add("Business");
        imageLists.add("Brands");
        imageLists.add("Arithmetic Aptitude");
        imageLists.add("Currency");
        imageLists.add("Economics");
        imageLists.add("World");
        imageLists.add("English Power");

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv3);
        QuestionListAdapter questionAdapter = new QuestionListAdapter(imageLists, this,name);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(questionAdapter);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        imageLists = new ArrayList<>();
        String name = getIntent().getStringExtra("name");
        imageLists.add("Business");
        imageLists.add("Brands");
        imageLists.add("Arithmetic Aptitude");
        imageLists.add("Currency");
        imageLists.add("Economics");
        imageLists.add("World");
        imageLists.add("English Power");

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv3);
        QuestionListAdapter questionAdapter = new QuestionListAdapter(imageLists, this,name);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(questionAdapter);


    }
}




