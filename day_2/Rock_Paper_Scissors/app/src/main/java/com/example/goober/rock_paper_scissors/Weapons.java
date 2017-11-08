package com.example.goober.rock_paper_scissors;

import static android.R.attr.name;

/**
 * Created by goober on 08/11/2017.
 */

public enum Weapons {

    ROCK(1),
    PAPER(2),
    SCISSORS(3);


    public int value;

    Weapons(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}