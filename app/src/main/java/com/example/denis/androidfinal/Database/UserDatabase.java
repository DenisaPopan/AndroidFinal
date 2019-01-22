package com.example.denis.androidfinal.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.denis.androidfinal.DAO.TaskDao;
import com.example.denis.androidfinal.DAO.UserDao;
import com.example.denis.androidfinal.Entities.Task;
import com.example.denis.androidfinal.Entities.User;

@Database(entities = {User.class, Task.class}, version = 2)
@TypeConverters({DateConverter.class})
public abstract class UserDatabase extends RoomDatabase
{
    public static UserDatabase databaseInstance;

    public abstract UserDao getUserDao();

    public abstract TaskDao getTaskDao();

    public static UserDatabase getDatabase(Context context)
    {
        if(databaseInstance==null)
        {
            databaseInstance=Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class, "user-database").allowMainThreadQueries().build();
        }
        return databaseInstance;
    }

    public static void destroyInstance()
    {
        databaseInstance = null;
    }
}
