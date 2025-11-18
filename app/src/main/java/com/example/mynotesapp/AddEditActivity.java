package com.example.mynotesapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddEditActivity extends AppCompatActivity {

    EditText edTitle, edDesc;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_edit);

        edTitle = findViewById(R.id.edTitle);
        edDesc = findViewById(R.id.edDesc);
        btn = findViewById(R.id.btn);
    }
}