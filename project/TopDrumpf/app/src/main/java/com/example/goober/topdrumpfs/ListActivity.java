package com.example.goober.topdrumpfs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_FIREPOWER;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_HEIGHT;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_MAXTAKEOFF;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_PLANEID;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_RANGE;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_SPEED;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_WEIGHT1;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_WEIGHT2;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_WEIGHT3;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_WEIGHT4;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_WEIGHT5;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_WEIGHT6;
import static com.example.goober.topdrumpfs.DBHelper.PLANESTATS_COLUMN_WING;

public class ListActivity extends AppCompatActivity {

    String selection = "";
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.checkPlaneDatabase();
        dbHelper.checkPlanestatsDatabase();

        setContentView(R.layout.activity_list);

        extras = getIntent().getExtras();
        selection = extras.getString("selection");

        if (Objects.equals(selection, "planes")) {
            ArrayList<Plane> planes = dbHelper.allPlanes();
            PlaneArrayAdapter listAdapter = new PlaneArrayAdapter(this, planes);
            ListView listview = (ListView)findViewById(R.id.card_list);
            listview.setAdapter(listAdapter);
        }else {
            ArrayList<Car> cars = dbHelper.allCars();
            CarArrayAdapter listAdapter = new CarArrayAdapter(this, cars);
            ListView listview = (ListView)findViewById(R.id.card_list);
            listview.setAdapter(listAdapter);
        }
    }
    public void getPlane(View listItem) {
        Plane plane = (Plane) listItem.getTag();
        Intent i = new Intent(this, PlaneActivity.class);
        i.putExtra("name", plane.getFirst());
        i.putExtra("nickname", plane.getSecond());
        i.putExtra("year", plane.getThird());
        i.putExtra("country", plane.getFourth());
        i.putExtra("speed", plane.getSpeed());
        i.putExtra("height", plane.getHeight());
        i.putExtra("range", plane.getRange());
        i.putExtra("max_takeoff", plane.getMax_takeoff());
        i.putExtra("wing", plane.getWing());
        i.putExtra("firepower", plane.getFirepower());

        startActivity(i);

    }
}

