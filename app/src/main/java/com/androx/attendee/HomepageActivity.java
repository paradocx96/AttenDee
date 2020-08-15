package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomepageActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        button1 = (Button) findViewById(R.id.btn_Event1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomepageActivity.this, AddAttendeeActivity.class);
                startActivity(intent);

                button1.setBackgroundColor(Color.parseColor("#9c27b0"));
                button1.setTextColor(Color.parseColor("#ffffff"));


            }
        });

    }
}