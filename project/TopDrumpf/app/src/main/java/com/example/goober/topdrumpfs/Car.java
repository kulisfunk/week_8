package com.example.goober.topdrumpfs;

/**
 * Created by goober on 10/11/2017.
 */

public class Car {

    Integer id;
    String make;
    String model;
    String year;
    String car_country;
    Integer car_id;
    Integer speed;
    Integer accel;
    Integer power;
    Integer capacity;
    Integer cylinders;
    Integer length;
    Integer weight1;
    Integer weight2;
    Integer weight3;
    Integer weight4;
    Integer weight5;
    Integer weight6;

    public Car(String make, String model, String year, String car_country) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.car_country = car_country;
    }

    public Car(Integer id, String make, String model, String year, String car_country) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.car_country = car_country;
    }

    public Car(Integer id, String make, String model, String year, String car_country, Integer speed, Integer accel, Integer power, Integer capacity, Integer cylinders, Integer length, Integer weight1, Integer weight2, Integer weight3, Integer weight4, Integer weight5, Integer weight6) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.car_country = car_country;
        this.car_id = id;
        this.speed = speed;
        this.accel = accel;
        this.power = power;
        this.capacity = capacity;
        this.cylinders = cylinders;
        this.length = length;
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
        return make;
    }

    public String getSecond() {
        return model;
    }

    public String getThird() {
        return year;
    }

    public String getFourth() {
        return car_country;
    }
}
