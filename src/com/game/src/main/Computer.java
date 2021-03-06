package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;

/*
NEEDS TO BE UPDATED AFTER WE GET THE PLAYER_TURN STATE WORKING
 */
public class Computer {
    private int x;
    protected int x2;
    private int y;
    protected int y2;
    public int count;
    private card[] hand=new card[6];
    public int hcount=0;
    private boolean ante;
    private boolean isTurn;
    private boolean fold;
    private boolean isBust=false;
    private boolean stay=false;
    protected boolean money=false;
    private int wallet=1000;
    private int handVal=0, hplayed=0;
    protected int maxHand=0;
    private SpriteSheet ss;
    private Game game;
    protected ArrayList<String> winner=new ArrayList<String>();





    private int cardCol, cardRow;
    private BufferedImage card1,card2, card3, card4, card5, card6, facedown, turn_indicator;


    public Computer(int X, int Y, Game game){
        this.game=game;
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
        g.drawImage(facedown, x2, y2,null);
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
        if(Game.State==Game.STATE.END_GAME){
            compPanel(g);
            drawWinner(g);
            drawNextHand(g);
        }
    }

    //Computer panel
    public void compPanel(Graphics g){
                g.drawImage(turn_indicator, x -200, y, null);
                Font fnt1 = new Font("arial", Font.BOLD, 100);
                if(getHandVal()>21){
                    g.drawString("BUST", x + 50, y +125 );
                }
                else
                    g.drawString("Hand:" + getHandVal(), x + 50, y +125 );
    }

    //places a card in the deck
    public void hit(card C){
        if(bust()==false ){
            getCard(C);
        }
    }

    //check if a player busted includes an if ace handler
    public boolean bust() {
        return getHandVal() > 21;
    }



    public int getMaxHand(){
        if(game.pcount>=1 && game.p1.getHandVal()<22 && game.p1.getAnte()){
            maxHand=game.p1.getHandVal();
            winner.add("Player 1");
        }
        if(game.pcount>=2 && game.p2.getHandVal()<22 && game.p2.getAnte()){
            if(maxHand<game.p2.getHandVal()){
                maxHand=game.p2.getHandVal();
                while (winner.size()!=0){
                    winner.remove(0);
                }
                winner.add("Player 2");
            }
            else if(maxHand==game.p2.getHandVal()){
                winner.add("Player 2");
            }
        }
        if(game.pcount>=3 && game.p3.getHandVal()<22 && game.p3.getAnte()){
            if(maxHand<game.p3.getHandVal()){
                maxHand=game.p3.getHandVal();
                while (winner.size()!=0){
                    winner.remove(0);
                }
                winner.add("Player 3");
            }
            else if(maxHand==game.p3.getHandVal()){
                winner.add("Player 3");
            }
        }
        if(game.pcount>=4 && game.p4.getHandVal()<22 && game.p4.getAnte()){
            if(maxHand<game.p4.getHandVal()){
                maxHand=game.p4.getHandVal();
                while (winner.size()!=0){
                    winner.remove(0);
                }
                winner.add("Player 4");
            }
            else if(maxHand==game.p4.getHandVal()){
                winner.add("Player 4");
            }
        }
        if(game.pcount>=5 && game.p5.getHandVal()<22 && game.p5.getAnte()){
            if(maxHand<game.p5.getHandVal()){
                maxHand=game.p5.getHandVal();
                while (winner.size()!=0){
                    winner.remove(0);
                }
                winner.add("Player 5");
            }
            else if(maxHand==game.p5.getHandVal()){
                winner.add("Player 5");
            }
        }
        if(game.pcount>=6 && game.p6.getHandVal()<22 && game.p6.getAnte()){
            if(maxHand<game.p6.getHandVal()){
                maxHand=game.p6.getHandVal();
                while (winner.size()!=0){
                    winner.remove(0);
                }
                winner.add("Player 6");
            }
            else if(maxHand==game.p6.getHandVal()){
                winner.add("Player 6");
            }
        }
        if(game.pcount>=7 && game.p7.getHandVal()<22 && game.p7.getAnte()){
            if(maxHand<game.p7.getHandVal()){
                maxHand=game.p7.getHandVal();
                while (winner.size()!=0){
                    winner.remove(0);
                }
                winner.add("Player 7");
            }
            else if(maxHand==game.p7.getHandVal()){
                winner.add("Player 7");
            }
        }
        return maxHand;
    }

    //returns the current value of the hand
    public int getHandVal(){
        handVal=0;
        int aceCount=0;
        for (int i=0; i<count; i++){
            handVal+=hand[i].getValue();
            if(hand[i].getValue()==11)
                aceCount++;
        }
        if (handVal>21 && aceCount!=0){
            for(int j=1; j<=aceCount; j++) {
                handVal=0;
                int l=1;
                for (int i = 0; i <count; i++) {
                    if (hand[i].getValue() == 11 && l<j+1 ) {
                        handVal += 1;
                        l++;
                    } else
                        handVal += hand[i].getValue();
                }
                if(handVal<=21){
                    return handVal;
                }
                j++;
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

    //distributes the winnings
    public void winnings(){
        ArrayList<String> winners= new ArrayList<String>();
        for(int i=0; i<winner.size(); i++) {
            String temp=winner.get(i);
            winners.add(temp);
        }
        //System.out.println(winners);
        System.out.println(maxHand);
        int winPot=game.pot/winner.size();
        while(winners.size()!=0){
            if(winners.get(0).contains("1")){
                game.p1.wallet+=winPot;
                winners.remove(0);
            }
            if(winners.size()>0 && winners.get(0).contains("2")){
                game.p2.wallet+=winPot;
                winners.remove(0);
            }
            if(winners.size()>0 && winners.get(0).contains("3")){
                game.p3.wallet+=winPot;
                winners.remove(0);
            }
            if(winners.size()>0 && winners.get(0).contains("4")){
                game.p4.wallet+=winPot;
                winners.remove(0);
            }
            if(winners.size()>0 && winners.get(0).contains("5")){
                game.p5.wallet+=winPot;
                winners.remove(0);
            }
            if(winners.size()>0 && winners.get(0).contains("6")){
                game.p6.wallet+=winPot;
                winners.remove(0);
            }
            if(winners.size()>0 && winners.get(0).contains("7")){
                game.p7.wallet+=winPot;
                winners.remove(0);
            }
            if(winners.size()>0 && winners.get(0).contains("Computer")){
                winners.remove(0);
            }

        }
        money=true;
    }
    //DRAWS THE WINNER'S PANEL
    public void drawWinner(Graphics g){
            Font fnt1 = new Font("arial", Font.BOLD,40);
            g.setFont(fnt1);
            g.drawString(winner+" WINS!!!", x -200, y +200);
    }
    public void button(String title, int x, int y, int width, int height, Graphics g){
        g.setColor(Color.white);
        g.fillRect(x , y, width, height);
        g.setColor(Color.black);
        g.drawRect(x , y, width, height);
        Font fnt1 = new Font("arial", Font.BOLD,9);
        g.setFont(fnt1);
        g.drawString(title, x+width/5, y+2*height/3);
    }

    //DRAW LOOP NEXT HAND MENU
    public void drawNextHand(Graphics g){
        g.setColor(Color.lightGray);
        g.fillRect(x+300, y, 300, 75);
        g.setColor(Color.black);
        g.drawRect(x+300 , y, 300, 75);
        button("New Hand", x+360,y+25,60, 25, g);
        button("MENU", x+500,y+25,60, 25, g);

    }
    //DRAWS THE CARD HAND
    public void drawHand(Graphics g){
        if (card1 !=null) {
            if(Game.State==Game.STATE.COMPUTER_TURN || Game.State==Game.STATE.END_GAME)
                g.drawImage(card1, x, y, null);
            else
                g.drawImage(facedown, x, y, null);
        }
        if (card2 !=null) {
            g.drawImage(card2, x +60, y, null);
        }
        if (card3 !=null) {
            g.drawImage(card3, x +75, y, null);
        }
        if (card4 !=null) {
            g.drawImage(card4, x +90, y, null);
        }
        if (card5 !=null) {
            g.drawImage(card5, x +105, y, null);
        }
        if (card6 !=null) {
            g.drawImage(card6, x +120, y, null);
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
        return x;
    }

    public int getY(){
        return y;

    }
    protected void clearHand(){
        for(int i=0; i<4; i++){
            hand[i]=null;
        }
        card1=null;
        card2=null;
        card3=null;
        card4=null;
        card5=null;
        card6=null;
        while(winner.size()>0){
            winner.remove(0);
        }
    }

}


