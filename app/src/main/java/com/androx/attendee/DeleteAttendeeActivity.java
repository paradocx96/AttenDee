package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeleteAttendeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_attendee);

        Button btn_Delete_yes = (Button) findViewById(R.id.btn_delete_yes);
        Button btn_Delete_no = (Button) findViewById(R.id.btn_delete_no);
        Button btn_delete_close = (Button) findViewById(R.id.btn_delete_close);

        btn_Delete_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteAttendeeActivity.this, AttendanceHomeActivity.class);
                startActivity(intent);
            }
        });

        btn_Delete_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteAttendeeActivity.this, OptionAttendeeActivity.class);
                startActivity(intent);
            }
        });

        btn_delete_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteAttendeeActivity.this, OptionAttendeeActivity.class);
                startActivity(intent);
            }
        });
    }
}