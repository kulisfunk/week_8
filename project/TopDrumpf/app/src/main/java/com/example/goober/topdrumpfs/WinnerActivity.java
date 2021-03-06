package com.example.goober.topdrumpfs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {

    Bundle extras;
    String winner;
    TextView winNameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        extras = getIntent().getExtras();
        winner = extras.getString("winner");
        if(winner.equals("You")){
            winNameTV = (TextView) findViewById(R.id.congrats);
            winNameTV.setText(winner.toUpperCase() + " are THE...");
        }
        else{
            winNameTV = (TextView) findViewById(R.id.congrats);
            winNameTV.setText(winner.toUpperCase() + " is THE...");
        }
    }

    public void onClickExit(View button) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
