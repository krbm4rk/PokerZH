package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Hand {
    private final ArrayList<Card> hand;
    private final int[] values;
    private final String[] suits;
    private double result = 0.0;

    public Hand(ArrayList<Card> cards) {
        hand = cards;
        values = values();
        suits = suits();

        Arrays.sort(values);
        Arrays.sort(suits);
    }

    //Generál egy sor számot
    private int[] values() {
        int[] result = new int[5];

        for (int i=0; i<hand.size(); i++)
        {
            result[i] = hand.get(i).intValue();
        }
        return result;
    }

    //Generál egy sor színt
    private String[] suits() {
        String[] result = new String[5];

        for (int i = 0; i < hand.size(); i++) {
            result[i] = hand.get(i).suit();
        }

        return result;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public double rankTheHand()
    {

        double ranking = 0;
        String rankja = "";

        if (isPair() > 1.0)
        {
            ranking = isPair();
        }

        if (isTwoPair() > 2.0)
        {
            ranking = isTwoPair();
        }

        if (isThreeOfAKind() > 3.0)
        {
            ranking = isThreeOfAKind();
        }

        if (isStraight() > 4.0)
        {
            ranking = isStraight();
        }

        if (isFlush() > 5.0)
        {
            ranking = isFlush();
        }

        if (isFullHouse() > 6.0)
        {
            ranking = isFullHouse();
        }

        if (isFourOfAKind() > 7.0)
        {
            ranking = isFourOfAKind();
        }

        if(isStraightFlush() > 8.0)
        {
            ranking = isStraightFlush();
        }

        return ranking;


    }

    //Ha pár, akkor 1.0 az értéke plusz a tizedesjegyek.
    public double isPair() {
        result = 0.0;

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i + 1]) {
                result = 1.0 + (values[i] * 0.01);
            }
        }

        return result;
    }

    public double isTwoPair() {
        result = 0.0;
        double value = 0.0;
        int counter = 0; //Párok száma

            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] == values[i + 1]) {
                    counter++;

                    value = values[i] * 0.01;
                }
            }

        if (counter == 2) {
            result = 2.0 + value;

        }

        return result;
    }

    public double isThreeOfAKind() {
        result = 0.0;

        for (int i = 0; i < values.length - 2; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2]) {
                result = 3.0 + (values[i] * 0.01);
            }
        }

        return result;
    }

    public double isStraight() {
        result = 0.0;
        int count = 0;

        for (int i = 0; i < values.length - 1; i++){
            if (values[i] == values[i + 1] - 1) {
                result = 4.0 + (values[i + 1] * 0.01);
                count++;

            } else {
                result = 0.0;

            }
        }
        if (count<4)
        {
            result = 0;
        }
        return result;

    }

    public double isFlush() {
        result = 0.0;
        int counter = 0;

        String suit = suits[0];

        for (int i = 0; i < suits.length-1; i++) {
            if (suits[i] == suits[i+1]) {
                counter++;
                if (counter==4) {
                    result = 5.0 + (values[i] * 0.01);
                }else{ result = 0.0;}
            }
        }

        return result;
    }

    public double isFullHouse() {
        result = 0.0;
        boolean one = false;
        boolean two = false;

        for (int i = 0; i < values.length - 2; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2]) {
                one = true;
            }
        }

        if (values[3] == values[4]) {
            two = true;
        }

        if (one && two) {
            result = 6.0 + (values[values.length - 1] * 0.01);
        }

        return result;
    }

    public double isFourOfAKind() {
        result = 0.0;
        int counter = 0;

        for (int i = 0; i < values.length - 3; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] == values[i + 3]) {
                result = 7.0 + (values[i] * 0.01);
            }
        }

        return result;
    }

    public double isStraightFlush() {
        result = 0.0;

        if (isStraight() > 4.0 && isFlush() > 5.0) {
            result = 8.0 + isStraight() - 4.0;
        }

        return result;
    }

    public String toString(){
        String result = "";
        result += hand.get(0).toString();

        for (int i = 1; i < 5; i++) {
            result += ", "+ hand.get(i).toString();
        }

        return result;
    }
}
