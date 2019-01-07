package com.mucha.kamil.myfirstapplication;

import android.provider.BaseColumns;

public final class DbContract {
    private DbContract(){}

    public static class FeedHistory implements BaseColumns {
        public static final String TABLE_NAME = "history";
        public static final String COLUMN_NAME_DATA = "data";
        public static final String ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
        public static final String DESCRIPTION_OPTIONS = "TEXT NOT NULL";
    }

}
