package com.example.scorex;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.scorex.data.ScoreContract.ScoreEntry;

public class PastGamesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.activity_past_games, container, false);
        String[] projections = {ScoreEntry._ID,
                ScoreEntry.COLUMN_SCORE_TEAMNAME_A,
                ScoreEntry.COLUMN_SCORE_TEAMSCORE_A,
                ScoreEntry.COLUMN_SCORE_TEAMNAME_B,
                ScoreEntry.COLUMN_SCORE_TEAMSCORE_B};
        Cursor cursor = getContext().getContentResolver().query(ScoreEntry.CONTENT_URI, projections, null, null, null);
        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        ScoreCursorAdapter adapter = new ScoreCursorAdapter(getContext(), cursor);
        listView.setAdapter(adapter);
        return rootView;
    }

}
