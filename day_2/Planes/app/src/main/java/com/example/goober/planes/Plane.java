package com.example.goober.planes;

import android.media.Image;
import android.widget.ImageView;

import static com.example.goober.planes.R.id.year;

/**
 * Created by goober on 07/11/2017.
 */

public class Plane {

    private String name;
    private String nickname;
    private String year;

    public Plane(String name, String nickname, String year) {
        this.name = name;
        this.nickname = nickname;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getYear() {
        return year;
    }

}
