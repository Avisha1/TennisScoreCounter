package com.example.android.tennisscorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import model.Player;

public class MainActivity extends AppCompatActivity {

    private Player playerA;
    private Player playerB;

    //player A
    TextView pointsPlayerA;
    TextView gamesPlayerA;
    TextView setsPlayerA;
    TextView serveFoulsPlayerA;

    //player b
    TextView pointsPlayerB;
    TextView gamesPlayerB;
    TextView setsPlayerB;
    TextView serveFoulsPlayerB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerA = new Player();
        playerB = new Player();

        //Bind player A view.
        pointsPlayerA = (TextView) findViewById(R.id.player_a_points);
        gamesPlayerA = (TextView) findViewById(R.id.player_a_games);
        setsPlayerA = (TextView) findViewById(R.id.player_a_sets);
        serveFoulsPlayerA = (TextView) findViewById(R.id.player_a_serve_fouls);

        //Bind player B view.
        pointsPlayerB = (TextView) findViewById(R.id.player_b_points);
        gamesPlayerB = (TextView) findViewById(R.id.player_b_games);
        setsPlayerB = (TextView) findViewById(R.id.player_b_sets);
        serveFoulsPlayerB = (TextView) findViewById(R.id.player_b_serve_fouls);

        showScoreOnScreen();
    }

    public void addPointPlayerA(View view) {
        playerA.addGamePoint(playerB);
        showScoreOnScreen();
    }

    public void addPointPlayerB(View view) {
        playerB.addGamePoint(playerA);
        showScoreOnScreen();
    }

    public void addServeFoulPlayerA(View view) {
        playerA.addServeFoul(playerB);
        showScoreOnScreen();
    }

    public void addServeFoulPlayerB(View view) {
        playerB.addServeFoul(playerA);
        showScoreOnScreen();
    }

    //After new points\games\sets being added, load the new score on UI.
    public void showScoreOnScreen() {
        pointsPlayerA.setText(playerA.getPointsString());
        gamesPlayerA.setText("games : " + playerA.getGames());
        setsPlayerA.setText("sets : " + playerA.getWonSets());
        serveFoulsPlayerA.setText("serve fouls: " + playerA.getServeFouls());

        pointsPlayerB.setText(playerB.getPointsString());
        gamesPlayerB.setText("games : " + playerB.getGames());
        setsPlayerB.setText("sets : " + playerB.getWonSets());
        serveFoulsPlayerB.setText("serve fouls: " + playerB.getServeFouls());
    }

    public void reset(View view) {
        playerA.reset();
        playerB.reset();

        showScoreOnScreen();
    }
}
