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
    Button btn_option;
    String pass_id, pass_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendee);

        att_name = findViewById(R.id.attendeeName_Example1);
        att_datetime = findViewById(R.id.attendeeDate_Example);
        att_remark = findViewById(R.id.attendeeRemark_Example4);
        btn_option = (Button) findViewById(R.id.btn_option);

        btn_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pass_id = id;
                pass_name = name;
                Intent intent = new Intent(ViewAttendeeActivity.this, OptionAttendeeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", pass_id);
                bundle.putString("name", pass_name);
                intent.putExtras(bundle);
                startActivity(intent);
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