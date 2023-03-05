package com.ukn.edu.tainex.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MyTicks.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    static final String DB_NAME = "TaiNEX.db";
    private static volatile AppDataBase instance;

    public static AppDataBase getInstance(Context context){
        synchronized (AppDataBase.class){
            if(instance == null){
                instance = create(context);
            }

            return instance;
        }
    }

    public abstract MyTicksDao getMyTicksDao();

    private static AppDataBase create(Context context){
        return Room.databaseBuilder(context, AppDataBase.class, DB_NAME).build();
    }
}
