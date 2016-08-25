package com.example.qklahpita.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Qk Lahpita on 8/23/2016.
 */
public class DatabaseOpenHelper extends SQLiteAssetHelper {
    public static final String DB_NAME = "data.db";

    //increase after change db
    public static final int DB_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
}
