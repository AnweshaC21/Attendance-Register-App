package com.example.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Faculty1<random> extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[], s2[], s3[];
    FloatingActionButton joinFab, newFab;
    ExtendedFloatingActionButton addFab;
    TextView joinText, newText;
    Boolean isFabVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty1);

        recyclerView = findViewById(R.id.recyclerViewFaculty);

        s1 = getResources().getStringArray(R.array.classroom_list);
        s2 = getResources().getStringArray(R.array.clasroom_description);
        s3 = getResources().getStringArray(R.array.faculty_names);

        RecyclerViewAdapterFacultyClass recyclerViewAdapterFacultyClass = new RecyclerViewAdapterFacultyClass(this, s1, s2, s3);
        recyclerView.setAdapter(recyclerViewAdapterFacultyClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addFab = findViewById(R.id.add_fab);
        joinFab = findViewById(R.id.join_class_fab);
        newFab = findViewById(R.id.new_class_fab);

        joinText = findViewById(R.id.join_class_text);
        newText = findViewById(R.id.new_class_text);

        joinFab.setVisibility(View.GONE);
        newFab.setVisibility(View.GONE);
        joinText.setVisibility(View.GONE);
        newText.setVisibility(View.GONE);
        isFabVisible = false;
        addFab.shrink();

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!isFabVisible) {
                    joinFab.show();
                    newFab.show();
                    joinText.setVisibility(View.VISIBLE);
                    newText.setVisibility(View.VISIBLE);

                    addFab.extend();
                    isFabVisible = true;
                }
                else {
                    joinFab.hide();
                    newFab.hide();
                    joinText.setVisibility(View.GONE);
                    newText.setVisibility(View.GONE);

                    addFab.shrink();
                    isFabVisible = false;
                }
            }
        });

        newFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(Faculty1.this);
                View promptsView = li.inflate(R.layout.create_new_classroom, null);

                AlertDialog.Builder alert = new AlertDialog.Builder(Faculty1.this);
                alert.setView(promptsView);
                alert.setTitle("New Classroom");
                final EditText input1 = new EditText(Faculty1.this);
                input1.findViewById(R.id.input_subject);
                final EditText input2 = new EditText(Faculty1.this);
                input2.findViewById(R.id.input_class);

                alert.setPositiveButton("Create",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String subject = String.valueOf(input1.getText());
                                String classname = String.valueOf(input2.getText());

                                Toast.makeText(Faculty1.this, "Classroom created!", Toast.LENGTH_SHORT).show();
                            }
                        });
                alert.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                alert.show();
            }
        });

        joinFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Faculty1.this);
                alert.setTitle("Enter Classroom Code to Join");
                EditText input = new EditText(Faculty1.this);
                alert.setView(input);

                alert.setPositiveButton("Join",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String code = String.valueOf(input.getText());

                                Toast.makeText(Faculty1.this, "Joined new classroom!", Toast.LENGTH_SHORT).show();
                            }
                        });
                alert.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                alert.show();
            }
        });
    }
}