package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Admin4 extends AppCompatActivity {

    String[] studentArray = {"Student Name1", "Student Name2", "Student Name3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin4);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.student_list, studentArray);
        ListView listView = (ListView) findViewById(R.id.studentList);
        listView.setAdapter(adapter);
    }
}