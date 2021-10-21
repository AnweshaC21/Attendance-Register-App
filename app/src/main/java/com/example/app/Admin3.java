package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Admin3 extends AppCompatActivity {

    String[] facultyArray = {"Faculty Name1", "Faculty Name2", "Faculty Name3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin3);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.faculty_list, facultyArray);
        ListView listView = (ListView) findViewById(R.id.facultyList);
        listView.setAdapter(adapter);
    }
}