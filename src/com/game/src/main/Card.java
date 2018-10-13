package com.game.src.main;
//card class to define values associated with a playing card
//each card contains a suit, value, and location of image in the sprite sheet (row and col)
class card {
    String suit;
    int value;
    int row;
    int col;

    //setter to pass values to it
    public void set(String st, int v, int col, int row) {
        suit=st;
        value=v;
        this.col=col;
        this.row=row;

    }

    //getters
    public String getSuit() {
        return suit;
    }
    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public int getValue() {
        return value;
    }

    //set value used to determine if a player has busted with an ace
    public void setValue(int v){
        value =v;
    }

}