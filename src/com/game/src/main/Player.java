package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Player {
    public int x,x2,y,y2;
    public int hcount=0;
    private boolean ante, isTurn, fold, isBust=false, stay=false;
    protected int wallet=1000, handVal=0, pid, count;
    public int betx, hitx, foldx, stayx, bwidth, by, bheight;
    private card[] hand=new card[6];
    private static int playerCount=1;
    private SpriteSheet ss;
    private Game game;




    private int cardCol, cardRow;
    private BufferedImage card1,card2, card3, card4, card5, card6, facedown, turn_indicator;

    public Player(int X, int Y, Game game){
        ante=false;
        fold=false;
        this.game=game;

        // sets the center where the card images will be drawn
        x = X;
        y = Y;
        //button locations relative to the center
        betx=x+5;
        hitx=betx;
        foldx=x+65;
        stayx=foldx;
        bwidth=25;
        by=y+155;
        bheight=25;

        //location of the computer's deck used for card dealing animation
        x2=465;
        y2=75;
        count=0;
        pid=playerCount;
        playerCount++;
        this.ss = new SpriteSheet(game.getSpriteSheet());




        facedown=ss.grabImage(26,2,75,109);
        turn_indicator=ss.grabImage(27,2,75,109);



    }


    public void tick() {
    }

    public void render(Graphics g){
        g.drawImage(facedown,(int)x2, (int)y2,null);
        if(Game.State==Game.STATE.ANTE){
            drawPlayerPanel(g);
            drawButtons(g);

        }
        if(Game.State!=Game.STATE.MENU && Game.State!=Game.STATE.ANTE) {
            drawPlayerPanel(g);
            drawButtons(g);
            if (x2 == x && y2 == y) {
                drawHand(g);
                drawButtons(g);
            }
        }

    }

    //creates the dealing animation by updating a drawn facedown card that sits on the top of the deck to the location of
    //the player's hand. When it reaches the location the player's hand is redrawn
    public void deal(){

            if (x < x2) {
                x2 -= 5;
            }
            if (y < y2) {
                y2 -= 5;
            }
            if (x > x2) {
                x2 += 5;
            }
            if (y > y2) {
                y2 += 5;
            }

    }

//places a card in the deck
    public void hit(card C){
        if(bust()==false ){
            getCard(C);

        }

    }

    //check if a player busted includes an if ace handler
    public boolean bust() {
        if ( getHandVal() > 21)
            return true;
        else
            return false;

    }




    //returns the current value of the hand
    public int getHandVal(){
        handVal=0;
        for (int i=0; i<count; i++){
            handVal+=hand[i].getValue();
        }
        if (handVal>21){
            handVal=0;
            for (int i=0; i<count; i++){
                if(hand[i].getValue()==11){
                    handVal+=1;
                }
                else
                    handVal+=hand[i].getValue();
            }
        }
        return handVal;
    }

    //Handles the bet function
    public void bet(){
        if (wallet>=100 && ante==false) {
            game.pot+=100;
            ante=true;
            wallet -= 100;
        }

    }

    //gets the image of each card in the hand
    public void getCard(card C1){
        if (count<6) {
            hand[count] = C1;
            if (count == 0) {
                card1 = ss.grabImage(hand[count].getCol(), hand[count].getRow(), 75, 109);
            } else if(count==1) {
                card2 = ss.grabImage(hand[count].getCol(), hand[count].getRow(), 75, 109);
            }
            else if(count==2) {
                card3 = ss.grabImage(hand[count].getCol(), hand[count].getRow(), 75, 109);
            }
            else if(count==3) {
                card4 = ss.grabImage(hand[count].getCol(), hand[count].getRow(), 75, 109);
            }
            else if(count==4) {
                card5 = ss.grabImage(hand[count].getCol(), hand[count].getRow(), 75, 109);
            }
            else if(count==5) {
                card6 = ss.grabImage(hand[count].getCol(), hand[count].getRow(), 75, 109);
            }
        }
        count ++;
    }



//DRAWING FUNCTIONS FOR THE PLAYER PANEL AND PANEL BUTTONS
    public void button(String title, int x, int y, int width, int height, Graphics g){
        g.setColor(Color.white);
        g.fillRect(x , y, width, height);
        g.setColor(Color.black);
        g.drawRect(x , y, width, height);
        Font fnt1 = new Font("arial", Font.BOLD,9);
        g.setFont(fnt1);
        g.drawString(title, x+width/5, y+2*height/3);
    }
    public void drawButtons(Graphics g){
        if(Game.State==Game.STATE.ANTE || Game.State==Game.STATE.NEW_HAND){
            button("Bet", betx, by, bwidth, bheight, g);
            button("Fold", foldx, by, bwidth, bheight, g);

        }
        else if (Game.State!=Game.STATE.MENU | Game.State!=Game.STATE.ANTE || Game.State!=Game.STATE.NEW_HAND) {
            button("Hit", betx, by, bwidth, bheight, g);
            button("Stay", stayx, by, bwidth, bheight, g);
        }

    }
    public void drawPlayerPanel(Graphics g){
        g.setColor(Color.lightGray);
        g.fillRect(x, (int)y+125, 100, 75);
        g.setColor(Color.black);
        g.drawRect(x , y+125, 100, 75);
        Font fnt1 = new Font("arial", Font.BOLD,12);
        g.setFont(fnt1);
        g.drawString("Player "+pid+": $"+wallet, (int)x+5, (int)y+145);
        if(isTurn==true){
            g.drawImage(turn_indicator, x+15, y+175, null);
        }
        if(game.State!=Game.STATE.ANTE || game.State!=Game.STATE.NEW_HAND) {
            if (getHandVal() > 21) {
                fnt1 = new Font("arial", Font.BOLD, 80);
                g.drawString("BUST", x + 35, y + 195);
            } else {
                fnt1 = new Font("arial", Font.BOLD, 80);
                g.drawString("Hand:" + getHandVal(), x + 30, y + 195);
            }
        }
    }
    //DRAWS THE PLAYER'S HAND VALUE

//DRAWS THE CARD HAND
    public void drawHand(Graphics g){
            if (card1 !=null) {
                g.drawImage(card1, (int) x, (int) y, null);
            }
            if (card2 !=null) {
                g.drawImage(card2, (int) x+40, (int) y, null);
            }
            if (card3 !=null) {
                g.drawImage(card3, (int) x+55, (int) y, null);
            }
            if (card4 !=null) {
                g.drawImage(card4, (int) x+70, (int) y, null);
            }
            if (card5 !=null) {
                g.drawImage(card2, (int) x+85, (int) y, null);
            }
            if (card6 !=null) {
                g.drawImage(card2, (int) x+100, (int) y, null);
            }

    }

    //getters and setters for handling whether a player bet, folded, is their turn, might need one for stay too
    public void setFold(){
        fold=true;
    }

    public boolean getFold(){
        return fold;
    }
    public boolean getAnte(){
        return ante;
    }
    public void setStay(boolean stay){
        this.stay=stay;
    }

    public void setAnte(boolean ante){
        this.ante=ante;
    }
    public void setTurn(boolean turn){
        isTurn=turn;
    }
    public boolean getIsTurn(){
        return isTurn;
    }
    public boolean getIsBust(){return isBust;}
    public boolean getStay(){return stay;}

    public int getX(){
        return x;
    }

    public int getY(){
        return (int)y;

    }
    protected void clearHand(){
        for(int i=0; i<4; i++){
            hand[i]=null;
        }
        card1=null;
        card2=null;
        card3=null;
        card4=null;
        card5=null;
        card6=null;
    }

}
