package com.game.src.main;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage image;

    public SpriteSheet(BufferedImage image){
        this.image=image;
    }
//Sprite Sheet is 27 cols by 2 rows 74 width 108 height where col 2 row 26 is the last populated card
    public BufferedImage grabImage(int col,int row, int width, int height){
        BufferedImage img = image.getSubimage((col*75)-75, (row*109)-109, width, height);
        return img;
    }
}
