package com.example.goober.topdrumpfs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;


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
        i.putExtra("speed", plane.getSpeed().toString());
        i.putExtra("height", plane.getHeight().toString());
        i.putExtra("range", plane.getRange().toString());
        i.putExtra("max_takeoff", plane.getMax_takeoff().toString());
        i.putExtra("wing", plane.getWing().toString());
        i.putExtra("firepower", plane.getFirepower().toString());
        startActivity(i);

    }
}

