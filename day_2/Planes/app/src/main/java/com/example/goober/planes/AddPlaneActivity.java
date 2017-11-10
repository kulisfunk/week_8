package com.example.goober.planes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.id.edit;
import static com.example.goober.planes.R.id.year;

public class AddPlaneActivity extends AppCompatActivity {


        EditText editName;
        EditText editNickname;
        EditText editYear;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_plane);
            editName = (EditText) findViewById(R.id.editName);
            editNickname = (EditText) findViewById(R.id.editNickname);
            editYear = (EditText) findViewById(R.id.editYear);

        }

        public void addPlane(View button){
            DBHelper dbHelper = new DBHelper(this);
            String name = editName.getText().toString();
            String nickname = editNickname.getText().toString();
            String year = editYear.getText().toString();
            dbHelper.save(name, nickname, year);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

}
