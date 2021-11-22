package com.example.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.TimePickerDialog;
import android.widget.TimePicker;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Faculty2<random> extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[];

    private Button button, button2, button3;
    private Random random = new Random();
    private String otp = String.format("%04d", random.nextInt(10000));
    private EditText topic;
    TextView date1, time1;
    int hr, min;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty2);

        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityAdmin4();
            }
        });

        date1 = findViewById(R.id.date_picker);
        time1 = findViewById(R.id.time_picker);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Faculty2.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                Faculty2.this.date1.setText(date);
            }
        };

        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Faculty2.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        hr = hourOfDay;
                        min = minute;

                        String time = hr + ":" + min;
                        SimpleDateFormat f24hours = new SimpleDateFormat("HH:mm");
                        try {
                            Date d = f24hours.parse(time);
                            SimpleDateFormat f12hours = new SimpleDateFormat("hh:mm aa");
                            time1.setText(f12hours.format(d));

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                }, 12, 0, false
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(hr, min);
                timePickerDialog.show();
            }
        });

        button3 = (Button) findViewById(R.id.buttonSchedule);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Faculty2.this);
                builder.setCancelable(true);
                builder.setMessage("Class scheduled! \nOTP is " + otp);
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });


//        topic = (EditText) findViewById(R.id.topicInput);
//        date = (EditText) findViewById(R.id.editTextDate);
//        time = (EditText) findViewById(R.id.editTextTime);

/*        button2 = (Button) findViewById(R.id.buttonSchedule);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(Faculty2.this);
                View promptsView = li.inflate(R.layout.faculty_schedule_class, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Faculty2.this);
                alertDialogBuilder.setView(promptsView);

                final EditText topicInput = (EditText) promptsView.findViewById(R.id.topicInput);
//                final EditText dateInput = (EditText) promptsView.findViewById(R.id.editTextDate);
                final EditText timeInput = (EditText) promptsView.findViewById(R.id.editTextTime);

*/

                /*alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setMessage("Schedule Class");
                alertDialogBuilder.setPositiveButton("Schedule",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                //    topic.setText(topicInput.getText());
                                //    date.setText(dateInput.getText());
                                //    time.setText(timeInput.getText());

                                    Toast.makeText(getApplicationContext(),"Class scheduled! \nOTP is " + otp, Toast.LENGTH_LONG).show();
                                }
                            });
                alertDialogBuilder.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });
*/
        recyclerView = findViewById(R.id.recyclerViewTopics);

        s1 = getResources().getStringArray(R.array.topic_list);
        s2 = getResources().getStringArray(R.array.topic_date);
        s3 = getResources().getStringArray(R.array.class_hour);

        RecyclerViewAdapterFacultyTopics recyclerViewAdapterFacultyTopics = new RecyclerViewAdapterFacultyTopics(this, s1, s2, s3);
        recyclerView.setAdapter(recyclerViewAdapterFacultyTopics);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void openActivityAdmin4() {
        Intent intent = new Intent(this, Admin4.class);
        startActivity(intent);
    }

}
