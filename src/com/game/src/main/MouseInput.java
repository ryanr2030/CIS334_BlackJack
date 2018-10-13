package com.game.src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{
    public Game game;
    MouseInput(Game game){
        this.game=game;
    }
    MouseInput(){

    }

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
          int x=Game.WIDTH/2+100,y=50;
            public Rectangle play3Button = new Rectangle(x+125 , y+50,200,50 );
            public Rectangle play4Button = new Rectangle(x+125 , y+150,200,50 );
            public Rectangle play5Button = new Rectangle(x+125 , y+250,200,50 );
            public Rectangle play6Button = new Rectangle(x+125, y+350,200,50 );
            public Rectangle play7Button = new Rectangle(x+125 , y+450,200,50 );
            public Rectangle quitButton = new Rectangle(x+125 , y+525,200,50 );
        */


        //HANDLES THE TRANSITION FROM MENU TO ANTE STAGE
        //BY DECLARING THE CORRECT # OF PLAYERS WHEN DEPENDING ON WHAT
        //BUTTON IS PRESSED
        if (Game.State == Game.STATE.MENU) {
            //Three Player
            if (mx >= Game.WIDTH / 2 + 225 && mx <= Game.WIDTH / 2 + 425) {
                if (my >= 100 && my <= 150) {
                    game.p1 = new Player(300, 300, game);
                    game.p2 = new Player(600, 300, game);
                    game.p3 = new Player(900, 300, game);
                    game.setPcount(3);
                    game.p1.setTurn(true);
                    Game.State = Game.STATE.ANTE;
                }
            }
            //Four Player
            if (mx >= Game.WIDTH / 2 + 225 && mx <= Game.WIDTH / 2 + 425) {
                if (my >= 200 && my <= 250) {
                    game.p1 = new Player(150, 300, game);
                    game.p2 = new Player(400, 300, game);
                    game.p3 = new Player(650, 300, game);
                    game.p4 = new Player(900, 300, game);
                    game.setPcount(4);
                    game.p1.setTurn(true);
                    Game.State = Game.STATE.ANTE;


                }
            }
            //5 Players
            if (mx >= Game.WIDTH / 2 + 225 && mx <= Game.WIDTH / 2 + 425) {
                if (my >= 300 && my <= 350) {
                    game.p1 = new Player(75, 300, game);
                    game.p2 = new Player(325, 300, game);
                    game.p3 = new Player(575, 300, game);
                    game.p4 = new Player(825, 300, game);
                    game.p5 = new Player(1075, 300, game);

                    game.setPcount(5);
                    game.p1.setTurn(true);
                    Game.State = Game.STATE.ANTE;
                }
            }
            //6 Players
            if (mx >= Game.WIDTH / 2 + 225 && mx <= Game.WIDTH / 2 + 425) {
                if (my >= 400 && my <= 450) {
                    Game.State = Game.STATE.HELP;
                }
            }

            if (mx >= Game.WIDTH / 2 + 225 && mx <= Game.WIDTH / 2 + 425) {
                if (my >= 500 && my <= 550) {
                    game.p1 = new Player(35, 300, game);
                    game.p2 = new Player(210, 300, game);
                    game.p3 = new Player(390, 300, game);
                    game.p4 = new Player(565, 300, game);
                    game.p5 = new Player(745, 300, game);
                    game.p6 = new Player(920, 300, game);
                    game.p7 = new Player(1100, 300, game);

                    game.setPcount(7);
                    game.p1.setTurn(true);
                    Game.State = Game.STATE.ANTE;
                }
            }

            //Quit
            if (mx >= Game.WIDTH / 2 + 225 && mx <= Game.WIDTH / 2 + 425) {
                if (my >= 575 && my <= 625) {

                    System.exit(0);
                }
            }

        }


        //STATE CONTROL FOR THE BUTTONS IN THE ANTE STATE
        // First 7 handle each player's bet button
        // Second 7 handle each player's fold button

        if (Game.State == Game.STATE.ANTE) {

            if (mx >= game.p1.betx && mx <= game.p1.betx + game.p1.bwidth && game.p1.getIsTurn() == true) {
                //Bet Button Clicked
                if (my >= game.p1.by && my <= game.p1.by + game.p1.bheight) {
                    System.out.println("CLICKED");
                    game.p1.bet();
                    game.p1.setAnte(true);
                    game.p1.setTurn(false);
                    game.initializer++;
                    game.p2.setTurn(true);

                }
            } else if (mx >= game.p2.betx && mx <= game.p2.betx + game.p2.bwidth && game.p2.getIsTurn() == true) {
                //Bet Button Clicked
                if (my >= game.p2.by && my <= game.p2.by + game.p2.bheight) {
                    System.out.println("CLICKED");
                    game.p2.bet();
                    game.p2.setAnte(true);
                    game.p2.setTurn(false);
                    game.initializer++;
                    game.p3.setTurn(true);

                }
            } else if (mx >= game.p3.betx && mx <= game.p3.betx + game.p3.bwidth && game.p3.getIsTurn() == true) {
                //Bet Button Clicked
                if (my >= game.p3.by && my <= game.p3.by + game.p3.bheight) {
                    System.out.println("CLICKED");
                    game.p3.bet();
                    game.p3.setAnte(true);
                    game.p3.setTurn(false);
                    game.initializer++;
                    if (game.getPcount() > 3)
                        game.p4.setTurn(true);
                    else {
                        game.p1.setTurn(true);
                        Game.State = Game.STATE.PLAYER1_TURN;
                        game.setHands();
                    }

                }
            } else if (game.p4 != null && mx >= game.p4.betx && mx <= game.p4.betx + game.p4.bwidth && game.p4.getIsTurn() == true) {
                //Bet Button Clicked
                if (my >= game.p4.by && my <= game.p4.by + game.p4.bheight) {
                    System.out.println("CLICKED");
                    game.p4.bet();
                    game.p4.setAnte(true);
                    game.p4.setTurn(false);
                    game.initializer++;
                    if (game.getPcount() > 4)
                        game.p5.setTurn(true);
                    else {
                        game.p1.setTurn(true);
                        Game.State = Game.STATE.PLAYER1_TURN;
                        game.setHands();
                    }

                }
            } else if (game.p5 != null && mx >= game.p5.betx && mx <= game.p5.betx + game.p5.bwidth && game.p5.getIsTurn() == true) {
                //Bet Button Clicked
                if (my >= game.p5.by && my <= game.p5.by + game.p5.bheight) {
                    System.out.println("CLICKED");
                    game.p5.bet();
                    game.p5.setAnte(true);
                    game.p5.setTurn(false);
                    game.initializer++;
                    if (game.getPcount() > 5)
                        game.p6.setTurn(true);
                    else {
                        game.p1.setTurn(true);
                        Game.State = Game.STATE.PLAYER1_TURN;
                        game.setHands();
                    }

                }
            } else if (game.p6 != null && mx >= game.p6.betx && mx <= game.p6.betx + game.p6.bwidth && game.p6.getIsTurn() == true) {
                //Bet Button Clicked
                if (my >= game.p6.by && my <= game.p6.by + game.p6.bheight) {
                    System.out.println("CLICKED");
                    game.p6.bet();
                    game.p6.setAnte(true);
                    game.p6.setTurn(false);
                    game.initializer++;

                    if (game.getPcount() > 6)
                        game.p7.setTurn(true);
                    else {
                        game.p1.setTurn(true);
                        game.setHands();
                        Game.State = Game.STATE.PLAYER1_TURN;
                    }

                }
            } else if (game.p7 != null && mx >= game.p7.betx && mx <= game.p7.betx + game.p7.bwidth && game.p7.getIsTurn() == true) {
                //Bet Button Clicked
                if (my >= game.p7.by && my <= game.p7.by + game.p7.bheight) {
                    System.out.println("CLICKED");
                    game.p7.bet();
                    game.p7.setAnte(true);
                    game.p7.setTurn(false);
                    game.initializer++;
                    game.p1.setTurn(true);
                    game.setHands();
                    Game.State = Game.STATE.PLAYER1_TURN;

                }

            }
            if (mx >= game.p1.foldx && mx <= game.p1.foldx + game.p1.bwidth && game.p1.getIsTurn() == true) {
                //Bet Button Clicked
                if (my >= game.p1.by && my <= game.p1.by + game.p1.bheight) {
                    System.out.println("CLICKED");
                    game.p1.setAnte(false);
                    game.p1.setTurn(false);
                    game.initializer++;
                    game.p2.setTurn(true);

                }
            }
            if (mx >= game.p2.foldx && mx <= game.p2.foldx + game.p2.bwidth && game.p2.getIsTurn() == true) {
                //Bet Button Clicked
                if (my >= game.p2.by && my <= game.p2.by + game.p2.bheight) {
                    System.out.println("CLICKED");
                    game.p2.setAnte(false);
                    game.p2.setTurn(false);
                    game.initializer++;
                    game.p3.setTurn(true);

                }
            } else if (game.p3 != null && mx >= game.p3.foldx && mx <= game.p3.foldx + game.p3.bwidth && game.p3.getIsTurn() == true) {
                //Fold Button Clicked
                if (my >= game.p3.by && my <= game.p3.by + game.p3.bheight) {
                    System.out.println("CLICKED");
                    game.p3.setAnte(false);
                    game.p3.setTurn(false);
                    game.initializer++;
                    if (game.getPcount() > 3)
                        game.p4.setTurn(true);
                    else {
                        game.p1.setTurn(true);
                        game.setHands();
                        Game.State = Game.STATE.PLAYER1_TURN;

                    }
                }

            } else if (game.p4 != null && mx >= game.p4.foldx && mx <= game.p4.foldx + game.p4.bwidth && game.p4.getIsTurn() == true) {
                //Fold Button Clicked
                if (my >= game.p4.by && my <= game.p4.by + game.p4.bheight) {
                    System.out.println("CLICKED");
                    game.p4.setAnte(false);
                    game.p4.setTurn(false);
                    game.initializer++;
                    if (game.getPcount() > 4)
                        game.p5.setTurn(true);
                    else {
                        game.p1.setTurn(true);
                        game.setHands();
                        Game.State = Game.STATE.PLAYER1_TURN;
                    }
                }

            } else if (game.p5 != null && mx >= game.p5.foldx && mx <= game.p5.foldx + game.p5.bwidth && game.p5.getIsTurn() == true) {
                //Fold Button Clicked
                if (my >= game.p5.by && my <= game.p5.by + game.p5.bheight) {
                    System.out.println("CLICKED");
                    game.p5.setAnte(false);
                    game.p5.setTurn(false);
                    game.initializer++;
                    if (game.getPcount() > 5)
                        game.p6.setTurn(true);
                    else {
                        game.p1.setTurn(true);
                        game.setHands();
                        Game.State = Game.STATE.PLAYER1_TURN;
                    }
                }

            } else if (game.p6 != null && mx >= game.p6.foldx && mx <= game.p6.foldx + game.p6.bwidth && game.p6.getIsTurn() == true) {
                //Fold Button Clicked
                if (my >= game.p6.by && my <= game.p6.by + game.p6.bheight) {
                    System.out.println("CLICKED");
                    game.p6.setAnte(false);
                    game.p6.setTurn(false);
                    game.initializer++;
                    if (game.getPcount() > 6)
                        game.p7.setTurn(true);
                    else {
                        game.p1.setTurn(true);
                        game.setHands();
                        Game.State = Game.STATE.PLAYER1_TURN;

                    }
                }

            } else if (game.p7 != null && mx >= game.p7.foldx && mx <= game.p7.foldx + game.p7.bwidth && game.p7.getIsTurn() == true) {
                //Fold Button Clicked
                if (my >= game.p7.by && my <= game.p7.by + game.p7.bheight) {
                    System.out.println("CLICKED");
                    game.p7.setAnte(false);
                    game.p7.setTurn(false);
                    game.initializer++;
                    game.p1.setTurn(true);
                    Game.State = Game.STATE.PLAYER1_TURN;
                    game.setHands();
                }

            }


        }
        /*
        ******************************************************************
        *********************TO DO****************************************
        ******************************************************************
         make the hit fold and stay button work for each player
         if we get it working for 1 player we just copy and paste it 6 times and change the variables
         */

        if (Game.State == Game.STATE.PLAYER1_TURN) {
            game.initializer=1;
            if (mx >= game.p1.betx && mx <= game.p1.betx + game.p1.bwidth && game.p1.getIsTurn() == true) {
                //Bet Button Clicked
                if (my >= game.p1.by && my <= game.p1.by + game.p1.bheight ) {
                    System.out.println("CLICKED");
                    game.p1.hit(game.deck.draw());
                    if (game.initializer == 4 | game.p1.bust() == true){
                        game.p1.setTurn(false);
                        game.initializer++;
                        game.p2.setTurn(true);
                    }
                }
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
