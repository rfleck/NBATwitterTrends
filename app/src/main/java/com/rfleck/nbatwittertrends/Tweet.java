package com.rfleck.nbatwittertrends;

/**
 * Created by rfleck on 8/14/2015.
 */
public class Tweet {
    private String user;
    private String text;
    private String imageURL;

    public Tweet(String user, String text, String imageURL) {
        this.user = user;
        this.text = text;
        this.imageURL = imageURL;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageURL() { return this.imageURL; }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}