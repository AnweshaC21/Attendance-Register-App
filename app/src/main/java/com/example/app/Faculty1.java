package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

public class Faculty1<random> extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.book_111, R.drawable.book_111, R.drawable.book_111, R.drawable.book_111, R.drawable.book_111, R.drawable.book_111, R.drawable.book_111, R.drawable.book_111, R.drawable.book_111, R.drawable.book_111};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty1);

        recyclerView = findViewById(R.id.recyclerViewFaculty);

        s1 = getResources().getStringArray(R.array.classroom_list);
        s2 = getResources().getStringArray(R.array.clasroom_description_faculty);

        RecyclerViewAdapterFacultyClass recyclerViewAdapterFacultyClass = new RecyclerViewAdapterFacultyClass(this, s1, s2, images);
        recyclerView.setAdapter(recyclerViewAdapterFacultyClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}