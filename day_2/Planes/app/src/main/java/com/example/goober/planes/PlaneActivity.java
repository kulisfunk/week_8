package com.example.goober.planes;

import android.app.Activity;
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
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane);

        extras = getIntent().getExtras();
        String name = extras.getString("name");
        String nickname = extras.getString("nickname");
        String year = extras.getString("year");

        nameTV = (TextView)findViewById(R.id.name);
        nicknameTV = (TextView)findViewById(R.id.nickname);
        yearTV = (TextView)findViewById(R.id.year);
        imageIV = (ImageView) findViewById(R.id.image);
        String currentImage = name.toLowerCase();



        Drawable pic = getDrawable(getResources().getIdentifier(currentImage, "drawable", getPackageName()));
        imageIV.setImageDrawable(pic);

        nameTV.setText(name.toUpperCase());
        nicknameTV.setText(nickname);
        yearTV.setText("First Flight" + year);
    }

    public void deletePlane(View button){
        Integer id = extras.getInt("id");
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.delete(id);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}


