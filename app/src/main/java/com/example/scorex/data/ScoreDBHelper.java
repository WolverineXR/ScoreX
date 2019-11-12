package com.example.scorex.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ScoreDBHelper extends SQLiteOpenHelper {
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ", ";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ScoreContract.ScoreEntry.TABLE_NAME + " (" +
            ScoreContract.ScoreEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
            ScoreContract.ScoreEntry.COLUMN_SCORE_TEAMNAME_A + TEXT_TYPE + COMMA_SEP +
            ScoreContract.ScoreEntry.COLUMN_SCORE_TEAMSCORE_A + INTEGER_TYPE + COMMA_SEP +
            ScoreContract.ScoreEntry.COLUMN_SCORE_TEAMNAME_B + TEXT_TYPE + COMMA_SEP +
            ScoreContract.ScoreEntry.COLUMN_SCORE_TEAMSCORE_B + INTEGER_TYPE + ")";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ScoreContract.ScoreEntry.TABLE_NAME;


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "score.db";
    public ScoreDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }
}
