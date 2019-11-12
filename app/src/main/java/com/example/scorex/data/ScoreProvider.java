package com.example.scorex.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.scorex.data.ScoreContract.ScoreEntry;

public class ScoreProvider extends ContentProvider {
    public static final String LOG_TAG = ScoreProvider.class.getSimpleName();
    private  ScoreDBHelper mDBHelper;

    private static final int SCORES = 100;
    private static final int SCORE_ID = 101;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(ScoreContract.CONTENT_AUTHORITY, ScoreContract.PATH_score, SCORES);
        sUriMatcher.addURI(ScoreContract.CONTENT_AUTHORITY, ScoreContract.PATH_score+"/#", SCORE_ID);
    }

    @Override
    public boolean onCreate() {
        mDBHelper = new ScoreDBHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database = mDBHelper.getReadableDatabase();
        Cursor cursor = null;
        int match = sUriMatcher.match(uri);
        switch(match){
            case SCORES:
                cursor = database.query(ScoreEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case SCORE_ID:
                selection = ScoreEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(ScoreEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query Unknown URI " + uri);
        }
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        int match = sUriMatcher.match(uri);
        switch(match){
            case SCORES:
                return ScoreEntry.CONTENT_LIST_TYPE;
            case SCORE_ID:
                return ScoreEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri + " with match " + match);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        final int match = sUriMatcher.match(uri);
        switch(match){
            case SCORES:
                return insertScore(uri, values);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }
    private Uri insertScore(Uri uri, ContentValues values){

        SQLiteDatabase database = mDBHelper.getWritableDatabase();
        long id = database.insert(ScoreEntry.TABLE_NAME, null, values);
        if(id == -1){
            Log.e(LOG_TAG, "Failed to insert row for " + uri);
            return null;
        }
        return ContentUris.withAppendedId(uri, id);
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase database = mDBHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        switch (match){
            case SCORES:
                return database.delete(ScoreEntry.TABLE_NAME, selection, selectionArgs);
            case SCORE_ID:
                selection = ScoreEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return database.delete(ScoreEntry.TABLE_NAME, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Deletion is not supported for " + uri);
        }
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
        final int match = sUriMatcher.match(uri);
        switch (match){
            case SCORES:
                return updateScore(uri, contentValues, selection, selectionArgs);
            case SCORE_ID:
                selection = ScoreEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return updateScore(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Update is not supported for " + uri);
        }
    }
    private int updateScore(Uri uri, ContentValues values, String selection, String[] selectionArgs){
        if(values.size() == 0)
            return 0;
        SQLiteDatabase database = mDBHelper.getWritableDatabase();
        return database.update(ScoreEntry.TABLE_NAME, values, selection, selectionArgs);
    }
}
