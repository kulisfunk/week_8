package com.example.goober.topdrumpfs;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    TextView countryTV;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane_game);

        DBHelper dbHelper = new DBHelper(this);
        computerCards = new ArrayList<Plane>();

        playerCards = dbHelper.allPlanes();
        Collections.shuffle(playerCards);
        int length = playerCards.size()/2 + (playerCards.size()%2);
        for(int i = 0; i < length; i++){
            computerCards.add(playerCards.remove(i));
        }

        computerCards.size();
        playerCards.size();


//        extras = getIntent().getExtras();
//        String name = extras.getString("name");
//        String nickname = extras.getString("nickname");
//        String year = extras.getString("year");
//        String country = extras.getString("country");
//        String speed = extras.getString("speed");
//        String height = extras.getString("height");
//        String range = extras.getString("range");
//        String max_takeoff = extras.getString("max_takeoff");
//        String wing = extras.getString("wing");
//        String firepower = extras.getString("firepower");

//        nameTV = (TextView)findViewById(R.id.name);
//        nicknameTV = (TextView)findViewById(R.id.nickname);
//        yearTV = (TextView)findViewById(R.id.year);
//        speedTV = (TextView)findViewById(R.id.speed);
//        heightTV = (TextView)findViewById(R.id.height);
//        rangeTV = (TextView)findViewById(R.id.range);
//        max_takeoffTV = (TextView)findViewById(R.id.max_takeoff);
//        wingTV = (TextView)findViewById(R.id.wing);
//        firepowerTV = (TextView)findViewById(R.id.firepower);
//
//        planeImageIV = (ImageView) findViewById(R.id.plane_image);
//        String planeImage = name.toLowerCase();
//        Drawable plane = getDrawable(getResources().getIdentifier(planeImage, "drawable", getPackageName()));
//        planeImageIV.setImageDrawable(plane);
//
//        flagImageIV = (ImageView) findViewById(R.id.flag_image);
//        String flagImage = country.toLowerCase();
//        Drawable flag = getDrawable(getResources().getIdentifier(flagImage, "drawable", getPackageName()));
//        flagImageIV.setImageDrawable(flag);

//        nameTV.setText(name.toUpperCase());
//        nicknameTV.setText(nickname);
//        yearTV.setText(year);
//        speedTV.setText(speed);
//        heightTV.setText(height);
//        rangeTV.setText(range);
//        max_takeoffTV.setText(max_takeoff);
//        wingTV.setText(wing);
//        firepowerTV.setText(firepower);
    }
}
