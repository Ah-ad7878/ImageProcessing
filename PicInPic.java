package org.pk.cas.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PicInPic {
    public static void main(String[] args) {
        BufferedImage tv = null, lion = null;

        //Load the image
        File fileTv = new File("F:/tvpic.jpg");

        File fileLion= new File("F:/lionpic.jpg");

        //use try and catch block for throw and catch the exceptions
        try {
            tv  = ImageIO.read(fileTv);
            System.out.println("Tv image readable");
            lion = ImageIO.read(fileLion);
            System.out.println("Lion image readable");

        }catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("image not readable");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        Graphics2D g2d = tv.createGraphics();

        int screenF = 202;   //left edge of pic
        int screenI = 241;   // upper edge of the pic
        int screenWidth = 620;  // Right side of the pic
        int screenHeight = 333;  // Bottom side of pic

        int lionHeight = screenHeight;
        int lionWidth = screenWidth;

        for (int i = screenI;i<screenI+screenHeight;i+=screenHeight){
            for (int f = screenF;f<screenF+screenWidth;f+=screenWidth){
                g2d.drawImage(lion,f,i,screenWidth,screenHeight,null);
            }
        }

        try {
            ImageIO.write(tv,"jpg", new File("F:/tvpic2.jpg"));
            System.out.println("Done");
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Image write is not correct");
        }


    }
}
