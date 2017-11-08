package com.example.goober.planes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by goober on 07/11/2017.
 */

public class PlaneArrayAdapter extends ArrayAdapter<Plane> {

    public PlaneArrayAdapter(Context context, ArrayList<Plane> planes){
        super(context, 0, planes);

    }

    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.plane_item, parent, false);
        }
        Plane currentPlane = getItem(position);
        TextView name = (TextView)listItemView.findViewById(R.id.name_text);
        name.setText(currentPlane.getName().toUpperCase());
        TextView title = (TextView)listItemView.findViewById(R.id.nickname_text);
        title.setText(currentPlane.getNickname());
        TextView year = (TextView)listItemView.findViewById(R.id.year_text);
        year.setText("First Flight " + currentPlane.getYear());
        listItemView.setTag(currentPlane);

        return listItemView;



    }
}
