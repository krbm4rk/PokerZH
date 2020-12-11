package com.company;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Card card1 = new Card("2","hearts");
        Card card2 = new Card("2","spades");
        Card card3 = new Card("3","hearts");
        Card card4 = new Card("5","hearts");
        Card card5 = new Card("6","hearts");

        ArrayList<Card> kartyak = new ArrayList<Card>();
        kartyak.add(card1);
        kartyak.add(card2);
        kartyak.add(card3);
        kartyak.add(card4);
        kartyak.add(card5);

        Hand hand1 = new Hand(kartyak);
        double rank = hand1.rankTheHand();
        if (rank > 1.0 && rank < 2.0)
        {
            System.out.println("PÁR");
        }
        else if(rank > 2.0 && rank < 3.0)
        {
            System.out.println("KÉT PÁR");
        }
        else if(rank > 3.0 && rank < 4.0)
        {
            System.out.println("DRILL");
        }
        else if(rank > 4.0 && rank < 5.0)
        {
            System.out.println("SOR");
        }
        else if(rank > 5.0 && rank < 6.0)
        {
            System.out.println("FLUSH");
        }
        else if(rank > 6.0 && rank < 7.0)
        {
            System.out.println("FULL HOUSE");
        }
        else if(rank > 7.0 && rank < 8.0)
        {
            System.out.println("POKER");
        }
        else if(rank > 8.0)
        {
            System.out.println("SOR FLUSH");
        }

    }
}
