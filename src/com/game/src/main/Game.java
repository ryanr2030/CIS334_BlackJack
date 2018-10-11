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
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 6;
    public static final int SCALE = 2;
    public final String TITLE ="Simple Black Jack Game";

    //used to start the game
    private boolean running = false;
    private Thread thread;

    //buffers the entire game window
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage gameBoard = null;
    private BufferedImage menuBackground = null;
    private BufferedImage deckImg = null;

    private Computer c;
    protected Player p1,p2,p3;
    int p1x,p1y,p2x,p2y,p3x,p3y;
    public Deck deck = new Deck();
    private JFrame frame;
    private Menu menu;
    protected int pot=0, initializer=0;
    MouseInput mouse;


    public static enum STATE{
        MENU,
        GAMESTART1,
        GAMESTART2,
        GAMESTART3,
        ANTE1,
        ANTE2,
        ANTE3,
        HELP,
        COMPUTER_TURN,
        PLAYER1_TURN,
        PLAYER2_TURN,
        PLAYER3_TURN

    }

    protected static STATE State = STATE.MENU;

    public void init(){
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            spriteSheet = loader.loadImage("/sprite_sheet.png");
            gameBoard = loader.loadImage("/gameBoard.png");
            menuBackground = loader.loadImage("/menuBackground.jpg");
        }catch(IOException e){
            e.printStackTrace();
        }
        deck.set();
        deck.shuffle();
        SpriteSheet ss = new SpriteSheet(spriteSheet);
        deckImg=ss.grabImage(26,2,75,109);
        mouse= new MouseInput();
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
        if(State==STATE.ANTE1 && initializer ==0){
            p1 = new Player(600, 300,this );
            initializer =1;

        }
        else if (State==STATE.ANTE2 && initializer==0){
            p1 = new Player(500, 300,this );
            p2 = new Player(700, 300, this);
            initializer =1;

        }
        else if (State==STATE.ANTE3 && initializer==0){
            p1 = new Player(300, 300, this);
            p2 = new Player(600, 300, this);
            p3 = new Player(900, 300, this);
            initializer =1;
        }
        else if(State == STATE.GAMESTART1) {
            if(initializer==1) {

                p1.getCard(deck.draw());
                p1.getCard(deck.draw());
                c.getCard(deck.draw());
                c.getCard(deck.draw());

                initializer=2;
            }
            p1.deal();
            c.deal();


        }
        else if(State == STATE.GAMESTART2) {
            if(initializer==1) {
                p1.getCard(deck.draw());
                p1.getCard(deck.draw());
                p2.getCard(deck.draw());
                p2.getCard(deck.draw());
                c.getCard(deck.draw());
                c.getCard(deck.draw());

                initializer=2;
            }
            p1.deal();
            p2.deal();
            c.deal();
        }
        else if(State == STATE.GAMESTART3) {
            if(initializer==1) {
                p1.getCard(deck.draw());
                p1.getCard(deck.draw());
                p2.getCard(deck.draw());
                p2.getCard(deck.draw());
                p3.getCard(deck.draw());
                p3.getCard(deck.draw());
                c.getCard(deck.draw());
                c.getCard(deck.draw());

                initializer=2;
            }
            p1.deal();
            p2.deal();
            p3.deal();
            c.deal();
        }
        else if(State == STATE.MENU){

        }
    }

    //everything in the game that renders
    private void render(){
        //buffer strategy handles all behind the scenes buffering
        //initialize buffer strategy
        BufferStrategy bs = this.getBufferStrategy();

        //create 3 buffers to load 2 images ahead of what is being projected
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        //draw buffers
        Graphics g = bs.getDrawGraphics();

        // ******************************
        //      DRAWING AREA
        if (State!=STATE.MENU) {
            drawBackground(g);
            drawDeck(g);
        }
        if(State == STATE.ANTE1 && initializer==1){
            p1.render(g);
            c.render(g);
        }
        else if(State == STATE.ANTE2 && initializer==1){
            p1.render(g);
            p2.render(g);
            c.render(g);
        }
        else if(State == STATE.ANTE3 && initializer==1){
            p1.render(g);
            p2.render(g);
            p3.render(g);
            c.render(g);
        }
        else if(State == STATE.GAMESTART1 && initializer==2) {


        }
        else if(State == STATE.GAMESTART2 && initializer==2) {


        }
        else if(State == STATE.GAMESTART3 && initializer==2) {




        }
        else if(State == STATE.MENU){
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

        //Create Scale Sizes for a game window

        //current frame we're working in
        JFrame frame = new JFrame("Black Jack");

        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        game.setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        game.setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        game.setFrame(frame);
        //add the game instance to the frame currently only the dimensions
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

    public BufferedImage getSpriteSheet(){
        return spriteSheet;
    }

    public void setFrame(JFrame frame ){
        this.frame=frame;
    }
    public JFrame getFrame(){
        return frame;
    }

    public void drawBackground(Graphics g){
        g.drawImage(gameBoard, 0, 0, null);

    }
    public void drawDeck(Graphics g){
        for (int i = 0; i < 15; i++) {
            int k = i + 2;
            g.drawImage(deckImg, 480 - k, 60 + i, null);

        }
    }


}
