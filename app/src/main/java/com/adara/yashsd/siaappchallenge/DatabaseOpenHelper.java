package com.adara.yashsd.siaappchallenge;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {

    private static final String DATABSE_NAME = "SoundClipsDataBase.db";
    private static final int DATABSE_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context,DATABSE_NAME, null, DATABSE_VERSION);
    }
}
