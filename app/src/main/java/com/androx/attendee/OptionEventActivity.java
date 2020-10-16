package com.androx.attendee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OptionEventActivity extends AppCompatActivity {

    TextView eve_name;
    String id, name, date, remark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_event);

        eve_name = (TextView)findViewById(R.id.txt_EventName6);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            id = bundle.getString("id");
            name = bundle.getString("name");
            date = bundle.getString("date");
            remark = bundle.getString("remark");
        }

        Button btn1 = (Button) findViewById(R.id.btn_edit_opt2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionEventActivity.this, EditEventActivity.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn_delete_opt2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDelete(id);
            }
        });

        Button btn_event_home = (Button) findViewById(R.id.btn_event5);
        btn_event_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionEventActivity.this, EventHomeActivity.class);
                startActivity(intent);
            }
        });

        Button btn_aboutus = (Button) findViewById(R.id.btn_aboutus5);
        btn_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionEventActivity.this, AboutUs.class);
                startActivity(intent);
            }
        });

        Button btn_attendance = (Button) findViewById(R.id.btn_attendance5);
        btn_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionEventActivity.this, AttendanceHomeActivity.class);
                startActivity(intent);
            }
        });

        Button btn_Option_Close = (Button) findViewById(R.id.btn_opt_close2);
        btn_Option_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionEventActivity.this, EventHomeActivity.class);
                startActivity(intent);
            }
        });
    }

    void confirmDelete(final String id) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(OptionEventActivity.this);
                myDB.deleteSingleEvent(id);
                Intent intent = new Intent(OptionEventActivity.this, EventHomeActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }
}