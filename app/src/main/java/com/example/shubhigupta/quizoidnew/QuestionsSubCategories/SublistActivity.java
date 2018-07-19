package com.example.shubhigupta.quizoidnew.QuestionsSubCategories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shubhigupta.quizoidnew.R;

import java.util.ArrayList;

public class SublistActivity extends AppCompatActivity {
    RecyclerView rvSub;
    ArrayList<ArrayList<Integer>> QuestionSubCategoriesMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sublist);
        QuestionSubCategoriesMain = new ArrayList<>();

        Intent gotIntent = getIntent();
        int position = gotIntent.getIntExtra("position",0);

        // Topic 1
        ArrayList<Integer> Topic1 = new ArrayList<>();
        Topic1.add(R.drawable.sample1);
        Topic1.add(R.drawable.sample1);
        Topic1.add(R.drawable.sample1);
        Topic1.add(R.drawable.sample1);
        Topic1.add(R.drawable.sample1);

        // Topic 2
        ArrayList<Integer> Topic2 = new ArrayList<>();
        Topic2.add(R.drawable.logo2);
        Topic2.add(R.drawable.logo2);
        Topic2.add(R.drawable.logo2);
        Topic2.add(R.drawable.logo2);
        Topic2.add(R.drawable.logo2);

        // Topic 3
        ArrayList<Integer> Topic3 = new ArrayList<>();
        Topic3.add(R.drawable.sample1);
        Topic3.add(R.drawable.sample1);
        Topic3.add(R.drawable.sample1);
        Topic3.add(R.drawable.sample1);
        Topic3.add(R.drawable.sample1);

        // Topic 4
        ArrayList<Integer> Topic4 = new ArrayList<>();
        Topic4.add(R.drawable.logo2);
        Topic4.add(R.drawable.logo2);
        Topic4.add(R.drawable.logo2);
        Topic4.add(R.drawable.logo2);
        Topic4.add(R.drawable.logo2);

        // Topic 5
        ArrayList<Integer> Topic5 = new ArrayList<>();
        Topic5.add(R.drawable.sample1);
        Topic5.add(R.drawable.sample1);
        Topic5.add(R.drawable.sample1);
        Topic5.add(R.drawable.sample1);
        Topic5.add(R.drawable.sample1);

        // Topic 6
        ArrayList<Integer> Topic6 = new ArrayList<>();
        Topic6.add(R.drawable.logo2);
        Topic6.add(R.drawable.logo2);
        Topic6.add(R.drawable.logo2);
        Topic6.add(R.drawable.logo2);
        Topic6.add(R.drawable.logo2);

        // add all the subtopics lists in main list
        QuestionSubCategoriesMain.add(Topic1);
        QuestionSubCategoriesMain.add(Topic2);
        QuestionSubCategoriesMain.add(Topic3);
        QuestionSubCategoriesMain.add(Topic4);
        QuestionSubCategoriesMain.add(Topic5);
        QuestionSubCategoriesMain.add(Topic6);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rvSub);
        QuestionSubListAdapter questionSubListAdapter = new QuestionSubListAdapter(QuestionSubCategoriesMain.get(position), this,position);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(questionSubListAdapter);


    }
}
