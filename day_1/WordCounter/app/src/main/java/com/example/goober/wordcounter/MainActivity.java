package com.example.goober.wordcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

import static android.R.attr.entries;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private Button countButton;
    private TextView outputCount;
    private WordCount counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.inputText);
        countButton = (Button) findViewById(R.id.countBtn);
        outputCount = (TextView) findViewById(R.id.countedWords);

    }


    public void onCountWordButtonClicked(View Button) {

        String inputText = input.getText().toString();
        counter = new WordCount(inputText);

        outputCount.setText(counter.finalAnswer(counter.mapIndividualWords()));
        }






}
