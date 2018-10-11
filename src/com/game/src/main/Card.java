package com.game.src.main;

class card {
    String suit;
    int value;
    int row;
    int col;

    public void set(String st, int v, int col, int row) {
        suit=st;
        value=v;
        this.col=col;
        this.row=row;

    }

    public String getSuit() {
        return suit;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setValue(int v){
        value =v;
    }

    public int getValue() {
        return value;
    }
}