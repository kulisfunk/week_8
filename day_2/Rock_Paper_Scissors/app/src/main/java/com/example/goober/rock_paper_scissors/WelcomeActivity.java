package com.example.goober.rock_paper_scissors;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button gameButton;
    Button infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        gameButton = (Button) findViewById(R.id.game);
        infoButton = (Button) findViewById(R.id.info);
    }


    public void gameButtonClicked(View Button){
        String url = "https://en.wikipedia.org/wiki/Rock–paper–scissors";
        Intent linkIntent = new Intent(Intent.ACTION_VIEW);
        linkIntent.setData(Uri.parse(url));
        startActivity(linkIntent);
    }



    public void infoButtonClicked(View Button){
        String url = "https://en.wikipedia.org/wiki/Rock–paper–scissors";
        Intent linkIntent = new Intent(Intent.ACTION_VIEW);
        linkIntent.setData(Uri.parse(url));
        startActivity(linkIntent);
    }
}
