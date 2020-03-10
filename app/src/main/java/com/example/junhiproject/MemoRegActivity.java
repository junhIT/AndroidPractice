package com.example.junhiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MemoRegActivity extends AppCompatActivity
implements View.OnClickListener{

    EditText memoRegTitleEdit;
    EditText memoRegNameEdit;
    EditText memoRegContentEdit;
    Intent intent;
    Date CurrentTime;
    ImageView memoRegBack;
    Button memoRegButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_reg);
        Log.e("MemoRegActivity", "OnCreate");

        Init();
    }

    private void Init() {
        Log.e("MemoRegActivity", "InIt");
        memoRegTitleEdit = findViewById(R.id.memoReg_titleEdit);
        memoRegNameEdit = findViewById(R.id.memoReg_nameEdit);
        memoRegContentEdit = findViewById(R.id.memoReg_contentEdit);

        memoRegBack = findViewById(R.id.memoReg_back);
        memoRegButton = findViewById(R.id.memoReg_button);

        memoRegBack.setOnClickListener(this);
        memoRegButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.e("MemoRegActivity", "onClick");
        switch (v.getId()){
            case R.id.memoReg_back:
                intent = new Intent(getApplicationContext(), MemoMainActivity.class);
                startActivity(intent);
                break;
            case R.id.memoReg_button:
                if(memoRegNameEdit.getText().length()<=0 || memoRegTitleEdit.getText().length()<=0 || memoRegContentEdit.getText().length()<=0 )
                {
                    Toast.makeText(getApplicationContext(), "내용을 입력하세요", Toast.LENGTH_SHORT).show();
                }else{
                    ContactDBHelper dbHelper = new ContactDBHelper(this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    CurrentTime = Calendar.getInstance().getTime();

                    db.execSQL(ContactDB.SQL_INSERT
                            +"( 3, "
                            +"'" + memoRegTitleEdit.getText() + "',"
                            +"'" + memoRegNameEdit.getText() + "',"
                            +"'" + CurrentTime.toString()    + "',"
                            +"'" + memoRegContentEdit.getText() + "'"
                            +");");
                }

                intent = new Intent(getApplicationContext(), MemoMainActivity.class);
                startActivity(intent);

                break;
        }
    }
}
