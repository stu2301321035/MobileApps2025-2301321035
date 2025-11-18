package com.example.mynotesapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpdateNoteActivity extends AppCompatActivity {

    EditText updateTitle, updateDesc;
    Button btnUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_note);

        updateTitle = findViewById(R.id.edUpdateTitle);
        updateDesc = findViewById(R.id.edUpdateDesc);
        btnUpdate = findViewById(R.id.btnUpdate);

    }
}