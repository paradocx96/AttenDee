package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_home);

        Button btn1 = (Button) findViewById(R.id.btn_homeEvent_add);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventHomeActivity.this, AddEventActivity.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn_homeEvent_e1);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventHomeActivity.this, ViewEventActivity.class);
                startActivity(intent);
            }
        });

    }
}