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
        card card14= new card();
        card card15= new card();
        card card16= new card();
        card card17= new card();
        card card18= new card();
        card card19= new card();
        card card20= new card();
        card card21= new card();
        card card22= new card();
        card card23= new card();
        card card24= new card();
        card card25= new card();
        card card26= new card();
        card card27= new card();
        card card28= new card();
        card card29= new card();
        card card30= new card();
        card card31= new card();
        card card32= new card();
        card card33= new card();
        card card34= new card();
        card card35= new card();
        card card36= new card();
        card card37= new card();
        card card38= new card();
        card card39= new card();
        card card40= new card();
        card card41= new card();
        card card42= new card();
        card card43= new card();
        card card44= new card();
        card card45= new card();
        card card46= new card();
        card card47= new card();
        card card48= new card();
        card card49= new card();
        card card50= new card();
        card card51= new card();
        card card52= new card();

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
        card14.set(suit[1], 2, 14, 1);
        card15.set(suit[1], 3, 15, 1);
        card16.set(suit[1], 4, 16, 1);
        card17.set(suit[1], 5, 17, 1);
        card18.set(suit[1], 6, 18, 1);
        card19.set(suit[1], 7, 19, 1);
        card20.set(suit[1], 8, 20, 1);
        card21.set(suit[1], 9, 21, 1);
        card22.set(suit[1], 10, 22, 1);
        card23.set(suit[1], 10, 23, 1);
        card24.set(suit[1], 10, 24, 1);
        card25.set(suit[1], 10, 25, 1);
        card26.set(suit[1], 11, 26, 1);
        deck.add(card14);
        deck.add(card15);
        deck.add(card16);
        deck.add(card17);
        deck.add(card18);
        deck.add(card19);
        deck.add(card20);
        deck.add(card21);
        deck.add(card22);
        deck.add(card23);
        deck.add(card24);
        deck.add(card25);
        deck.add(card26);

        //spades
        card27.set(suit[2], 2, 27, 1);
        card28.set(suit[2], 3, 1, 2);
        card29.set(suit[2], 4, 2, 2);
        card30.set(suit[2], 5, 3, 2);
        card31.set(suit[2], 6, 4, 2);
        card32.set(suit[2], 7, 5, 2);
        card33.set(suit[2], 8, 6, 2);
        card34.set(suit[2], 9, 7, 2);
        card35.set(suit[2], 10, 8, 2);
        card36.set(suit[2], 10, 9, 2);
        card37.set(suit[2], 10, 10, 2);
        card38.set(suit[2], 10, 11, 2);
        card39.set(suit[2], 11, 12, 2);
        deck.add(card27);
        deck.add(card28);
        deck.add(card29);
        deck.add(card30);
        deck.add(card31);
        deck.add(card32);
        deck.add(card33);
        deck.add(card34);
        deck.add(card35);
        deck.add(card36);
        deck.add(card37);
        deck.add(card38);
        deck.add(card39);

        //clubs
        card40.set(suit[3], 2, 13, 2);
        card41.set(suit[3], 3, 14, 2);
        card42.set(suit[3], 4, 15, 2);
        card43.set(suit[3], 5, 16, 2);
        card44.set(suit[3], 6, 17, 2);
        card45.set(suit[3], 7, 18, 2);
        card46.set(suit[3], 8, 19, 2);
        card47.set(suit[3], 9, 20, 2);
        card48.set(suit[3], 10, 21, 2);
        card49.set(suit[3], 10, 22, 2);
        card50.set(suit[3], 10, 23, 2);
        card51.set(suit[3], 10, 24, 2);
        card52.set(suit[3], 11, 25, 2);
        deck.add(card40);
        deck.add(card41);
        deck.add(card42);
        deck.add(card43);
        deck.add(card44);
        deck.add(card45);
        deck.add(card46);
        deck.add(card47);
        deck.add(card48);
        deck.add(card49);
        deck.add(card50);
        deck.add(card51);
        deck.add(card52);


    }

    //returns the card on the top of the deck and removes it from the array list
    //the removal is neccessary to prevent duplicate cards from being drawn
    public card draw(){
        card top = deck.get(0) ;
        deck.remove(0);
        return top;
    }
    public void clearDeck(){
        while(deck.size()>0){
            deck.remove(0);
        }
    }
    //uses the Collections.shuffle function to shuffle the values in the array list
    //was too lazy to write a shuffle function
    public void shuffle(){
        Collections.shuffle(deck);


    }

}
