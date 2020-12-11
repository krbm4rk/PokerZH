package com.company;

public class Card {
private int value;
private String suit;


public Card(String v, String s) {
    if (v.equals("2") || v.equals("3") || v.equals("4") || v.equals("5") || v.equals("6") || v.equals("7") || v.equals("8") || v.equals("9") || v.equals("10") || v.equals("11") || v.equals("12") || v.equals("13") || v.equals("14")) {
        value = Integer.parseInt(v);
    } else {
        if (v.equals("J")) {
            value = 11;
        } else if (v.equals("Q")) {
            value = 12;
        } else if (v.equals("K")) {
            value = 13;
        } else if (v.equals("A")) {
            value = 14;
        }
    }
    suit = s;
}

    public String value()
    {
        String result = "";
        //Ha egy sima szám kártya
        if (value >= 2 && value <=10)
        {
            result = Integer.toString(value);
        }
        //Ha pedig egy betűs kártya
        else if (value >= 11 && value <= 14) {
            if (value == 11) {
                result = "J";
            } else if (value == 12) {
                result = "Q";
            } else if (value == 13) {
                result = "K";
            } else if (value == 14) {
                result = "A";
            } else {
                result = "Error";
            }
        }


        return result;
    }

    public int intValue()
    {
        //Szám (2-10, 11 jack, 12 queen, 13 king, 14 ace)
        return value;
    }

    public String suit ()
    {
        //Szín (hearts, spades, clubs, diamonds)
        return suit;
    }

}

