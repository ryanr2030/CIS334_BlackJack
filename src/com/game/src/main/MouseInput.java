package com.game.src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput extends Game implements MouseListener{



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        /*

            width/2+100  y=100
            public Rectangle playSingleButton = new Rectangle(x+125 , y+50,200,50 );
            public Rectangle playTwoButton = new Rectangle(x+125 , y+150,200,50 );
            public Rectangle playThreeButton = new Rectangle(x+125 , y+250,200,50 );
            public Rectangle helpButton = new Rectangle(x+125, y+350,200,50 );
            public Rectangle quitButton = new Rectangle(x+125 , y+450,200,50 );
        */


        //Mouse listener to handle input for the Menu
        if(Game.State==Game.STATE.MENU) {
            //Single Player
            if (mx >= Game.WIDTH / 2 + 225 && mx <= Game.WIDTH / 2 + 425) {
                if (my >= 150 && my <= 200) {
                    //Single Player clicked
                    Game.State = Game.STATE.ANTE1;
                }
            }
            //Two Player
            if (mx >= Game.WIDTH / 2 + 225 && mx <= Game.WIDTH / 2 + 425) {
                if (my >= 250 && my <= 300) {
                    //Single Player clicked
                    Game.State = Game.STATE.ANTE2;
                }
            }
            //Three Player
            if (mx >= Game.WIDTH / 2 + 225 && mx <= Game.WIDTH / 2 + 425) {
                if (my >= 350 && my <= 400) {
                    //Single Player clicked
                    Game.State = Game.STATE.ANTE3;
                }
            }
            //Help
            if (mx >= Game.WIDTH / 2 + 225 && mx <= Game.WIDTH / 2 + 425) {
                if (my >= 450 && my <= 500) {
                    //Single Player clicked
                    Game.State = Game.STATE.HELP;
                }
            }
            //Quit
            if (mx >= Game.WIDTH / 2 + 225 && mx <= Game.WIDTH / 2 + 425) {
                if (my >= 550 && my <= 600) {
                    //Single Player clicked
                    System.exit(0);
                }
            }

        }


        /*
          if(Game.State==Game.STATE.ANTE1 | Game.State==Game.STATE.ANTE2 |Game.State==Game.STATE.ANTE3){
            button("Bet", (int)(x+60), (int)(y+180), 40, 25, g);
            button("Fold", (int) (x + 120), (int) (y + 180), 40, 25, g);
         */
        //Mouse listener to handle input for each bet


        if(Game.State==STATE.ANTE1) {


            //Bet Button Clicked
            if (mx >=600 && mx <= 1280) {
                if (my >= 300 && my <= 640) {
                    System.out.println("CLICKED");
                        p1.bet();

                }
            }
            else if (mx >= p1.getX()+120 && mx <= p1.getX()+160) {
                if (my >= p1.getY() && my <= 225) {
                        p1.fold();
                }
            }
            else if(p1.getFold() | p1.getAnte() ){
                Game.State= STATE.GAMESTART1;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
