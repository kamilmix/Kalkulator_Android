package com.mucha.kamil.myfirstapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Database";
    private static final String TABLE_NAME = "history";

    private static final String COLUMN_NAME_DATA = "data";
    public static final String KEY_ID = "_id";
    public static final String ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final String DESCRIPTION_OPTIONS = "TEXT NOT NULL";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "( " +
                    KEY_ID + " " + ID_OPTIONS + ", " +
                    COLUMN_NAME_DATA + " " + DESCRIPTION_OPTIONS +
                    ");";

    private static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        db.execSQL(CREATE_TABLE);
    }

    public void addValue(String string){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_DATA,string);
        db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<String> getAllToArray() {
      ArrayList<String> list = new ArrayList<>();

      String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        while(cursor.moveToNext()) {

            list.add(cursor.getString(1));
        }
        cursor.close();

        return list;

    }



}
