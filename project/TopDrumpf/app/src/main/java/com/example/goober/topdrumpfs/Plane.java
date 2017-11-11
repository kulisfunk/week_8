package com.example.goober.topdrumpfs;

/**
 * Created by goober on 10/11/2017.
 */

public class Plane {

    Integer id;
    String name;
    String nickname;
    String year;
    String plane_country;
    Integer plane_id;
    Integer speed;
    Integer height;
    Integer range;
    Integer max_takeoff;
    Integer wing;
    Integer firepower;
    Integer weight1;
    Integer weight2;
    Integer weight3;
    Integer weight4;
    Integer weight5;
    Integer weight6;

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

    public Plane(Integer id, String name, String nickname, String year, String plane_country, Integer speed, Integer height, Integer range, Integer max_takeoff, Integer wing, Integer firepower, Integer weight1, Integer weight2, Integer weight3, Integer weight4, Integer weight5, Integer weight6) {
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
        this.weight2 = weight2;
        this.weight3 = weight3;
        this.weight4 = weight4;
        this.weight5 = weight5;
        this.weight6 = weight6;
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

    public Integer getWeight2() {
        return weight2;
    }

    public Integer getWeight3() {
        return weight3;
    }

    public Integer getWeight4() {
        return weight4;
    }

    public Integer getWeight5() {
        return weight5;
    }

    public Integer getWeight6() {
        return weight6;
    }
}
