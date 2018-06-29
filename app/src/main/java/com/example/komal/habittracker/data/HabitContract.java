package com.example.komal.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Komal on 14-04-2018.
 */

public final class HabitContract {

    private HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habits";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT = "nameOfHabit";
        public final static String COLUMN_HOURS ="Hours";

    }
}
