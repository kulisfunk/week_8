package com.example.goober.topdrumpfs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by goober on 11/11/2017.
 */

public class CarArrayAdapter extends ArrayAdapter<Car>{

    public CarArrayAdapter(Context context, ArrayList<Car> cards){
        super(context, 0, cards);

    }

    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }
        Car car = getItem(position);
        TextView first = (TextView)listItemView.findViewById(R.id.first_text);
        first.setText(car.getFirst().toUpperCase());
        TextView second = (TextView)listItemView.findViewById(R.id.second_text);
        second.setText(car.getSecond());
        TextView third = (TextView)listItemView.findViewById(R.id.third_text);
        third.setText(car.getThird());
        TextView fourth = (TextView)listItemView.findViewById(R.id.fourth_text);
        third.setText(car.getFourth());
        listItemView.setTag(car);


        return listItemView;



    }
}
