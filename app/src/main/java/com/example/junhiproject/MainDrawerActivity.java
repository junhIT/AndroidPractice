package com.example.junhiproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainDrawerActivity extends AppCompatActivity
implements View.OnClickListener, View.OnTouchListener {

    DrawerLayout drawerLayout;
    Button button1;
    ImageView main_listImage;
    TextView drawerMemo, drawerNoti, drawerEvent, drawerSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer_actvity);



        initialize();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "버튼 1을 클릭했습니다.", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initialize() {
        main_listImage = findViewById(R.id.main_listImage);
        drawerLayout = findViewById(R.id.main_drawer);
        button1 = findViewById(R.id.main_button1);
        drawerMemo = findViewById(R.id.main_DrawerMemo);
        drawerNoti = findViewById(R.id.main_DrawerNoti);
        drawerEvent = findViewById(R.id.main_DrawerEvent);
        drawerSetting = findViewById(R.id.main_DrawerSetting);

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        button1.setOnClickListener(this);

        drawerMemo.setOnClickListener(this);
        drawerNoti.setOnClickListener(this);
        drawerEvent.setOnClickListener(this);
        drawerSetting.setOnClickListener(this);
        main_listImage.setOnClickListener(this);

        main_listImage.setOnTouchListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_DrawerMemo:
                Intent intent = new Intent(getApplicationContext(), MemoMainActivity.class);
                startActivity(intent);
                break;
            case R.id.main_DrawerNoti:
                toast("준비중입니다.");
                break;
            case R.id.main_DrawerEvent:
                toast("준비중입니다.");
                break;
            case R.id.main_DrawerSetting:
                toast("준비중입니다.");
                break;
            case R.id.main_listImage:
                if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    drawerLayout.openDrawer(Gravity.LEFT);
                } else {
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                break;


        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageView view = (ImageView) v;
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            view.setColorFilter(0xaa111111, PorterDuff.Mode.SRC_OVER);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            view.setColorFilter(0x00000000, PorterDuff.Mode.SRC_OVER);
        }
        return false;
    }

    private void toast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            finish();
        }
    }



}
