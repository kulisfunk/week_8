package com.example.goober.topdrumpfs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button planeButton;
    String newGame = "true";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(this);
        dbHelper.checkPlaneDatabase();
        dbHelper.checkPlanestatsDatabase();

        planeButton = (Button) findViewById(R.id.planeBtn);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.view_planes) {

            Intent i = new Intent(this, ListActivity.class);
            i.putExtra("selection", "planes");
            startActivity(i);


            return true;
        } else {
            if (item.getItemId() == R.id.view_cars) {
                Intent intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

    public void getPlane(View listItem) {
        Plane plane = (Plane) listItem.getTag();
        Intent i = new Intent(this, ListActivity.class);
        i.putExtra("name", plane.getFirst());
        i.putExtra("nickname", plane.getSecond());
        i.putExtra("year", plane.getThird());
        i.putExtra("plane_country", plane.getFourth());
        i.putExtra("id", plane.getId());
        startActivity(i);

    }

    public void getCar(View listItem) {
        Car car = (Car) listItem.getTag();
        Intent i = new Intent(this, ListActivity.class);
        i.putExtra("make", car.getFirst());
        i.putExtra("model", car.getSecond());
        i.putExtra("year", car.getThird());
        i.putExtra("car_country", car.getFourth());
        i.putExtra("id", car.getId());
        startActivity(i);

    }

    public void onPlaneButtonClicked(View button){

        Intent i = new Intent(this, PlaneGameActivity.class);
        i.putExtra("game", newGame);
        startActivity(i);

    }

}
