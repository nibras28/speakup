package com.example.proto2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final long SPLASH_SCREEN_TIMEOUT = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a Handler object to delay the start of the NextActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create the Intent to start the NextActivity
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);

                // Finish the MainActivity
                finish();
            }
        }, SPLASH_SCREEN_TIMEOUT);
    }
}
