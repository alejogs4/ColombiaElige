package com.app.web.ags.colombiaelige.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, SqlConstants.DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SqlConstants.VOTERS_TABLE);
        db.execSQL(SqlConstants.CANDIDATES_TABLE);
        db.execSQL(SqlConstants.VOTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SqlConstants.DROP_DATABASE);
        this.onCreate(db);
    }
}
