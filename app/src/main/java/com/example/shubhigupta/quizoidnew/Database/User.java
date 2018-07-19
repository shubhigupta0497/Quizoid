package com.example.shubhigupta.quizoidnew.Database;

/**
 * Created by shubhigupta on 25/03/17.
 */

public class User {
    String name;
    String emailId;
    String username;
    String password;
    int scores;

    public int random(){
        return (int) Math.round((Math.random()*1000)%50);
    }

    public User(){
        this.scores = random();
    }
    //getters

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getScores() {
        return scores;
    }
    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }
}
