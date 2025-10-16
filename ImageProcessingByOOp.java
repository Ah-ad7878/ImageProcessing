package org.pk.cas.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessingByOOp {

  static  BufferedImage tv = null,car = null,Car;

  //set pic pixel
    public static final int LEFT_PIXEL = 202;
    public static final int UPPER_PIXEL = 241;
    public static final int RIGHT_PIXEL =620;
    public static final int BOTTOM_PIXEL = 333;

    //set colour bits
    public static final int ALPHA_BIT = 24;
    public static final int RED_BIT = 16;
    public static final int GREEN_BIT = 8;
    public static final int TOTAL_BITS = 255;


    //firstly read the first image which is tv
    public static BufferedImage tvPic(String path){
//            BufferedImage tv = nul;
        File file = new File(path);
        try {
            tv = ImageIO.read(file);
            System.out.println("tv image read correctly");
        }catch (IOException e){
            System.out.println("Error in read the file"+e.getMessage());
        }
        return tv;
    }

    //read the second image of car
    public static BufferedImage carPic(String path){
        //BufferedImage car = null;
        File file = new File(path);
        try {
            car = ImageIO.read(file);
            System.out.println("bike image read correctly");
        }catch (IOException e){
            System.out.println("Error in read file 2");
        }
        return car;
    }

    //processing on a image
    public static BufferedImage effectOnImage(BufferedImage tv){
        int leftSide = LEFT_PIXEL;
        int upperSide  = UPPER_PIXEL;
        int rightSide =RIGHT_PIXEL;
        int bottomSide = BOTTOM_PIXEL;

        BufferedImage Car = new BufferedImage(rightSide,bottomSide, car.getType());

        //this for use for outer loop
        for (int i = 0;i<bottomSide;i++){
            //this for use for inner loop
            for (int j = 0;j<rightSide;j++){
                int a = j*car.getWidth()/rightSide;
                int b = i*car.getHeight()/bottomSide;

                int pixel = car.getRGB(a,b);
                int alpha = extractAlpha(pixel);
                int red = extractRed(pixel);
                int green = extractGreen(pixel);
                int blue = extractBlue(pixel);

                red = filter(red,0.4);
                blue = filter(blue,0.5);
                green = filter(green,0.3);


                pixel =pixelRGB(alpha,red,green,blue);

                Car.setRGB(j,i,pixel);

                tv.setRGB(leftSide+j,upperSide+i,Car.getRGB(j,i));


            }
        }
        return tv;
    }


    public static void writePic(BufferedImage image,String format,String path){
        try {
        ImageIO.write(image,format,new File(path));
            System.out.println("image write correctly");
        }catch (IOException e){
            System.out.println("Error in write the file"+e.getMessage());
        }
    }


    public static int extractAlpha(int pixel){
        return pixel>>ALPHA_BIT;
    }
    public static int extractRed(int pixel){
        return pixel>>RED_BIT & TOTAL_BITS;
    }
    public static int extractGreen(int pixel){
        return pixel>>GREEN_BIT & TOTAL_BITS;
    }
    public static int extractBlue(int pixel){
        return pixel & TOTAL_BITS;
    }

    public  static int pixelRGB(int  alpha,int red,int green,int blue){
        return alpha << ALPHA_BIT | red << RED_BIT | green << GREEN_BIT | blue;
    }

    public static int filter(int colour,double percent){
        return (int)(colour*percent);
    }


}
