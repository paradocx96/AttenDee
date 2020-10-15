package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewEventActivity extends AppCompatActivity {

    TextView eve_name, eve_datetime, eve_remark;
    String id, name, datetime, remark;
    String pass_id, pass_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        eve_name = findViewById(R.id.eventNameDeleteCon);
        eve_datetime = findViewById(R.id.eventDate2);
        eve_remark = findViewById(R.id.eventDescription2);

        Button btn_event_home = (Button) findViewById(R.id.btn_event6);
        btn_event_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewEventActivity.this, EventHomeActivity.class);
                startActivity(intent);
            }
        });

        Button btn_aboutus = (Button) findViewById(R.id.btn_aboutus6);
        btn_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewEventActivity.this, AboutUs.class);
                startActivity(intent);
            }
        });

        Button btn_attendance = (Button) findViewById(R.id.btn_attendance6);
        btn_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewEventActivity.this, AttendanceHomeActivity.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn_option2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass_id = id;
                pass_name = name;

                Intent intent = new Intent(ViewEventActivity.this, OptionEventActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", pass_id);
                bundle.putString("name", pass_name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        Button btn3 = (Button) findViewById(R.id.btn_add6);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewEventActivity.this, AddEventActivity.class);
                startActivity(intent);
            }
        });

        getIntentData();
    }

    void getIntentData() {
        if (getIntent().hasExtra("id") &&
                getIntent().hasExtra("name") &&
                getIntent().hasExtra("datetime") &&
                getIntent().hasExtra("remark")) {

            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            datetime = getIntent().getStringExtra("datetime");
            remark = getIntent().getStringExtra("remark");

            eve_name.setText(name);
            eve_datetime.setText(datetime);
            eve_remark.setText(remark);

        } else {
            Toast.makeText(this,"No Data!", Toast.LENGTH_SHORT).show();
        }
    }
}