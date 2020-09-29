package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionAttendeeActivity extends AppCompatActivity {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_attendee);

        Button btn_Option_Edit = (Button) findViewById(R.id.btn_edit_opt);
        Button btn_Option_Delete = (Button) findViewById(R.id.btn_delete_opt);
        Button btn_Option_Close = (Button) findViewById(R.id.btn_opt_close);

        btn_Option_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionAttendeeActivity.this, EditAttendeeActivity.class);
//                id = getIntent().getStringExtra("id");
//                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        btn_Option_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionAttendeeActivity.this, DeleteAttendeeActivity.class);
                startActivity(intent);
            }
        });

        btn_Option_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionAttendeeActivity.this, ViewAttendeeActivity.class);
                startActivity(intent);
            }
        });
    }
}