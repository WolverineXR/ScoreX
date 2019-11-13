package com.example.scorex.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class ScoreContract {
    private ScoreContract() {
    }

    public static final String CONTENT_AUTHORITY = "com.example.scorex";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_score = "score";

    public static final class ScoreEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_score);

        public static final String TABLE_NAME = "score";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE_GAME = "game";
        public static final String COLUMN_SCORE_TEAMNAME_A = "teamname_A";
        public static final String COLUMN_SCORE_TEAMSCORE_A = "teamscore_A";
        public static final String COLUMN_SCORE_TEAMNAME_B = "teamname_B";
        public static final String COLUMN_SCORE_TEAMSCORE_B = "teamscore_B";

        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_score;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_score;


    }

}
