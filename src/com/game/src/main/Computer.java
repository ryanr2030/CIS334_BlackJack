package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/*
NEEDS TO BE UPDATED AFTER WE GET THE PLAYER_TURN STATE WORKING
 */
public class Computer {
    private double x,x2,y,y2;
    private int count;
    private card[] hand=new card[6];
    public int hcount=0;
    private boolean ante, isTurn, fold, isBust=false, stay=false;
    private int wallet=1000, handVal=0;
    private SpriteSheet ss;
    private Game game;




    private int cardCol, cardRow;
    private BufferedImage card1,card2, card3, card4, card5, card6, facedown, turn_indicator;


    public Computer(double X, double Y, Game game){
        game.addMouseListener(new MouseInput(game));
        x = X;
        y = Y;
        x2=465;
        y2=75;
        count=0;
        this.ss = new SpriteSheet(game.getSpriteSheet());
        facedown=ss.grabImage(26,2,75,109);
        turn_indicator=ss.grabImage(27,2,75,109);



    }

    public void tick() {
    }

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


    public void render(Graphics g){
        //card that is delt
        g.drawImage(facedown,(int)x2, (int)y2,null);
        if(Game.State==Game.STATE.ANTE){

        }
        if(Game.State!=Game.STATE.MENU && Game.State!=Game.STATE.ANTE) {
            if (x2 == x && y2 == y) {
                drawHand(g);
            }
        }
        if(Game.State==Game.STATE.COMPUTER_TURN) {
            compPanel(g);
        }
    }

    //Computer panel
    public void compPanel(Graphics g){
                g.drawImage(turn_indicator, (int)x-200, (int)y, null);
                Font fnt1 = new Font("arial", Font.BOLD, 100);
                g.drawString("Hand:" + getHandVal(), (int)x + 50, (int)y+125 );
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
                    handVal+=2;
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



    //DRAWS THE CARD HAND
    public void drawHand(Graphics g){
        if (card1 !=null) {
            if(Game.State==Game.STATE.COMPUTER_TURN)
                g.drawImage(card1, (int) x, (int) y, null);
            else
                g.drawImage(facedown, (int) x, (int) y, null);
        }
        if (card2 !=null) {
            g.drawImage(card2, (int) x+60, (int) y, null);
        }
        if (card3 !=null) {
            g.drawImage(card3, (int) x+75, (int) y, null);
        }
        if (card4 !=null) {
            g.drawImage(card4, (int) x+90, (int) y, null);
        }
        if (card5 !=null) {
            g.drawImage(card2, (int) x+105, (int) y, null);
        }
        if (card6 !=null) {
            g.drawImage(card2, (int) x+120, (int) y, null);
        }

    }

    //getters and setters for handling whether a player bet, folded, is their turn, might need one for stay too
    public void setFold(){
        fold=true;
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
        return (int)x;
    }

    public int getY(){
        return (int)y;

    }

}


