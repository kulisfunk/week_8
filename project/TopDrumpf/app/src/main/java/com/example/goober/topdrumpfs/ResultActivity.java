package com.example.goober.topdrumpfs;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    ImageView winImageIV;
    ImageView loseImageIV;


//    ArrayList<Plane> playerCards;
//    ArrayList<Plane> computerCards;
//    ArrayList<Plane> currentCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        extras = getIntent().getExtras();
        winner = extras.getString("winner");
        loser = extras.getString("loser");
        winAttr = Integer.parseInt(extras.getString("winAttr"));
        loseAttr = Integer.parseInt(extras.getString("loseAttr"));
        choice = extras.getString("choice");
        victor = extras.getString("victor");

        winNameTV = (TextView) findViewById(R.id.win_name);
        winAttrTV = (TextView) findViewById(R.id.win_attr);
        loseNameTV = (TextView) findViewById(R.id.lose_name);
        loseAttrTV = (TextView) findViewById(R.id.lose_attr);

        winImageIV = (ImageView) findViewById(R.id.win_image);
        String winnerImage = winner.toLowerCase();
        Drawable win = getDrawable(getResources().getIdentifier(winnerImage, "drawable", getPackageName()));
        winImageIV.setImageDrawable(win);

        loseImageIV = (ImageView) findViewById(R.id.lose_image);
        String loserImage = loser.toLowerCase();
        Drawable lose = getDrawable(getResources().getIdentifier(loserImage, "drawable", getPackageName()));
        loseImageIV.setImageDrawable(lose);

        winNameTV.setText(victor + " " + winner.toUpperCase());
        winAttrTV.setText("With a " + choice + " of " + winAttr);
        loseNameTV.setText(loser.toUpperCase());
        loseAttrTV.setText(choice + " of " + loseAttr);







    }

    public void onClickContinue(View button){
        Intent i = new Intent(this, PlaneGameActivity.class);
        i.putExtra("game", "false");
        startActivity(i);

    }
}
