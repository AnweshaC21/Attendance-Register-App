package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Admin1 extends AppCompatActivity {

    private Button button, button2;
    String viewList = "none";
    int pos;
    EditText nameEditText,emailEditText,passwordEditText;

    public void clickMe(View view) {

        Log.i("Name", nameEditText.getText().toString());
        Log.i("Email", emailEditText.getText().toString());
        Log.i("Password:", passwordEditText.getText().toString());

        Log.i("view list", viewList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin1);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_users);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_users, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_users2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner_users2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewList = spinner2.getSelectedItem().toString().trim();
                switch (viewList) {
                    case "Admin":
                        openActivityAdmin2();
                        break;
                    case "Faculty":
                        openActivityAdmin3();
                        break;
                    case "Student":
                        openActivityAdmin4();
                        break;
                }
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"User added successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openActivityAdmin2() {
        Intent intent = new Intent(this, Admin2.class);
        startActivity(intent);
    }

    public void openActivityAdmin3() {
        Intent intent = new Intent(this, Admin3.class);
        startActivity(intent);
    }

    public void openActivityAdmin4() {
        Intent intent = new Intent(this, Admin4.class);
        startActivity(intent);
    }
}