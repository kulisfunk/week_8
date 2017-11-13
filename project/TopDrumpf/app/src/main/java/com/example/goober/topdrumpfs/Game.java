package com.example.goober.topdrumpfs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by goober on 13/11/2017.
 */

public class Game {

    ArrayList<Plane> playerCards;
    ArrayList<Plane> computerCards;
    ArrayList<Plane> currentCards;




    public Game() {
    }

    public void createPacks(ArrayList<Plane> planes){
        computerCards = new ArrayList<>();
        playerCards = planes;
        Collections.shuffle(playerCards);
        int length = playerCards.size()/2 + (playerCards.size()%2);
        for(int i = 0; i < length; i++){
            computerCards.add(playerCards.remove(i));
        }
    }


}
