package com.game.src.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JButton;

import javax.swing.*;

public class Game extends Canvas implements Runnable{
    //
    //Sets resolution to 1280x640
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 6;
    public static final int SCALE = 2;
    public final String TITLE ="Simple Black Jack Game";
    //used to start the game
    private boolean running = false;

    //threads to allow multithreading
    private Thread thread;


    //buffers the entire game window

    //contains all the card images
    private BufferedImage spriteSheet = null;

    //contains the poker table background during the game
    private BufferedImage gameBoard = null;
    //contains the background image for the menu
    private BufferedImage menuBackground = null;
    //contains a facedown card used to paint the deck in each frame
    private BufferedImage deckImg = null;

    //declare a computer player
    private Computer c;

    //declare the number of possible players in the game
    protected Player p1,p2,p3,p4, p5, p6, p7;
    //used to tell how many players to initialize
    private int pcount=0;

    //Create a deck object
    public Deck deck = new Deck();

    //frame to be painted on
    private JFrame frame;

    //declare the menu ui in the game class
    private Menu menu;

    //pot will be used to distribute the winnings to the winning player during the end state
    //initializer is used to make sure player assignment is not repeated
    public int pot=0, initializer=0;
    MouseInput mouse;

    /*Enumeration list to control the game.

    These are the most important part of the game because they tell the game loop what to draw
    in each frame.

        STATE FLOW: MENU--> ANTE-->PLAYER1_TURN-->...-->PLAYERN_TURN-->COMPUTER_TURN-->ANTE-->PLAYER1_TURN-->...-->PLAYERN_TURN-->COMPUTER_TURN
                    -->END_GAME

        MENU functionality: displays the menu gui transitions to Ante with the selected amount of players

        ANTE functionality:initialize the correct number of player objects, allow each player to bet or fold,
                            deal two cards to two each player the comp, transitions to Player1's turn
             gui paints: deal animation, display cards in hand of players that bet, (optional)fold/hit button click animations,
                        (optional) display a chip when a player bets, paint gameboard, and player ui (i.e. player # buttons and wallet value)
                        Add current turn indicator
        PLAYER_TURN functionality: Checks if the player busted(including ace exception), Allows the player to hit (Max of 4 times) or fold,
                    checks if another play has black jack (forces cur player to hit till bust or they also get blackjack),
                    transitions to either next player's turn or the computer's turn
              gui paints: draw animation for each hit, display the current hand with hit updates, if fold remove hit, stay, and fold buttons and remove cards
        COMPUTER_TURN: Checks the scores of all of the other players, if the computer is losing hits until it wins or if it busts same paint animation
                        display the winner's name across the screen clicking anywhere on the screen starts the next hand

        END GAME: occurs if all players run out of money or if a certain key is pressed should return back to the MENU state
    */
    public static enum STATE{
        MENU,
        ANTE,
        HELP,
        COMPUTER_TURN,
        PLAYER_TURN,
        END_GAME

    }

    protected static STATE State = STATE.MENU;

    //initialize the game
    public void init(){
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            spriteSheet = loader.loadImage("/sprite_sheet.png");
            gameBoard = loader.loadImage("/gameBoard.png");
            menuBackground = loader.loadImage("/menuBackground.jpg");
        }catch(IOException e){
            e.printStackTrace();
        }
        //sets the deck with each card object
        deck.set();
        //shuffles the deck
        deck.shuffle();

        //makes all the sprites available to the game
        SpriteSheet ss = new SpriteSheet(spriteSheet);

        deckImg=ss.grabImage(26,2,75,109);
        mouse= new MouseInput(this);
        menu= new Menu();


        c= new Computer(600, 60, this);




    }

    //starts our thread to run the game loop on
    private synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);

        thread.start();
    }

    //stops the thread and joins them together and waits for the OS to kill them
    private synchronized void stop(){
        if(!running)
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks =60.0;
        double ns = 1000000000/amountOfTicks;
        //time passed
        double delta =0;
        int updates = 0;
        int frames=0;
        long timer=System.currentTimeMillis();


        //start the game loop
        while(running){
            //set fps
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            if(delta >= 1){
                tick();
                delta--;
                updates++;
            }
            render();
            frames++;
            if(System.currentTimeMillis()-timer>1000){
               timer+=1000;
               System.out.println(updates+" Ticks, FPS "+frames);
               updates=0;
               frames=0;
            }
        }
        stop();
    }

    //everything in the game that updates
    private void tick(){
        if(State==STATE.ANTE ) {
        }
        else if(State == STATE.PLAYER_TURN){
                dealHands();
        }
        else if(State == STATE.MENU){

        }
    }

    //everything in the game that renders must be drawn or have another object call
    private void render(){
        //buffer strategy handles all behind the scenes buffering
        //initialize buffer strategy
        BufferStrategy bs = this.getBufferStrategy();

        //create 3 buffers to load 2 images ahead of what is being projected
        if(bs == null){
            createBufferStrategy(2);
            return;
        }

        //draw buffers
        Graphics g = bs.getDrawGraphics();

        // ******************************
        //      DRAWING AREA
        if (State!=STATE.MENU) {
            drawBackground(g);
            drawDeck(g);
            drawPot(g);

        }
        if(State == STATE.ANTE ) {
            drawHands(g);

        }
        if(State == STATE.PLAYER_TURN){
            drawHands(g);
        }
        if(State == STATE.COMPUTER_TURN){
            drawHands(g);
        }
        if(State == STATE.END_GAME){
            drawHands(g);
        }
        if(State == STATE.MENU){
            g.drawImage(menuBackground, 0, 0, null);
            menu.render(g);

        }
        //*****************************

        //dispose of buffers and show on image
        g.dispose();
        bs.show();

    }

    public static void main(String args[]){

        //create the instance of our game


        //current frame we're working in
        JFrame frame = new JFrame("Black Jack");
        //Create Scale Sizes for a game window
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        game.setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        game.setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        game.setFrame(frame);
        //add the game instance to the frame currently 1280x640
        frame.add(game);


        frame.setVisible(true);
        //set all of its contents at or above their preferred sizes
        frame.pack();

        //Close when 'x' is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //game window is not resizeable
        frame.setResizable(false);

        //game frame defaults to center of the screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Call the start to begin the game loop
        game.start();


    }
    //sets the values in each player's hand
    public void setHands(){
        if(pcount>=1 && p1.getAnte()==true){
            p1.getCard(deck.draw());
            p1.getCard(deck.draw());
        }
        if(pcount>=2 && p2.getAnte()==true){
            p2.getCard(deck.draw());
            p2.getCard(deck.draw());
        }
        if(pcount>=3 && p3.getAnte()==true){
            p3.getCard(deck.draw());
            p3.getCard(deck.draw());
        }
        if(pcount>=4 && p4.getAnte()==true){
            p4.getCard(deck.draw());
            p4.getCard(deck.draw());
        }
        if(pcount>=5 && p5.getAnte()==true){
            p5.getCard(deck.draw());
            p5.getCard(deck.draw());
        }
        if(pcount>=6 && p6.getAnte()==true){
            p6.getCard(deck.draw());
            p6.getCard(deck.draw());
        }
        if(pcount>=7 && p7.getAnte()==true){
            p7.getCard(deck.draw());
            p7.getCard(deck.draw());
        }
        c.getCard(deck.draw());
        c.getCard(deck.draw());

    }
    //updates the x and y coordinates of the dealed hands to provide the animation
    private void dealHands(){
        if(pcount>=1 && p1.getAnte()==true){
            p1.deal();
        }
        if(pcount>=2 && p2.getAnte()==true){
            p2.deal();
        }
        if(pcount>=3 && p3.getAnte()==true){
            p3.deal();
        }
        if(pcount>=4 && p4.getAnte()==true){
            p4.deal();
        }
        if(pcount>=5 && p5.getAnte()==true){
            p5.deal();
        }
        if(pcount>=6 && p6.getAnte()==true){
            p6.deal();
        }
        if(pcount>=7 && p7.getAnte()==true){
            p7.deal();
        }
        c.deal();
    }
    public BufferedImage getSpriteSheet(){
        return spriteSheet;
    }
//Calls the render function of each player that is in the game to draw their current hand each frame
    public void drawHands(Graphics g){
        if(pcount>=1){
            p1.render(g);
        }
        if(pcount>=2 ){
            p2.render(g);
        }
        if(pcount>=3 ){
            p3.render(g);
        }
        if(pcount>=4){
            p4.render(g);
        }
        if(pcount>=5 ){
            p5.render(g);
        }
        if(pcount>=6 ){
            p6.render(g);
        }
        if(pcount>=7 ){
            p7.render(g);
        }
        c.render(g);
    }
//draws the background game board
    public void drawBackground(Graphics g){
        g.drawImage(gameBoard, 0, 0, null);

    }
    //drwas the value of the pot
    public void drawPot(Graphics g){
        Font fnt1 = new Font("arial", Font.BOLD,20);
        g.setFont(fnt1);
        g.drawString("Pot Value $"+pot,600, 220 );
    }

    //draws the deck image next to the computer's hand
    public void drawDeck(Graphics g){
        for (int i = 0; i < 15; i++) {
            int k = i + 2;
            g.drawImage(deckImg, 480 - k, 60 + i, null);

        }
    }

    //getters and setters for utility
    public int getPcount(){
        return pcount;
    }

    public void setPcount(int i){
        pcount=i;
    }

    public void setFrame(JFrame frame ){
        this.frame=frame;
    }
    public JFrame getFrame(){
        return frame;
    }
}
