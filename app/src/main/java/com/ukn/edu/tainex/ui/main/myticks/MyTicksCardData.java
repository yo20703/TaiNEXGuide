package com.ukn.edu.tainex.ui.main.myticks;

public class MyTicksCardData {
    private int image;
    private String date;
    private String name;
    private String place;
    private String time;
    private int count;

    public MyTicksCardData(int image, String date, String name, String place, String time, int count) {
        this.image = image;
        this.date = date;
        this.name = name;
        this.place = place;
        this.time = time;
        this.count = count;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
