package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class AddAttendeeActivity extends AppCompatActivity {

    private Button naviBtn;
    private EditText remarks, name;
    private Button addAttendBtn;
    private Context context;
    private MyDatabaseHelper myDatabaseHelper;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendee);


        naviBtn = (Button) findViewById(R.id.btn2_menu);

        addAttendBtn = (Button) findViewById(R.id.addPersonBtn);
        name = findViewById(R.id.editTxt_personName);
        remarks = findViewById(R.id.editTxt_remarks);
        textView = findViewById(R.id.tv);

        context = this;
        myDatabaseHelper = new MyDatabaseHelper(context);

        addAttendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(name.getText());
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

                    Attendance attendance = new Attendance(personName, dateTime, personRemarks);
                    myDatabaseHelper.addAttendence(attendance);

                    startActivity(new Intent(AddAttendeeActivity.this, AttendanceHomeActivity.class));
                }
            }
        });



    }
}