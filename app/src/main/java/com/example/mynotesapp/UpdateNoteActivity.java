package com.example.mynotesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mynotesapp.database.NoteHelper;

import org.jetbrains.annotations.TestOnly;

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


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //get the data from the MainActivity
        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("description");
        int id = getIntent().getIntExtra("id",0);
        updateTitle.setText(title);
        updateDesc.setText(desc);
        String sId = String.valueOf(id);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (updateTitle.length()>0&&updateDesc.length()>0){
                    NoteHelper noteHelper = new NoteHelper(UpdateNoteActivity.this);
                    noteHelper.updateData(updateTitle.getText().toString(), updateDesc.getText().toString(),sId);
                    Toast.makeText(UpdateNoteActivity.this, "The Data is Successfully Updated", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateNoteActivity.this,MainActivity.class));
                }else{
                    Toast.makeText(UpdateNoteActivity.this, "The Data is not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}