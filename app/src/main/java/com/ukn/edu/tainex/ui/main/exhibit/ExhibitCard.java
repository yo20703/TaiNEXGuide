package com.ukn.edu.tainex.ui.main.exhibit;

public class ExhibitCard {
    private int image;
    private String date;
    private String name;
    private String place;

    public ExhibitCard(){
        super();
    }

    public ExhibitCard(int image, String date, String name, String place){
        super();
        this.image = image;
        this.date = date;
        this.name = name;
        this.place = place;
    }

    public int getImage(){
        return image;
    }

    public void setImage(int image){
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
}
