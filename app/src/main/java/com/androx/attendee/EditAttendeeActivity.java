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

    private Button saveChangeBtn, chancelBtn;
    private EditText remarks, name;
    private Context context;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_attendee);

        saveChangeBtn = (Button) findViewById(R.id.saveChangeBtn);
        chancelBtn = (Button) findViewById(R.id.cancelBtn);
        name = findViewById(R.id.update_editTxt_personName);
        remarks = findViewById(R.id.update_editTxt_remarks);

        context = this;
        myDatabaseHelper = new MyDatabaseHelper(context);

        final String id = getIntent().getStringExtra("id1");

        Attendance attendance = myDatabaseHelper.getSingleAttendance(Integer.parseInt(id));

        name.setText(attendance.getName());
        remarks.setText(attendance.getRemarks());

        chancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(EditAttendeeActivity.this, AttendanceHomeActivity.class);
                startActivity(intent);



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

                    startActivity( new Intent(EditAttendeeActivity.this, AttendanceHomeActivity.class));

                }
            }
        });




    }
}