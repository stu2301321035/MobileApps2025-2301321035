package com.example.mynotesapp;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mynotesapp.database.NoteHelper;

public class AddEditActivity extends AppCompatActivity {

    EditText edTitle, edDesc;
    Button btn;
    NoteHelper noteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_edit);

        edTitle = findViewById(R.id.edTitle);
        edDesc = findViewById(R.id.edDesc);
        btn = findViewById(R.id.btn);
        noteHelper = new NoteHelper(AddEditActivity.this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edTitle.length()>0&&edDesc.length()>0){
                    noteHelper.insertData(edTitle.getText().toString(),edDesc.getText().toString());
                    Toast.makeText(AddEditActivity.this, "The Note is Successfully Added",Toast.LENGTH_SHORT).show();
                    edDesc.setText("");
                    edTitle.setText("");
                    finish();
                }else {
                    Toast.makeText(AddEditActivity.this, "The Note is not added", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}