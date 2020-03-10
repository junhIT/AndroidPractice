package com.example.junhiproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactDBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 3;
    public static final String DBFILE_CONTACT = "junhi.db";

    public ContactDBHelper(Context context) {
        super(context, DBFILE_CONTACT, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ContactDB.SQL_CREATE_TBL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);
    }

    public void onDelete(SQLiteDatabase db) {
        db.execSQL(ContactDB.SQL_DROP_TBL);
    }
}
