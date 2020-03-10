package com.example.junhiproject;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.Date;

public class Dictionary {
    private int image;
    private String title;
    private String date;
    private String name;
    private String content;

    public Dictionary(int image, String title, String date, String name, String content) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.name = name;
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

}
