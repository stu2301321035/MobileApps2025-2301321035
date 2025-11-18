package com.example.mynotesapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotesapp.adapter.NoteAdapter;
import com.example.mynotesapp.database.NoteHelper;
import com.example.mynotesapp.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Note> arrayList = new ArrayList<>();
    NoteHelper noteHelper;
    FloatingActionButton floatingId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        floatingId = findViewById(R.id.floatingId);
        recyclerView = findViewById(R.id.recyclerView);
        noteHelper = new NoteHelper(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = noteHelper.showData();
        while (cursor.moveToNext()){
            arrayList.add(new Note(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
        }

        NoteAdapter adapter = new NoteAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);


        floatingId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });
    }
}