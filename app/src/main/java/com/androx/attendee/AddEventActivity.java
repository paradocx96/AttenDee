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

public class AddEventActivity extends AppCompatActivity {

    private Button eventsButton, add;
    private EditText name, date, remarks;
    private Context context;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        eventsButton = (Button) findViewById(R.id.events);
        add = (Button) findViewById(R.id.ADD);

        name = findViewById(R.id.textInputEditText2);
        date = findViewById(R.id.editTextDate);
        remarks = findViewById(R.id.editTextTextMultiLine);

        context = this;
        myDatabaseHelper = new MyDatabaseHelper(context);

        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddEventActivity.this,EventHomeActivity.class));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eventName = name.getText().toString();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
                String eventDate = simpleDateFormat.format(new Date());
                String eventRemarks = remarks.getText().toString();

                if(eventName.length()==0)
                {
                    name.requestFocus();
                    name.setError("EVENT NAME CANNOT BE EMPTY");
                }
                else {
                    Event event = new Event(eventName, eventDate, eventRemarks);
                    myDatabaseHelper.addEvent(event);

                    startActivity(new Intent(AddEventActivity.this, AddEventActivity.class));
                }
            }
        });
    }
}