package com.example.junhiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MemoDetailActivity extends AppCompatActivity {

    ImageView memoDetailImage;
    TextView memoDetailTitle;
    TextView memoDetailDate;
    TextView memoDetailName;
    TextView memoDetailContent;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_detail);

        init();
        dataInput();

    }

    private void init() {
        memoDetailImage = findViewById(R.id.memoDetail_image);
        memoDetailTitle = findViewById(R.id.memoDetail_title);
        memoDetailDate = findViewById(R.id.memoDetail_date);
        memoDetailName = findViewById(R.id.memoDetail_name);
        memoDetailContent = findViewById(R.id.memoDetail_content);

        intent = getIntent();
    }

    private void dataInput() {
        Integer image = intent.getExtras().getInt(ContactDB.COL_IMG);
        memoDetailImage.setImageResource(this.getResources().getIdentifier("pimg"+image, "drawable", this.getPackageName()));

        String title = intent.getExtras().getString(ContactDB.COL_TITLE);
        memoDetailTitle.setText(title);

        String date = intent.getExtras().getString(ContactDB.COL_DATE);
        memoDetailDate.setText(date);

        String name = intent.getExtras().getString(ContactDB.COL_NAME);
        memoDetailName.setText(name);

        String content = intent.getExtras().getString(ContactDB.COL_CONTENT);
        memoDetailContent.setText(content);

    }

}
