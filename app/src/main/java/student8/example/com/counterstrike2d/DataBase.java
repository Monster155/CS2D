package student8.example.com.counterstrike2d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "GameSets";
    public static final String TABLE_NAME = "GameSettings";
    public static final String SETTING = "WhatSetting";
    public static final String PARAMS = "WhatParams";
    public static final int DB_VERSION = 1;

    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + TABLE_NAME + " (" + SETTING + " TEXT, " + PARAMS + " TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int l, int n) {
        db.execSQL("DROP TABLE " + TABLE_NAME + ";");
        onCreate(db);
    }
}
