package com.example.goober.topdrumpfs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by goober on 11/11/2017.
 */

public class PlaneArrayAdapter extends ArrayAdapter<Plane>{


    public PlaneArrayAdapter(Context context, ArrayList<Plane> cards){
        super(context, 0, cards);

    }

    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }
        Plane plane = getItem(position);
        TextView first = (TextView)listItemView.findViewById(R.id.first_text);
        first.setText(plane.getFirst().toUpperCase());
        TextView second = (TextView)listItemView.findViewById(R.id.second_text);
        second.setText(plane.getSecond());
        TextView third = (TextView)listItemView.findViewById(R.id.third_text);
        third.setText(plane.getThird());
        TextView fourth = (TextView)listItemView.findViewById(R.id.fourth_text);
        fourth.setText(plane.getFourth());
        listItemView.setTag(plane);


        return listItemView;



    }
}
