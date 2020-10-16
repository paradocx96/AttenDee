package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditEventActivity extends AppCompatActivity {

    private Button eventsButton;
    private Button attendance;
    private Button aboutUs;
    private Button addEventButton;
    private Button viewEventButton;
    private Button update;
    private EditText name, date, remarks;
    private Context context;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);

        eventsButton = (Button) findViewById(R.id.events);
        attendance = (Button) findViewById(R.id.button5);
        aboutUs = (Button) findViewById(R.id.btn_Aboutus1);
        addEventButton = (Button) findViewById(R.id.btn_add_editEvent);
        viewEventButton = (Button) findViewById(R.id.btn_view6);
        update = (Button) findViewById(R.id.updateEvent);
        name = findViewById(R.id.textInputEditText2);
        date = findViewById(R.id.editTextDate);
        remarks = findViewById(R.id.editTextTextMultiLine);

        context = this;
        myDatabaseHelper = new MyDatabaseHelper(context);

        final String id = getIntent().getStringExtra("id");
        System.out.println(id);

        Event event = myDatabaseHelper.getSingleEvent(Integer.parseInt(id));

        name.setText(event.getName());
        remarks.setText(event.getRemarks());

        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditEventActivity.this, AddEventActivity.class));
            }
        });

        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditEventActivity.this, AttendanceHomeActivity.class));
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditEventActivity.this, HomepageActivity.class));
            }
        });

        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditEventActivity.this, AddEventActivity.class));
            }
        });

        viewEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditEventActivity.this, ViewEventActivity.class));
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eventName = name.getText().toString();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
                String eventDate = simpleDateFormat.format(new Date());
                String eventRemarks = remarks.getText().toString();

                    Event event = new Event(Integer.parseInt(id),eventName, eventDate, eventRemarks);
                    myDatabaseHelper.updateEvent(event);

                    startActivity(new Intent(EditEventActivity.this, AddEventActivity.class));
            }
        });
    }
}