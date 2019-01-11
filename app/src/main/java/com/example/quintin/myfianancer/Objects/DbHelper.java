package com.example.quintin.myfianancer.Objects;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "financecheckbook.db";
    public static final String TABLE_NAME = "Expenses";
    public static final String ITEM_ID = "ID";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "PRICE";
    public static final String COL_3 = "DATE";

    public DbHelper(Context context) {
        super(context, DBNAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
            " (ITEM_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NAME TEXT, " +
            "PRICE INTEGER, " +
            "DATE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, int price, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, name);
        cv.put(COL_2, price);
        cv.put(COL_3, date);

        long retVal = db.insert(TABLE_NAME, null, cv);
        if(retVal == -1) {
            return false; // insertion into db failed
        }
         return true; // insertion successful
    }
}
