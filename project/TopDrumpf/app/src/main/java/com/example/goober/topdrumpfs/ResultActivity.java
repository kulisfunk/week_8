package com.example.goober.topdrumpfs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.goober.topdrumpfs.R.id.computer_cards;
import static com.example.goober.topdrumpfs.R.id.computers_cards;
import static com.example.goober.topdrumpfs.R.id.player_cards;

public class ResultActivity extends AppCompatActivity {

    Bundle extras;
    String winner;
    String loser;
    Integer winAttr;
    Integer loseAttr;
    String choice;
    String victor;
    TextView winNameTV;
    TextView loseNameTV;
    TextView winAttrTV;
    TextView loseAttrTV;
    TextView playerCardsTV;
    TextView computerCardsTV;
    ImageView winImageIV;
    ImageView loseImageIV;
    Boolean winStatus;
    String computerTurn;
    String playerCardAmount;
    String computerCardAmount;


    ArrayList<Integer> playerPlanes;
    ArrayList<Integer> computerPlanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        extras = getIntent().getExtras();

        playerPlanes = extras.getIntegerArrayList("playerPlanes");
        computerPlanes = extras.getIntegerArrayList("computerPlanes");


        winner = extras.getString("winner");
        loser = extras.getString("loser");
        winAttr = Integer.parseInt(extras.getString("winAttr"));
        loseAttr = Integer.parseInt(extras.getString("loseAttr"));
        choice = extras.getString("choice");
        victor = extras.getString("victor");
        computerTurn = extras.getString("computerTurn");
        playerCardAmount = Integer.toString(playerPlanes.size());
        computerCardAmount = Integer.toString(computerPlanes.size());

        winNameTV = (TextView) findViewById(R.id.win_name);
        winAttrTV = (TextView) findViewById(R.id.win_attr);
        loseNameTV = (TextView) findViewById(R.id.lose_name);
        loseAttrTV = (TextView) findViewById(R.id.lose_attr);
        playerCardsTV = (TextView) findViewById(player_cards);
        computerCardsTV = (TextView) findViewById(computer_cards);

        winImageIV = (ImageView) findViewById(R.id.win_image);
        String winnerImage = winner.toLowerCase();
        Drawable win = getDrawable(getResources().getIdentifier(winnerImage, "drawable", getPackageName()));
        winImageIV.setImageDrawable(win);

        loseImageIV = (ImageView) findViewById(R.id.lose_image);
        String loserImage = loser.toLowerCase();
        Drawable lose = getDrawable(getResources().getIdentifier(loserImage, "drawable", getPackageName()));
        loseImageIV.setImageDrawable(lose);

        winNameTV.setText(victor + " " + winner.toUpperCase());
        winAttrTV.setText(choice + " " + winAttr);
        loseNameTV.setText(loser.toUpperCase());
        loseAttrTV.setText(choice + " " + loseAttr);
        playerCardsTV.setText(playerCardAmount);
        computerCardsTV.setText(computerCardAmount);








    }

    public void onClickContinue(View button){
        winCheck();
        if (winStatus) {
            winner();
            Intent i = new Intent(this, WinnerActivity.class);
            i.putExtra("winner", winner);
            startActivity(i);
        }else {

            Intent i = new Intent(this, PlaneGameActivity.class);
            i.putExtra("game", "false");
            i.putExtra("playerPlanes", playerPlanes);
            i.putExtra("computerPlanes", computerPlanes);
            i.putExtra("computerTurn", computerTurn);
            startActivity(i);
        }

    }

    public void onClickExit(View button) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void winCheck(){
        if ((playerPlanes.size() == 32) || (computerPlanes.size() == 32)){
            winStatus = true;
        }
        else {
            winStatus = false;
        }
    }

    public void winner(){
        if (playerPlanes.size() == 32){
            winner = "You";
        }
        else {
            winner = "Phone";
        }
    }

}
