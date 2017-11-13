package com.example.goober.topdrumpfs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    Bundle extras;
    boolean newGame = false;
    ArrayList<Plane> playerCards;
    ArrayList<Plane> computerCards;
    ArrayList<Plane> currentCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        extras = getIntent().getExtras();

    }

    public void onClickContinue(View button){
        Intent i = new Intent(this, PlaneGameActivity.class);

        startActivity(i);

    }
}
