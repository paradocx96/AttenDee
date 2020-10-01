package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditAttendeeActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5, saveChangeBtn;
    private EditText remarks, name;
    private Button addAttendBtn;
    private Context context;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_attendee);

        button1 = (Button) findViewById(R.id.btn1_menu);
        button2 = (Button) findViewById(R.id.btn2_menu);
        button3 = (Button) findViewById(R.id.btn3_menu);
        button4 = (Button) findViewById(R.id.btn4_menu);
        button5 = (Button) findViewById(R.id.btn5_menu);
        saveChangeBtn = (Button) findViewById(R.id.saveChangeBtn);

        name = findViewById(R.id.update_editTxt_personName);
        remarks = findViewById(R.id.update_editTxt_remarks);

        context = this;
        myDatabaseHelper = new MyDatabaseHelper(context);

        final String id = getIntent().getStringExtra("id1");
        System.out.println(id);

        Attendance attendance = myDatabaseHelper.getSingleAttendance(Integer.parseInt(id));

        name.setText(attendance.getName());
        remarks.setText(attendance.getRemarks());


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EditAttendeeActivity.this,AddEventActivity.class));
//                button1.setBackgroundColor(Color.parseColor("#ffffff"));
//                button1.setTextColor(Color.parseColor("#9c27b0"));
//
//
//                button2.setBackgroundColor(Color.parseColor("#9c27b0"));
//                button2.setTextColor(Color.parseColor("#ffffff"));
//
//
//                button3.setBackgroundColor(Color.parseColor("#9c27b0"));
//                button3.setTextColor(Color.parseColor("#ffffff"));


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EditAttendeeActivity.this,AttendanceHomeActivity.class));
//                button2.setBackgroundColor(Color.parseColor("#ffffff"));
//                button2.setTextColor(Color.parseColor("#9c27b0"));
//
//
//                button1.setBackgroundColor(Color.parseColor("#9c27b0"));
//                button1.setTextColor(Color.parseColor("#ffffff"));
//
//
//                button3.setBackgroundColor(Color.parseColor("#9c27b0"));
//                button3.setTextColor(Color.parseColor("#ffffff"));



            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                button3.setBackgroundColor(Color.parseColor("#ffffff"));
//                button3.setTextColor(Color.parseColor("#9c27b0"));
//
//
//                button1.setBackgroundColor(Color.parseColor("#9c27b0"));
//                button1.setTextColor(Color.parseColor("#ffffff"));
//
//
//                button2.setBackgroundColor(Color.parseColor("#9c27b0"));
//                button2.setTextColor(Color.parseColor("#ffffff"));


            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(EditAttendeeActivity.this, AddAttendeeActivity.class);
                startActivity(intent);


//                button4.setBackgroundColor(Color.parseColor("#ff9100"));
//                button4.setTextColor(Color.parseColor("#ffffff"));
//
//                button5.setBackgroundColor(Color.parseColor("#ffffff"));
//                button5.setTextColor(Color.parseColor("#ff9100"));

            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(EditAttendeeActivity.this, AttendanceHomeActivity.class);
                startActivity(intent);


//                button5.setBackgroundColor(Color.parseColor("#ff9100"));
//                button5.setTextColor(Color.parseColor("#ffffff"));
//
//                button4.setBackgroundColor(Color.parseColor("#ffffff"));
//                button4.setTextColor(Color.parseColor("#ff9100"));


            }
        });

        saveChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String personName = name.getText().toString();
                String personRemarks = remarks.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss", Locale.getDefault());
                String dateTime = sdf.format(new Date());

                if(personName.length()==0)
                {
                    name.requestFocus();
                    name.setError("FIELD CANNOT BE EMPTY");
                }
                else if(!personName.matches("[a-zA-Z ]+"))
                {
                    name.requestFocus();
                    name.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
                else if(remarks.length()==0)
                {
                    remarks.requestFocus();
                    remarks.setError("FIELD CANNOT BE EMPTY");
                }
                else {

                    Attendance attendance = new Attendance(Integer.parseInt(id), personName, dateTime, personRemarks);
                    myDatabaseHelper.updateAttendance(attendance);
                    startActivity(new Intent(EditAttendeeActivity.this, AttendanceHomeActivity.class));

                }
            }
        });




    }
}