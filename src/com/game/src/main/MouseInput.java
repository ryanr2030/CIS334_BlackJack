package com.game.src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MouseInput implements MouseListener{
    public Game game;
    int i =0, test=0;
    ArrayList<String> turnList = new ArrayList <>();
    boolean turns=true, score=true;

    public MouseInput(Game game) {
        this.game=game;
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
                        game.p1 = new Player(70, 300, game);
                        game.p2 = new Player(260, 300, game);
                        game.p3 = new Player(445, 300, game);
                        game.p4 = new Player(630, 300, game);
                        game.p5 = new Player(815, 300, game);
                        game.p6 = new Player(1000, 300, game);
                        game.setPcount(6);
                        game.p1.setTurn(true);
                        Game.State=Game.STATE.ANTE;
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
                        Game.State = Game.STATE.PLAYER_TURN;
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
                        Game.State = Game.STATE.PLAYER_TURN;
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
                        Game.State = Game.STATE.PLAYER_TURN;
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
                        Game.State = Game.STATE.PLAYER_TURN;
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
                    Game.State = Game.STATE.PLAYER_TURN;

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
                        game.initializer=1;
                        Game.State = Game.STATE.PLAYER_TURN;

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
                        Game.State = Game.STATE.PLAYER_TURN;
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
                        Game.State = Game.STATE.PLAYER_TURN;
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
                        Game.State = Game.STATE.PLAYER_TURN;

                    }
                }

            } else if (game.p7 != null && mx >= game.p7.foldx && mx <= game.p7.foldx + game.p7.bwidth && game.p7.getIsTurn()) {
                //Fold Button Clicked
                if (my >= game.p7.by && my <= game.p7.by + game.p7.bheight) {
                    System.out.println("CLICKED");
                    game.p7.setAnte(false);
                    game.p7.setTurn(false);
                    game.initializer++;
                    game.p1.setTurn(true);
                    Game.State = Game.STATE.PLAYER_TURN;
                    game.setHands();
                }

            }


        }


        if (Game.State == Game.STATE.PLAYER_TURN) {
            if (turns) {
                turnList.add("P1 " + game.p1.getAnte());
                turnList.add("P2 " + game.p2.getAnte());
                turnList.add("P3 " + game.p3.getAnte());
                if (game.p4 != null)
                    turnList.add("P4 " + game.p4.getAnte());
                if (game.p5 != null)
                    turnList.add("P5 " + game.p5.getAnte());
                if (game.p6 != null)
                    turnList.add("P6 " + game.p6.getAnte());
                if (game.p7 != null)
                    turnList.add("P7 " + game.p7.getAnte());
                turnList.add("Computer");
                turns = false;
            }
            if (turnList.size() == 1) {
                Game.State = Game.STATE.COMPUTER_TURN;
            }
            if(turnList.get(0).contains("P1 false")){
                game.p1.setTurn(false);
            }
            if (turnList.get(0).contains("P1 true")) {
                    //Stay Pressed
                    if (mx >= game.p1.stayx && mx <= game.p1.stayx + game.p1.bwidth && my >= game.p1.by && my <= game.p1.by + game.p1.bheight) {
                        turnList.remove(0);
                        game.p1.setTurn(false);
                    }
                    else if (game.p1.getHandVal() > 21) {
                        System.out.println("Player 1 Busted:" + game.p1.getHandVal());
                        turnList.remove(0);
                        game.p1.setTurn(false);
                     }
                    else if(game.p1.getHandVal()==21){
                        turnList.remove(0);
                        game.p1.setTurn(false);
                    }
                    //hit pressed
                    else if (mx >= game.p1.betx && mx <= game.p1.betx + game.p1.bwidth && my >= game.p1.by && my <= game.p1.by + game.p1.bheight && game.p1.hcount < 4) {
                        game.p1.hit(game.deck.draw());
                        game.p1.x2=465;
                        game.p1.y2=75;
                        game.p1.hcount++;
                        System.out.println("HIT CLICKED");
                        if (game.p1.getHandVal() > 21) {
                            System.out.println("Player 1 Busted:" + game.p1.getHandVal());
                            turnList.remove(0);
                            game.p1.setTurn(false);
                        }

                        if(game.p1.getHandVal()==21){
                            turnList.remove(0);
                            game.p1.setTurn(false);
                        }
                    }

                }
                if (turnList.get(0).contains("P2 true")) {
                    if (!game.p2.getIsTurn())
                        game.p2.setTurn(true);
                    if (game.p2.getHandVal() > 21) {
                        System.out.println("Player 2 Busted:" + game.p2.getHandVal());
                        turnList.remove(0);
                        game.p2.setTurn(false);
                    }
                    else if(game.p2.getHandVal()==21){
                        turnList.remove(0);
                        game.p2.setTurn(false);
                    }
                    //Stay Pressed
                    else if (mx >= game.p2.stayx && mx <= game.p2.stayx + game.p2.bwidth && my >= game.p2.by && my <= game.p2.by + game.p2.bheight) {
                        turnList.remove(0);
                        game.p2.setTurn(false);
                    }
                    //hit pressed
                    else if (mx >= game.p2.betx && mx <= game.p2.betx + game.p2.bwidth && my >= game.p2.by && my <= game.p2.by + game.p2.bheight && game.p2.hcount < 4) {
                        game.p2.hit(game.deck.draw());
                        game.p2.x2=465;
                        game.p2.y2=75;
                        game.p2.hcount++;
                        System.out.println("HIT CLICKED");
                        if (game.p2.getHandVal() > 21) {
                            System.out.println("Player 2 Busted:" + game.p2.getHandVal());
                            turnList.remove(0);
                            game.p2.setTurn(false);
                        }
                        if(game.p2.getHandVal()==21){
                            turnList.remove(0);
                            game.p2.setTurn(false);
                        }
                    }

                }
                if (turnList.get(0).contains("P3 true")) {
                    if (!game.p3.getIsTurn())
                        game.p3.setTurn(true);
                    if (game.p3.getHandVal() > 21) {
                        System.out.println("Player 3 Busted:" + game.p3.getHandVal());
                        turnList.remove(0);
                        game.p3.setTurn(false);
                    }
                    else if(game.p3.getHandVal()==21){
                        turnList.remove(0);
                        game.p3.setTurn(false);
                    }
                    //Stay Pressed
                    else if (mx >= game.p3.stayx && mx <= game.p3.stayx + game.p3.bwidth && my >= game.p3.by && my <= game.p3.by + game.p3.bheight) {
                        turnList.remove(0);
                        game.p3.setTurn(false);
                    }
                    //hit pressed
                    else if (mx >= game.p3.betx && mx <= game.p3.betx + game.p3.bwidth && my >= game.p3.by && my <= game.p3.by + game.p3.bheight && game.p3.hcount < 4) {
                        game.p3.hit(game.deck.draw());
                        game.p3.x2=465;
                        game.p3.y2=75;
                        game.p3.hcount++;
                        System.out.println("HIT CLICKED");
                        if (game.p3.getHandVal() > 21) {
                            System.out.println("Player 3 Busted:" + game.p3.getHandVal());
                            turnList.remove(0);
                            game.p3.setTurn(false);
                        }
                        if(game.p3.getHandVal()==21){
                            turnList.remove(0);
                            game.p3.setTurn(false);
                        }
                    }

                }

                if (turnList.get(0).contains("P4 true")) {
                    if (!game.p4.getIsTurn())
                        game.p4.setTurn(true);
                    if (game.p4.getHandVal() > 21) {
                        System.out.println("Player 4 Busted:" + game.p4.getHandVal());
                        turnList.remove(0);
                        game.p4.setTurn(false);
                    }
                    else if(game.p4.getHandVal()==21){
                        turnList.remove(0);
                        game.p4.setTurn(false);
                    }
                    //Stay Pressed
                    else if (mx >= game.p4.stayx && mx <= game.p4.stayx + game.p4.bwidth && my >= game.p4.by && my <= game.p4.by + game.p4.bheight) {
                        turnList.remove(0);
                        game.p4.setTurn(false);
                    }
                    //hit pressed
                    else if (mx >= game.p4.betx && mx <= game.p4.betx + game.p4.bwidth && my >= game.p4.by && my <= game.p4.by + game.p4.bheight && game.p4.hcount < 4) {
                        game.p4.hit(game.deck.draw());
                        game.p4.x2=465;
                        game.p4.y2=75;
                        game.p4.hcount++;
                        System.out.println("HIT CLICKED");
                        if (game.p4.getHandVal() > 21) {
                            System.out.println("Player 4 Busted:" + game.p4.getHandVal());
                            turnList.remove(0);
                            game.p4.setTurn(false);
                        }
                        if(game.p4.getHandVal()==21){
                            turnList.remove(0);
                            game.p4.setTurn(false);
                        }
                    }

                }
                if (turnList.get(0).contains("P5 true")) {
                    if (!game.p5.getIsTurn())
                        game.p5.setTurn(true);
                    if (game.p5.getHandVal() > 21) {
                        System.out.println("Player 5 Busted:" + game.p5.getHandVal());
                        turnList.remove(0);
                        game.p5.setTurn(false);
                    }
                    else if(game.p5.getHandVal()==21){
                        turnList.remove(0);
                        game.p5.setTurn(false);
                    }
                    //Stay Pressed
                    else if (mx >= game.p5.stayx && mx <= game.p5.stayx + game.p5.bwidth && my >= game.p5.by && my <= game.p5.by + game.p5.bheight) {
                        turnList.remove(0);
                        game.p5.setTurn(false);
                    }
                    //hit pressed
                    else if (mx >= game.p5.betx && mx <= game.p5.betx + game.p5.bwidth && my >= game.p5.by && my <= game.p5.by + game.p5.bheight && game.p5.hcount < 4) {
                        game.p5.hit(game.deck.draw());
                        game.p5.x2=465;
                        game.p5.y2=75;
                        game.p5.hcount++;
                        System.out.println("HIT CLICKED");
                        if (game.p5.getHandVal() > 21) {
                            System.out.println("Player 5 Busted:" + game.p5.getHandVal());
                            turnList.remove(0);
                            game.p5.setTurn(false);
                        }
                        if(game.p5.getHandVal()==21){
                            turnList.remove(0);
                            game.p5.setTurn(false);
                        }
                    }

                }
                if (turnList.get(0).contains("P6 true")) {
                    if (!game.p6.getIsTurn())
                        game.p6.setTurn(true);
                    if (game.p6.getHandVal() > 21) {
                        System.out.println("Player 6 Busted:" + game.p6.getHandVal());
                        turnList.remove(0);
                        game.p6.setTurn(false);
                    }
                    else if(game.p6.getHandVal()==21){
                        turnList.remove(0);
                        game.p6.setTurn(false);
                    }
                    //Stay Pressed
                    else if (mx >= game.p6.stayx && mx <= game.p6.stayx + game.p6.bwidth && my >= game.p6.by && my <= game.p6.by + game.p6.bheight) {
                        turnList.remove(0);
                        game.p6.setTurn(false);
                    }
                    //hit pressed
                    else if (mx >= game.p6.betx && mx <= game.p6.betx + game.p6.bwidth && my >= game.p6.by && my <= game.p6.by + game.p6.bheight && game.p6.hcount < 4) {
                        game.p6.hit(game.deck.draw());
                        game.p6.x2=465;
                        game.p6.y2=75;
                        game.p6.hcount++;
                        System.out.println("HIT CLICKED");
                        if (game.p6.getHandVal() > 21) {
                            System.out.println("Player 6 Busted:" + game.p6.getHandVal());
                            turnList.remove(0);
                            game.p6.setTurn(false);
                        }
                        if(game.p6.getHandVal()==21){
                            turnList.remove(0);
                            game.p6.setTurn(false);
                        }
                    }

                }
                if (turnList.get(0).contains("P7 true")) {
                    if (!game.p7.getIsTurn())
                        game.p7.setTurn(true);
                    if (game.p7.getHandVal() > 21) {
                        System.out.println("Player 7 Busted:" + game.p7.getHandVal());
                        turnList.remove(0);
                        game.p7.setTurn(false);
                    }
                    else if(game.p7.getHandVal()==21){
                        turnList.remove(0);
                        game.p7.setTurn(false);
                    }
                    //Stay Pressed
                    else if (mx >= game.p7.stayx && mx <= game.p7.stayx + game.p7.bwidth && my >= game.p7.by && my <= game.p7.by + game.p7.bheight) {
                        turnList.remove(0);
                        game.p7.setTurn(false);
                    }
                    //hit pressed
                    else if (mx >= game.p7.betx && mx <= game.p7.betx + game.p7.bwidth && my >= game.p7.by && my <= game.p7.by + game.p7.bheight && game.p7.hcount < 4) {
                        game.p7.hit(game.deck.draw());
                        game.p7.x2=465;
                        game.p7.y2=75;
                        game.p7.hcount++;
                        System.out.println("HIT CLICKED");
                        if (game.p7.getHandVal() > 21) {
                            System.out.println("Player 7 Busted:" + game.p7.getHandVal());
                            turnList.remove(0);
                            game.p7.setTurn(false);
                        }
                        if(game.p7.getHandVal()==21){
                            turnList.remove(0);
                            game.p7.setTurn(false);
                        }
                    }

                }
                if (turnList.get(0).contains("false")) {
                    turnList.remove(0);
                }


        }

        if (Game.State == Game.STATE.COMPUTER_TURN) {
            if(score) {
                game.c.getMaxHand();
                score=false;
            }
            while (game.c.getHandVal() < 22 && game.c.getHandVal() <= game.c.maxHand) {
                game.c.hit(game.deck.draw());
                System.out.println(game.c.getHandVal());
            }
            if(game.c.getHandVal() <22 && game.c.getHandVal()>game.c.maxHand){
                while(game.c.winner.size()!=0){
                    game.c.winner.remove(0);
                }
                game.c.winner.add("Computer");
            }
                Game.State=Game.STATE.END_GAME;
                game.c.winnings();

                System.out.println(game.c.winner);
                game.c.maxHand=0;
                score=true;

        }
        if (Game.State== Game.STATE.END_GAME){
            //define start next hand button
            /*
            button("New Hand", x+360,y+25,60, 25, g);
            button("MENU", x+500,y+25,60, 25, g);
            */

            //New Hand Clicked
            if(mx>=game.c.getX()+360 && mx<=game.c.getX()+420 && my>=game.c.getY()+25 && my<=game.c.getY()+50){
                System.out.println("New Hand Clicked");
                game.deck.clearDeck();
                game.deck.set();
                game.deck.shuffle();
                game.c.clearHand();
                game.c.count=0;
                turns=true;
                while(turnList.size()>0){
                    turnList.remove(0);
                }
                if(game.pcount>=1){
                    game.p1.setAnte(false);
                    game.p1.setTurn(true);
                    game.p1.count=0;
                    game.p1.hcount=0;
                    game.p1.handVal=0;
                    game.p1.clearHand();
                    game.p1.x2=465;
                    game.p1.y2=75;

                }
                if(game.pcount>=2){
                    game.p2.setAnte(false);
                    game.p2.setTurn(false);
                    game.p2.count=0;
                    game.p2.handVal=0;
                    game.p2.hcount=0;
                    game.p2.clearHand();
                    game.p2.x2=465;
                    game.p2.y2=75;
                }
                if(game.pcount>=3){
                    game.p3.setAnte(false);
                    game.p3.setTurn(false);
                    game.p3.count=0;
                    game.p3.handVal=0;
                    game.p3.hcount=0;
                    game.p3.clearHand();
                    game.p3.x2=465;
                    game.p3.y2=75;
                }
                if(game.pcount>=4){
                    game.p4.setAnte(false);
                    game.p4.setTurn(false);
                    game.p4.count=0;
                    game.p4.handVal=0;
                    game.p4.hcount=0;
                    game.p4.clearHand();
                    game.p4.x2=465;
                    game.p4.y2=75;
                }
                if(game.pcount>=5){
                    game.p5.setAnte(false);
                    game.p5.setTurn(false);
                    game.p5.count=0;
                    game.p5.handVal=0;
                    game.p5.hcount=0;
                    game.p5.clearHand();
                    game.p5.x2=465;
                    game.p5.y2=75;

                }
                if(game.pcount>=6){
                    game.p6.setAnte(false);
                    game.p6.setTurn(false);
                    game.p6.count=0;
                    game.p6.handVal=0;
                    game.p6.hcount=0;
                    game.p6.clearHand();
                    game.p6.x2=465;
                    game.p6.y2=75;
                }
                if(game.pcount>=7 ){
                    game.p7.setAnte(false);
                    game.p7.setTurn(false);
                    game.p7.count=0;
                    game.p7.handVal=0;
                    game.p7.hcount=0;
                    game.p7.clearHand();
                    game.p7.x2=465;
                    game.p7.y2=75;

                }
                game.c.money=false;
                game.c.x2=465;
                game.c.y2=75;
                game.initializer=0;
                game.pot=0;
                Game.State=Game.STATE.ANTE;



            }

            //New Hand Clicked
            if(mx>=game.c.getX()+500 && mx<=game.c.getX()+560 && my>=game.c.getY()+25 && my<=game.c.getY()+50){
                System.out.println("MENU Clicked");
                game.p1=null;
                game.p2=null;
                game.p3=null;
                game.p4=null;
                game.p5=null;
                game.p6=null;
                game.p7=null;
                game.c=null;
                Game.State=Game.STATE.MENU;



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
