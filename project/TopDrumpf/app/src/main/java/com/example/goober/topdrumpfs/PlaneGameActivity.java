package com.example.goober.topdrumpfs;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.goober.topdrumpfs.R.id.computers_cards;
import static com.example.goober.topdrumpfs.R.id.player_cards;


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
    TextView playerCardsTV;
    TextView computerCardTV;
    String winner;
    String loser;
    String winAttr;
    String loseAttr;
    String victor;
    String playerCardAmount;
    String computerCardAmount;
    String choice;
    String pack;


    Bundle extras;
    ArrayList<Integer> playerCards;
    ArrayList<Integer> computerCards;
    ArrayList<Plane> currentHand;
    ArrayList<Integer> currentIds;
    String computerTurn;

    String newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane_game);
        computerTurn = "false";
        Intent i = getIntent();
        extras = i.getExtras();
        currentHand = new ArrayList<>();
        currentIds = new ArrayList<>();


        if(i.hasExtra("game")){
            newGame = extras.getString("game");

        }



        if (newGame.equals("true")) {
            DBHelper dbHelper = new DBHelper(this);
            computerCards = new ArrayList<>();
            currentHand = new ArrayList<>();
            playerCards = dbHelper.allPlanesToIds();

            Collections.shuffle(playerCards);
            int length = playerCards.size() / 2 + (playerCards.size() % 2);
            for (int count = 0; count < length; count++) {
                computerCards.add(playerCards.remove(count));
            }
            playerCardAmount = Integer.toString(playerCards.size());
            computerCardAmount = Integer.toString(computerCards.size());
        }


        if (i.hasExtra("playerCards")) {

            playerCards = new ArrayList<>();
            computerCards = new ArrayList<>();

            playerCards = extras.getIntegerArrayList("playerCards");
            computerCards = extras.getIntegerArrayList("computerCards");
            playerCardAmount = Integer.toString(playerCards.size());
            computerCardAmount = Integer.toString(computerCards.size());
            computerTurn = extras.getString("computerTurn");





        }

        pickPlayerCard();
        pickComputerCard();
        recoverCurrentCards();

        if (computerTurn.equals("true")) {
            Integer index = currentHand.get(1).weight1;
            if (index == 1) {
                speedResult();
                displayWin();
            } else if (index == 2) {
                heightResult();
                displayWin();
            } else if (index == 3) {
                rangeResult();
                displayWin();
            } else if (index == 4) {
                takeoffResult();
                displayWin();
            } else if (index == 5) {
                wingResult();
                displayWin();
            } else if (index == 6) {
                firepowerResult();
                displayWin();
            }
        }else{

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
            playerCardsTV = (TextView) findViewById(player_cards);
            computerCardTV = (TextView) findViewById(computers_cards);

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
            playerCardsTV.setText(playerCardAmount);
            computerCardTV.setText(computerCardAmount);
        }
    }


    public void recoverCurrentCards(){
        for (Integer index = 0; index < currentIds.size(); index++) {
            DBHelper db = new DBHelper(this);
            Integer selector = currentIds.get(index);

            Plane single = db.singlePlane(selector).remove(0);
            currentHand.add(single);
        }
    }


    public void pickPlayerCard(){
        if (playerCards.size() > 0) {
            currentIds.add(playerCards.remove(0));
        }
    }

    public void pickComputerCard() {
        if (computerCards.size() > 0){
        currentIds.add(computerCards.remove(0));
        }
    }

    public void preparePlayerWin(){
            winner = currentHand.get(0).name;
            loser = currentHand.get(1).name;
            playerCards.addAll(currentIds);
            currentHand.clear();
            victor = "Your ";
            computerTurn = "false";
    }

    public void prepareComputerWin(){

            winner = currentHand.get(1).name;
            loser = currentHand.get(0).name;
            computerCards.addAll(currentIds);
            currentHand.clear();
            victor = "Computer's";
            computerTurn = "true";
        }



    public void displayWin(){
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("playerCards", playerCards);
        i.putExtra("computerCards", computerCards);
        i.putExtra("winner", winner);
        i.putExtra("loser", loser);
        i.putExtra("winAttr", winAttr);
        i.putExtra("loseAttr", loseAttr);
        i.putExtra("choice", choice);
        i.putExtra("victor", victor);
        i.putExtra("computerTurn", computerTurn);
        startActivity(i);
    }


    public void speedResult(){
        choice = "Speed";
        if (currentHand.get(0).speed > currentHand.get(1).speed){
            winAttr = currentHand.get(0).speed.toString();
            loseAttr = currentHand.get(1).speed.toString();
            preparePlayerWin();
        }else {
            winAttr = currentHand.get(1).speed.toString();
            loseAttr = currentHand.get(0).speed.toString();
            prepareComputerWin();
        }
    }

    public void rangeResult(){
        choice = "Range";
        if (currentHand.get(0).range > currentHand.get(1).range){
            winAttr = currentHand.get(0).range.toString();
            loseAttr = currentHand.get(1).range.toString();
            preparePlayerWin();
        }else {
            winAttr = currentHand.get(1).range.toString();
            loseAttr = currentHand.get(0).range.toString();
            prepareComputerWin();
        }
    }

    public void heightResult(){
        choice = "Height";
        if (currentHand.get(0).height > currentHand.get(1).height){
            winAttr = currentHand.get(0).height.toString();
            loseAttr = currentHand.get(1).height.toString();
            preparePlayerWin();
        }else {
            winAttr = currentHand.get(1).height.toString();
            loseAttr = currentHand.get(0).height.toString();
            prepareComputerWin();
        }
    }

    public void takeoffResult(){
        choice = "Max Takeoff";
        if (currentHand.get(0).max_takeoff > currentHand.get(1).max_takeoff){
            winAttr = currentHand.get(0).max_takeoff.toString();
            loseAttr = currentHand.get(1).max_takeoff.toString();
            preparePlayerWin();
        }else {
            winAttr = currentHand.get(1).max_takeoff.toString();
            loseAttr = currentHand.get(0).max_takeoff.toString();
            prepareComputerWin();
        }
    }

    public void wingResult(){
        choice = "Wing Span";
        if (currentHand.get(0).wing > currentHand.get(1).wing){
            winAttr = currentHand.get(0).wing.toString();
            loseAttr = currentHand.get(1).wing.toString();
            preparePlayerWin();
        }else {
            winAttr = currentHand.get(1).wing.toString();
            loseAttr = currentHand.get(0).wing.toString();
            prepareComputerWin();
        }
    }

    public void firepowerResult(){
        choice = "Firepower";
        if (currentHand.get(0).firepower > currentHand.get(1).firepower){
            winAttr = currentHand.get(0).firepower.toString();
            loseAttr = currentHand.get(1).firepower.toString();
            preparePlayerWin();
        }else {
            winAttr = currentHand.get(1).firepower.toString();
            loseAttr = currentHand.get(0).firepower.toString();
            prepareComputerWin();
        }
    }

    public void onClickButton(View button){
        switch (button.getId()) {
            case R.id.button1:
                speedResult();
                displayWin();
                break;
            case R.id.button2:
                rangeResult();
                displayWin();
                break;
            case R.id.button3:
                heightResult();
                displayWin();
                break;
            case R.id.button4:
                takeoffResult();
                displayWin();
                break;
            case R.id.button5:
                wingResult();
                displayWin();
                break;
            case R.id.button6:
                firepowerResult();
                displayWin();
                break;
        }
    }
}






