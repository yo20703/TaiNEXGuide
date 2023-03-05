package com.ukn.edu.tainex.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyTicks {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "tick_type")
    public String tickType;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "phone_number")
    public String phoneNumber;

    @ColumnInfo(name = "time_stamp")
    public String timeStamp;

    @ColumnInfo(name = "image")
    public int image;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "exhibit_name")
    public String exhibitName;

    @ColumnInfo(name = "place")
    public String place;
}
