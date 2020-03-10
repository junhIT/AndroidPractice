package com.example.junhiproject;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PopupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_popup);

        Button popup_buttonYes = findViewById(R.id.popup_buttonYes);
        Button popup_buttonNo = findViewById(R.id.popup_buttonNo);

        popup_buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        popup_buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                return;
            }
        });
    }

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()== MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return false;
    }

    public void onBackPressed(){
        return;
    }
}
