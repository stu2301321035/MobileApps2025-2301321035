package com.example.mynotesapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.function.DoubleBinaryOperator;

public class NoteHelper extends SQLiteOpenHelper {


    private static final String DATABASE = "NOTES_DB";
    private static final int VERSION = 2;
    public NoteHelper(@Nullable Context context, @Nullable String name) {
        super(context, DATABASE, null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table notes_table(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists notes_table");
    }

    public void insertData(String title, String description){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("description",description);
        database.insert("notes_table",null,values);
    }

}
