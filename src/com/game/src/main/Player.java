package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Player {
    private double x,x2,y,y2;
    private boolean ante, fold;
    private int wallet=1000, handVal=0, pid, count;
    private card[] hand=new card[6];
    private static int playerCount=1;
    private SpriteSheet ss;
    private JFrame frame;




    private int cardCol, cardRow;
    private BufferedImage card1,card2, card3, card4, card5, card6, background, facedown;

    public Player(double X, double Y, Game game){
        game.addMouseListener(new MouseInput());
        ante=false;
        fold=false;
        x = X;
        y = Y;
        x2=465;
        y2=75;
        count=0;
        pid=playerCount;
        playerCount++;
        this.ss = new SpriteSheet(game.getSpriteSheet());




        facedown=ss.grabImage(26,2,75,109);



    }

    public void tick() {
        //draw card annimation add event listener
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


    public void hit(card C){
        if(bust()==false){
            getCard(C);

        }

    }
    public boolean bust(){
        if(handVal>21){
            if(containsAce()==true){
                getHandVal();
                bust();
            }
            else
                return true;
        }
        return false;
    }



    public boolean containsAce(){
        for(int i =0; i<6; i++){
            if (hand[count].getValue()==11){
                hand[count].setValue(2);
                return true;
            }
        }
        return false;
    }
    public int getHandVal(){
        for (int i=0; i<6; i++){
            handVal+=hand[i].getValue();
        }
        return handVal;
    }
    public void bet(){
        if (wallet>100) {
            ante=true;
            wallet -= 100;
        }

    }
    public void fold(){
        fold=true;
    }

    public boolean getFold(){
        return fold;
    }
    public boolean getAnte(){
        return ante;
    }
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
    public void render(Graphics g){
        g.drawImage(facedown,(int)x2, (int)y2,null);
        if(Game.State==Game.STATE.ANTE1 | Game.State==Game.STATE.ANTE2 |Game.State==Game.STATE.ANTE3){
            drawPlayerPanel(g);
            drawButtons(g);
        }
        if(Game.State==Game.STATE.GAMESTART1 | Game.State==Game.STATE.GAMESTART2 |Game.State==Game.STATE.GAMESTART3) {
            drawPlayerPanel(g);
            drawButtons(g);
            if (x2 == x && y2 == y) {
                drawHand(g);
            }
        }

    }



    public void button(String title, int x, int y, int width, int height, Graphics g){
        g.setColor(Color.white);
        g.fillRect(x , y, width, height);
        g.setColor(Color.black);
        g.drawRect(x , y, width, height);
        g.drawString(title, x+width/5, y+2*height/3);
    }
    public void drawButtons(Graphics g){
        if(Game.State==Game.STATE.ANTE1 | Game.State==Game.STATE.ANTE2 |Game.State==Game.STATE.ANTE3){
            button("Bet", (int)(x+60), (int)(y+180), 40, 25, g);
            button("Fold", (int) (x + 120), (int) (y + 180), 40, 25, g);

        }
        else if (Game.State==Game.STATE.GAMESTART1 | Game.State==Game.STATE.GAMESTART2 |Game.State==Game.STATE.GAMESTART3) {
            button("Hit", (int) (x + 60), (int) (y + 180), 40, 25, g);
            button("Fold", (int) (x + 120), (int) (y + 180), 40, 25, g);
        }

    }
    public void drawPlayerPanel(Graphics g){
        g.setColor(Color.lightGray);
        g.fillRect((int)x +40, (int)y+150, 175, 80);
        g.setColor(Color.black);
        g.drawRect((int)x+40 , (int)y+150, 175, 80);
        Font fnt1 = new Font("arial", Font.BOLD,15);
        g.setFont(fnt1);

        g.drawString("Player "+pid+": $"+wallet, (int)x+45, (int)y+165);

    }

    public void drawHand(Graphics g){
            if (card1 !=null) {
                g.drawImage(card1, (int) x, (int) y, null);
            }
            if (card2 !=null) {
                g.drawImage(card2, (int) x+80, (int) y, null);
            }
            if (card3 !=null) {
                g.drawImage(card3, (int) x+120, (int) y, null);
            }
            if (card4 !=null) {
                g.drawImage(card4, (int) x+160, (int) y, null);
            }
            if (card5 !=null) {
                g.drawImage(card2, (int) x+200, (int) y, null);
            }
            if (card6 !=null) {
                g.drawImage(card2, (int) x+240, (int) y, null);
            }

    }

    public int getX(){
        return (int)x;

    }
    public int getY(){
        return (int)y;

    }

}
