package com.example.shubhigupta.quizoidnew.QuestionsSubCategories;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shubhigupta.quizoidnew.GameStartActivity;
import com.example.shubhigupta.quizoidnew.R;

import java.util.ArrayList;

/**
 * Created by shubhigupta on 20/04/17.
 */

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.QuestionListHolder> {
private ArrayList<String> QuestionCategories;
private Context context;
    public String name;
    int pos;

    public QuestionListAdapter(ArrayList<String> questionSubCategories, Context context,String name) {
        QuestionCategories = questionSubCategories;
        this.context = context;
        this.name = name;
        }

    @Override
    public QuestionListAdapter.QuestionListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.question_holder,parent, false);

        return new QuestionListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QuestionListAdapter.QuestionListHolder holder, final int position) {
        String question = QuestionCategories.get(position);
        switch (position) {
            case 0:
                pos = 43;
                break;
            case 1:
                pos = 87;
                break;
            case 2:
                pos = 162;
                break;
            case 3:
                pos = 87;
                break;
            case 4:
                pos = 67;
                break;
            case 5:
                pos = 109;
                break;
            case 6:
                pos = 5;
                break;
        }

            holder.tv.setText(question);


        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,GameStartActivity.class);
                i.putExtra("qid",pos);
                i.putExtra("nameA",name);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return QuestionCategories.size();
    }

    public class QuestionListHolder extends RecyclerView.ViewHolder {
        TextView tv;


        public QuestionListHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
