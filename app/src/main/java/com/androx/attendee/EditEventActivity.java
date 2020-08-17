package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditEventActivity extends AppCompatActivity {

    private Button eventsButton;
    private Button addEventButton;
    private Button editEventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);

        eventsButton =(Button) findViewById(R.id.events);
        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityEvents();
            }
        });

        addEventButton =(Button) findViewById(R.id.AddNewEvent);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityAddEvents();
            }
        });

    }

    public void openActivityEvents(){
        Intent intent4 = new Intent(this, AddEventActivity.class);
        startActivity(intent4);
    }

    public void openActivityAddEvents(){
        Intent intent5 = new Intent(this, AddEventActivity.class);
        startActivity(intent5);
    }

}