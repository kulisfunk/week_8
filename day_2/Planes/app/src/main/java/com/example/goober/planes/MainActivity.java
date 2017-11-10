package com.example.goober.planes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.checkDatabase();

        setContentView(R.layout.activity_main);
        ArrayList<Plane> planeList = dbHelper.all();

        PlaneArrayAdapter planeAdapter = new PlaneArrayAdapter(this, planeList);
        ListView listview = (ListView)findViewById(R.id.plane_list);
        listview.setAdapter(planeAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.add_plane){
            Intent intent = new Intent(this, AddPlaneActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getPlane(View listItem) {
        Plane plane = (Plane) listItem.getTag();
        Intent i = new Intent(this, PlaneActivity.class);
        i.putExtra("name", plane.getName());
        i.putExtra("nickname", plane.getNickname());
        i.putExtra("year", plane.getYear());
        i.putExtra("id", plane.getId());
        startActivity(i);

    }


}
