package com.example.scorex;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.scorex.data.ScoreContract;

public class ScoreCursorAdapter extends CursorAdapter {
    public ScoreCursorAdapter(Context context, Cursor c){
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView teamname_A = (TextView) view.findViewById(R.id.teamname_A);
        TextView teamscore_A = (TextView) view.findViewById(R.id.teamscore_A);
        TextView teamname_B = (TextView) view.findViewById(R.id.teamname_B);
        TextView teamscore_B = (TextView) view.findViewById(R.id.teamscore_B);

        int teamnameAColumnIndex = cursor.getColumnIndex(ScoreContract.ScoreEntry.COLUMN_SCORE_TEAMNAME_A);
        int teamscoreAColumnIndex = cursor.getColumnIndex(ScoreContract.ScoreEntry.COLUMN_SCORE_TEAMSCORE_A);
        int teamnameBColumnIndex = cursor.getColumnIndex(ScoreContract.ScoreEntry.COLUMN_SCORE_TEAMNAME_B);
        int teamscoreBColumnIndex = cursor.getColumnIndex(ScoreContract.ScoreEntry.COLUMN_SCORE_TEAMSCORE_B);

        String teamnameA = cursor.getString(teamnameAColumnIndex);
        int teamscoreA = cursor.getInt(teamscoreAColumnIndex);
        String teamnameB = cursor.getString(teamnameBColumnIndex);
        int teamscoreB = cursor.getInt(teamscoreBColumnIndex);

        teamname_A.setText(teamnameA);
        teamscore_A.setText("" + teamscoreA);
        teamname_B.setText(teamnameB);
        teamscore_B.setText("" + teamscoreB);
    }
}
