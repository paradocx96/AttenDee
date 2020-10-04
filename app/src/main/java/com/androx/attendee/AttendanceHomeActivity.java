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

public class AttendanceHomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyDatabaseHelper mydb;
    ArrayList<String> att_id, att_name, att_dateTime, att_remark;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_home);

        recyclerView = findViewById(R.id.attendanceList);

        mydb = new MyDatabaseHelper(AttendanceHomeActivity.this);
        att_id = new ArrayList<>();
        att_name = new ArrayList<>();
        att_dateTime = new ArrayList<>();
        att_remark = new ArrayList<>();

        Button btn2 = (Button) findViewById(R.id.btn_add);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AttendanceHomeActivity.this, AddAttendeeActivity.class);
                startActivity(intent);
            }
        });

        saveAllAttendanceInArray();

        customAdapter = new CustomAdapter(AttendanceHomeActivity.this,att_id,att_name,att_dateTime,att_remark);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AttendanceHomeActivity.this));
    }

    void saveAllAttendanceInArray() {
        Cursor cursor = mydb.getAllAttendance();

        if (cursor.getCount() == 0) {
            Toast.makeText(this,"No Data!", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                att_id.add(cursor.getString(0));
                att_name.add(cursor.getString(1));
                att_dateTime.add(cursor.getString(2));
                att_remark.add(cursor.getString(3));

            }
        }
    }
}