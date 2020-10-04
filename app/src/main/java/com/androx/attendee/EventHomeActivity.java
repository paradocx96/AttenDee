package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class EventHomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyDatabaseHelper mydb;
    ArrayList<String> eve_id, eve_name, eve_dateTime, eve_remark;
    EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_home);

        Button btn_add = (Button) findViewById(R.id.btn_add_eHome);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventHomeActivity.this, AddEventActivity.class);
                startActivity(intent);
            }
        });


        Button btn_event_home = (Button) findViewById(R.id.btn_event_eHome);
        btn_event_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventHomeActivity.this, EventHomeActivity.class);
                startActivity(intent);
            }
        });

        Button btn_aboutus = (Button) findViewById(R.id.btn_aboutus_eHome);
        btn_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventHomeActivity.this, AboutUs.class);
                startActivity(intent);
            }
        });

        Button btn_attendance = (Button) findViewById(R.id.btn_attendance_eHome);
        btn_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventHomeActivity.this, AttendanceHomeActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.eventList);
        mydb = new MyDatabaseHelper(EventHomeActivity.this);
        eve_id = new ArrayList<>();
        eve_name = new ArrayList<>();
        eve_dateTime = new ArrayList<>();
        eve_remark = new ArrayList<>();

        saveAllAttendanceInArray();

        eventAdapter = new EventAdapter(EventHomeActivity.this,eve_id,eve_name,eve_dateTime,eve_remark);
        recyclerView.setAdapter(eventAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(EventHomeActivity.this));
    }

    void saveAllAttendanceInArray() {
        Cursor cursor = mydb.getAllEvents();

        if (cursor.getCount() == 0) {
            Toast.makeText(this,"No Data!", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                eve_id.add(cursor.getString(0));
                eve_name.add(cursor.getString(1));
                eve_dateTime.add(cursor.getString(2));
                eve_remark.add(cursor.getString(3));
            }
        }
    }
}