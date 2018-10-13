package com.game.src.main;

import java.awt.*;

public class Menu {
    int x=Game.WIDTH/2+100,y=50;

    public Rectangle play3Button = new Rectangle(x+125 , y+50,200,50 );
    public Rectangle play4Button = new Rectangle(x+125 , y+150,200,50 );
    public Rectangle play5Button = new Rectangle(x+125 , y+250,200,50 );
    public Rectangle play6Button = new Rectangle(x+125, y+350,200,50 );
    public Rectangle play7Button = new Rectangle(x+125 , y+450,200,50 );
    public Rectangle quitButton = new Rectangle(x+125 , y+525,200,50 );


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
        g2d.draw(play3Button);
        g.drawString("3 Player", play3Button.x+35, play3Button.y+35 );

        g.setColor(Color.lightGray);
        g.fillRect(x+125 , y+150,200,50 );
        g.setColor(Color.white);
        g2d.draw(play4Button);
        g.drawString("4 Player", play4Button.x+35, play4Button.y+35 );

        g.setColor(Color.lightGray);
        g.fillRect(x+125 , y+250,200,50 );
        g.setColor(Color.white);
        g2d.draw(play5Button);
        g.drawString("5 Player", play5Button.x+35, play5Button.y+35 );

        g.setColor(Color.lightGray);
        g.fillRect(x+125 , y+350,200,50 );
        g.setColor(Color.white);
        g2d.draw(play6Button);
        g.drawString("6 Player", play6Button.x+35, play6Button.y+35 );

        g.setColor(Color.lightGray);
        g.fillRect(x+125 , y+450,200,50 );
        g.setColor(Color.white);
        g2d.draw(play7Button);
        g.drawString("7 Player", play7Button.x+35, play7Button.y+35 );

        g.setColor(Color.lightGray);
        g.fillRect(x+125 , y+525,200,50 );
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
