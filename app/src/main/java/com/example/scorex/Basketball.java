package com.example.scorex;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    public void resetScore(View view){
        scoreA = 0;
        scoreB = 0;
        displayA();
        displayB();
    }
}
