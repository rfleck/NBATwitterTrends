package com.rfleck.nbatwittertrends;

/**
 * Created by rfleck on 8/14/2015.
 */
public class Tweet {
    private String user;
    private String text;
    private int image;

    public Tweet(String user, String text, int image){
        this.user = user;
        this.text = text;
        this.image = image;
    }

    public String getUser(){
        return this.user;
    }

    public void setUser(String user){
        this.user  = user;
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }

    public int getImage(){
        return this.image;
    }

    public void setImage(int image){
        this.image = image;
    }
}