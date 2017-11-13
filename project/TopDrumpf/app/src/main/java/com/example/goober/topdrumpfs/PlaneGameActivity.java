package com.example.goober.topdrumpfs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.R.attr.country;
import static android.R.attr.x;
import static android.media.CamcorderProfile.get;
import static com.example.goober.topdrumpfs.R.id.firepower;
import static com.example.goober.topdrumpfs.R.id.max_takeoff;
import static com.example.goober.topdrumpfs.R.id.wing;

public class PlaneGameActivity extends AppCompatActivity {

    TextView nameTV;
    TextView nicknameTV;
    TextView yearTV;
    TextView speedTV;
    TextView heightTV;
    TextView rangeTV;
    TextView max_takeoffTV;
    TextView wingTV;
    TextView firepowerTV;
    ImageView planeImageIV;
    ImageView flagImageIV;
    String winner;
    String loser;
    String winAttr;
    String loseAttr;
    String victor;


    Bundle extras;
    ArrayList<Plane> playerCards;
    ArrayList<Plane> computerCards;
    ArrayList<Plane> currentHand;
    ArrayList<Plane> pile;
    String newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane_game);

        Intent i = getIntent();
        Bundle extras = i.getExtras();


        if(i.hasExtra("game")){
                newGame = extras.getString("game");
            }



        if (newGame.equals("true")) {
            DBHelper dbHelper = new DBHelper(this);
            computerCards = new ArrayList<>();
            currentHand = new ArrayList<>();
            pile = new ArrayList<>();
            playerCards = dbHelper.allPlanes();
            Collections.shuffle(playerCards);
            int length = playerCards.size() / 2 + (playerCards.size() % 2);
            for (int count = 0; count < length; count++) {
                computerCards.add(playerCards.remove(count));
            }
        }
        currentHand.add(pickPlayerCard());
        currentHand.add(pickComputerCard());


        String name = currentHand.get(0).name;
        String nickname = currentHand.get(0).nickname;
        String year = currentHand.get(0).year;
        String country = currentHand.get(0).plane_country;
        String speed = currentHand.get(0).speed.toString();
        String height = currentHand.get(0).height.toString();
        String range = currentHand.get(0).range.toString();
        String max_takeoff = currentHand.get(0).max_takeoff.toString();
        String wing = currentHand.get(0).wing.toString();
        String firepower = currentHand.get(0).firepower.toString();

        nameTV = (TextView) findViewById(R.id.name);
        nicknameTV = (TextView) findViewById(R.id.nickname);
        yearTV = (TextView) findViewById(R.id.year);
        speedTV = (TextView) findViewById(R.id.speed);
        heightTV = (TextView) findViewById(R.id.height);
        rangeTV = (TextView) findViewById(R.id.range);
        max_takeoffTV = (TextView) findViewById(R.id.max_takeoff);
        wingTV = (TextView) findViewById(R.id.wing);
        firepowerTV = (TextView) findViewById(R.id.firepower);

        planeImageIV = (ImageView) findViewById(R.id.plane_image);
        String planeImage = name.toLowerCase();
        Drawable plane = getDrawable(getResources().getIdentifier(planeImage, "drawable", getPackageName()));
        planeImageIV.setImageDrawable(plane);

        flagImageIV = (ImageView) findViewById(R.id.flag_image);
        String flagImage = country.toLowerCase();
        Drawable flag = getDrawable(getResources().getIdentifier(flagImage, "drawable", getPackageName()));
        flagImageIV.setImageDrawable(flag);

        nameTV.setText(name.toUpperCase());
        nicknameTV.setText(nickname);
        yearTV.setText(year);
        speedTV.setText(speed);
        heightTV.setText(height);
        rangeTV.setText(range);
        max_takeoffTV.setText(max_takeoff);
        wingTV.setText(wing);
        firepowerTV.setText(firepower);


    }

    public Plane pickPlayerCard(){
        if (playerCards.size() > 0);
        Plane currentCard = (Plane) playerCards.remove(0);
            playerCards.size();
            return currentCard;
        }

    public Plane pickComputerCard(){
        if (computerCards.size() > 0);
        Plane currentCard = (Plane) computerCards.remove(0);
        computerCards.size();
        return currentCard;
    }

    public void onClickButtonSpeed(View button){

        if (currentHand.get(0).speed > currentHand.get(1).speed){
            winner = currentHand.get(0).name;
            loser = currentHand.get(1).name;
            winAttr = currentHand.get(0).speed.toString();
            loseAttr = currentHand.get(1).speed.toString();

            playerCards.addAll(currentHand);
            currentHand.clear();
            victor = "Your ";

        }else{
            winner = currentHand.get(1).name;
            loser = currentHand.get(0).name;
            winAttr = currentHand.get(1).speed.toString();
            loseAttr = currentHand.get(0).speed.toString();
            computerCards.addAll(currentHand);
            currentHand.clear();
            victor = "Computer's ";
        }
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("winner", winner);
        i.putExtra("loser", loser);
        i.putExtra("winAttr", winAttr);
        i.putExtra("loseAttr", loseAttr);
        i.putExtra("choice", "speed");
        i.putExtra("victor", victor);
        startActivity(i);

    }

    public void onClickButtonRange(View button){

        if (currentHand.get(0).range > currentHand.get(1).range){
            String winner = currentHand.get(0).name;
            String loser = currentHand.get(1).name;
            playerCards.addAll(currentHand);
            currentHand.clear();

        }else{
            String winner = currentHand.get(1).name;
            String loser = currentHand.get(0).name;
            computerCards.addAll(currentHand);
            currentHand.clear();
        }
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("winner", winner);
        i.putExtra("loser", loser);
        startActivity(i);

    }

    public void onClickButtonHeight(View button){

        if (currentHand.get(0).height > currentHand.get(1).height){
            winner = currentHand.get(0).name;
            loser = currentHand.get(1).name;
            playerCards.addAll(currentHand);
            currentHand.clear();

        }else{
            winner = currentHand.get(1).name;
            loser = currentHand.get(0).name;
            computerCards.addAll(currentHand);
            currentHand.clear();
        }
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("winner", winner);
        i.putExtra("loser", loser);
        startActivity(i);

    }

    public void onClickButtonTakeoff(View button){
        if (currentHand.get(0).max_takeoff > currentHand.get(1).max_takeoff){
            String winner = currentHand.get(0).name;
            String loser = currentHand.get(1).name;
            playerCards.addAll(currentHand);
            currentHand.clear();

        }else{
            String winner = currentHand.get(1).name;
            String loser = currentHand.get(0).name;
            computerCards.addAll(currentHand);
            currentHand.clear();
        }
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("winner", winner);
        i.putExtra("loser", loser);
        startActivity(i);

    }

    public void onClickButtonWing(View button){
        if (currentHand.get(0).wing > currentHand.get(1).wing){
            String winner = currentHand.get(0).name;
            String loser = currentHand.get(1).name;
            playerCards.addAll(currentHand);
            currentHand.clear();

        }else{
            String winner = currentHand.get(1).name;
            String loser = currentHand.get(0).name;
            computerCards.addAll(currentHand);
            currentHand.clear();
        }
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("winner", winner);
        i.putExtra("loser", loser);
        startActivity(i);

    }

    public void onClickButtonFirepower(View button){
        if (currentHand.get(0).firepower > currentHand.get(1).firepower){
            String winner = currentHand.get(0).name;
            String loser = currentHand.get(1).name;
            playerCards.addAll(currentHand);
            currentHand.clear();

        }else{
            String winner = currentHand.get(1).name;
            String loser = currentHand.get(0).name;
            computerCards.addAll(currentHand);
            currentHand.clear();
        }
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("winner", winner);
        i.putExtra("loser", loser);
        startActivity(i);

    }
}







