package com.example.administrator.datacan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 11/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CanPath.db";
    public static final String TABLE_NAME = "can_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";


    public DatabaseHelper(Context context, ) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_1 + " TEXT, " + COL_2 + " INTEGER, "
                + COL_3 + " INTEGER);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_1 + ", " + COL_2
                + ", " + COL_3 + ") VALUES ('Chocolate Fudge', 95, 750);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
