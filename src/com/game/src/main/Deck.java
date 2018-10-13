package com.game.src.main;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

/*
    TO DO: I BROKE THE SEQUENCE FOR SETTING THE DECK. THE VALUE BEING LOADED IN IS INCORRECT FOR A FEW CARDS BECAUSE
    OF AN INCORRECT OFFSET.
 */
//The deck class is used to create the deck to be run for each hand in the game class
//the main function is to create an iterable object that contains card value, suit, and
// an identifiable way to load the image
public class Deck{

    //creates an array list of cards called deck
    //each card has a suit, value, row, and col value
    //the row and col value are used to retrieve the associated card image from the
    //sprite sheet
    private ArrayList<card> deck = new ArrayList <card>();
    static String [] suit = {"hearts", "diamonds", "spades", "clubs"};


    /*set function assigns a suit, value, col, and row to each card type in the Deck 'deck'
      this will set the deck in order to start i.e 2-ACE of hearts then 2-ACE of diamonds
      2-ACE of spades and finally  2-ace of clubs
     */
    public void set(){
        int val= 2;
        int col = 1;
        int row=1;
        for (int i=1; i<53; i++, col++){
            //The sprite sheet contains 2 rows with 27 columns we only want r1 c1-27 and r2 c2-25
            //because the last entrys are a facedown card and a blank entry that we don't want in the
            //deck

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
                    cur.set(suit[1], val, col, row);
                    deck.add(cur);
                    val = 2;
                } else if (i ==24 | i==23 | i==22) {
                    val = 10;
                    cur.set(suit[1], val, col, row);
                    deck.add(cur);
                    val++;
                } else {
                    cur.set(suit[1], val, col, row);
                    deck.add(cur);
                    val++;
                }
            }
            else if (i>25 && i < 39) {
                if (i == 38) {
                    val = 11;
                    cur.set(suit[2], val, col, row);
                    deck.add(cur);
                    val = 2;
                } else if (i == 37 | i==36 | i==35) {
                    val = 10;
                    cur.set(suit[2], val, col, row);
                    deck.add(cur);
                    val++;
                } else {
                    cur.set(suit[2], val, col, row);
                    deck.add(cur);
                    val++;
                }
            }
            else if (i>38 && i < 52) {
                if (i == 51) {
                    val = 11;
                    cur.set(suit[3], val, col, row);
                    deck.add(cur);
                    val = 2;
                } else if (i == 50 | i ==49 | i==48) {
                    val = 10;
                    cur.set(suit[3], val, col, row);
                    deck.add(cur);
                    val++;
                } else {
                    cur.set(suit[3], val, col, row);
                    deck.add(cur);
                    val++;
                }
            }

        }

    }

    //returns the card on the top of the deck and removes it from the array list
    //the removal is neccessary to prevent duplicate cards from being drawn
    public card draw(){
        card top = deck.get(0) ;
        deck.remove(0);
        return top;
    }

    //uses the Collections.shuffle function to shuffle the values in the array list
    //was too lazy to write a shuffle function
    public void shuffle(){
        Collections.shuffle(deck);
    }

}
