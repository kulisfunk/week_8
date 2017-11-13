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

    Bundle extras;
    ArrayList<Plane> playerCards;
    ArrayList<Plane> computerCards;
    ArrayList<Plane> currentHand;
    ArrayList<Plane> pile;
    boolean newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane_game);
        newGame = true;

        Intent i = getIntent();
        Bundle extras = i.getExtras();

//        if (i.hasExtra("playerCards")) {
//
//            playerCards = (ArrayList<Plane>) getIntent().getBundleExtra("arrays").getSerializable("playerCards");
//            computerCards = (ArrayList<Plane>) getIntent().getBundleExtra("arrays").getSerializable("computerCards");
//            currentHand = (ArrayList<Plane>) getIntent().getBundleExtra("arrays").getSerializable("currentCards");
//        }else{
        if(i.hasExtra("game")){
                newGame = extras.getBoolean("game");
            }



        if (newGame == true) {
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


        String name = playerCards.get(0).name;
        String nickname = playerCards.get(0).nickname;
        String year = playerCards.get(0).year;
        String country = playerCards.get(0).plane_country;
        String speed = playerCards.get(0).speed.toString();
        String height = playerCards.get(0).height.toString();
        String range = playerCards.get(0).range.toString();
        String max_takeoff = playerCards.get(0).max_takeoff.toString();
        String wing = playerCards.get(0).wing.toString();
        String firepower = playerCards.get(0).firepower.toString();

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







