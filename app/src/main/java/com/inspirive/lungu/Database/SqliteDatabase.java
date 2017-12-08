package com.inspirive.lungu.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import okhttp3.MediaType;

/**
 * Project: Lungu
 * Script by Williams Abiola on 08/12/2017.
 **/

public class SqliteDatabase extends SQLiteOpenHelper {
    static String API_KEY = "hwir33i5i@iWI823Jhx1";
    static String WEB_SERVICE = "";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "lungu.db";
    static final String TABLE_FAVOURITES = "favorites page";
    static final String COLUMN_ID = "id";
    static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    //TABLE USER DETAILS
    static final String COLUMN_PAGE_ID = "user_id";

    SqliteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FAVOURITES_TABLE = "CREATE TABLE "+TABLE_FAVOURITES+" " + "("
                +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +COLUMN_PAGE_ID+" TEXT)";

        db.execSQL(CREATE_FAVOURITES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE_FAVOURITES = "DROP TABLE IF EXISTS "+TABLE_FAVOURITES;
        db.execSQL(DROP_TABLE_FAVOURITES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}


