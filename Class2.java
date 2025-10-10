package org.pk.cas.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Class2 {
    public static void main(String[] args) {
        BufferedImage image = null, secondImage = null;
        File file = new File("F:/Supra.jpg");

        try {
            image = ImageIO.read(file);
            System.out.println("image read correctly");
        }catch (IOException w){
            System.out.println(w.getMessage());
            System.out.println("Image not readable!");
        }

        secondImage = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
        int borderThickness = 15;
        int width = image.getWidth();
        int height = image.getHeight();

       for (int row=0;row<image.getHeight();row++){
           for (int columb = 0;columb<image.getWidth();columb++){
              if (columb<borderThickness || columb>= width-borderThickness ||  row<borderThickness|| row>= height-borderThickness){
                  secondImage.setRGB(columb,row,Color.WHITE.getGreen());
              }else {
                  secondImage.setRGB(columb,row,image.getRGB(columb,row));
              }
           }
       }

        try {
            ImageIO.write(secondImage, "jpg", new File("F:/Supra3.jpg"));
            System.out.println("image is readable");
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("image not readable");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("illegal Argument");
        }

    }
}
