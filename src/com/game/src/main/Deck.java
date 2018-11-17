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
        //Hearts
        card card1= new card();
        card card2= new card();
        card card3= new card();
        card card4= new card();
        card card5= new card();
        card card6= new card();
        card card7= new card();
        card card8= new card();
        card card9= new card();
        card card10= new card();
        card card11= new card();
        card card12= new card();
        card card13= new card();

        card1.set(suit[0], 2, 1, 1);
        card2.set(suit[0], 3, 2, 1);
        card3.set(suit[0], 4, 3, 1);
        card4.set(suit[0], 5, 4, 1);
        card5.set(suit[0], 6, 5, 1);
        card6.set(suit[0], 7, 6, 1);
        card7.set(suit[0], 8, 7, 1);
        card8.set(suit[0], 9, 8, 1);
        card9.set(suit[0], 10, 9, 1);
        card10.set(suit[0], 10, 10, 1);
        card11.set(suit[0], 10, 11, 1);
        card12.set(suit[0], 10, 12, 1);
        card13.set(suit[0], 11, 13, 1);
            deck.add(card1);
            deck.add(card2);
            deck.add(card3);
            deck.add(card4);
            deck.add(card5);
            deck.add(card6);
            deck.add(card7);
            deck.add(card8);
            deck.add(card9);
            deck.add(card10);
            deck.add(card11);
            deck.add(card12);
            deck.add(card13);

        //Diamonds
        card1.set(suit[1], 2, 14, 1);
        card2.set(suit[1], 3, 15, 1);
        card3.set(suit[1], 4, 16, 1);
        card4.set(suit[1], 5, 17, 1);
        card5.set(suit[1], 6, 18, 1);
        card6.set(suit[1], 7, 19, 1);
        card7.set(suit[1], 8, 20, 1);
        card8.set(suit[1], 9, 21, 1);
        card9.set(suit[1], 10, 22, 1);
        card10.set(suit[1], 10, 23, 1);
        card11.set(suit[1], 10, 24, 1);
        card12.set(suit[1], 10, 25, 1);
        card13.set(suit[1], 11, 26, 1);
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);
        deck.add(card5);
        deck.add(card6);
        deck.add(card7);
        deck.add(card8);
        deck.add(card9);
        deck.add(card10);
        deck.add(card11);
        deck.add(card12);
        deck.add(card13);

        //spades
        card1.set(suit[2], 2, 27, 1);
        card2.set(suit[2], 3, 1, 2);
        card3.set(suit[2], 4, 2, 2);
        card4.set(suit[2], 5, 3, 2);
        card5.set(suit[2], 6, 4, 2);
        card6.set(suit[2], 7, 5, 2);
        card7.set(suit[2], 8, 6, 2);
        card8.set(suit[2], 9, 7, 2);
        card9.set(suit[2], 10, 8, 2);
        card10.set(suit[2], 10, 9, 2);
        card11.set(suit[2], 10, 10, 2);
        card12.set(suit[2], 10, 11, 2);
        card13.set(suit[2], 11, 12, 2);
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);
        deck.add(card5);
        deck.add(card6);
        deck.add(card7);
        deck.add(card8);
        deck.add(card9);
        deck.add(card10);
        deck.add(card11);
        deck.add(card12);
        deck.add(card13);

        //clubs
        card1.set(suit[3], 2, 13, 2);
        card2.set(suit[3], 3, 14, 2);
        card3.set(suit[3], 4, 15, 2);
        card4.set(suit[3], 5, 16, 2);
        card5.set(suit[3], 6, 17, 2);
        card6.set(suit[3], 7, 18, 2);
        card7.set(suit[3], 8, 19, 2);
        card8.set(suit[3], 9, 20, 2);
        card9.set(suit[3], 10, 21, 2);
        card10.set(suit[3], 10, 22, 2);
        card11.set(suit[3], 10, 23, 2);
        card12.set(suit[3], 10, 24, 2);
        card13.set(suit[3], 11, 25, 2);
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);
        deck.add(card5);
        deck.add(card6);
        deck.add(card7);
        deck.add(card8);
        deck.add(card9);
        deck.add(card10);
        deck.add(card11);
        deck.add(card12);
        deck.add(card13);


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
