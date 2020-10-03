package com.androx.attendee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OptionAttendeeActivity extends AppCompatActivity {

    TextView att_id, att_name;
    String id, name;
    Button btn_Option_Edit, btn_Option_Delete, btn_Option_Close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_attendee);

        btn_Option_Edit = (Button) findViewById(R.id.btn_edit_opt);
        btn_Option_Delete = (Button) findViewById(R.id.btn_delete_opt);
        btn_Option_Close = (Button) findViewById(R.id.btn_opt_close);

        att_name = (TextView)findViewById(R.id.attendeeName3);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            id = bundle.getString("id");
            name = bundle.getString("name");
            att_name.setText(name);
        }

        btn_Option_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionAttendeeActivity.this, EditAttendeeActivity.class);
                intent.putExtra("id1", id);
                startActivity(intent);
            }
        });

        btn_Option_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDelete(id);
            }
        });

        /*btn_Option_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionAttendeeActivity.this, ViewAttendeeActivity.class);
                startActivity(intent);
            }
        });*/
    }

    void confirmDelete(final String del_id) { // IT19180526
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(OptionAttendeeActivity.this);
                myDB.deleteSingleAttendee(del_id);
                Intent intent = new Intent(OptionAttendeeActivity.this, AttendanceHomeActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.create().show();
    }
}