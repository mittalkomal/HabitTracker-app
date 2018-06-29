package com.example.komal.habittracker.data;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.komal.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by Komal on 14-04-2018.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habit.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TRACKING_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME +
                "(" + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HabitEntry.COLUMN_HABIT + " STRING NOT NULL," +
                HabitEntry.COLUMN_HOURS + " INT NOT NULL);";

        db.execSQL(TRACKING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}

