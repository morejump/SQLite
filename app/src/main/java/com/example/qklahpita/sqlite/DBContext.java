package com.example.qklahpita.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qk Lahpita on 8/23/2016.
 */
public class DBContext {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

    private DBContext(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }
    // hi hi

    private static DBContext inst;
    public static DBContext getInst(Context context) {
        if (inst == null) {
            inst = new DBContext(context);
        }
        return inst;
    }

    public void openConnection() {
        database = openHelper.getReadableDatabase();
    }

    public void closeConnection() {
        if (database != null) {
            database.close();
        }
    }

    public List<MathWord> getAllMathWord() {
        List<MathWord> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT subject, a, b, c, d FROM mathword", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            List<String> listAnswer = new ArrayList<>();
            String content = cursor.getString(0);
            listAnswer.add(cursor.getString(1));
            listAnswer.add(cursor.getString(2));
            listAnswer.add(cursor.getString(3));
            listAnswer.add(cursor.getString(4));
            list.add(new MathWord(content, listAnswer));

            cursor.moveToNext();
        }
        return list;
    }
}
