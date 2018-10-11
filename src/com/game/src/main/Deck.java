package com.game.src.main;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
    private ArrayList<card> deck = new ArrayList <card>();
    static String [] suit = {"hearts", "diamonds", "spades", "clubs"};

    public void set(){
        int val= 2;
        int col = 1;
        int row=1;
        for (int i=0; i<52; i++, col++){
            if (col==27 && row == 1){
                col=1;
                row=2;
            }
            card cur= new card();

            if (i<13){
                if(i==12) {
                    val=11;
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val=2;
                }
                else if (i==11 | i==10 | i==9) {
                    val = 10;
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val++;
                }
                else{
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val++;
                }
            }
            else if (i>12 && i < 26) {
                if (i == 25) {
                    val = 11;
                    val = 1;
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val = 2;
                } else if (i ==24 | i==23 | i==22) {
                    val = 10;
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val++;
                } else {
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val++;
                }
            }
            else if (i>25 && i < 39) {
                if (i == 38) {
                    val = 11;
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val = 1;
                } else if (i == 37 | i==36 | i==35) {
                    val = 10;
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val++;
                } else {
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val++;
                }
            }
            else if (i>38 && i < 52) {
                if (i == 51) {
                    val = 11;
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val = 1;
                } else if (i == 50 | i ==49 | i==48) {
                    val = 10;
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val++;
                } else {
                    cur.set(suit[0], val, col, row);
                    deck.add(cur);
                    val++;
                }
            }

        }

    }


    public card draw(){
        card top = deck.get(0) ;
        deck.remove(0);
        return top;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

}
