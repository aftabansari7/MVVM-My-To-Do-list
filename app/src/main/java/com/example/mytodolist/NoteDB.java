package com.example.mytodolist;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Note.class, version = 1)
public abstract class NoteDB extends RoomDatabase {
    private static NoteDB instance;
    public abstract NoteDao noteDao();
//    synchronized instance runs on main thread.
    public static synchronized NoteDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDB.class, "note_db").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
