package com.example.goober.planes;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaneActivity extends AppCompatActivity {

    TextView nameTV;
    TextView nicknameTV;
    TextView yearTV;
    ImageView imageIV;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane);



        Intent i = getIntent();
        Bundle extras = i.getExtras();
        String name = extras.getString("name");
        String nickname = extras.getString("nickname");
        String year = extras.getString("year");

        nameTV = (TextView)findViewById(R.id.name);
        nicknameTV = (TextView)findViewById(R.id.nickname);
        yearTV = (TextView)findViewById(R.id.year);
        imageIV = (ImageView) findViewById(R.id.image);
//        String currentImage = "planes:drawable/" + name;
        String currentImage = name;

//        int id = getResources().getIdentifier(currentImage, "drawable", getPackageName());
//        imageIV.setImageResource(id);

        Drawable pic = getDrawable(getResources().getIdentifier(currentImage, "drawable", getPackageName()));
        imageIV.setImageDrawable(pic);

        nameTV.setText(name.toUpperCase());
        nicknameTV.setText(nickname);
        yearTV.setText("First Flight" + year);
            }
}


