package com.example.scorex;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scorex.data.ScoreContract.ScoreEntry;

public class Basketball extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);
    }

    public void AddThreeToTeamA(View view){
        scoreA += 3;
        displayA();
    }

    public void AddTwoToTeamA(View view){
        scoreA += 2;
        displayA();
    }

    public void AddOneToTeamA(View view){
        scoreA += 1;
        displayA();
    }

    public void AddThreeToTeamB(View view){
        scoreB += 3;
        displayB();

    }

    public void AddTwoToTeamB(View view){
        scoreB += 2;
        displayB();
    }

    public void AddOneToTeamB(View view){
        scoreB += 1;
        displayB();
    }

    public void displayA(){
        TextView teamATextView = (TextView) findViewById(R.id.teamA_text_view);
        teamATextView.setText("" + scoreA);
    }

    public void displayB(){
        TextView teamBTextView = (TextView) findViewById(R.id.teamB_text_view);
        teamBTextView.setText("" + scoreB);
    }

    public void saveScore(View view){
        String teamnameA = ((EditText) findViewById(R.id.basket_team_A)).getText().toString();
        String teamnameB = ((EditText) findViewById(R.id.basket_team_B)).getText().toString();

        ContentValues values = new ContentValues();
        values.put(ScoreEntry.COLUMN_SCORE_TEAMNAME_A, teamnameA);
        values.put(ScoreEntry.COLUMN_SCORE_TEAMSCORE_A, scoreA);
        values.put(ScoreEntry.COLUMN_SCORE_TEAMNAME_B, teamnameB);
        values.put(ScoreEntry.COLUMN_SCORE_TEAMSCORE_B, scoreB);
        Uri newUri = getContentResolver().insert(ScoreEntry.CONTENT_URI, values);
        if(newUri == null)
            Toast.makeText(this, "Score insertion failed", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Score insertion successful", Toast.LENGTH_SHORT).show();
    }

    public void resetScore(View view){
        scoreA = 0;
        scoreB = 0;
        displayA();
        displayB();
    }
}
