package com.example.shubhigupta.quizoidnew.QuestionsSubCategories;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shubhigupta.quizoidnew.Database.HighScoreObject;
import com.example.shubhigupta.quizoidnew.R;

import java.util.ArrayList;

/**
 * Created by shubhigupta on 22/04/17.
 */

public class ScoreBoardAdapter extends RecyclerView.Adapter<ScoreBoardAdapter.ScoresHolder> {
    ArrayList<HighScoreObject> list;
    Context context;

    public ScoreBoardAdapter(ArrayList<HighScoreObject> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ScoresHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.scores_holder,parent, false);

        return new ScoresHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ScoresHolder holder, int position) {
        String name = list.get(position).getName();
        int Scores = list.get(position).getScore();
        String scores = Integer.toString(Scores);
        holder.Name.setText(name);
        //holder.Name.setBackgroundColor();
        holder.Scores.setText(scores);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ScoresHolder extends RecyclerView.ViewHolder {
        TextView Name, Scores;
        public ScoresHolder(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.PlayersName);
            Scores = (TextView) itemView.findViewById(R.id.PlayerScore);
        }
    }
}
