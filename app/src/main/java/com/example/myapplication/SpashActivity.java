package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Intent i = new Intent(SpashActivity.this, WelcomeActivity.class);
                startActivity(i);
                finish(); } }, 3000);
    }
}
