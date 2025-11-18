package com.example.mynotesapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NoteHelper extends SQLiteOpenHelper {


    private static final String DATABASE = "NOTES_DB";
    private static final int VERSION = 2;
    public NoteHelper(@Nullable Context context) {
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

    public Cursor showData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from notes_table",null);
        return cursor;
    }

    public void updateData(String id,String title, String description){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put("id",id);
        values.put("title",title);
        values.put("description",description);

        db.update("notes_table",values,"id=?",new String[]{id});
    }

    public void deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("notes_table", "id=?", new String[]{id});
    }


}
