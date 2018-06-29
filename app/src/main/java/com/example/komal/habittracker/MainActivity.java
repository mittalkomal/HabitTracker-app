package com.example.komal.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;
import com.example.komal.habittracker.data.HabitDbHelper;
import com.example.komal.habittracker.data.HabitContract.HabitEntry;


public class MainActivity extends AppCompatActivity {
    HabitDbHelper mDbHelper = new HabitDbHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView displayView = (TextView) findViewById(R.id.text);

        insertHabitTracker("Reading", 10);
        insertHabitTracker("UdacityCourse", 4);
        Cursor cursor = readHabitTracker();
    }

    public void insertHabitTracker(String habit, int hours) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT, habit);
        values.put(HabitEntry.COLUMN_HOURS, hours);

        db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor readHabitTracker() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT,
                HabitEntry.COLUMN_HOURS
        };
        Cursor cursor = db.query(HabitEntry.TABLE_NAME, projection,
                null, null, null, null, null);
        return cursor;
    }
}
