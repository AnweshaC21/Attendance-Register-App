package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.app.Adaptery;
import com.example.app.Admin2;
import com.example.app.R;

public class stud1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud1);

        GridView gridView= findViewById(R.id.gridy);
        gridView.setAdapter(new Adaptery(this));
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivitysub();
            }
        });
    }
    public void openActivitysub() {
        Intent intent = new Intent(this, sub_details.class);
        startActivity(intent);
    }

}