package com.game.src.main;

import java.awt.*;

public class Menu {
    int x=Game.WIDTH/2+100,y=100;

    public Rectangle playSingleButton = new Rectangle(x+125 , y+50,200,50 );
    public Rectangle playTwoButton = new Rectangle(x+125 , y+150,200,50 );
    public Rectangle playThreeButton = new Rectangle(x+125 , y+250,200,50 );
    public Rectangle helpButton = new Rectangle(x+125, y+350,200,50 );
    public Rectangle quitButton = new Rectangle(x+125 , y+450,200,50 );

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial",Font.BOLD, 50 );
        g.setFont(fnt0);
        g.setColor(Color.black);
        g.drawString("BLACK JACK GAME", ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString("BLACK JACK GAME", ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString("BLACK JACK GAME", ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString("BLACK JACK GAME", ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(Color.white);
        g.drawString("BLACK JACK GAME", x, y);

        g.setColor(Color.lightGray);
        g.fillRect(x+125 , y+50,200,50 );
        g.setColor(Color.white);
        Font fnt1 = new Font("arial", Font.BOLD,30);
        g.setFont(fnt1);
        g2d.draw(playSingleButton);
        g.drawString("Single Player", playSingleButton.x+5, playSingleButton.y+35 );

        g.setColor(Color.lightGray);
        g.fillRect(x+125 , y+150,200,50 );
        g.setColor(Color.white);
        g2d.draw(playTwoButton);
        g.drawString("Two Players", playTwoButton.x+10, playTwoButton.y+35 );

        g.setColor(Color.lightGray);
        g.fillRect(x+125 , y+250,200,50 );
        g.setColor(Color.white);
        g2d.draw(playThreeButton);
        g.drawString("Three Players", playThreeButton.x+2, playThreeButton.y+35 );

        g.setColor(Color.lightGray);
        g.fillRect(x+125 , y+350,200,50 );
        g.setColor(Color.white);
        g2d.draw(helpButton);
        g.drawString("Help", helpButton.x+65, helpButton.y+35 );

        g.setColor(Color.lightGray);
        g.fillRect(x+125 , y+450,200,50 );
        g.setColor(Color.white);
        g2d.draw(quitButton);
        g.drawString("Quit", quitButton.x+65, quitButton.y+35 );



    }


    int ShiftNorth(int p, int distance) {
        return (p - distance);
    }
    int ShiftSouth(int p, int distance) {
        return (p + distance);
    }
    int ShiftEast(int p, int distance) {
        return (p + distance);
    }
    int ShiftWest(int p, int distance) {
        return (p - distance);
    }
}
