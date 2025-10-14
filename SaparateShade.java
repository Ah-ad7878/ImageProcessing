package org.pk.cas.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaparateShade {
    public static void main(String[] args) {
        BufferedImage image = null, secondImage = null;
        File file = new File("F:/pizza.jpg");

        try {
            image = ImageIO.read(file);
            System.out.println("Image readable correctly");
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Error in read the pic");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error in read the file");
        }

        secondImage = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());


        for (int i = 0;i<image.getHeight();i++){
            for (int j = 0;j<image.getWidth();j++){
                int pixel = image.getRGB(j,i);


//separate the shade
                int alpha = (pixel>>24);
                int red= (pixel>>16) & 0xFF;
                int green = (pixel>>8) & 0xFF;
                int blue = pixel& 0xFF;

                blue = 0xFF-blue;
                red = 0xFF-red;
                green = 0xFF-green;
//
//                red = (red+green+blue)/3;
//                green = (red+green+blue)/3;
//                blue = (red+green+blue)/3;

//                red = 0xFF-red;
//                green = 0xFF-green;

//                red = (int)(red*0.4);
//
//
                pixel = (alpha<<24) | (red<<16) | (green<<8) |blue;
                secondImage.setRGB(j,i,pixel);
            }
        }

        try {
            ImageIO.write(secondImage,"jpg", new File("F:/pizza2.jpg"));
            System.out.println("image read correctly");
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Error in write the pic");
        }



    }
}
