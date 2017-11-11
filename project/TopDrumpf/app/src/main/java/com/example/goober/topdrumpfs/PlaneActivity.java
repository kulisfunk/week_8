package com.example.goober.topdrumpfs;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class PlaneActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane);

        extras = getIntent().getExtras();
        String name = extras.getString("name");
        String nickname = extras.getString("nickname");
        String year = extras.getString("year");
        String country = extras.getString("country");
        String speed = extras.getString("speed");
        String height = extras.getString("height");
        String range = extras.getString("range");
        String max_takeoff = extras.getString("max_takeoff");
        String wing = extras.getString("wing");
        String firepower = extras.getString("firepower");

        nameTV = (TextView)findViewById(R.id.name);
        nicknameTV = (TextView)findViewById(R.id.nickname);
        yearTV = (TextView)findViewById(R.id.year);
        speedTV = (TextView)findViewById(R.id.speed);
        heightTV = (TextView)findViewById(R.id.height);
        rangeTV = (TextView)findViewById(R.id.range);
        max_takeoffTV = (TextView)findViewById(R.id.max_takeoff);
        wingTV = (TextView)findViewById(R.id.wing);
        firepowerTV = (TextView)findViewById(R.id.firepower);

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

}

