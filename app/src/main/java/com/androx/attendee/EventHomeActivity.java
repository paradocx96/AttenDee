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
    }
}