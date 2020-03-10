package com.example.junhiproject;

public class ContactDB {

    private ContactDB() {};

    public static final String TBL_CONTACT = "ANDROIDB";

    public static final String COL_NO = "NO";
    public static final String COL_IMG = "IMG";
    public static final String COL_TITLE = "TITLE";
    public static final String COL_NAME = "NAME";
    public static final String COL_DATE = "DATE";
    public static final String COL_CONTENT = "CONTENT";

    //CREATE TABLE ANDROIDB
    public static final String SQL_CREATE_TBL = "CREATE TABLE IF NOT EXISTS " + TBL_CONTACT + " " +
            "(" +
                COL_NO      +   " INTEGER PRIMARY KEY AUTOINCREMENT "+ ", " +
                COL_IMG     +   " INTEGER"                                    + ", " +
                COL_TITLE   +   " TEXT"                                       + ", " +
                COL_NAME    +   " TEXT"                                       + ", " +
                COL_DATE    +   " TEXT"                                       + ", " +
                COL_CONTENT +   " TEXT"                                       +
            ");" ;

    //DROP TABLE ANDROIDB
    public static final String SQL_DROP_TBL = "DROP TABLE IF EXISTS " + TBL_CONTACT;

    //SELECT * FROM ANDROIDB
    public static final String SQL_SELECT = "SELECT * FROM " + TBL_CONTACT;

    //INSERT
    public static final String SQL_INSERT = "INSERT INTO " + TBL_CONTACT + " " + "("
            + COL_IMG + ", " + COL_TITLE + ", " + COL_NAME + ", " + COL_DATE + ", " + COL_CONTENT + ") VALUES ";


}
