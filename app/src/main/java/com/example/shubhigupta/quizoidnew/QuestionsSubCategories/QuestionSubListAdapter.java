package com.example.shubhigupta.quizoidnew.QuestionsSubCategories;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.shubhigupta.quizoidnew.AppIntro;
import com.example.shubhigupta.quizoidnew.GameStartActivity;
import com.example.shubhigupta.quizoidnew.R;

import java.util.ArrayList;

/**
 * Created by shubhigupta on 14/04/17.
 */

public class QuestionSubListAdapter extends RecyclerView.Adapter<QuestionSubListAdapter.QuestionSubListHolder> {
    private ArrayList<Integer> QuestionSubCategories;
    private Context context;
    private int TopicPos;

    public QuestionSubListAdapter(ArrayList<Integer> questionSubCategories, Context context,int TopicPosition) {
        QuestionSubCategories = questionSubCategories;
        this.context = context;
        TopicPos = TopicPosition;
    }

    @Override
    public QuestionSubListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.question_holder,parent, false);


        return new QuestionSubListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QuestionSubListHolder holder, final int position) {
        int questionImg = QuestionSubCategories.get(position);

        holder.imgView.setImageResource(questionImg);
        holder.imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GameStartActivity.class);
                //i.putExtra("Replay",false);
                i.putExtra("SubListposition",position);
                i.putExtra("MainTopicposition",TopicPos);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return QuestionSubCategories.size();
    }

    public class QuestionSubListHolder extends RecyclerView.ViewHolder {
        ImageView imgView;

        public QuestionSubListHolder(View itemView) {
            super(itemView);
            //imgView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
