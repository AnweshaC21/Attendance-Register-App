package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button button;
    String selectedItem = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_users3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_users3, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedItem = spinner.getSelectedItem().toString().trim();
                switch (selectedItem) {
                    case "Admin":
                        openActivityAdmin1();
                        break;
                    case "Faculty":
                        openActivityFaculty1();
                        break;
                    case "Student":
                        openActivityStud1();
                        break;
                }
            }
        });
    }

    public void openActivityAdmin1() {
        Intent intent = new Intent(this, Admin1.class);
        startActivity(intent);
    }

    public void openActivityFaculty1() {
        Intent intent = new Intent(this, Faculty1.class);
        startActivity(intent);
    }

    public void openActivityStud1() {
        Intent intent = new Intent(this, stud1.class);
        startActivity(intent);
    }
}