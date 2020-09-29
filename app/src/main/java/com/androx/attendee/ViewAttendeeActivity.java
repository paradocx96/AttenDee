package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAttendeeActivity extends AppCompatActivity {

    TextView att_name, att_datetime, att_remark;
    String id, name, datetime, remark;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendee);

        att_name = findViewById(R.id.attendeeName_Example1);
        att_datetime = findViewById(R.id.attendeeDate_Example);
        att_remark = findViewById(R.id.attendeeRemark_Example4);

        btn1 = (Button) findViewById(R.id.btn_option);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAttendeeActivity.this, OptionAttendeeActivity.class);

                Intent intent1 = new Intent(ViewAttendeeActivity.this, EditAttendeeActivity.class);
                String id1 = getIntent().getStringExtra("id");
                intent1.putExtra("id1", id1);
                startActivity(intent);
                startActivity(intent1);
            }
        });

        getIntentData();
    }

    void getIntentData() {
        if (getIntent().hasExtra("id") &&
                getIntent().hasExtra("name") &&
                getIntent().hasExtra("datetime") &&
                getIntent().hasExtra("remark")) {

            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            datetime = getIntent().getStringExtra("datetime");
            remark = getIntent().getStringExtra("remark");

            att_name.setText(name);
            att_datetime.setText(datetime);
            att_remark.setText(remark);

        } else {
            Toast.makeText(this,"No Data!", Toast.LENGTH_SHORT).show();
        }
    }
}