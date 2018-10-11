package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class Computer {
    private double x,x2,y,y2;
    private int count;
    private int wallet=1000;
    private card[] hand=new card[6];

    private SpriteSheet ss;
    private JFrame frame;

    private BufferedImage handImg, background, facedown;
    public Computer(double X, double Y, Game game){
        game.addMouseListener(new MouseInput());

        x = X;
        y = Y;
        x2=465;
        y2=75;
        count=0;
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

    public void getCard(card C1){
        if (count<6) {
            hand[count] = C1;
            if (count == 1) {
                handImg = ss.grabImage(hand[count].getCol(), hand[count].getRow(), 75, 109);
            } else {
                background = ss.grabImage(hand[count].getCol(), hand[count].getRow(), 75, 109);
            }
        }
        count ++;
    }
    public void render(Graphics g){
        if(Game.State==Game.STATE.GAMESTART1 | Game.State==Game.STATE.GAMESTART2 |Game.State==Game.STATE.GAMESTART3 ) {
            g.drawImage(facedown, (int) x2, (int) y2, null);

            if (x2 == x && y2 == y) {
                g.drawImage(facedown, (int) x, (int) y, null);
                g.drawImage(background, (int) x + 80, (int) y, null);


            }
        }

    }
    public void button(String title, int x, int y, int width, int height, Graphics g) {
    }
    public void drawButtons(Graphics g){


    }

}