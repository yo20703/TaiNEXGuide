package com.ukn.edu.tainex.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyTicksDao {
    @Query("SELECT * FROM MyTicks")
    List<MyTicks> getAll();

    @Query("SELECT * FROM MyTicks WHERE tick_type = :tickType")
    List<MyTicks> findByTickType(String tickType);

    @Insert
    void insert(MyTicks myTicks);
}
