package org.pk.cas.image;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PicInPic2 {
    public static void main(String[] args) {
        BufferedImage tv = null, lion = null;

        File fileTv = new File("F:/tvpic.jpg");

        File fileLion = new File("F:/lionpic.jpg");

        try {
            tv = ImageIO.read(fileTv);
            lion  = ImageIO.read(fileLion);
            System.out.println("Both pic is correctly readable");
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Error");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error");
        }

        int screenF = 202;   //left edge of pic
        int screenI = 241;   // upper edge of the pic
        int screenWidth = 620;  // Right side of the pic
        int screenHeight = 333;  //Bottom side of pic

        BufferedImage Lion = new BufferedImage(screenWidth,screenHeight,lion.getType());

        for (int i = 0;i<screenHeight;i++){
            for (int f = 0;f<screenWidth;f++){
                int lionF = f*lion.getWidth()/screenWidth;
                int lionI = i*lion.getHeight()/screenHeight;
                Lion.setRGB(f,i,lion.getRGB(lionF,lionI));

                tv.setRGB(screenF+f,screenI+i,Lion.getRGB(f,i));


            }
        }

        try {
            ImageIO.write(tv,"jpg",new File("F:/tvpic3.jpg"));
            System.out.println("No problem in read the pic");
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Error in write the pic");
        }



    }
}
