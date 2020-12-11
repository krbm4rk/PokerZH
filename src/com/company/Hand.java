package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Hand {
    private ArrayList<Card> hand;
    private int[] values;
    private String[] suits;

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

        if (isPair() > 1.0)
        {
            ranking = isPair();
        }
        else if (isTwoPair() > 2.0)
        {
            ranking = isTwoPair();
        }
        else if (isThreeOfAKind() > 3.0)
        {
            ranking = isThreeOfAKind();
        }
        else if (isStraight() > 4.0)
        {
            ranking = isStraight();
        }
        else if (isFlush() > 5.0)
        {
            ranking = isFlush();
        }
        else if (isFullHouse() > 6.0)
        {
            ranking = isFullHouse();
        }
        else if (isFourOfAKind() > 7.0)
        {
            ranking = isFourOfAKind();
        }
        else if(isStraightFlush() > 8.0)
        {
            ranking = isStraightFlush();
        }
        else{

        }

        return ranking;


    }

    //Ha pár, akkor 1.0 az értéke plusz a tizedesjegyek.
    public double isPair() {
        double result = 0.0;

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i + 1]) {
                result = 1.0 + (values[i] * 0.01);
            }
        }

        return result;
    }

    public double isTwoPair() {
        double result = 0.0;
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
        double result = 0.0;
        int counter = 0;

        for (int i = 0; i < values.length - 2; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2]) {
                result = 3.0 + (values[i] * 0.01);
            }
        }

        return result;
    }

    public double isStraight() {
        double result = 0.0;

        for (int i = 0; i < values.length - 1; i++){
            if (values[i] == values[i + 1] - 1) {
                result = 4.0 + (values[i + 1] * 0.01);
            } else {
                result = 0.0;
            }
        }

        return result;
    }

    public double isFlush() {
        double result = 0.0;

        String suit = suits[0];

        for (int i = 0; i < suits.length; i++) {
            result = 5.0 + (values[i] * 0.01);

            if (suits[i].equals(suit) == false) {
                result = 0.0;
            }
        }

        return result;
    }

    public double isFullHouse() {
        double result = 0.0;
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
        double result = 0.0;
        int counter = 0;

        for (int i = 0; i < values.length - 3; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] == values[i + 3]) {
                result = 7.0 + (values[i] * 0.01);
            }
        }

        return result;
    }

    public double isStraightFlush() {
        double result = 0.0;

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
