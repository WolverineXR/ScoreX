package com.example.scorex;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.scorex.data.ScoreContract.ScoreEntry;

public class ScoreCursorAdapter extends CursorAdapter {
    public ScoreCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView game = (TextView) view.findViewById(R.id.game);
        TextView teamA = (TextView) view.findViewById(R.id.teamA);
        TextView teamB = (TextView) view.findViewById(R.id.teamB);

        int gameColumnIndex = cursor.getColumnIndex(ScoreEntry.COLUMN_SCORE_GAME);
        int teamnameAColumnIndex = cursor.getColumnIndex(ScoreEntry.COLUMN_SCORE_TEAMNAME_A);
        int teamscoreAColumnIndex = cursor.getColumnIndex(ScoreEntry.COLUMN_SCORE_TEAMSCORE_A);
        int teamnameBColumnIndex = cursor.getColumnIndex(ScoreEntry.COLUMN_SCORE_TEAMNAME_B);
        int teamscoreBColumnIndex = cursor.getColumnIndex(ScoreEntry.COLUMN_SCORE_TEAMSCORE_B);

        String gameName = cursor.getString(gameColumnIndex);
        String teamnameA = cursor.getString(teamnameAColumnIndex);
        int teamscoreA = cursor.getInt(teamscoreAColumnIndex);
        String teamnameB = cursor.getString(teamnameBColumnIndex);
        int teamscoreB = cursor.getInt(teamscoreBColumnIndex);

        game.setText(gameName);
        teamA.setText(teamnameA + " : " + teamscoreA);
        teamB.setText(teamnameB + " : " + teamscoreB);
    }
}
