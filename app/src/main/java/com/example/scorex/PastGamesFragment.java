package com.example.scorex;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.scorex.data.ScoreContract.ScoreEntry;

public class PastGamesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_past_games, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        String[] projections = {ScoreEntry._ID,
                ScoreEntry.COLUMN_SCORE_GAME,
                ScoreEntry.COLUMN_SCORE_TEAMNAME_A,
                ScoreEntry.COLUMN_SCORE_TEAMSCORE_A,
                ScoreEntry.COLUMN_SCORE_TEAMNAME_B,
                ScoreEntry.COLUMN_SCORE_TEAMSCORE_B};
        Cursor cursor = getActivity().getContentResolver().query(ScoreEntry.CONTENT_URI, projections, null, null, null);
        ListView listView = (ListView) getActivity().findViewById(R.id.listview);
        ScoreCursorAdapter adapter = new ScoreCursorAdapter(getActivity(), cursor);
        listView.setAdapter(adapter);
    }
}
