package com.androx.attendee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMEOUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentHome = new Intent(MainActivity.this, HomepageActivity.class);
                startActivity(intentHome);
                finish();
            }
        },SPLASH_TIMEOUT);
    }
}