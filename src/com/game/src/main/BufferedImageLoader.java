package com.game.src.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


//Utility class used to load an image from the buffer
public class BufferedImageLoader {
    private BufferedImage image;

    public BufferedImage loadImage(String path) throws IOException {
        image = ImageIO.read(getClass().getResource(path));
        return image;
    }
}
