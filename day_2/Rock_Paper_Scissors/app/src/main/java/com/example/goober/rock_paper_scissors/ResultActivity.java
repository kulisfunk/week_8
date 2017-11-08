package com.example.goober.rock_paper_scissors;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    String result;
    String winWeapon;
    String loseWeapon;
    TextView resultTV;
    ImageView winWeaponIV;
    ImageView loseWeaponIV;
    String yourScore;
    String myScore;
    Button againButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        againButton = (Button) findViewById(R.id.again_button);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        result = extras.getString("result");
        winWeapon = extras.getString("winWeapon").toLowerCase();
        loseWeapon = extras.getString("loseWeapon").toLowerCase();
        yourScore = extras.getString("yourScore");
        myScore = extras.getString("myScore");

        resultTV = (TextView) findViewById(R.id.result);
        resultTV.setText(result);

        winWeaponIV = (ImageView) findViewById(R.id.win_weapon);
        String winImage = winWeapon;
        Drawable win = getDrawable(getResources().getIdentifier(winImage, "drawable", getPackageName()));
        winWeaponIV.setImageDrawable(win);

        loseWeaponIV = (ImageView) findViewById(R.id.lose_weapon);
        String loseImage = loseWeapon;
        Drawable lose = getDrawable(getResources().getIdentifier(loseImage, "drawable", getPackageName()));
        loseWeaponIV.setImageDrawable(lose);

//        winWeaponTV = (TextView) findViewById(R.id.win_weapon);
//        winWeaponTV.setText(winWeapon);
//        loseWeaponTV = (TextView) findViewById(R.id.lose_weapon);
//        loseWeaponTV.setText(loseWeapon);


    }

    public void onClickBackButton(View Button){

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("myScore", myScore);
        i.putExtra("yourScore", yourScore);
        startActivity(i);

    }


}
