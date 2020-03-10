package com.example.junhiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainDrawerActivity.class);
                //Intent intent = new Intent(getApplicationContext(), MemoMainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    protected void onPause(){
        super.onPause();
        finish();
    }

    public void onBackPressed(){
    }
}
