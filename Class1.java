package org.pk.cas.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Class1 {
    public static void main(String[] args) {
        BufferedImage sourceImage = null , effecImage = null;
        File file = new File("F:/Supra.jpg");
        try {
            sourceImage = ImageIO.read(file);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        effecImage = new BufferedImage(sourceImage.getWidth(),sourceImage.getHeight(),sourceImage.getType());
        System.out.println("----");

        int start,mid,end;
//        Scanner sc =new Scanner(System.in);
//        System.out.print("Enter a number: ");
//        int number = sc.nextInt();

        start=mid=end = Math.min(sourceImage.getHeight(),sourceImage.getWidth())/2;


        for (int row = 0;row<sourceImage.getHeight();row++){
            for (int colub = 0;colub<sourceImage.getWidth();colub++){
                if (colub>=start && colub<=end){
                    effecImage.setRGB(colub,row,sourceImage.getRGB(colub,row));
                }else {
                    effecImage.setRGB(colub,row, Color.YELLOW.getRGB());
                }
            }
            if(row<mid){
                start--;
                end++;
            }else {
                start++;
                end--;
            }
        }

        try {
            ImageIO.write(effecImage,"jpg",new File("F:/Supra2.jpg"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Done code");

    }
}
