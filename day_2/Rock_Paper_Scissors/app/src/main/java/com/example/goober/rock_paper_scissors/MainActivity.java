package com.example.goober.rock_paper_scissors;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static com.example.goober.rock_paper_scissors.R.id.welcome;

public class MainActivity extends AppCompatActivity {

    Button rockButton;
    Button paperButton;
    Button scissorsButton;
    TextView welcomeTV;
    TextView instructionTV;
    TextView myScoreTV;
    TextView yourScoreTV;
    Integer myScore;
    Integer yourScore;
    String myScoreStr = "0";
    String yourScoreStr = "0";
    int player;
    int computer;
    ArrayList<Weapons> choices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choices = new ArrayList<>();
        Intent i = getIntent();
        Bundle extras = i.getExtras();

        if (i.hasExtra("myScore")) {

            myScoreStr = extras.getString("myScore");
            yourScoreStr = extras.getString("yourScore");}


            rockButton = (Button) findViewById(R.id.rock);
            paperButton = (Button) findViewById(R.id.paper);
            scissorsButton = (Button) findViewById(R.id.scissors);
            welcomeTV = (TextView) findViewById(R.id.welcome);
            welcomeTV.setText("Welcome to Rock-Paper-Scissors");
            instructionTV = (TextView) findViewById(R.id.instruction);
            instructionTV.setText("Select a weapon below to do battle with me....");
            myScore = Integer.valueOf(myScoreStr);
            yourScore = Integer.valueOf(yourScoreStr);
            myScoreTV = (TextView) findViewById(R.id.comp_score);
            myScoreStr = String.valueOf(myScore);
            myScoreTV.setText(myScoreStr);
            yourScoreTV = (TextView) findViewById(R.id.player_score);
            yourScoreStr = String.valueOf(yourScore);
            yourScoreTV.setText(yourScoreStr);
        }

    public int getRandomNumber() {
        Random rand = new Random();
        int listSize = 3;
        int random = rand.nextInt(listSize);
        return random;
    }

    public int checkWin(){

        computer = getRandomNumber();

        if( player == computer){

            return 3;

        } else {
            if((player == 1 && computer == 3) || (player == 2 && computer == 1) || (player == 3 && computer == 2)) {

                return 1;
            }
        }

        return 2;
    }




    public void onRockButtonClicked(View button) {
        player = 1;
        if(checkWin() == 1) {
            yourScoreStr = String.valueOf(yourScore + 1);
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("result", "You win!!!!");
            i.putExtra("winWeapon", "ROCK");
            i.putExtra("loseWeapon", "SCISSORS");
            i.putExtra("myScore", myScoreStr);
            i.putExtra("yourScore", yourScoreStr);

            startActivity(i);
        } else {
            if(checkWin() == 2) {
                myScoreStr = String.valueOf(myScore + 1);
                Intent i = new Intent(this, ResultActivity.class);
                i.putExtra("result", "Computer wins!!!!");
                i.putExtra("winWeapon", "PAPER");
                i.putExtra("loseWeapon", "ROCK");
                i.putExtra("myScore", myScoreStr);
                i.putExtra("yourScore", yourScoreStr);
                startActivity(i);

            } else {
                Intent i = new Intent(this, ResultActivity.class);
                i.putExtra("result", "It's a Draw");
                i.putExtra("winWeapon", "ROCK");
                i.putExtra("loseWeapon", "ROCK");
                i.putExtra("myScore", myScoreStr);
                i.putExtra("yourScore", yourScoreStr);
                startActivity(i);
            }

        }


    }


    public void onScissorsButtonClicked(View button){

        player = 3;
        if(checkWin() == 1) {
            yourScoreStr = String.valueOf(yourScore + 1);
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("result", "You win!!!!");
            i.putExtra("winWeapon", "SCISSORS");
            i.putExtra("loseWeapon", "PAPER");
            i.putExtra("myScore", myScoreStr);
            i.putExtra("yourScore", yourScoreStr);
            startActivity(i);
        } else {
            if(checkWin() == 2) {
                myScoreStr = String.valueOf(myScore + 1);
                Intent i = new Intent(this, ResultActivity.class);
                i.putExtra("result", "Computer wins!!!!");
                i.putExtra("winWeapon", "ROCK");
                i.putExtra("loseWeapon", "SCISSORS");
                i.putExtra("myScore", myScoreStr);
                i.putExtra("yourScore", yourScoreStr);
                startActivity(i);

            } else {
                Intent i = new Intent(this, ResultActivity.class);
                i.putExtra("result", "It's a Draw");
                i.putExtra("winWeapon", "SCISSORS");
                i.putExtra("loseWeapon", "SCISSORS");
                i.putExtra("myScore", myScoreStr);
                i.putExtra("yourScore", yourScoreStr);
                startActivity(i);
            }

        }
    }

    public void onPaperButtonClicked(View button){

        player = 2;
        if(checkWin() == 1) {
            yourScoreStr = String.valueOf(yourScore + 1);
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("result", "You win!!!!");
            i.putExtra("winWeapon", "PAPER");
            i.putExtra("loseWeapon", "ROCK");
            i.putExtra("myScore", myScoreStr);
            i.putExtra("yourScore", yourScoreStr);
            startActivity(i);
        } else {
            if(checkWin() == 2) {
                myScoreStr = String.valueOf(myScore + 1);
                Intent i = new Intent(this, ResultActivity.class);
                i.putExtra("result", "Computer wins!!!!");
                i.putExtra("winWeapon", "SCISSORS");
                i.putExtra("loseWeapon", "PAPER");
                i.putExtra("myScore", myScoreStr);
                i.putExtra("yourScore", yourScoreStr);
                startActivity(i);

            } else {
                Intent i = new Intent(this, ResultActivity.class);
                i.putExtra("result", "It's a Draw");
                i.putExtra("winWeapon", "PAPER");
                i.putExtra("loseWeapon", "PAPER");
                i.putExtra("myScore", myScoreStr);
                i.putExtra("yourScore", yourScoreStr);
                startActivity(i);
            }

        }

    }


}
