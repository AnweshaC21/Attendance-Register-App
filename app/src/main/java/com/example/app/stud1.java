package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import com.example.app.Adaptery;
import com.example.app.Admin2;
import com.example.app.R;

public class stud1 extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        button = (Button) findViewById(R.id.button3);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud1);

        GridView gridView= findViewById(R.id.gridy);
        gridView.setAdapter(new Adaptery(this));
    }

}