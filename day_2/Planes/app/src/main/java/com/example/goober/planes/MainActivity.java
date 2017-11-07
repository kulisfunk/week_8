package com.example.goober.planes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlaneArray planes = new PlaneArray();
        ArrayList<Plane> planeList = planes.getList();

        PlaneArrayAdapter planeAdapter = new PlaneArrayAdapter(this, planeList);
        ListView listview = (ListView)findViewById(R.id.plane_list);
        listview.setAdapter(planeAdapter);

    }
    public void getPlane(View listItem) {
        Plane plane = (Plane) listItem.getTag();
        Intent i = new Intent(this, PlaneActivity.class);
        i.putExtra("name", plane.getName());
        i.putExtra("nickname", plane.getNickname());
        i.putExtra("year", plane.getYear());
        startActivity(i);

    }
}
