package com.example.goober.topdrumpfs;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by goober on 10/11/2017.
 */

public class Plane implements Serializable{

    private Integer id;
    private String name;
    private String nickname;
    private String year;
    private String plane_country;
    private Integer plane_id;
    private Integer speed;
    private Integer height;
    private Integer range;
    private Integer max_takeoff;
    private Integer wing;
    private Integer firepower;
    private Integer weight1;

    public Plane(String name, String nickname, String year, String plane_country) {
        this.name = name;
        this.nickname = nickname;
        this.year = year;
        this.plane_country = plane_country;
    }

    public Plane(Integer id, String name, String nickname, String year, String plane_country) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.year = year;
        this.plane_country = plane_country;
    }

    public Plane(Integer id, String name, String nickname, String year, String plane_country, Integer speed, Integer height, Integer range, Integer max_takeoff, Integer wing, Integer firepower, Integer weight1) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.year = year;
        this.plane_country = plane_country;
        this.plane_id = id;
        this.speed = speed;
        this.height = height;
        this.range = range;
        this.max_takeoff = max_takeoff;
        this.wing = wing;
        this.firepower = firepower;
        this.weight1 = weight1;
    }


    public Integer getId() {
        return id;
    }

    public String getFirst() {
        return name;
    }

    public String getSecond() {
        return nickname;
    }

    public String getThird() {
        return year;
    }

    public String getFourth() {
        return plane_country;
    }

    public Integer getPlane_id() {
        return plane_id;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getRange() {
        return range;
    }

    public Integer getMax_takeoff() {
        return max_takeoff;
    }

    public Integer getWing() {
        return wing;
    }

    public Integer getFirepower() {
        return firepower;
    }

    public Integer getWeight1() {
        return weight1;
    }
}
