package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Admin2 extends AppCompatActivity {

    String[] adminArray = {"Admin Name1", "Admin Name2", "Admin Name3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.admin_list, adminArray);
        ListView listView = (ListView) findViewById(R.id.adminList);
        listView.setAdapter(adapter);
    }
}