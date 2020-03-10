package com.example.junhiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MemoMainActivity extends AppCompatActivity
implements View.OnClickListener {


    public ArrayList<Dictionary> mArrayList;
    private CustomAdapter mAdapter;
    private FloatingActionButton floatingActionButton;
    private int count = -1;
    private ImageView backImage;
    private RecyclerView mRecyclerview;
    private LinearLayoutManager mLinearLayoutManager;
    private TextView text;
    private Date date;
    Intent intent;


    Dictionary data;
    SimpleDateFormat sdformat;


    ContactDBHelper dbHelper = null;
    SQLiteDatabase db;
    String sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_main);
        Init();

        checkItemCount();
    }

    private void checkItemCount() {
        if(mAdapter.getItemCount()!=0){
            text.setVisibility(View.GONE);
        }else{
            text.setVisibility(View.VISIBLE);
        }
    }

    private void Init() {
        floatingActionButton = (FloatingActionButton) findViewById(R.id.memoMain_button);
        mRecyclerview = (RecyclerView) findViewById(R.id.memoMain_RecyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);

        text = (TextView) findViewById(R.id.memoMain_text);

        backImage = (ImageView)findViewById(R.id.memoMain_back);
        mArrayList = new ArrayList<>();
        mAdapter = new CustomAdapter((mArrayList), this);

        mRecyclerview.setLayoutManager(mLinearLayoutManager);
        mRecyclerview.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerview.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerview.addItemDecoration(dividerItemDecoration);

        floatingActionButton.setOnClickListener(this);
        backImage.setOnClickListener(this);

        mAdapter.setOnItemClickListener(new CustomAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View v, int position) {
                Log.e("MainActivity", "아이템 클릭!"+position+mArrayList.get(position).getName());

                intent = new Intent(getApplicationContext(), MemoDetailActivity.class);

                intent.putExtra(ContactDB.COL_IMG, mArrayList.get(position).getImage());
                intent.putExtra(ContactDB.COL_TITLE, mArrayList.get(position).getTitle());
                intent.putExtra(ContactDB.COL_NAME, mArrayList.get(position).getName());
                intent.putExtra(ContactDB.COL_DATE, mArrayList.get(position).getDate());
                intent.putExtra(ContactDB.COL_CONTENT, mArrayList.get(position).getContent());

                startActivity(intent);


            }
        });





        dbHelper = new ContactDBHelper(this);
        db = dbHelper.getReadableDatabase();


        Cursor cursor = db.rawQuery(ContactDB.SQL_SELECT, null);
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                data = new Dictionary (cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
                mArrayList.add(data);
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.memoMain_button:
                intent = new Intent(getApplicationContext(), MemoRegActivity.class);
                startActivity(intent);
                break;
            case R.id.memoMain_back:
                intent = new Intent(getApplicationContext(), MainDrawerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
