package com.example.shubhigupta.quizoidnew.Database;

/**
 * Created by shubhigupta on 14/04/17.
 */

public class HighScoreObject {
    String Name;
    int Score;

    public HighScoreObject() {
//        Name = name;
//        Score = score;
    }

    public HighScoreObject(String name, int score) {
        Name = name;
        Score = score;
    }

    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setScore(int score) {
        Score = score;
    }
}
